package eapli.base.surveymanagement.grammar.questionverifier;

import eapli.base.surveymanagement.domain.QuestionType;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class QuestionValidator {

    public static QuestionType questionType;
    public static List<String> options;
    public static String text;

    public static void validate(File file, QuestionType type) throws IOException, RuntimeException {
        questionType = type;
        options=new ArrayList<>();
        FileInputStream fis = new FileInputStream(file);
        QuestionVerifierLexer lexer = new QuestionVerifierLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QuestionVerifierParser parser = new QuestionVerifierParser(tokens);
        ParseTree tree = parser.question(); // parse
        QuestionAdapter vis = new QuestionAdapter();
        vis.visit(tree);
    }

    public static void reset(){
        questionType = null;
        options = new ArrayList<>();
        text = null;
    }
}
