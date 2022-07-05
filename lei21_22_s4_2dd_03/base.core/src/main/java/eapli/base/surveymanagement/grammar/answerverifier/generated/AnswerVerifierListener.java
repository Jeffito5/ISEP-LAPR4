// Generated from E:/Backup/UNI/Ano 2/Semestre 2/LAPR4/lei21_22_s4_2dd_03/base.core/src/main/java/eapli/base/surveymanagement/grammar/answerverifier\AnswerVerifier.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.grammar.answerverifier.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AnswerVerifierParser}.
 */
public interface AnswerVerifierListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#readSurvey}.
	 * @param ctx the parse tree
	 */
	void enterReadSurvey(AnswerVerifierParser.ReadSurveyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#readSurvey}.
	 * @param ctx the parse tree
	 */
	void exitReadSurvey(AnswerVerifierParser.ReadSurveyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#readQuestionnaire}.
	 * @param ctx the parse tree
	 */
	void enterReadQuestionnaire(AnswerVerifierParser.ReadQuestionnaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#readQuestionnaire}.
	 * @param ctx the parse tree
	 */
	void exitReadQuestionnaire(AnswerVerifierParser.ReadQuestionnaireContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#readSection}.
	 * @param ctx the parse tree
	 */
	void enterReadSection(AnswerVerifierParser.ReadSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#readSection}.
	 * @param ctx the parse tree
	 */
	void exitReadSection(AnswerVerifierParser.ReadSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#readQuestion}.
	 * @param ctx the parse tree
	 */
	void enterReadQuestion(AnswerVerifierParser.ReadQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#readQuestion}.
	 * @param ctx the parse tree
	 */
	void exitReadQuestion(AnswerVerifierParser.ReadQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#readAnswer}.
	 * @param ctx the parse tree
	 */
	void enterReadAnswer(AnswerVerifierParser.ReadAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#readAnswer}.
	 * @param ctx the parse tree
	 */
	void exitReadAnswer(AnswerVerifierParser.ReadAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(AnswerVerifierParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(AnswerVerifierParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_question(AnswerVerifierParser.Multiple_choice_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_question(AnswerVerifierParser.Multiple_choice_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#choices}.
	 * @param ctx the parse tree
	 */
	void enterChoices(AnswerVerifierParser.ChoicesContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#choices}.
	 * @param ctx the parse tree
	 */
	void exitChoices(AnswerVerifierParser.ChoicesContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#choice}.
	 * @param ctx the parse tree
	 */
	void enterChoice(AnswerVerifierParser.ChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#choice}.
	 * @param ctx the parse tree
	 */
	void exitChoice(AnswerVerifierParser.ChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#free_text_question}.
	 * @param ctx the parse tree
	 */
	void enterFree_text_question(AnswerVerifierParser.Free_text_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#free_text_question}.
	 * @param ctx the parse tree
	 */
	void exitFree_text_question(AnswerVerifierParser.Free_text_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#answerText}.
	 * @param ctx the parse tree
	 */
	void enterAnswerText(AnswerVerifierParser.AnswerTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#answerText}.
	 * @param ctx the parse tree
	 */
	void exitAnswerText(AnswerVerifierParser.AnswerTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#answerOptions}.
	 * @param ctx the parse tree
	 */
	void enterAnswerOptions(AnswerVerifierParser.AnswerOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#answerOptions}.
	 * @param ctx the parse tree
	 */
	void exitAnswerOptions(AnswerVerifierParser.AnswerOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(AnswerVerifierParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(AnswerVerifierParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(AnswerVerifierParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(AnswerVerifierParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#phrase}.
	 * @param ctx the parse tree
	 */
	void enterPhrase(AnswerVerifierParser.PhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#phrase}.
	 * @param ctx the parse tree
	 */
	void exitPhrase(AnswerVerifierParser.PhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(AnswerVerifierParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(AnswerVerifierParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#repeatInfo}.
	 * @param ctx the parse tree
	 */
	void enterRepeatInfo(AnswerVerifierParser.RepeatInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#repeatInfo}.
	 * @param ctx the parse tree
	 */
	void exitRepeatInfo(AnswerVerifierParser.RepeatInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#extraInfo}.
	 * @param ctx the parse tree
	 */
	void enterExtraInfo(AnswerVerifierParser.ExtraInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#extraInfo}.
	 * @param ctx the parse tree
	 */
	void exitExtraInfo(AnswerVerifierParser.ExtraInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#obli}.
	 * @param ctx the parse tree
	 */
	void enterObli(AnswerVerifierParser.ObliContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#obli}.
	 * @param ctx the parse tree
	 */
	void exitObli(AnswerVerifierParser.ObliContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#welcomeMessage}.
	 * @param ctx the parse tree
	 */
	void enterWelcomeMessage(AnswerVerifierParser.WelcomeMessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#welcomeMessage}.
	 * @param ctx the parse tree
	 */
	void exitWelcomeMessage(AnswerVerifierParser.WelcomeMessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#finalMessage}.
	 * @param ctx the parse tree
	 */
	void enterFinalMessage(AnswerVerifierParser.FinalMessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#finalMessage}.
	 * @param ctx the parse tree
	 */
	void exitFinalMessage(AnswerVerifierParser.FinalMessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(AnswerVerifierParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(AnswerVerifierParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstructions(AnswerVerifierParser.InstructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstructions(AnswerVerifierParser.InstructionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#surveyID}.
	 * @param ctx the parse tree
	 */
	void enterSurveyID(AnswerVerifierParser.SurveyIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#surveyID}.
	 * @param ctx the parse tree
	 */
	void exitSurveyID(AnswerVerifierParser.SurveyIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#questionnaireID}.
	 * @param ctx the parse tree
	 */
	void enterQuestionnaireID(AnswerVerifierParser.QuestionnaireIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#questionnaireID}.
	 * @param ctx the parse tree
	 */
	void exitQuestionnaireID(AnswerVerifierParser.QuestionnaireIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#sectionID}.
	 * @param ctx the parse tree
	 */
	void enterSectionID(AnswerVerifierParser.SectionIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#sectionID}.
	 * @param ctx the parse tree
	 */
	void exitSectionID(AnswerVerifierParser.SectionIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#questionID}.
	 * @param ctx the parse tree
	 */
	void enterQuestionID(AnswerVerifierParser.QuestionIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#questionID}.
	 * @param ctx the parse tree
	 */
	void exitQuestionID(AnswerVerifierParser.QuestionIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#obligatoriness}.
	 * @param ctx the parse tree
	 */
	void enterObligatoriness(AnswerVerifierParser.ObligatorinessContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#obligatoriness}.
	 * @param ctx the parse tree
	 */
	void exitObligatoriness(AnswerVerifierParser.ObligatorinessContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#repeatability}.
	 * @param ctx the parse tree
	 */
	void enterRepeatability(AnswerVerifierParser.RepeatabilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#repeatability}.
	 * @param ctx the parse tree
	 */
	void exitRepeatability(AnswerVerifierParser.RepeatabilityContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerVerifierParser#repeatID}.
	 * @param ctx the parse tree
	 */
	void enterRepeatID(AnswerVerifierParser.RepeatIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerVerifierParser#repeatID}.
	 * @param ctx the parse tree
	 */
	void exitRepeatID(AnswerVerifierParser.RepeatIDContext ctx);
}