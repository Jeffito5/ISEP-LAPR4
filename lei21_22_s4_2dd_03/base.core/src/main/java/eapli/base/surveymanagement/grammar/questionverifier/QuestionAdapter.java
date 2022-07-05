package eapli.base.surveymanagement.grammar.questionverifier;

import eapli.base.surveymanagement.domain.QuestionType;
/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class QuestionAdapter extends QuestionVerifierBaseVisitor<String> {

    @Override
    public String visitFree_text_question(QuestionVerifierParser.Free_text_questionContext ctx) {
        QuestionValidator.text = ctx.getText();
        return super.visitFree_text_question(ctx);
    }

    @Override
     public String visitChoice(QuestionVerifierParser.ChoiceContext ctx) {
        if (QuestionValidator.questionType == QuestionType.FREE_TEXT)
            new RuntimeException("ERROR: A Free-Text Question cannot have multiple options.");
        QuestionValidator.options.add(ctx.getText());
        return visitChildren(ctx);
    }


}
