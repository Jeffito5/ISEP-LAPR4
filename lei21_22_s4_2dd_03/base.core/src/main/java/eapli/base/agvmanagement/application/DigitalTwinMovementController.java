package eapli.base.agvmanagement.application;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.domain.Autonomy;
import eapli.base.agvmanagement.domain.Route;
import eapli.base.agvmanagement.domain.RoutePlanner;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Identifier;
import eapli.base.ordermanagement.domain.OrderItem;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.domain.Product;
import eapli.base.warehousemanagement.domain.*;

import java.util.ArrayList;
import java.util.List;


public class DigitalTwinMovementController {

    private final AGVRepository agvRepository = PersistenceContext.repositories().agvs();

    private final OrderRepository orderRepository = PersistenceContext.repositories().orders();

    private final JpaRepository<Plant, Integer> plantRepository = new JpaRepository<Plant, Integer>() {
        @Override
        protected String persistenceUnitName() {
            return null;
        }
    };


    public ProductOrder order(String orderId) {
        if (orderRepository.findById(Identifier.valueOf(Integer.parseInt(orderId))).isPresent()) {
            return orderRepository.findById(Identifier.valueOf(Integer.parseInt(orderId))).get();
        } else {
            return null;
        }
    }

    public AGV agv(String agvId) {
        if (agvRepository.findByIdentifier(eapli.base.agvmanagement.domain.Identifier.valueOf(agvId)).isPresent()) {
            return agvRepository.findByIdentifier(eapli.base.agvmanagement.domain.Identifier.valueOf(agvId)).get();
        } else {
            return null;
        }
    }

    public Plant plant() {
        return plantRepository.findAll().get(0);
    }

    public void updateAGVAutonomy(String agvId, int autonomy) {
        AGV agv = agv(agvId);
        agv.updateAutonomy(Autonomy.valueOf(autonomy));
        agvRepository.save(agv);
    }

    public int checkCollision(String agvId) {
        AGV agv = agv(agvId);
        for (AGV other : agvRepository.findAGVOccupied()) {
            if (!agv.equals(other)) {
                float agvLength = agv.coordinates().length();
                float agvWidth = agv.coordinates().width();
                float otherLength = other.coordinates().length();
                float otherWidth = other.coordinates().width();
                if ((agvLength - 1 == otherLength && agvWidth == otherWidth) || (agvLength == otherLength && agvWidth - 1 == otherWidth) || (agvLength + 1 == otherLength && agvWidth == otherWidth) || (agvLength == otherLength && agvWidth + 1 == otherWidth)) {
                    return 1;
                }
                if ((agvLength - 2 == otherLength && agvWidth == otherWidth) || (agvLength + 2 == otherLength && agvWidth == otherWidth) || (agvLength == otherLength && agvWidth - 2 == otherWidth) || (agvLength == otherLength && agvWidth + 2 == otherWidth) ||
                        (agvLength - 1 == otherLength && agvWidth - 1 == otherWidth) || (agvLength - 1 == otherLength && agvWidth + 1 == otherWidth) || (agvLength + 1 == otherLength && agvWidth - 1 == otherWidth) || (agvLength + 1 == otherLength && agvWidth + 1 == otherWidth)) {
                    return 2;
                }
            }
        }
        return 0;
    }

    public List<Coordinates> route(String agvId, String orderId) {
        ProductOrder order = order(orderId);
        AGV agv = agv(agvId);

        List<Coordinates> path = new ArrayList<>();
        path.add(agv.coordinates());
        for (OrderItem orderItem : order.items()) {
            Product product = orderItem.product();
            for (Aisle aisle : plant().aisles()) {
                if (aisle.identifier().equals(String.valueOf(product.productMeasurements().aisleID()))) {
                    for (Row row : aisle.rows()) {
                        if (row.identifier().equals(String.valueOf(product.productMeasurements().rowID()))) {
                            if (aisle.accessibility().equals("w+"))
                                path.add(new Coordinates(String.valueOf(row.begin().length()), String.valueOf(row.begin().width() + 1)));

                            if (aisle.accessibility().equals("w-"))
                                path.add(new Coordinates(String.valueOf(row.begin().length()), String.valueOf(row.begin().width() - 1)));

                            if (aisle.accessibility().equals("l-"))
                                path.add(new Coordinates(String.valueOf(row.begin().length() + 1), String.valueOf(row.begin().width())));

                            if (aisle.accessibility().equals("l+"))
                                path.add(new Coordinates(String.valueOf(row.begin().length() - 1), String.valueOf(row.begin().width())));
                        }
                    }
                }
            }
        }

        path.add(checkAGVDock(agv).begin());
        return path;
    }

    public Dock checkAGVDock(AGV agv) {
        for (Dock dock : plant().docks()) {
            if (dock.identity().equals(agv.docker())) {
                return dock;
            }
        }
        return null;
    }

    public Route calculateRoute(Coordinates src, Coordinates dest) {
        RoutePlanner routePlanner = new RoutePlanner(plant());
        return routePlanner.shortestPathBetweenTwoPoints(src, dest);
    }

    public void updateAGVPosition(String agvId, Coordinates coordinates) {
        AGV agv = agv(agvId);
        agv.updateCoordinates(String.valueOf(coordinates.length()), String.valueOf(coordinates.width()));
        agvRepository.save(agv);
    }


    public Route comebackDock(String agvId) {
        AGV agv = agv(agvId);
        return calculateRoute(agv.coordinates(), checkAGVDock(agv).begin());
    }

}
