// Generated from E:/Backup/UNI/Ano 2/Semestre 2/LAPR4/lei21_22_s4_2dd_03/base.core/src/main/java/eapli/base/surveymanagement/grammar/answerverifier\AnswerVerifier.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.grammar.answerverifier.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AnswerVerifierParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AnswerVerifierVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#readSurvey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadSurvey(AnswerVerifierParser.ReadSurveyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#readQuestionnaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadQuestionnaire(AnswerVerifierParser.ReadQuestionnaireContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#readSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadSection(AnswerVerifierParser.ReadSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#readQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadQuestion(AnswerVerifierParser.ReadQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#readAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadAnswer(AnswerVerifierParser.ReadAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(AnswerVerifierParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_question(AnswerVerifierParser.Multiple_choice_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#choices}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoices(AnswerVerifierParser.ChoicesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice(AnswerVerifierParser.ChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#free_text_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFree_text_question(AnswerVerifierParser.Free_text_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#answerText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerText(AnswerVerifierParser.AnswerTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#answerOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerOptions(AnswerVerifierParser.AnswerOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(AnswerVerifierParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(AnswerVerifierParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase(AnswerVerifierParser.PhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(AnswerVerifierParser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#repeatInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatInfo(AnswerVerifierParser.RepeatInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#extraInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtraInfo(AnswerVerifierParser.ExtraInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#obli}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObli(AnswerVerifierParser.ObliContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#welcomeMessage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWelcomeMessage(AnswerVerifierParser.WelcomeMessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#finalMessage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalMessage(AnswerVerifierParser.FinalMessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription(AnswerVerifierParser.DescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructions(AnswerVerifierParser.InstructionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#surveyID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSurveyID(AnswerVerifierParser.SurveyIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#questionnaireID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionnaireID(AnswerVerifierParser.QuestionnaireIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#sectionID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSectionID(AnswerVerifierParser.SectionIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#questionID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionID(AnswerVerifierParser.QuestionIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#obligatoriness}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObligatoriness(AnswerVerifierParser.ObligatorinessContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#repeatability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatability(AnswerVerifierParser.RepeatabilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerVerifierParser#repeatID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatID(AnswerVerifierParser.RepeatIDContext ctx);
}