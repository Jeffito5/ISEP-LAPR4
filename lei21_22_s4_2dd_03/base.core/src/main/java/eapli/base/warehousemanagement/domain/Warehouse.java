package eapli.base.warehousemanagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Ana Rita Silva
 */
@Entity
public class Warehouse implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue()
    private Integer id;
    private String name;
    @OneToOne
    private Plant plant;

    /**
     * Represents the warehouse
     * @param name name of the warehouse
     * @param plant plant of the warehouse
     */
    public Warehouse(String name, Plant plant) {
        this.name = name;
        this.plant = plant;
    }

    /**
     * Empty constructor
     */
    public Warehouse() {
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }

    @Override
    public String toString() {
        return "Warehouse:" + "\n    Id = " + id +
                "\n    Name = " + name +
                "\n    Plant = " + plant;
    }
}
