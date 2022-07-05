package eapli.base.surveymanagement.builders;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.survey.*;

import javax.naming.directory.InvalidAttributesException;
import java.lang.annotation.Target;
import java.util.Date;
import java.util.List;

/**
 * Author: 1201180 - Guilherme Sencadas
 */

public class SurveyBuilder {

    public SurveyCode code;
    public SurveyDescription description;
    public TimeInterval timeInterval;
    public Questionnaire questionnaire;
    public TargetAudience targetAudience;
    public List<Customer> audience;

    private boolean reset;

    /**
     * Constructor
     *
     * @param reset Defines if the Builder is to be reset after building the entity.
     */
    public SurveyBuilder(boolean reset) {
        this.reset = reset;
    }


    /**
     * Defines the Builder's Survey Code
     *
     * @param code Section Code to be used in the build
     * @return Current Builder
     */
    public SurveyBuilder withCode(String code) {
        this.code = new SurveyCode(code);
        return this;
    }

    /**
     * Defines the Builder's Survey Description
     *
     * @param description Section Description to be used in the build
     * @return Current Builder
     */
    public SurveyBuilder withDescription(String description) {
        this.description = new SurveyDescription(description);
        return this;
    }

    /**
     * Defines the Builder's Survey Time Interval
     *
     * @param firstDate  First Date of the Time Interval to be used in the build
     * @param secondDate Second Date of the Time Interval to be used in the build
     * @return Current Builder
     */
    public SurveyBuilder withTimeInterval(Date firstDate, Date secondDate) {
        this.timeInterval = new TimeInterval(firstDate, secondDate);
        return this;
    }

    /**
     * Defines the Builder's Survey Target Audience
     *
     * @param targetAudience  Survey Target Type to be used in the build
     * @param codes List with the codes of the Categories, products or Brands
     * @return Current Builder
     */
    public SurveyBuilder withTargetAudience(TargetType targetAudience, List<String> codes, Date firstDate, Date secondDate) throws InvalidAttributesException {
        if (codes == null || codes.isEmpty())
            throw new InvalidAttributesException("ERROR: Code List cannot be null/ empty!");

        this.targetAudience = new TargetAudience(targetAudience, codes, new TimeInterval(firstDate,secondDate));
        return this;
    }

    /**
     * Defines the Builder's Survey Questionnaire
     *
     * @param questionnaire  Survey's Questionnaire to be used in the build
     * @return Current Builder
     */
    public SurveyBuilder withQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
        return this;
    }

    public SurveyBuilder withAudience(List<Customer> customers){
        this.audience = customers;
        return this;
    }

    /**
     * Builds the new entity with the given information.
     *
     * @return New instance of Survey.
     * @throws InvalidAttributesException Thrown by the exceptions.
     */
    public Survey build() throws InvalidAttributesException {

        if (this.code == null)
            throw new InvalidAttributesException("ERROR: Missing Survey Code!");

        if (this.description == null)
            throw new InvalidAttributesException("ERROR: Missing Survey Description!");

        if (this.questionnaire == null)
            throw new InvalidAttributesException("ERROR: Missing Survey Questionnaire!");

        if (this.targetAudience == null)
            throw new InvalidAttributesException("ERROR: Missing Survey Target Audience!");

        if (this.timeInterval == null)
            throw new InvalidAttributesException("ERROR: Missing Survey Time Interval!");

        if (this.audience == null)
            throw new InvalidAttributesException("ERROR: Missing Survey Time Interval!");

        Survey survey = new Survey(this);
        if (reset)
            reset();
        return survey;
    }


    /**
     * Resets all the information in the Builder
     */
    private void reset() {
        this.code = null;
        this.description = null;
        this.timeInterval = null;
        this.targetAudience = null;
        this.questionnaire = null;
    }

}
