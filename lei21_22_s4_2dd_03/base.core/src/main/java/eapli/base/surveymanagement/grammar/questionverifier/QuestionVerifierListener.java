// Generated from E:/Backup/UNI/Ano 2/Semestre 2/LAPR4/lei21_22_s4_2dd_03/base.core/src/main/java/eapli/base/surveymanagement/grammar\QuestionVerifier.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.grammar.questionverifier;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuestionVerifierParser}.
 */
public interface QuestionVerifierListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuestionVerifierParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QuestionVerifierParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionVerifierParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QuestionVerifierParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionVerifierParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_question(QuestionVerifierParser.Multiple_choice_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionVerifierParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_question(QuestionVerifierParser.Multiple_choice_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionVerifierParser#choices}.
	 * @param ctx the parse tree
	 */
	void enterChoices(QuestionVerifierParser.ChoicesContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionVerifierParser#choices}.
	 * @param ctx the parse tree
	 */
	void exitChoices(QuestionVerifierParser.ChoicesContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionVerifierParser#choice}.
	 * @param ctx the parse tree
	 */
	void enterChoice(QuestionVerifierParser.ChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionVerifierParser#choice}.
	 * @param ctx the parse tree
	 */
	void exitChoice(QuestionVerifierParser.ChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionVerifierParser#free_text_question}.
	 * @param ctx the parse tree
	 */
	void enterFree_text_question(QuestionVerifierParser.Free_text_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionVerifierParser#free_text_question}.
	 * @param ctx the parse tree
	 */
	void exitFree_text_question(QuestionVerifierParser.Free_text_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionVerifierParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(QuestionVerifierParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionVerifierParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(QuestionVerifierParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionVerifierParser#phrase}.
	 * @param ctx the parse tree
	 */
	void enterPhrase(QuestionVerifierParser.PhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionVerifierParser#phrase}.
	 * @param ctx the parse tree
	 */
	void exitPhrase(QuestionVerifierParser.PhraseContext ctx);
}