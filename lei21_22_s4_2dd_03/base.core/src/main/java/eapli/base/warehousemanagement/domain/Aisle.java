package eapli.base.warehousemanagement.domain;

import eapli.base.ordermanagement.domain.Identifier;

import javax.persistence.*;
import java.util.List;

/**
 * @author Ana Rita Silva
 */
@Entity
public class Aisle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String identifier;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "length", column = @Column(name = "begin_length")),
            @AttributeOverride(name = "width", column = @Column(name = "begin_width")),
    })
    private Coordinates begin;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "length", column = @Column(name = "end_length")),
            @AttributeOverride(name = "width", column = @Column(name = "end_width")),
    })
    private Coordinates end;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "length", column = @Column(name = "depth_length")),
            @AttributeOverride(name = "width", column = @Column(name = "depth_width")),
    })
    private Coordinates depth;

    private String accessibility;
    @OneToMany
    private List<Row> rows;

    /**
     * Represents the Warehouse Aisle
     *
     * @param identifier    identification number
     * @param begin         coordinates were the aisle begins
     * @param end           coordinates were the aisle ends
     * @param depth         coordinates of the aisle's depth
     * @param accessibility where the aisle can be accessed
     * @param rows          list of row the aisle has
     */
    public Aisle(String identifier, Coordinates begin, Coordinates end, Coordinates depth, String accessibility, List<Row> rows) {
        this.identifier = identifier;
        this.begin = begin;
        this.end = end;
        this.depth = depth;
        this.accessibility = accessibility;
        this.rows = rows;
    }

    /**
     * Empty constructor
     */
    public Aisle() {

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

    public String accessibility() {
        return accessibility;
    }

    public List<Row> rows() {
        return rows;
    }

    /**
     * Transforms an aisle in a string format
     *
     * @return aisle in a string format
     */
    @Override
    public String toString() {
        return "Aisle:" +
                "\n    Identifier = " + identifier +
                "\n    Begin = " + begin +
                "\n    End = " + end +
                "\n    Depth = " + depth +
                "\n    Accessibility = " + accessibility +
                "\n    Rows = " + rows;
    }

    public Coordinates depth() {
        return depth;
    }
}
