package eapli.base.surveymanagement.builders;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.surveymanagement.application.AnswerSurveyController;
import eapli.base.surveymanagement.domain.Answer;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.QuestionType;
import eapli.base.surveymanagement.domain.Section;
import eapli.base.surveymanagement.domain.survey.Survey;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

public class AnswerBuilder {

    public Survey survey;
    public Question question;
    public Section section;
    public List<String> options;
    public Customer customer;
    private final boolean reset;

    public AnswerBuilder(boolean reset) {
        this.reset = reset;
    }


    public AnswerBuilder withSurvey(Survey survey) {
        this.survey = survey;
        return this;
    }

    public AnswerBuilder withSection(Section section) {
        this.section = section;
        return this;
    }

    public AnswerBuilder withQuestion(Question question) {
        this.question = question;
        return this;
    }

    public AnswerBuilder withText(List<String> options) throws InvalidAttributesException {
        if ((question.type() == QuestionType.SORTING) && options.size() != question.options().size())
            throw new InvalidAttributesException("ERROR: Sorting Question need you to sort all the options!");

        if (question.type() == QuestionType.MULTIPLE_CHOICE && options.size() == 0)
            throw new InvalidAttributesException("ERROR: Multiple Choice Questions need one or more options selected!");


        if ((question.type() == QuestionType.SINGLE_CHOICE
                || question.type() == QuestionType.SCALING
                || question.type() == QuestionType.FREE_TEXT
                || question.type() == QuestionType.NUMERIC)
                && options.size() > 1)
            throw new InvalidAttributesException("ERROR: This question type cannot have more than one option!");

        this.options = options;
        return this;
    }


    public AnswerBuilder withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Answer build() throws InvalidAttributesException {
        if (survey == null)
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing survey!");

        if (section == null)
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing section!");

        if (question == null)
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing question!");

        if (options == null || options.isEmpty())
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing answer text!");

        if (customer == null) {
            throw new InvalidAttributesException("ERROR: Cannot complete operation! Missing customer!");
        }
        if (!new AnswerSurveyController().hasAnswered(customer, survey, section, question)) {
            Answer answer = new Answer(survey, section, question, options, customer);
            if (reset)
                reset();
            return answer;
        }
       return null;
    }

    private void reset() {
        customer = null;
        survey = null;
        section = null;
        question = null;
        options = null;
    }

}
