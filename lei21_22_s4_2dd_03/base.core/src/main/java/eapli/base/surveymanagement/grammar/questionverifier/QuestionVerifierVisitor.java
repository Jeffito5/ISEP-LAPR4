// Generated from E:/Backup/UNI/Ano 2/Semestre 2/LAPR4/lei21_22_s4_2dd_03/base.core/src/main/java/eapli/base/surveymanagement/grammar\QuestionVerifier.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.grammar.questionverifier;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuestionVerifierParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuestionVerifierVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuestionVerifierParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QuestionVerifierParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionVerifierParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_question(QuestionVerifierParser.Multiple_choice_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionVerifierParser#choices}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoices(QuestionVerifierParser.ChoicesContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionVerifierParser#choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice(QuestionVerifierParser.ChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionVerifierParser#free_text_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFree_text_question(QuestionVerifierParser.Free_text_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionVerifierParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(QuestionVerifierParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionVerifierParser#phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase(QuestionVerifierParser.PhraseContext ctx);
}