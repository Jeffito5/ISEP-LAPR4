package eapli.base.catalogmanagement.domain;

import eapli.base.productmanagement.domain.InternalCode;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Luís Araújo
 */
@Embeddable
public class CatalogId implements ValueObject, Comparable<CatalogId>, Serializable {
    /**
     * Id of the catalog
     */
    private Long id;

    /**
     * Empty constructor
     */
    public CatalogId() {
    }

    /**
     * Constructor with the parameter id
     * @param id
     */
    public CatalogId(Long id) {
        this.id = id;
    }

    /**
     * Method that returns the id
     * @return id
     */
    public Long id() {
        return id;
    }

    @Override
    public String toString() {
        return "CatalogId{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CatalogId)) return false;
        CatalogId catalogId = (CatalogId) o;
        return Objects.equals(id, catalogId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(CatalogId o) {
        return 0;
    }
}
