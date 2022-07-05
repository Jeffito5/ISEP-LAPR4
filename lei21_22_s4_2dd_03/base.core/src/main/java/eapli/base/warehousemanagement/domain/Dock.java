package eapli.base.warehousemanagement.domain;

import eapli.base.warehousemanagement.mappers.dtos.DockDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Locale;

/**
 * @author Ana Rita Silva
 */
@Entity
public class Dock implements Serializable, AggregateRoot<String> {

    @Id
    private String id;
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
    private String status;

    public Coordinates begin() {
        return begin;
    }

    public Coordinates depth() {
        return depth;
    }

    private enum STATUS {
        OCCUPIED,
        FREE
    }

    /**
     * Represents the agv's dock
     *
     * @param id            dock's identification
     * @param begin         coordinates were the dock begins
     * @param end           coordinates were the dock ends
     * @param depth         coordinates of the dock's depth
     * @param accessibility where the dock can be accessed
     */
    public Dock(String id, Coordinates begin, Coordinates end, Coordinates depth, String accessibility) {
        this.id = id;
        this.begin = begin;
        this.end = end;
        this.depth = depth;
        this.accessibility = accessibility;
        this.status = String.valueOf(STATUS.FREE).toUpperCase(Locale.ROOT);
    }

    public String id() {
        return id;
    }

    /**
     * Empty constructor
     */
    protected Dock() {

    }

    /**
     * Gets the dock's status in order to know if it is available or occupied
     *
     * @return status
     */
    public String knowStatus() {
        return this.status;
    }

    /**
     * Changes the status
     * - If is free it changes to occupied and vice-versa
     */
    public void changeStatus() {
        if (this.status.equalsIgnoreCase(String.valueOf(STATUS.FREE))) {
            this.status = String.valueOf(STATUS.OCCUPIED);
        } else {
            this.status = String.valueOf(STATUS.FREE);
        }
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public String identity() {
        return this.id;
    }

    public DockDTO toDTO() {
        return new DockDTO(id, begin.length(), begin.width(), end.length(), end.width(), depth.length(), depth.width(), accessibility, status);
    }

    @Override
    public String toString() {
        return "Dock: " +
                "\n    Id = " + id + '\'' +
                "\n    Begin = " + begin +
                "\n    End = " + end +
                "\n    Depth = " + depth +
                "\n    Accessibility = " + accessibility + '\'' +
                "\n    Status = " + status;
    }
}
