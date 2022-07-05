package eapli.base.surveymanagement.builders;

import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.Section;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

/**
 * Author: 1201180 - Guilherme Sencadas
 */

public class QuestionnaireBuilder {

    boolean reset;

    public String questionnaireId;
    public String title;
    public String welcomeMessage;
    public String finalMessage;
    public List<Section> sections;

    /**
     * Constructor
     *
     * @param reset Defines if the Builder is to be reset after building the entity.
     */
    public QuestionnaireBuilder(boolean reset) {
        this.reset = reset;
    }

    /**
     * Defines the Builder's Questionnaire ID
     *
     * @param id Questionnaire ID to be used in the build
     * @return Current Builder
     */
    public QuestionnaireBuilder withId(String id) {
        this.questionnaireId = id;
        return this;
    }

    /**
     * Defines the Builder's Questionnaire Title
     *
     * @param title Questionnaire Title to be used in the build
     * @return Current Builder
     */
    public QuestionnaireBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Defines the Builder's Questionnaire Welcome Message
     *
     * @param message Questionnaire Welcome Message to be used in the build
     * @return Current Builder
     */
    public QuestionnaireBuilder withWelcomeMessage(String message) {
        this.welcomeMessage = message;
        return this;
    }

    /**
     * Defines the Builder's Questionnaire Final Message
     *
     * @param message Questionnaire Final Message to be used in the build
     * @return Current Builder
     */
    public QuestionnaireBuilder withFinalMessage(String message) {
        this.finalMessage = message;
        return this;
    }

    /**
     * Defines the Builder's Questionnaire List of Sections
     *
     * @param sections List of Sections to be used in the Questionnaire
     * @return Current Builder
     */
    public QuestionnaireBuilder withSections(List<Section> sections) {
        this.sections = sections;
        return this;
    }


    /**
     * Builds the new entity with the given information.
     *
     * @return New instance of Questionnaire.
     * @throws InvalidAttributesException Thrown by the exceptions and verifications.
     */
    public Questionnaire build() throws InvalidAttributesException {

        if (this.questionnaireId == null || this.questionnaireId.isEmpty() || this.questionnaireId.isBlank())
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing questionnaire id!");

        if (this.title == null || this.title.isEmpty() || this.title.isBlank())
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing questionnaire title!");

        if (this.finalMessage == null || this.finalMessage.isEmpty() || this.finalMessage.isBlank())
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing questionnaire final message!");

        if (sections == null || sections.isEmpty())
            throw new InvalidAttributesException("ERROR: Cannot complete operation! List of sections is empty!");

        Questionnaire questionnaire = new Questionnaire(this);

        if (reset)
            reset();

        return questionnaire;
    }

    /**
     * Resets all the information in the Builder
     */
    private void reset() {
        this.questionnaireId = null;
        this.title = null;
        this.welcomeMessage = null;
        this.finalMessage = null;
        this.sections = null;
    }
}
