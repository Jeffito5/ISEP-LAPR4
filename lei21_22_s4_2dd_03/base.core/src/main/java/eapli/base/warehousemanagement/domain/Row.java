package eapli.base.warehousemanagement.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author Ana Rita Silva
 */
@Entity
@Table(name = "rowline")
public class Row {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    private String identifier;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "length", column = @Column(name = "begin_length")),
            @AttributeOverride( name = "width", column = @Column(name = "begin_width")),
    })
    private Coordinates begin;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "length", column = @Column(name = "end_length")),
            @AttributeOverride( name = "width", column = @Column(name = "end_width")),
    })
    private Coordinates end;
    @OneToMany
    private List<Shelf> shelves;

    /**
     * Represent a row present in an aisle of the warehouse
     *
     * @param identifier      row identification
     * @param begin   coordinates were the row begins
     * @param end     coordinates were the row ends
     * @param shelves list of shelves presented in the row
     */
    public Row(String identifier, Coordinates begin, Coordinates end, List<Shelf> shelves) {
        this.identifier = identifier;
        this.begin = begin;
        this.end = end;
        this.shelves = shelves;
    }

    /**
     * Empty constructor
     */
    protected Row() {
    }

    public String identifier() {
        return identifier;
    }

    public Coordinates begin() {
        return begin;
    }

    public Coordinates end() {
        return end;
    }

    @Override
    public String toString() {
        return "Row:" + "\n    Identifier = " + identifier +
                "\n    Begin = " + begin +
                "\n    End = " + end +
                "\n    Shelves = " + shelves;
    }
}
