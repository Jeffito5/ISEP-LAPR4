// Generated from E:/Backup/UNI/Ano 2/Semestre 2/LAPR4/lei21_22_s4_2dd_03/base.core/src/main/java/eapli/base/surveymanagement/grammar/answerverifier\AnswerVerifier.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.grammar.answerverifier.generated;
import eapli.base.surveymanagement.grammar.questionverifier.VerifierError;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AnswerVerifierParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected ANTLRErrorStrategy _errHandler = new VerifierError();

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, SURVEY=5, QUESTIONNAIRE=6, QUESTION=7, 
		SECTION=8, WELCOME_MESSAGE=9, FINAL_MESSAGE=10, MANDATORY=11, OPTIONAL=12, 
		CONDITIONAL=13, DESCRIPTION=14, ABOUT=15, CATEGORY=16, BRAND=17, INSTRUCTIONS=18, 
		ANSWER=19, LIST_OF_SECTIONS=20, LIST_OF_QUESTIONS=21, LIST_OF_OPTIONS=22, 
		WORD=23, PUNCTUATION=24, SPACE=25, COMMA=26, IGNORE=27, OPTION=28, LETTER=29, 
		NUMBER=30;
	public static final int
		RULE_readSurvey = 0, RULE_readQuestionnaire = 1, RULE_readSection = 2, 
		RULE_readQuestion = 3, RULE_readAnswer = 4, RULE_question = 5, RULE_multiple_choice_question = 6, 
		RULE_choices = 7, RULE_choice = 8, RULE_free_text_question = 9, RULE_answerText = 10, 
		RULE_answerOptions = 11, RULE_option = 12, RULE_text = 13, RULE_phrase = 14, 
		RULE_title = 15, RULE_repeatInfo = 16, RULE_extraInfo = 17, RULE_obli = 18, 
		RULE_welcomeMessage = 19, RULE_finalMessage = 20, RULE_description = 21, 
		RULE_instructions = 22, RULE_surveyID = 23, RULE_questionnaireID = 24, 
		RULE_sectionID = 25, RULE_questionID = 26, RULE_obligatoriness = 27, RULE_repeatability = 28, 
		RULE_repeatID = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"readSurvey", "readQuestionnaire", "readSection", "readQuestion", "readAnswer", 
			"question", "multiple_choice_question", "choices", "choice", "free_text_question", 
			"answerText", "answerOptions", "option", "text", "phrase", "title", "repeatInfo", 
			"extraInfo", "obli", "welcomeMessage", "finalMessage", "description", 
			"instructions", "surveyID", "questionnaireID", "sectionID", "questionID", 
			"obligatoriness", "repeatability", "repeatID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'-'", "'('", "')'", null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "' '", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "SURVEY", "QUESTIONNAIRE", "QUESTION", 
			"SECTION", "WELCOME_MESSAGE", "FINAL_MESSAGE", "MANDATORY", "OPTIONAL", 
			"CONDITIONAL", "DESCRIPTION", "ABOUT", "CATEGORY", "BRAND", "INSTRUCTIONS", 
			"ANSWER", "LIST_OF_SECTIONS", "LIST_OF_QUESTIONS", "LIST_OF_OPTIONS", 
			"WORD", "PUNCTUATION", "SPACE", "COMMA", "IGNORE", "OPTION", "LETTER", 
			"NUMBER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AnswerVerifier.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AnswerVerifierParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ReadSurveyContext extends ParserRuleContext {
		public TerminalNode SURVEY() { return getToken(AnswerVerifierParser.SURVEY, 0); }
		public TerminalNode SPACE() { return getToken(AnswerVerifierParser.SPACE, 0); }
		public SurveyIDContext surveyID() {
			return getRuleContext(SurveyIDContext.class,0);
		}
		public ReadQuestionnaireContext readQuestionnaire() {
			return getRuleContext(ReadQuestionnaireContext.class,0);
		}
		public ReadSurveyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readSurvey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterReadSurvey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitReadSurvey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitReadSurvey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadSurveyContext readSurvey() throws RecognitionException {
		ReadSurveyContext _localctx = new ReadSurveyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_readSurvey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(SURVEY);
			setState(61);
			match(SPACE);
			setState(62);
			surveyID();
			setState(63);
			match(T__0);
			setState(64);
			readQuestionnaire();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadQuestionnaireContext extends ParserRuleContext {
		public List<TerminalNode> QUESTIONNAIRE() { return getTokens(AnswerVerifierParser.QUESTIONNAIRE); }
		public TerminalNode QUESTIONNAIRE(int i) {
			return getToken(AnswerVerifierParser.QUESTIONNAIRE, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(AnswerVerifierParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(AnswerVerifierParser.SPACE, i);
		}
		public QuestionnaireIDContext questionnaireID() {
			return getRuleContext(QuestionnaireIDContext.class,0);
		}
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public WelcomeMessageContext welcomeMessage() {
			return getRuleContext(WelcomeMessageContext.class,0);
		}
		public TerminalNode LIST_OF_SECTIONS() { return getToken(AnswerVerifierParser.LIST_OF_SECTIONS, 0); }
		public ReadSectionContext readSection() {
			return getRuleContext(ReadSectionContext.class,0);
		}
		public FinalMessageContext finalMessage() {
			return getRuleContext(FinalMessageContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AnswerVerifierParser.EOF, 0); }
		public ReadQuestionnaireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readQuestionnaire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterReadQuestionnaire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitReadQuestionnaire(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitReadQuestionnaire(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadQuestionnaireContext readQuestionnaire() throws RecognitionException {
		ReadQuestionnaireContext _localctx = new ReadQuestionnaireContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_readQuestionnaire);
		int _la;
		try {
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case QUESTIONNAIRE:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(QUESTIONNAIRE);
				setState(67);
				match(SPACE);
				setState(68);
				questionnaireID();
				setState(69);
				match(T__0);
				setState(70);
				match(SPACE);
				setState(71);
				title();
				setState(72);
				welcomeMessage();
				setState(73);
				match(LIST_OF_SECTIONS);
				setState(74);
				readSection();
				setState(75);
				match(QUESTIONNAIRE);
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(76);
					match(SPACE);
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(82);
				finalMessage();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				match(EOF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadSectionContext extends ParserRuleContext {
		public TerminalNode SECTION() { return getToken(AnswerVerifierParser.SECTION, 0); }
		public List<TerminalNode> SPACE() { return getTokens(AnswerVerifierParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(AnswerVerifierParser.SPACE, i);
		}
		public SectionIDContext sectionID() {
			return getRuleContext(SectionIDContext.class,0);
		}
		public RepeatInfoContext repeatInfo() {
			return getRuleContext(RepeatInfoContext.class,0);
		}
		public ObliContext obli() {
			return getRuleContext(ObliContext.class,0);
		}
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public TerminalNode LIST_OF_QUESTIONS() { return getToken(AnswerVerifierParser.LIST_OF_QUESTIONS, 0); }
		public ReadQuestionContext readQuestion() {
			return getRuleContext(ReadQuestionContext.class,0);
		}
		public ReadSectionContext readSection() {
			return getRuleContext(ReadSectionContext.class,0);
		}
		public ReadSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterReadSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitReadSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitReadSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadSectionContext readSection() throws RecognitionException {
		ReadSectionContext _localctx = new ReadSectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_readSection);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(SECTION);
				setState(88);
				match(SPACE);
				setState(89);
				sectionID();
				setState(90);
				match(T__0);
				setState(91);
				repeatInfo();
				setState(92);
				obli();
				setState(93);
				match(SPACE);
				setState(94);
				match(T__1);
				setState(95);
				match(SPACE);
				setState(96);
				title();
				setState(97);
				description();
				setState(98);
				match(LIST_OF_QUESTIONS);
				setState(99);
				readQuestion();
				setState(100);
				readSection();
				}
				break;
			case QUESTIONNAIRE:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadQuestionContext extends ParserRuleContext {
		public TerminalNode QUESTION() { return getToken(AnswerVerifierParser.QUESTION, 0); }
		public ObliContext obli() {
			return getRuleContext(ObliContext.class,0);
		}
		public QuestionIDContext questionID() {
			return getRuleContext(QuestionIDContext.class,0);
		}
		public TerminalNode PUNCTUATION() { return getToken(AnswerVerifierParser.PUNCTUATION, 0); }
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public ReadAnswerContext readAnswer() {
			return getRuleContext(ReadAnswerContext.class,0);
		}
		public ReadQuestionContext readQuestion() {
			return getRuleContext(ReadQuestionContext.class,0);
		}
		public List<TerminalNode> SPACE() { return getTokens(AnswerVerifierParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(AnswerVerifierParser.SPACE, i);
		}
		public ReadQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterReadQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitReadQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitReadQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadQuestionContext readQuestion() throws RecognitionException {
		ReadQuestionContext _localctx = new ReadQuestionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_readQuestion);
		int _la;
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case QUESTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(QUESTION);
				setState(106);
				match(T__0);
				setState(107);
				obli();
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(108);
					match(SPACE);
					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(114);
				match(T__1);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(115);
					match(SPACE);
					}
					}
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(121);
				questionID();
				setState(122);
				match(PUNCTUATION);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(123);
					match(SPACE);
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(129);
				question();
				setState(130);
				readAnswer();
				setState(131);
				readQuestion();
				}
				break;
			case QUESTIONNAIRE:
			case SECTION:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadAnswerContext extends ParserRuleContext {
		public TerminalNode ANSWER() { return getToken(AnswerVerifierParser.ANSWER, 0); }
		public AnswerTextContext answerText() {
			return getRuleContext(AnswerTextContext.class,0);
		}
		public AnswerOptionsContext answerOptions() {
			return getRuleContext(AnswerOptionsContext.class,0);
		}
		public TerminalNode PUNCTUATION() { return getToken(AnswerVerifierParser.PUNCTUATION, 0); }
		public ReadAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterReadAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitReadAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitReadAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadAnswerContext readAnswer() throws RecognitionException {
		ReadAnswerContext _localctx = new ReadAnswerContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_readAnswer);
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(ANSWER);
				setState(137);
				answerText();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(ANSWER);
				setState(139);
				answerOptions();
				setState(140);
				match(PUNCTUATION);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(ANSWER);
				setState(143);
				answerOptions();
				throw new RuntimeException("GRAMMAR ERROR: Missing Final Punctuation! E.g. Period '.'");
				}
				case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(146);
				match(ANSWER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionContext extends ParserRuleContext {
		public Free_text_questionContext free_text_question() {
			return getRuleContext(Free_text_questionContext.class,0);
		}
		public Multiple_choice_questionContext multiple_choice_question() {
			return getRuleContext(Multiple_choice_questionContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_question);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				free_text_question();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				multiple_choice_question();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multiple_choice_questionContext extends ParserRuleContext {
		public Free_text_questionContext free_text_question() {
			return getRuleContext(Free_text_questionContext.class,0);
		}
		public TerminalNode LIST_OF_OPTIONS() { return getToken(AnswerVerifierParser.LIST_OF_OPTIONS, 0); }
		public ChoicesContext choices() {
			return getRuleContext(ChoicesContext.class,0);
		}
		public Multiple_choice_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterMultiple_choice_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitMultiple_choice_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitMultiple_choice_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choice_questionContext multiple_choice_question() throws RecognitionException {
		Multiple_choice_questionContext _localctx = new Multiple_choice_questionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_multiple_choice_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			free_text_question();
			setState(154);
			match(LIST_OF_OPTIONS);
			setState(155);
			choices();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChoicesContext extends ParserRuleContext {
		public ChoiceContext choice() {
			return getRuleContext(ChoiceContext.class,0);
		}
		public ChoicesContext choices() {
			return getRuleContext(ChoicesContext.class,0);
		}
		public ChoicesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choices; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterChoices(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitChoices(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitChoices(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoicesContext choices() throws RecognitionException {
		ChoicesContext _localctx = new ChoicesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_choices);
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				choice();
				setState(158);
				choices();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				choice();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChoiceContext extends ParserRuleContext {
		public TerminalNode OPTION() { return getToken(AnswerVerifierParser.OPTION, 0); }
		public List<TerminalNode> SPACE() { return getTokens(AnswerVerifierParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(AnswerVerifierParser.SPACE, i);
		}
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public ChoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitChoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitChoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoiceContext choice() throws RecognitionException {
		ChoiceContext _localctx = new ChoiceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_choice);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(OPTION);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(164);
				match(SPACE);
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(171); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(170);
					phrase();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(173); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Free_text_questionContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public ExtraInfoContext extraInfo() {
			return getRuleContext(ExtraInfoContext.class,0);
		}
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public List<TerminalNode> PUNCTUATION() { return getTokens(AnswerVerifierParser.PUNCTUATION); }
		public TerminalNode PUNCTUATION(int i) {
			return getToken(AnswerVerifierParser.PUNCTUATION, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(AnswerVerifierParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(AnswerVerifierParser.SPACE, i);
		}
		public Free_text_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_free_text_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterFree_text_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitFree_text_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitFree_text_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Free_text_questionContext free_text_question() throws RecognitionException {
		Free_text_questionContext _localctx = new Free_text_questionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_free_text_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			text();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUNCTUATION) {
				{
				{
				setState(176);
				match(PUNCTUATION);
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(182);
				match(SPACE);
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(188);
			extraInfo();
			setState(189);
			instructions();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnswerTextContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public AnswerTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterAnswerText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitAnswerText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitAnswerText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerTextContext answerText() throws RecognitionException {
		AnswerTextContext _localctx = new AnswerTextContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_answerText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			text();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnswerOptionsContext extends ParserRuleContext {
		public OptionContext option() {
			return getRuleContext(OptionContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(AnswerVerifierParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AnswerVerifierParser.COMMA, i);
		}
		public List<AnswerOptionsContext> answerOptions() {
			return getRuleContexts(AnswerOptionsContext.class);
		}
		public AnswerOptionsContext answerOptions(int i) {
			return getRuleContext(AnswerOptionsContext.class,i);
		}
		public List<TerminalNode> SPACE() { return getTokens(AnswerVerifierParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(AnswerVerifierParser.SPACE, i);
		}
		public AnswerOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterAnswerOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitAnswerOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitAnswerOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerOptionsContext answerOptions() throws RecognitionException {
		AnswerOptionsContext _localctx = new AnswerOptionsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_answerOptions);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			option();
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(194);
					match(COMMA);
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACE) {
						{
						{
						setState(195);
						match(SPACE);
						}
						}
						setState(200);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(201);
					answerOptions();
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionContext extends ParserRuleContext {
		public TerminalNode OPTION() { return getToken(AnswerVerifierParser.OPTION, 0); }
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(OPTION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextContext extends ParserRuleContext {
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public TerminalNode SPACE() { return getToken(AnswerVerifierParser.SPACE, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_text);
		try {
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				phrase();
				setState(210);
				text();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				phrase();
				setState(213);
				match(SPACE);
				setState(214);
				text();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
				phrase();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PhraseContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(AnswerVerifierParser.WORD, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public TerminalNode PUNCTUATION() { return getToken(AnswerVerifierParser.PUNCTUATION, 0); }
		public TerminalNode SPACE() { return getToken(AnswerVerifierParser.SPACE, 0); }
		public TerminalNode COMMA() { return getToken(AnswerVerifierParser.COMMA, 0); }
		public TerminalNode QUESTIONNAIRE() { return getToken(AnswerVerifierParser.QUESTIONNAIRE, 0); }
		public TerminalNode SURVEY() { return getToken(AnswerVerifierParser.SURVEY, 0); }
		public TerminalNode QUESTION() { return getToken(AnswerVerifierParser.QUESTION, 0); }
		public TerminalNode SECTION() { return getToken(AnswerVerifierParser.SECTION, 0); }
		public TerminalNode WELCOME_MESSAGE() { return getToken(AnswerVerifierParser.WELCOME_MESSAGE, 0); }
		public TerminalNode FINAL_MESSAGE() { return getToken(AnswerVerifierParser.FINAL_MESSAGE, 0); }
		public TerminalNode LIST_OF_OPTIONS() { return getToken(AnswerVerifierParser.LIST_OF_OPTIONS, 0); }
		public TerminalNode LIST_OF_QUESTIONS() { return getToken(AnswerVerifierParser.LIST_OF_QUESTIONS, 0); }
		public TerminalNode LIST_OF_SECTIONS() { return getToken(AnswerVerifierParser.LIST_OF_SECTIONS, 0); }
		public TerminalNode CATEGORY() { return getToken(AnswerVerifierParser.CATEGORY, 0); }
		public TerminalNode BRAND() { return getToken(AnswerVerifierParser.BRAND, 0); }
		public TerminalNode MANDATORY() { return getToken(AnswerVerifierParser.MANDATORY, 0); }
		public TerminalNode OPTIONAL() { return getToken(AnswerVerifierParser.OPTIONAL, 0); }
		public TerminalNode CONDITIONAL() { return getToken(AnswerVerifierParser.CONDITIONAL, 0); }
		public TerminalNode DESCRIPTION() { return getToken(AnswerVerifierParser.DESCRIPTION, 0); }
		public TerminalNode INSTRUCTIONS() { return getToken(AnswerVerifierParser.INSTRUCTIONS, 0); }
		public TerminalNode ABOUT() { return getToken(AnswerVerifierParser.ABOUT, 0); }
		public TerminalNode ANSWER() { return getToken(AnswerVerifierParser.ANSWER, 0); }
		public PhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_phrase);
		try {
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				match(WORD);
				setState(220);
				phrase();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				match(WORD);
				setState(222);
				match(PUNCTUATION);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(223);
				match(PUNCTUATION);
				setState(224);
				match(SPACE);
				setState(225);
				phrase();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(226);
				match(PUNCTUATION);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(227);
				match(WORD);
				setState(228);
				match(SPACE);
				setState(229);
				phrase();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(230);
				match(COMMA);
				setState(231);
				match(SPACE);
				setState(232);
				phrase();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(233);
				match(QUESTIONNAIRE);
				setState(234);
				phrase();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(235);
				match(SURVEY);
				setState(236);
				phrase();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(237);
				match(QUESTION);
				setState(238);
				phrase();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(239);
				match(SECTION);
				setState(240);
				phrase();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(241);
				match(WELCOME_MESSAGE);
				setState(242);
				phrase();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(243);
				match(FINAL_MESSAGE);
				setState(244);
				phrase();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(245);
				match(LIST_OF_OPTIONS);
				setState(246);
				phrase();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(247);
				match(LIST_OF_QUESTIONS);
				setState(248);
				phrase();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(249);
				match(LIST_OF_SECTIONS);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(250);
				match(CATEGORY);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(251);
				match(BRAND);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(252);
				match(MANDATORY);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(253);
				match(OPTIONAL);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(254);
				match(CONDITIONAL);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(255);
				match(DESCRIPTION);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(256);
				match(INSTRUCTIONS);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(257);
				match(ABOUT);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(258);
				match(ANSWER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TitleContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(AnswerVerifierParser.WORD, 0); }
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public List<TerminalNode> SPACE() { return getTokens(AnswerVerifierParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(AnswerVerifierParser.SPACE, i);
		}
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitTitle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitTitle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_title);
		int _la;
		try {
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				match(WORD);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				match(WORD);
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(263);
					match(SPACE);
					}
					}
					setState(268);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(269);
				title();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepeatInfoContext extends ParserRuleContext {
		public List<TerminalNode> SPACE() { return getTokens(AnswerVerifierParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(AnswerVerifierParser.SPACE, i);
		}
		public TerminalNode ABOUT() { return getToken(AnswerVerifierParser.ABOUT, 0); }
		public RepeatabilityContext repeatability() {
			return getRuleContext(RepeatabilityContext.class,0);
		}
		public RepeatIDContext repeatID() {
			return getRuleContext(RepeatIDContext.class,0);
		}
		public RepeatInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterRepeatInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitRepeatInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitRepeatInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatInfoContext repeatInfo() throws RecognitionException {
		RepeatInfoContext _localctx = new RepeatInfoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_repeatInfo);
		int _la;
		try {
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				match(SPACE);
				setState(273);
				match(T__2);
				setState(274);
				match(ABOUT);
				setState(275);
				match(SPACE);
				setState(276);
				repeatability();
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(277);
					match(SPACE);
					}
					}
					setState(282);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(283);
				repeatID();
				setState(284);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtraInfoContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public ExtraInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extraInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterExtraInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitExtraInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitExtraInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtraInfoContext extraInfo() throws RecognitionException {
		ExtraInfoContext _localctx = new ExtraInfoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_extraInfo);
		try {
			setState(294);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				match(T__2);
				setState(290);
				text();
				setState(291);
				match(T__3);
				}
				break;
			case INSTRUCTIONS:
			case ANSWER:
			case LIST_OF_OPTIONS:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObliContext extends ParserRuleContext {
		public ObligatorinessContext obligatoriness() {
			return getRuleContext(ObligatorinessContext.class,0);
		}
		public ObliContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obli; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterObli(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitObli(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitObli(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObliContext obli() throws RecognitionException {
		ObliContext _localctx = new ObliContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_obli);
		try {
			setState(301);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				match(T__2);
				setState(297);
				obligatoriness();
				setState(298);
				match(T__3);
				}
				break;
			case T__1:
			case SPACE:
				enterOuterAlt(_localctx, 2);
				{
				throw new RuntimeException("GRAMMAR ERROR: Missing Obligatoriness!");
				}
				default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WelcomeMessageContext extends ParserRuleContext {
		public TerminalNode WELCOME_MESSAGE() { return getToken(AnswerVerifierParser.WELCOME_MESSAGE, 0); }
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public WelcomeMessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_welcomeMessage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterWelcomeMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitWelcomeMessage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitWelcomeMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WelcomeMessageContext welcomeMessage() throws RecognitionException {
		WelcomeMessageContext _localctx = new WelcomeMessageContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_welcomeMessage);
		try {
			setState(306);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WELCOME_MESSAGE:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				match(WELCOME_MESSAGE);
				setState(304);
				text();
				}
				break;
			case LIST_OF_SECTIONS:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinalMessageContext extends ParserRuleContext {
		public TerminalNode FINAL_MESSAGE() { return getToken(AnswerVerifierParser.FINAL_MESSAGE, 0); }
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public FinalMessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalMessage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterFinalMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitFinalMessage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitFinalMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinalMessageContext finalMessage() throws RecognitionException {
		FinalMessageContext _localctx = new FinalMessageContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_finalMessage);
		try {
			setState(311);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FINAL_MESSAGE:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				match(FINAL_MESSAGE);
				setState(309);
				text();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				throw new RuntimeException("GRAMMAR ERROR: Missing Final Message!");
				}
				default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionContext extends ParserRuleContext {
		public TerminalNode DESCRIPTION() { return getToken(AnswerVerifierParser.DESCRIPTION, 0); }
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitDescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_description);
		try {
			setState(316);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DESCRIPTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				match(DESCRIPTION);
				setState(314);
				text();
				}
				break;
			case LIST_OF_QUESTIONS:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionsContext extends ParserRuleContext {
		public TerminalNode INSTRUCTIONS() { return getToken(AnswerVerifierParser.INSTRUCTIONS, 0); }
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public InstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterInstructions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitInstructions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitInstructions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionsContext instructions() throws RecognitionException {
		InstructionsContext _localctx = new InstructionsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_instructions);
		try {
			setState(321);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INSTRUCTIONS:
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				match(INSTRUCTIONS);
				setState(319);
				text();
				}
				break;
			case ANSWER:
			case LIST_OF_OPTIONS:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SurveyIDContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(AnswerVerifierParser.WORD, 0); }
		public SurveyIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_surveyID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterSurveyID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitSurveyID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitSurveyID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SurveyIDContext surveyID() throws RecognitionException {
		SurveyIDContext _localctx = new SurveyIDContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_surveyID);
		try {
			setState(325);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				match(WORD);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				throw new RuntimeException("GRAMMAR ERROR: Missing SURVEY ID!");
				}
				default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionnaireIDContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(AnswerVerifierParser.WORD, 0); }
		public QuestionnaireIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionnaireID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterQuestionnaireID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitQuestionnaireID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitQuestionnaireID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionnaireIDContext questionnaireID() throws RecognitionException {
		QuestionnaireIDContext _localctx = new QuestionnaireIDContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_questionnaireID);
		try {
			setState(329);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				match(WORD);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				throw new RuntimeException("GRAMMAR ERROR: Missing Questionnaire ID!");
				}
				default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SectionIDContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(AnswerVerifierParser.WORD, 0); }
		public SectionIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sectionID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterSectionID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitSectionID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitSectionID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionIDContext sectionID() throws RecognitionException {
		SectionIDContext _localctx = new SectionIDContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_sectionID);
		try {
			setState(333);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				match(WORD);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				throw new RuntimeException("GRAMMAR ERROR: Missing Section ID!");
				}
				default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionIDContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(AnswerVerifierParser.WORD, 0); }
		public QuestionIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterQuestionID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitQuestionID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitQuestionID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionIDContext questionID() throws RecognitionException {
		QuestionIDContext _localctx = new QuestionIDContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_questionID);
		try {
			setState(337);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(335);
				match(WORD);
				}
				break;
			case PUNCTUATION:
				enterOuterAlt(_localctx, 2);
				{
				throw new RuntimeException("GRAMMAR ERROR: Missing Question ID!");
				}
				default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObligatorinessContext extends ParserRuleContext {
		public TerminalNode MANDATORY() { return getToken(AnswerVerifierParser.MANDATORY, 0); }
		public TerminalNode OPTIONAL() { return getToken(AnswerVerifierParser.OPTIONAL, 0); }
		public TerminalNode CONDITIONAL() { return getToken(AnswerVerifierParser.CONDITIONAL, 0); }
		public ObligatorinessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obligatoriness; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterObligatoriness(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitObligatoriness(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitObligatoriness(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObligatorinessContext obligatoriness() throws RecognitionException {
		ObligatorinessContext _localctx = new ObligatorinessContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_obligatoriness);
		try {
			setState(343);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MANDATORY:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				match(MANDATORY);
				}
				break;
			case OPTIONAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(340);
				match(OPTIONAL);
				}
				break;
			case CONDITIONAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(341);
				match(CONDITIONAL);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				throw new RuntimeException("GRAMMAR ERROR: Invalid Obligatoriness!");
				}
				default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepeatabilityContext extends ParserRuleContext {
		public TerminalNode CATEGORY() { return getToken(AnswerVerifierParser.CATEGORY, 0); }
		public TerminalNode BRAND() { return getToken(AnswerVerifierParser.BRAND, 0); }
		public RepeatabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatability; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterRepeatability(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitRepeatability(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitRepeatability(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatabilityContext repeatability() throws RecognitionException {
		RepeatabilityContext _localctx = new RepeatabilityContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_repeatability);
		try {
			setState(348);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CATEGORY:
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				match(CATEGORY);
				}
				break;
			case BRAND:
				enterOuterAlt(_localctx, 2);
				{
				setState(346);
				match(BRAND);
				}
				break;
			case T__3:
			case WORD:
			case SPACE:
				enterOuterAlt(_localctx, 3);
				{
				throw new RuntimeException("GRAMMAR ERROR: Invalid Repeatability!");
				}
				default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepeatIDContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(AnswerVerifierParser.WORD, 0); }
		public RepeatIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).enterRepeatID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerVerifierListener ) ((AnswerVerifierListener)listener).exitRepeatID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVerifierVisitor ) return ((AnswerVerifierVisitor<? extends T>)visitor).visitRepeatID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatIDContext repeatID() throws RecognitionException {
		RepeatIDContext _localctx = new RepeatIDContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_repeatID);
		try {
			setState(352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(350);
				match(WORD);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				throw new RuntimeException("GRAMMAR ERROR: Missing Repeated Attribute ID!");
				}
				default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001e\u0163\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001N\b\u0001\n\u0001"+
		"\f\u0001Q\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001V\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002h\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003n\b\u0003"+
		"\n\u0003\f\u0003q\t\u0003\u0001\u0003\u0001\u0003\u0005\u0003u\b\u0003"+
		"\n\u0003\f\u0003x\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"}\b\u0003\n\u0003\f\u0003\u0080\t\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0087\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0094\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u0098\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u00a2\b\u0007\u0001\b\u0001\b\u0005\b\u00a6\b\b\n\b\f\b\u00a9\t"+
		"\b\u0001\b\u0004\b\u00ac\b\b\u000b\b\f\b\u00ad\u0001\t\u0001\t\u0005\t"+
		"\u00b2\b\t\n\t\f\t\u00b5\t\t\u0001\t\u0005\t\u00b8\b\t\n\t\f\t\u00bb\t"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u00c5\b\u000b\n\u000b\f\u000b\u00c8\t\u000b\u0001\u000b"+
		"\u0005\u000b\u00cb\b\u000b\n\u000b\f\u000b\u00ce\t\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u00da\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u0104\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0109\b"+
		"\u000f\n\u000f\f\u000f\u010c\t\u000f\u0001\u000f\u0003\u000f\u010f\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u0117\b\u0010\n\u0010\f\u0010\u011a\t\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0120\b\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0127\b\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u012e"+
		"\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0133\b\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0138\b\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0003\u0015\u013d\b\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0003\u0016\u0142\b\u0016\u0001\u0017\u0001\u0017\u0003\u0017"+
		"\u0146\b\u0017\u0001\u0018\u0001\u0018\u0003\u0018\u014a\b\u0018\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u014e\b\u0019\u0001\u001a\u0001\u001a\u0003"+
		"\u001a\u0152\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003"+
		"\u001b\u0158\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u015d"+
		"\b\u001c\u0001\u001d\u0001\u001d\u0003\u001d\u0161\b\u001d\u0001\u001d"+
		"\u0000\u0000\u001e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:\u0000\u0000\u0183\u0000"+
		"<\u0001\u0000\u0000\u0000\u0002U\u0001\u0000\u0000\u0000\u0004g\u0001"+
		"\u0000\u0000\u0000\u0006\u0086\u0001\u0000\u0000\u0000\b\u0093\u0001\u0000"+
		"\u0000\u0000\n\u0097\u0001\u0000\u0000\u0000\f\u0099\u0001\u0000\u0000"+
		"\u0000\u000e\u00a1\u0001\u0000\u0000\u0000\u0010\u00a3\u0001\u0000\u0000"+
		"\u0000\u0012\u00af\u0001\u0000\u0000\u0000\u0014\u00bf\u0001\u0000\u0000"+
		"\u0000\u0016\u00c1\u0001\u0000\u0000\u0000\u0018\u00cf\u0001\u0000\u0000"+
		"\u0000\u001a\u00d9\u0001\u0000\u0000\u0000\u001c\u0103\u0001\u0000\u0000"+
		"\u0000\u001e\u010e\u0001\u0000\u0000\u0000 \u011f\u0001\u0000\u0000\u0000"+
		"\"\u0126\u0001\u0000\u0000\u0000$\u012d\u0001\u0000\u0000\u0000&\u0132"+
		"\u0001\u0000\u0000\u0000(\u0137\u0001\u0000\u0000\u0000*\u013c\u0001\u0000"+
		"\u0000\u0000,\u0141\u0001\u0000\u0000\u0000.\u0145\u0001\u0000\u0000\u0000"+
		"0\u0149\u0001\u0000\u0000\u00002\u014d\u0001\u0000\u0000\u00004\u0151"+
		"\u0001\u0000\u0000\u00006\u0157\u0001\u0000\u0000\u00008\u015c\u0001\u0000"+
		"\u0000\u0000:\u0160\u0001\u0000\u0000\u0000<=\u0005\u0005\u0000\u0000"+
		"=>\u0005\u0019\u0000\u0000>?\u0003.\u0017\u0000?@\u0005\u0001\u0000\u0000"+
		"@A\u0003\u0002\u0001\u0000A\u0001\u0001\u0000\u0000\u0000BC\u0005\u0006"+
		"\u0000\u0000CD\u0005\u0019\u0000\u0000DE\u00030\u0018\u0000EF\u0005\u0001"+
		"\u0000\u0000FG\u0005\u0019\u0000\u0000GH\u0003\u001e\u000f\u0000HI\u0003"+
		"&\u0013\u0000IJ\u0005\u0014\u0000\u0000JK\u0003\u0004\u0002\u0000KO\u0005"+
		"\u0006\u0000\u0000LN\u0005\u0019\u0000\u0000ML\u0001\u0000\u0000\u0000"+
		"NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000"+
		"\u0000PR\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000RS\u0003(\u0014"+
		"\u0000SV\u0001\u0000\u0000\u0000TV\u0005\u0000\u0000\u0001UB\u0001\u0000"+
		"\u0000\u0000UT\u0001\u0000\u0000\u0000V\u0003\u0001\u0000\u0000\u0000"+
		"WX\u0005\b\u0000\u0000XY\u0005\u0019\u0000\u0000YZ\u00032\u0019\u0000"+
		"Z[\u0005\u0001\u0000\u0000[\\\u0003 \u0010\u0000\\]\u0003$\u0012\u0000"+
		"]^\u0005\u0019\u0000\u0000^_\u0005\u0002\u0000\u0000_`\u0005\u0019\u0000"+
		"\u0000`a\u0003\u001e\u000f\u0000ab\u0003*\u0015\u0000bc\u0005\u0015\u0000"+
		"\u0000cd\u0003\u0006\u0003\u0000de\u0003\u0004\u0002\u0000eh\u0001\u0000"+
		"\u0000\u0000fh\u0001\u0000\u0000\u0000gW\u0001\u0000\u0000\u0000gf\u0001"+
		"\u0000\u0000\u0000h\u0005\u0001\u0000\u0000\u0000ij\u0005\u0007\u0000"+
		"\u0000jk\u0005\u0001\u0000\u0000ko\u0003$\u0012\u0000ln\u0005\u0019\u0000"+
		"\u0000ml\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000"+
		"\u0000\u0000op\u0001\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000qo\u0001"+
		"\u0000\u0000\u0000rv\u0005\u0002\u0000\u0000su\u0005\u0019\u0000\u0000"+
		"ts\u0001\u0000\u0000\u0000ux\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000"+
		"\u0000vw\u0001\u0000\u0000\u0000wy\u0001\u0000\u0000\u0000xv\u0001\u0000"+
		"\u0000\u0000yz\u00034\u001a\u0000z~\u0005\u0018\u0000\u0000{}\u0005\u0019"+
		"\u0000\u0000|{\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000"+
		"~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0081"+
		"\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0082\u0003"+
		"\n\u0005\u0000\u0082\u0083\u0003\b\u0004\u0000\u0083\u0084\u0003\u0006"+
		"\u0003\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0087\u0001\u0000"+
		"\u0000\u0000\u0086i\u0001\u0000\u0000\u0000\u0086\u0085\u0001\u0000\u0000"+
		"\u0000\u0087\u0007\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u0013\u0000"+
		"\u0000\u0089\u0094\u0003\u0014\n\u0000\u008a\u008b\u0005\u0013\u0000\u0000"+
		"\u008b\u008c\u0003\u0016\u000b\u0000\u008c\u008d\u0005\u0018\u0000\u0000"+
		"\u008d\u0094\u0001\u0000\u0000\u0000\u008e\u008f\u0005\u0013\u0000\u0000"+
		"\u008f\u0090\u0003\u0016\u000b\u0000\u0090\u0091\u0006\u0004\uffff\uffff"+
		"\u0000\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0094\u0005\u0013\u0000"+
		"\u0000\u0093\u0088\u0001\u0000\u0000\u0000\u0093\u008a\u0001\u0000\u0000"+
		"\u0000\u0093\u008e\u0001\u0000\u0000\u0000\u0093\u0092\u0001\u0000\u0000"+
		"\u0000\u0094\t\u0001\u0000\u0000\u0000\u0095\u0098\u0003\u0012\t\u0000"+
		"\u0096\u0098\u0003\f\u0006\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097"+
		"\u0096\u0001\u0000\u0000\u0000\u0098\u000b\u0001\u0000\u0000\u0000\u0099"+
		"\u009a\u0003\u0012\t\u0000\u009a\u009b\u0005\u0016\u0000\u0000\u009b\u009c"+
		"\u0003\u000e\u0007\u0000\u009c\r\u0001\u0000\u0000\u0000\u009d\u009e\u0003"+
		"\u0010\b\u0000\u009e\u009f\u0003\u000e\u0007\u0000\u009f\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a2\u0003\u0010\b\u0000\u00a1\u009d\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a2\u000f\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a7\u0005\u001c\u0000\u0000\u00a4\u00a6\u0005\u0019\u0000"+
		"\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000"+
		"\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ac\u0003\u001c\u000e\u0000\u00ab\u00aa\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u0011\u0001\u0000\u0000"+
		"\u0000\u00af\u00b3\u0003\u001a\r\u0000\u00b0\u00b2\u0005\u0018\u0000\u0000"+
		"\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b9\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b8\u0005\u0019\u0000\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00bd\u0003\"\u0011\u0000\u00bd"+
		"\u00be\u0003,\u0016\u0000\u00be\u0013\u0001\u0000\u0000\u0000\u00bf\u00c0"+
		"\u0003\u001a\r\u0000\u00c0\u0015\u0001\u0000\u0000\u0000\u00c1\u00cc\u0003"+
		"\u0018\f\u0000\u00c2\u00c6\u0005\u001a\u0000\u0000\u00c3\u00c5\u0005\u0019"+
		"\u0000\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c8\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c9\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c9\u00cb\u0003\u0016\u000b\u0000\u00ca\u00c2\u0001\u0000"+
		"\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u0017\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005\u001c"+
		"\u0000\u0000\u00d0\u0019\u0001\u0000\u0000\u0000\u00d1\u00d2\u0003\u001c"+
		"\u000e\u0000\u00d2\u00d3\u0003\u001a\r\u0000\u00d3\u00da\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d5\u0003\u001c\u000e\u0000\u00d5\u00d6\u0005\u0019\u0000"+
		"\u0000\u00d6\u00d7\u0003\u001a\r\u0000\u00d7\u00da\u0001\u0000\u0000\u0000"+
		"\u00d8\u00da\u0003\u001c\u000e\u0000\u00d9\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d9\u00d4\u0001\u0000\u0000\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000"+
		"\u00da\u001b\u0001\u0000\u0000\u0000\u00db\u00dc\u0005\u0017\u0000\u0000"+
		"\u00dc\u0104\u0003\u001c\u000e\u0000\u00dd\u00de\u0005\u0017\u0000\u0000"+
		"\u00de\u0104\u0005\u0018\u0000\u0000\u00df\u00e0\u0005\u0018\u0000\u0000"+
		"\u00e0\u00e1\u0005\u0019\u0000\u0000\u00e1\u0104\u0003\u001c\u000e\u0000"+
		"\u00e2\u0104\u0005\u0018\u0000\u0000\u00e3\u00e4\u0005\u0017\u0000\u0000"+
		"\u00e4\u00e5\u0005\u0019\u0000\u0000\u00e5\u0104\u0003\u001c\u000e\u0000"+
		"\u00e6\u00e7\u0005\u001a\u0000\u0000\u00e7\u00e8\u0005\u0019\u0000\u0000"+
		"\u00e8\u0104\u0003\u001c\u000e\u0000\u00e9\u00ea\u0005\u0006\u0000\u0000"+
		"\u00ea\u0104\u0003\u001c\u000e\u0000\u00eb\u00ec\u0005\u0005\u0000\u0000"+
		"\u00ec\u0104\u0003\u001c\u000e\u0000\u00ed\u00ee\u0005\u0007\u0000\u0000"+
		"\u00ee\u0104\u0003\u001c\u000e\u0000\u00ef\u00f0\u0005\b\u0000\u0000\u00f0"+
		"\u0104\u0003\u001c\u000e\u0000\u00f1\u00f2\u0005\t\u0000\u0000\u00f2\u0104"+
		"\u0003\u001c\u000e\u0000\u00f3\u00f4\u0005\n\u0000\u0000\u00f4\u0104\u0003"+
		"\u001c\u000e\u0000\u00f5\u00f6\u0005\u0016\u0000\u0000\u00f6\u0104\u0003"+
		"\u001c\u000e\u0000\u00f7\u00f8\u0005\u0015\u0000\u0000\u00f8\u0104\u0003"+
		"\u001c\u000e\u0000\u00f9\u0104\u0005\u0014\u0000\u0000\u00fa\u0104\u0005"+
		"\u0010\u0000\u0000\u00fb\u0104\u0005\u0011\u0000\u0000\u00fc\u0104\u0005"+
		"\u000b\u0000\u0000\u00fd\u0104\u0005\f\u0000\u0000\u00fe\u0104\u0005\r"+
		"\u0000\u0000\u00ff\u0104\u0005\u000e\u0000\u0000\u0100\u0104\u0005\u0012"+
		"\u0000\u0000\u0101\u0104\u0005\u000f\u0000\u0000\u0102\u0104\u0005\u0013"+
		"\u0000\u0000\u0103\u00db\u0001\u0000\u0000\u0000\u0103\u00dd\u0001\u0000"+
		"\u0000\u0000\u0103\u00df\u0001\u0000\u0000\u0000\u0103\u00e2\u0001\u0000"+
		"\u0000\u0000\u0103\u00e3\u0001\u0000\u0000\u0000\u0103\u00e6\u0001\u0000"+
		"\u0000\u0000\u0103\u00e9\u0001\u0000\u0000\u0000\u0103\u00eb\u0001\u0000"+
		"\u0000\u0000\u0103\u00ed\u0001\u0000\u0000\u0000\u0103\u00ef\u0001\u0000"+
		"\u0000\u0000\u0103\u00f1\u0001\u0000\u0000\u0000\u0103\u00f3\u0001\u0000"+
		"\u0000\u0000\u0103\u00f5\u0001\u0000\u0000\u0000\u0103\u00f7\u0001\u0000"+
		"\u0000\u0000\u0103\u00f9\u0001\u0000\u0000\u0000\u0103\u00fa\u0001\u0000"+
		"\u0000\u0000\u0103\u00fb\u0001\u0000\u0000\u0000\u0103\u00fc\u0001\u0000"+
		"\u0000\u0000\u0103\u00fd\u0001\u0000\u0000\u0000\u0103\u00fe\u0001\u0000"+
		"\u0000\u0000\u0103\u00ff\u0001\u0000\u0000\u0000\u0103\u0100\u0001\u0000"+
		"\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0102\u0001\u0000"+
		"\u0000\u0000\u0104\u001d\u0001\u0000\u0000\u0000\u0105\u010f\u0005\u0017"+
		"\u0000\u0000\u0106\u010a\u0005\u0017\u0000\u0000\u0107\u0109\u0005\u0019"+
		"\u0000\u0000\u0108\u0107\u0001\u0000\u0000\u0000\u0109\u010c\u0001\u0000"+
		"\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000"+
		"\u0000\u0000\u010b\u010d\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000"+
		"\u0000\u0000\u010d\u010f\u0003\u001e\u000f\u0000\u010e\u0105\u0001\u0000"+
		"\u0000\u0000\u010e\u0106\u0001\u0000\u0000\u0000\u010f\u001f\u0001\u0000"+
		"\u0000\u0000\u0110\u0111\u0005\u0019\u0000\u0000\u0111\u0112\u0005\u0003"+
		"\u0000\u0000\u0112\u0113\u0005\u000f\u0000\u0000\u0113\u0114\u0005\u0019"+
		"\u0000\u0000\u0114\u0118\u00038\u001c\u0000\u0115\u0117\u0005\u0019\u0000"+
		"\u0000\u0116\u0115\u0001\u0000\u0000\u0000\u0117\u011a\u0001\u0000\u0000"+
		"\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000"+
		"\u0000\u0119\u011b\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000"+
		"\u0000\u011b\u011c\u0003:\u001d\u0000\u011c\u011d\u0005\u0004\u0000\u0000"+
		"\u011d\u0120\u0001\u0000\u0000\u0000\u011e\u0120\u0001\u0000\u0000\u0000"+
		"\u011f\u0110\u0001\u0000\u0000\u0000\u011f\u011e\u0001\u0000\u0000\u0000"+
		"\u0120!\u0001\u0000\u0000\u0000\u0121\u0122\u0005\u0003\u0000\u0000\u0122"+
		"\u0123\u0003\u001a\r\u0000\u0123\u0124\u0005\u0004\u0000\u0000\u0124\u0127"+
		"\u0001\u0000\u0000\u0000\u0125\u0127\u0001\u0000\u0000\u0000\u0126\u0121"+
		"\u0001\u0000\u0000\u0000\u0126\u0125\u0001\u0000\u0000\u0000\u0127#\u0001"+
		"\u0000\u0000\u0000\u0128\u0129\u0005\u0003\u0000\u0000\u0129\u012a\u0003"+
		"6\u001b\u0000\u012a\u012b\u0005\u0004\u0000\u0000\u012b\u012e\u0001\u0000"+
		"\u0000\u0000\u012c\u012e\u0006\u0012\uffff\uffff\u0000\u012d\u0128\u0001"+
		"\u0000\u0000\u0000\u012d\u012c\u0001\u0000\u0000\u0000\u012e%\u0001\u0000"+
		"\u0000\u0000\u012f\u0130\u0005\t\u0000\u0000\u0130\u0133\u0003\u001a\r"+
		"\u0000\u0131\u0133\u0001\u0000\u0000\u0000\u0132\u012f\u0001\u0000\u0000"+
		"\u0000\u0132\u0131\u0001\u0000\u0000\u0000\u0133\'\u0001\u0000\u0000\u0000"+
		"\u0134\u0135\u0005\n\u0000\u0000\u0135\u0138\u0003\u001a\r\u0000\u0136"+
		"\u0138\u0006\u0014\uffff\uffff\u0000\u0137\u0134\u0001\u0000\u0000\u0000"+
		"\u0137\u0136\u0001\u0000\u0000\u0000\u0138)\u0001\u0000\u0000\u0000\u0139"+
		"\u013a\u0005\u000e\u0000\u0000\u013a\u013d\u0003\u001a\r\u0000\u013b\u013d"+
		"\u0001\u0000\u0000\u0000\u013c\u0139\u0001\u0000\u0000\u0000\u013c\u013b"+
		"\u0001\u0000\u0000\u0000\u013d+\u0001\u0000\u0000\u0000\u013e\u013f\u0005"+
		"\u0012\u0000\u0000\u013f\u0142\u0003\u001a\r\u0000\u0140\u0142\u0001\u0000"+
		"\u0000\u0000\u0141\u013e\u0001\u0000\u0000\u0000\u0141\u0140\u0001\u0000"+
		"\u0000\u0000\u0142-\u0001\u0000\u0000\u0000\u0143\u0146\u0005\u0017\u0000"+
		"\u0000\u0144\u0146\u0006\u0017\uffff\uffff\u0000\u0145\u0143\u0001\u0000"+
		"\u0000\u0000\u0145\u0144\u0001\u0000\u0000\u0000\u0146/\u0001\u0000\u0000"+
		"\u0000\u0147\u014a\u0005\u0017\u0000\u0000\u0148\u014a\u0006\u0018\uffff"+
		"\uffff\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u0149\u0148\u0001\u0000"+
		"\u0000\u0000\u014a1\u0001\u0000\u0000\u0000\u014b\u014e\u0005\u0017\u0000"+
		"\u0000\u014c\u014e\u0006\u0019\uffff\uffff\u0000\u014d\u014b\u0001\u0000"+
		"\u0000\u0000\u014d\u014c\u0001\u0000\u0000\u0000\u014e3\u0001\u0000\u0000"+
		"\u0000\u014f\u0152\u0005\u0017\u0000\u0000\u0150\u0152\u0006\u001a\uffff"+
		"\uffff\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0151\u0150\u0001\u0000"+
		"\u0000\u0000\u01525\u0001\u0000\u0000\u0000\u0153\u0158\u0005\u000b\u0000"+
		"\u0000\u0154\u0158\u0005\f\u0000\u0000\u0155\u0158\u0005\r\u0000\u0000"+
		"\u0156\u0158\u0006\u001b\uffff\uffff\u0000\u0157\u0153\u0001\u0000\u0000"+
		"\u0000\u0157\u0154\u0001\u0000\u0000\u0000\u0157\u0155\u0001\u0000\u0000"+
		"\u0000\u0157\u0156\u0001\u0000\u0000\u0000\u01587\u0001\u0000\u0000\u0000"+
		"\u0159\u015d\u0005\u0010\u0000\u0000\u015a\u015d\u0005\u0011\u0000\u0000"+
		"\u015b\u015d\u0006\u001c\uffff\uffff\u0000\u015c\u0159\u0001\u0000\u0000"+
		"\u0000\u015c\u015a\u0001\u0000\u0000\u0000\u015c\u015b\u0001\u0000\u0000"+
		"\u0000\u015d9\u0001\u0000\u0000\u0000\u015e\u0161\u0005\u0017\u0000\u0000"+
		"\u015f\u0161\u0006\u001d\uffff\uffff\u0000\u0160\u015e\u0001\u0000\u0000"+
		"\u0000\u0160\u015f\u0001\u0000\u0000\u0000\u0161;\u0001\u0000\u0000\u0000"+
		"#OUgov~\u0086\u0093\u0097\u00a1\u00a7\u00ad\u00b3\u00b9\u00c6\u00cc\u00d9"+
		"\u0103\u010a\u010e\u0118\u011f\u0126\u012d\u0132\u0137\u013c\u0141\u0145"+
		"\u0149\u014d\u0151\u0157\u015c\u0160";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}