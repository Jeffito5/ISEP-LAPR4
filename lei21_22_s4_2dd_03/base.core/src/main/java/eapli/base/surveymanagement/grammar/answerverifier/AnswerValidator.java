package eapli.base.surveymanagement.grammar.answerverifier;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.surveymanagement.application.AnswerSurveyController;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.Section;
import eapli.base.surveymanagement.domain.survey.Survey;
import eapli.base.surveymanagement.grammar.answerverifier.generated.AnswerVerifierLexer;
import eapli.base.surveymanagement.grammar.answerverifier.generated.AnswerVerifierParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * Author: 1201180 - Guilherme Sencadas
 */

public class AnswerValidator {

    public static Survey survey;
    public static Questionnaire questionnaire;
    public static Section section;
    public static Question question;
    public static List<String> options = new ArrayList<>();
    public static Customer customer;

    private final AnswerSurveyController controller;

    public AnswerValidator(AnswerSurveyController controller){
        this.controller = controller;
    }

    public void validate(String path) throws IOException {

        FileInputStream fis = new FileInputStream(path);
        AnswerVerifierLexer lexer = new AnswerVerifierLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AnswerVerifierParser parser = new AnswerVerifierParser(tokens);
        ParseTree tree = parser.readSurvey(); // parse
        AnswerAdapter vis = new AnswerAdapter(controller);
        vis.visit(tree);

    }
}
