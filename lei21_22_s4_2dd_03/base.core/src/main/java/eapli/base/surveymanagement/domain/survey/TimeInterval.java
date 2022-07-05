package eapli.base.surveymanagement.domain.survey;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Guilherme Sencadas - 1201180
 */

@Embeddable
public class TimeInterval implements ValueObject, Serializable {

    private Date firstDate;
    private Date secondDate;

    protected TimeInterval() {
    }

    public TimeInterval(Date firstDate, Date secondDate) {
        if (firstDate.after(secondDate))
            throw new IllegalArgumentException("Error: First date cannot be after the second!");

        if (secondDate.before(firstDate))
            throw new IllegalArgumentException("Error: Second date cannot be before the first!");

        if (firstDate.equals(secondDate))
            throw new IllegalArgumentException("Error: The two dates cannot be the same!");

        this.firstDate = firstDate;
        this.secondDate = secondDate;
    }

    public boolean inInterval(Date date) {
        return (date.after(firstDate) && date.before(secondDate));
    }

    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "[" + formatter.format(firstDate) + "] - [" + formatter.format(secondDate) + "]";
    }
}
