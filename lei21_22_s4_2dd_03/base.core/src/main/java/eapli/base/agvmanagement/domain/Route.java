package eapli.base.agvmanagement.domain;

import eapli.base.warehousemanagement.domain.Coordinates;

import java.util.List;

public class Route {

    public List<Coordinates> coordinatesList;
    public List<String> movementList;
    public int[][] warehouseRoute;

    public Route(List<Coordinates> pointList, List<String> movementList, int[][] warehouseRoute) {
        this.coordinatesList = pointList;
        this.movementList = movementList;
        this.warehouseRoute = warehouseRoute;
    }
}
