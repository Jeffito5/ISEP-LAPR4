package eapli.base.surveymanagement.domain.survey;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Author: 1201180 - Guilherme Sencadas
 */
@Embeddable
public class SurveyDescription implements ValueObject, Serializable {

    public static int DESCRIPTION_MAX_LENGTH = 40;
    private String description;

    //Required by JPA
    protected SurveyDescription() {
    }

    public SurveyDescription(String description) {

    if (description==null)
            throw new IllegalArgumentException("ERROR: Survey Description cannot be null!");
        if (description.isEmpty() || description.isBlank())
            throw new IllegalArgumentException("ERROR: Survey Description cannot be empty!");
        if (!(description.length()<DESCRIPTION_MAX_LENGTH))
            throw new IllegalArgumentException("ERROR: Survey Description must have a total of "+DESCRIPTION_MAX_LENGTH+" characters!");

        this.description = description;
    }

    public String description() {
        return description;
    }
}
