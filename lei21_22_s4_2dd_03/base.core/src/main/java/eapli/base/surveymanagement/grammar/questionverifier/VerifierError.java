package eapli.base.surveymanagement.grammar.questionverifier;

import org.antlr.v4.runtime.*;
/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class VerifierError extends DefaultErrorStrategy {

    @Override
    public void reportError(Parser recognizer, RecognitionException e) {
        throw new RuntimeException("Grammar Error:Something went wrong! (Most commonly due to sentence not finished with final punctuation (E.g. '.'(Period)))");
    }


}
