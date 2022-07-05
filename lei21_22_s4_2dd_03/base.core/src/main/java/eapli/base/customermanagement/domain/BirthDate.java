package eapli.base.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */

@Embeddable
public class BirthDate implements ValueObject, Serializable {

    private String birthDate;

    protected BirthDate() {

    }

    protected BirthDate(String birthDate) {
        ruleBirthDate(birthDate);
        this.birthDate=birthDate;
    }

    /**
     * new constructor
     * @param birthDate birthdate
     * @return birthdate
     */
    public static BirthDate valueOf(String birthDate) {
        return new BirthDate(birthDate);
    }

    /**
     * rule birthdate
     *
     * @param birthDate birthdate
     */
    private void ruleBirthDate(String birthDate) {
        if (birthDate.isBlank())
            return;
        Date date;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date actual=new Date();
        try {
            actual = format.parse(String.valueOf(Calendar.getInstance()));
        } catch (ParseException ignored) {
        }

        try {
            date = format.parse(birthDate);
        } catch (ParseException ex) {
            throw new IllegalArgumentException("Invalid date format.");
        }
        if (!birthDate.equals(format.format(date))) {
            throw new IllegalArgumentException("Invalid date format.");
        }
        if(actual.before(date))
            throw new IllegalArgumentException("Invalid date.");
    }

    @Override
    public String toString() {
        return "BirthDate{" +
                "birthDate='" + birthDate + '\'' +
                '}';
    }
}
