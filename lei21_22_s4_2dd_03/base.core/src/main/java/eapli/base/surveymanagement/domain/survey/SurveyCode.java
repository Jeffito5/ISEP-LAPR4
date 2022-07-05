package eapli.base.surveymanagement.domain.survey;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Author: 1201180 - Guilherme Sencadas
 */

@Embeddable
public class SurveyCode implements ValueObject, Serializable {

    public static int CODE_MAX_LENGTH = 15;
    private String code;

    ///Required by JPA
    protected SurveyCode() {
    }

    public SurveyCode(String code) {
        if (code == null)
            throw new IllegalArgumentException("ERROR: Survey Code cannot be null!");
        if (code.isEmpty() || code.isBlank())
            throw new IllegalArgumentException("ERROR: Survey Code cannot be empty!");
        if (!code.chars().allMatch(Character::isLetterOrDigit))
            throw new IllegalArgumentException("ERROR: Survey Code has non-alphanumeric characters!");

        if (!(code.length() < CODE_MAX_LENGTH))
            throw new IllegalArgumentException("ERROR: Survey Code must have a total of " + CODE_MAX_LENGTH + " characters!");

        this.code = code;
    }

    public String code() {
        return code;
    }
}
