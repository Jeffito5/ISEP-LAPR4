package eapli.base.surveymanagement.builders;

import eapli.base.surveymanagement.domain.Condition;
import eapli.base.surveymanagement.domain.Obligatoriness;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.QuestionType;

import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Guilherme Sencadas - 1201180
 */
public class QuestionBuilder {

    public String questionId;
    public String text;
    public String instructions;
    public Obligatoriness obligatoriness;
    public Condition condition;
    public String info;
    public QuestionType type;
    public List<String> options;
    public boolean reset;

    /**
     * Constructor
     *
     * @param reset Defines if the Builder is to be reset after building the entity.
     */
    public QuestionBuilder(boolean reset) {
        this.reset = reset;
    }

    /**
     * Defines the Builder's Question ID
     *
     * @param questionId Question ID to be used in the build
     * @return Current Builder
     */
    public QuestionBuilder withQuestionId(String questionId) {
        this.questionId = questionId;
        return this;
    }

    /**
     * Defines the Builder's Question Text
     *
     * @param text Question Text to be used in the build
     * @return Current Builder
     */
    public QuestionBuilder withText(String text) {
        this.text = text;
        return this;
    }

    /**
     * Defines the Builder's Question Instructions
     *
     * @param instructions Question Instructions to be used in the build
     * @return Current Builder
     */
    public QuestionBuilder withInstructions(String instructions) {
        this.instructions = instructions;
        return this;
    }

    /**
     * Defines the Builder's Question Obligatoriness
     *
     * @param obligatoriness Question Obligatoriness to be used in the build
     * @return Current Builder
     */
    public QuestionBuilder withObligatoriness(Obligatoriness obligatoriness) {
        this.obligatoriness = obligatoriness;
        return this;
    }

    /**
     * Defines the Builder's Question Condition
     *
     * @param conditionOption   Question Option for the Condition to be used in the build
     * @param conditionQuestion Condition Question to be used in the build
     * @return Current Builder
     */
    public QuestionBuilder withCondition(String conditionQuestion, String conditionOption) throws InvalidAttributesException {
        if (this.obligatoriness == Obligatoriness.CONDITIONAL) {
            if (conditionQuestion == null || conditionQuestion.isBlank() || conditionQuestion.isEmpty())
                throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing condition question!");

            this.condition = new Condition(null, conditionQuestion, conditionOption);
        } else
            this.condition = null;      //Ignores if condition is not required

        return this;
    }

    /**
     * Defines the Builder's Question Extra Information
     *
     * @param info Question Extra Information to be used in the build
     * @return Current Builder
     */
    public QuestionBuilder withInfo(String info) {
        this.info = info;
        return this;
    }

    /**
     * Defines the Builder's Question Type
     *
     * @param type Question Type to be used in the build
     * @return Current Builder
     */
    public QuestionBuilder withType(QuestionType type) {
        this.type = type;
        return this;
    }

    /**
     * Defines the Builder's Question Obligatoriness
     *
     * @param options When the Question Type requires options
     * @return Current Builder
     */
    public QuestionBuilder withOptions(List<String> options) {
        this.options = options;
        return this;
    }

    /**
     * Builds the new entity with the given information.
     *
     * @return New instance of Question.
     * @throws InvalidAttributesException Thrown by the exceptions and verifications.
     */
    public Question build() throws InvalidAttributesException {

        if (this.questionId == null || this.questionId.isEmpty() || this.questionId.isBlank())
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing question id!");

        if (this.text == null || this.text.isEmpty() || this.text.isBlank())
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing question text!");

        if (this.obligatoriness == null)
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing question obligatoriness!");

        if (obligatoriness == Obligatoriness.CONDITIONAL && (condition == null))
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing 'condition' due to obligatoriness is set to 'Conditional'!");

        if (this.type == null)
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing question type!");

        if ((this.type == QuestionType.FREE_TEXT || this.type == QuestionType.NUMERIC) && (this.options != null && !this.options.isEmpty()))
            throw new InvalidAttributesException("ERROR: Cannot complete operation! " + type + " type Questions cannot have a list of options!");

        if ((this.type == QuestionType.SINGLE_CHOICE || this.type == QuestionType.SINGLE_CHOICE_WITH_INPUT_VALUE
                || this.type == QuestionType.MULTIPLE_CHOICE || this.type == QuestionType.MULTIPLE_CHOICE_WITH_INPUT_VALUE
                || this.type == QuestionType.SCALING || this.type == QuestionType.SORTING
        ) && (this.options == null || this.options.isEmpty()))
            throw new InvalidAttributesException("ERROR: Cannot complete operation! " + type + " type Questions must have a list of options!");


        Question question = new Question(this);

        if (reset)
            reset();

        return question;
    }

    /**
     *Resets all the information in the Builder
     */
    private void reset() {
        this.questionId = null;
        this.text = null;
        this.type = null;
        this.obligatoriness = null;
        this.info = null;
        this.instructions = null;
        this.options = new ArrayList<>();
    }
}
