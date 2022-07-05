package eapli.base.warehousemanagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Ana Rita Silva
 */
@Entity
public class Plant implements Serializable, AggregateRoot<Integer> {

    @Id
    @GeneratedValue
    private Integer id;
    private float length;
    private float width;
    private float square;
    private String unit;


    @OneToMany
    private List<Aisle> aisles;

    @OneToMany
    private List<Dock> docks;

    /**
     * Empty constructor
     */
    public Plant() {
    }

    /**
     * Represents the warehouse plant
     *
     * @param length length of the space available in the warehouse defined by the plant
     * @param width  width of the space available in the warehouse defined by the plant
     * @param square size of the square
     * @param unit   measurement's unit
     * @param aisles aisles presented in the plant
     * @param docks  agv's docks presented in the plant
     */
    public Plant(String length, String width, String square, String unit, List<Aisle> aisles, List<Dock> docks) {
        validatePlant(length, width, square);
        this.unit = unit;
        this.aisles = aisles;
        this.docks = docks;
    }

    /**
     * Validates the plant
     *
     * @param l length
     * @param w width
     * @param s square
     */
    private void validatePlant(String l, String w, String s) {
        this.length = Float.parseFloat(l);
        this.width = Float.parseFloat(w);
        this.square = Float.parseFloat(s);
        if (length <= 0 || width <= 0 || square <= 0) {
            throw new IllegalArgumentException("The measurements (length, width and square) have to be a positive value.");
        }
    }

    public float length() {
        return length;
    }

    public float width() {
        return width;
    }

    public float square() {
        return square;
    }

    @Override
    public String toString() {
        return "Plant:" +
                "\n    Id = " + id +
                "\n    Length = " + length +
                "\n    Width = " + width +
                "\n    Square = " + square +
                "\n    Unit = " + unit +
                "\n    Aisles = " + aisles +
                "\n    Docks = " + docks;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return id;
    }

    public List<Aisle> aisles() {
        return aisles;
    }

    public List<Dock> docks() {
        return docks;
    }
}
