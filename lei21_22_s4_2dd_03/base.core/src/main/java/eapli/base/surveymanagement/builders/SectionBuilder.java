package eapli.base.surveymanagement.builders;

import eapli.base.surveymanagement.domain.*;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class SectionBuilder {
    boolean reset;

    public String sectionId;
    public String title;
    public String description;
    public Repeatability repeatability;
    public Condition condition;
    public Obligatoriness obligatoriness;

    public List<Question> questions;

    /**
     * Constructor
     *
     * @param reset Defines if the Builder is to be reset after building the entity.
     */
    public SectionBuilder(boolean reset) {
        this.reset = reset;
    }


    /**
     * Defines the Builder's Section ID
     *
     * @param sectionId Section ID to be used in the build
     * @return Current Builder
     */
    public SectionBuilder withSectionId(String sectionId) {
        this.sectionId = sectionId;
        return this;
    }

    /**
     * Defines the Builder's Section Title
     *
     * @param title Section Title to be used in the build
     * @return Current Builder
     */
    public SectionBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Defines the Builder's Section Title
     *
     * @param description Section Description to be used in the build
     * @return Current Builder
     */
    public SectionBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Defines the Builder's Section Repeatability
     *
     * @param repeatability Section Repeatability to be used in the build
     * @return Current Builder
     */
    public SectionBuilder withRepeatability(Repeatability repeatability) {
        this.repeatability = repeatability;
        return this;
    }

    /**
     * Defines the Builder's Section Obligatoriness
     *
     * @param obligatoriness Section Obligatoriness to be used in the build
     * @return Current Builder
     */
    public SectionBuilder withObligatoriness(Obligatoriness obligatoriness) {
        this.obligatoriness = obligatoriness;
        return this;
    }

    /**
     * Defines the Builder's Section Condition
     *
     * @param conditionOption Question Option to be used in the Section's Condition
     * @param conditionQuestion Question to be used in the Section's Condition
     * @param conditionSection Section that contains the Condition Question
     * @return Current Builder
     */
    public SectionBuilder withCondition(String conditionSection, String conditionQuestion, String conditionOption) throws InvalidAttributesException {

        if (this.obligatoriness == Obligatoriness.CONDITIONAL) {
            if (conditionSection==null || conditionSection.isBlank() || conditionSection.isEmpty())
                throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing condition section!");

            if (conditionQuestion==null || conditionQuestion.isBlank() || conditionQuestion.isEmpty())
                throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing condition question!");

            this.condition = new Condition(conditionSection,conditionQuestion,conditionOption);
        } else this.condition = null;      //Ignores if condition is not required

        return this;
    }

    /**
     * Defines the Builder's Section List of Questions
     *
     * @param questions Questions to be used in the build
     * @return Current Builder
     */
    public SectionBuilder withQuestions(List<Question> questions) throws InvalidAttributesException {

        if ( questions==null||questions.isEmpty())
            throw new InvalidAttributesException("ERROR: Cannot complete operation! List of questions is empty!");

        if (this.obligatoriness == Obligatoriness.OPTIONAL) {
            for (Question question : questions) {
                if (!question.isOptional())
                    throw new IllegalArgumentException("ERROR: An 'Optional' Section can oly have 'Optional' Questions!");
            }
        }
        if (this.obligatoriness == Obligatoriness.MANDATORY){
            boolean verify = false;
            for (Question question : questions){
                if (question.isMandatory())
                    verify = true;
            }
            if (!verify)
                throw new IllegalArgumentException("ERROR: A 'Mandatory' Section requires at least one Mandatory Question!");
        }
        this.questions = questions;
        return this;
    }

    /**
     * Builds the new entity with the given information.
     *
     * @return New instance of Section.
     * @throws InvalidAttributesException Thrown by the exceptions and verifications.
     */
    public Section build() throws InvalidAttributesException {

        if (this.sectionId == null || this.sectionId.isEmpty() || this.sectionId.isBlank())
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing section id!");

        if (this.title == null || this.title.isEmpty() || this.title.isBlank())
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing section title!");

        if (this.obligatoriness == null)
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing section obligatoriness!");

        if (obligatoriness == Obligatoriness.CONDITIONAL && (condition == null))
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing 'condition' due to obligatoriness is set to 'Conditional'!");

        if (questions == null || questions.isEmpty())
            throw new InvalidAttributesException("ERROR: Cannot complete operation! List of questions is empty!");

        if (repeatability == null)
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing repeatability!");

        Section section = new Section(this);

        if (reset) reset();

        return section;
    }

    /**
     * Resets all the information in the Builder
     */
    private void reset() {
        this.sectionId = null;
        this.title = null;
        this.condition = null;
        this.obligatoriness = null;
        this.description = null;
        this.questions = null;
        this.repeatability = null;
    }
}
