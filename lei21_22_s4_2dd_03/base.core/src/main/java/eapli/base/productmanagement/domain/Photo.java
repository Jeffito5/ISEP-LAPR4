package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Luís Araújo
 */
@Embeddable
public class Photo implements ValueObject, Comparable<Photo>, Serializable {
    /**
     * Product's photo
     */
    private String path;

    /**
     * Empty constructor
     */
    public Photo() {
    }

    /**
     * Constructor with the parameter path
     * @param path
     */
    public Photo(String path) {
        this.path = path;
    }

    /**
     * Method that returns the photo
     * @return photo
     */
    public String path() {
        return path;
    }

    @Override
    public String toString() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;
        Photo photo = (Photo) o;
        return Objects.equals(path, photo.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }

    @Override
    public int compareTo(Photo o) {
        return 0;
    }
}
