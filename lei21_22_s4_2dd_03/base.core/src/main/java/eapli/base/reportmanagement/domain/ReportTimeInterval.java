package eapli.base.reportmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Luís Araújo
 */
@Embeddable
public class ReportTimeInterval implements ValueObject, Serializable {
    /**
     * Report first date
     */
    private Date firstDate;
    /**
     * Report last date
     */
    private Date secondDate;

    /**
     * Empty constructor
     */
    protected ReportTimeInterval() {
    }

    /**
     * Constructor that verifies both dates
     *
     * @param firstDate
     * @param secondDate
     */
    public ReportTimeInterval(Date firstDate, Date secondDate) {
        if (firstDate.after(secondDate))
            throw new IllegalArgumentException("Error: First date cannot be after the second!");

        if (secondDate.before(firstDate))
            throw new IllegalArgumentException("Error: Second date cannot be before the first!");

        if (firstDate.equals(secondDate))
            throw new IllegalArgumentException("Error: The two dates cannot be the same!");

        this.firstDate = firstDate;
        this.secondDate = secondDate;
    }

    /**
     * Method that verifies if a certain date is in the interval
     *
     * @param date
     * @return true if the date is in the interval and false otherwise
     */
    public boolean inInterval(Date date) {
        return (date.after(firstDate) && date.before(secondDate));
    }

    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "[" + formatter.format(firstDate) + "] - [" + formatter.format(secondDate) + "]";
    }
}
