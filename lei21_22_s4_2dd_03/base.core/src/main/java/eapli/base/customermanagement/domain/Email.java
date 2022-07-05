package eapli.base.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.regex.Pattern;


/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 */
@Embeddable
public class Email implements ValueObject, Serializable {

    private String email;

    protected Email(){}

    protected Email(String email) {
        ruleEmail(email);
        this.email=email;
    }

    public String email(){
        return email;
    }

    /**
     * new constructor
     * @param email email
     * @return email
     */
    public static Email valueOf(String email){
        return new Email(email);
    }

    /**
     * rule email
     * @param email email
     */
    private void ruleEmail(String email) {
        if (StringUtils.isBlank(email))
            throw new IllegalArgumentException("Email can't be null.");

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (!pat.matcher(email).matches())
            throw new IllegalArgumentException("Invalid format for email.");
    }

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                '}';
    }
}
