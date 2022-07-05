package eapli.base.surveymanagement.grammar.answerverifier;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.surveymanagement.application.AnswerSurveyController;
import eapli.base.surveymanagement.domain.QuestionType;
import eapli.base.surveymanagement.grammar.answerverifier.generated.AnswerVerifierBaseVisitor;
import eapli.base.surveymanagement.grammar.answerverifier.generated.AnswerVerifierParser;
import lombok.SneakyThrows;

import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Author: 1201180 - Guilherme Sencadas
 */

public class AnswerAdapter extends AnswerVerifierBaseVisitor<String> {
    private final AnswerSurveyController controller;

    public AnswerAdapter( AnswerSurveyController controller){
        this.controller = controller;
    }


    @Override
    public String visitAnswerText(AnswerVerifierParser.AnswerTextContext ctx) {
        if (!(AnswerValidator.question.type() == QuestionType.FREE_TEXT || AnswerValidator.question.type() == QuestionType.NUMERIC))
            throw new RuntimeException("ERROR: Question Type does not support free-text answer!");

        if (AnswerValidator.question.type() == QuestionType.NUMERIC){
            try {
                Double.parseDouble(ctx.getText());
            }catch (NumberFormatException e){
                throw new RuntimeException("ERROR: Numeric question requires a numeric answer!");
            }
        }

        AnswerValidator.options.add(0, ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public String visitOption(AnswerVerifierParser.OptionContext ctx) {
        if (AnswerValidator.question.type() == QuestionType.FREE_TEXT || AnswerValidator.question.type() == QuestionType.NUMERIC)
            throw new RuntimeException("ERROR: Question Type does not support multiple options!");

        for (String option : AnswerValidator.question.options()) {
            if (option.startsWith(ctx.getText())) {
                AnswerValidator.options.add(ctx.getText());
                return visitChildren(ctx);
            }
        }
        throw new RuntimeException("ERROR: No option found by '" + ctx.getText() + "' !");
    }

    @Override
    public String visitSurveyID(AnswerVerifierParser.SurveyIDContext ctx) {
        try {
            AnswerValidator.survey = controller.findSurvey(ctx.getText());
        } catch (IndexOutOfBoundsException e) {
            AnswerValidator.survey = null;
        }
        if (AnswerValidator.survey == null)
            throw new RuntimeException("ERROR: No survey found with id '" + ctx.getText() + "'.");

        boolean contains = false;
        for (Customer customer : AnswerValidator.survey.audience()) {
            if (customer.compareTo(AnswerValidator.customer.identity()) == 0)
                contains = true;
        }

        if (!contains)
            throw new RuntimeException("ERROR: The current customer doesn't have access to survey '" + ctx.getText() + "'.");

        return visitChildren(ctx);
    }

    @Override
    public String visitQuestionnaireID(AnswerVerifierParser.QuestionnaireIDContext ctx) {
        AnswerValidator.questionnaire = controller.findQuestionnaire(AnswerValidator.survey, ctx.getText());
        if (AnswerValidator.questionnaire == null)
            throw new RuntimeException("ERROR: No questionnaire found with id '" + ctx.getText() + "' in current Survey.");
        return visitChildren(ctx);
    }

    @Override
    public String visitSectionID(AnswerVerifierParser.SectionIDContext ctx) {
        AnswerValidator.section = controller.findSection(AnswerValidator.questionnaire, ctx.getText());
        if (AnswerValidator.section == null)
            throw new RuntimeException("ERROR: No section found with id '" + ctx.getText() + "'.");
        return visitChildren(ctx);
    }

    @Override
    public String visitQuestionID(AnswerVerifierParser.QuestionIDContext ctx) {
        AnswerValidator.question = controller.findQuestion(AnswerValidator.section, ctx.getText());
        if (AnswerValidator.question == null)
            throw new RuntimeException("ERROR: No question found with id '" + ctx.getText() + "'.");
        return visitChildren(ctx);
    }

    @SneakyThrows
    @Override
    public String visitReadQuestion(AnswerVerifierParser.ReadQuestionContext ctx) {
        if (AnswerValidator.question!= null && AnswerValidator.question.isMandatory() && AnswerValidator.options.isEmpty()){
            throw new RuntimeException("ERROR: A mandatory question was not answered!");
        }

        if (AnswerValidator.question != null && !AnswerValidator.options.isEmpty()) {
            controller.createAnswer(AnswerValidator.survey, AnswerValidator.section, AnswerValidator.question, AnswerValidator.options);
            AnswerValidator.question = null;
            AnswerValidator.options = new ArrayList<>();
        }



        return visitChildren(ctx);
    }

}
