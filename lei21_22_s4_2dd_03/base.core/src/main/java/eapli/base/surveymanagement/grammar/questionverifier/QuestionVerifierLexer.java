// Generated from E:/Backup/UNI/Ano 2/Semestre 2/LAPR4/lei21_22_s4_2dd_03/base.core/src/main/java/eapli/base/surveymanagement/grammar\QuestionVerifier.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.grammar.questionverifier;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuestionVerifierLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OPTION=1, WORD=2, PUNCTUATION=3, IGNORE=4, SPACE=5, COMMA=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"OPTION", "WORD", "PUNCTUATION", "IGNORE", "SPACE", "COMMA"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "' '", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OPTION", "WORD", "PUNCTUATION", "IGNORE", "SPACE", "COMMA"
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


	public QuestionVerifierLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QuestionVerifier.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u00066\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0004\u0000\u0011\b\u0000\u000b\u0000\f\u0000\u0012\u0001\u0000\u0003"+
		"\u0000\u0016\b\u0000\u0001\u0001\u0004\u0001\u0019\b\u0001\u000b\u0001"+
		"\f\u0001\u001a\u0001\u0001\u0004\u0001\u001e\b\u0001\u000b\u0001\f\u0001"+
		"\u001f\u0001\u0001\u0004\u0001#\b\u0001\u000b\u0001\f\u0001$\u0001\u0001"+
		"\u0003\u0001(\b\u0001\u0001\u0002\u0004\u0002+\b\u0002\u000b\u0002\f\u0002"+
		",\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0000\u0000\u0006\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\u0001\u0000\u0007\u0001\u0000a"+
		"z\u0001\u000019\u0002\u0000AZaz\u0001\u000009\u0002\u0000\"\"\'\'\u0004"+
		"\u0000!!-.:;??\u0002\u0000\t\n\r\r>\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0001\u0015\u0001\u0000\u0000\u0000\u0003"+
		"\'\u0001\u0000\u0000\u0000\u0005*\u0001\u0000\u0000\u0000\u0007.\u0001"+
		"\u0000\u0000\u0000\t2\u0001\u0000\u0000\u0000\u000b4\u0001\u0000\u0000"+
		"\u0000\r\u000e\u0007\u0000\u0000\u0000\u000e\u0016\u0005)\u0000\u0000"+
		"\u000f\u0011\u0007\u0001\u0000\u0000\u0010\u000f\u0001\u0000\u0000\u0000"+
		"\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0010\u0001\u0000\u0000\u0000"+
		"\u0012\u0013\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000"+
		"\u0014\u0016\u0005)\u0000\u0000\u0015\r\u0001\u0000\u0000\u0000\u0015"+
		"\u0010\u0001\u0000\u0000\u0000\u0016\u0002\u0001\u0000\u0000\u0000\u0017"+
		"\u0019\u0007\u0002\u0000\u0000\u0018\u0017\u0001\u0000\u0000\u0000\u0019"+
		"\u001a\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a"+
		"\u001b\u0001\u0000\u0000\u0000\u001b(\u0001\u0000\u0000\u0000\u001c\u001e"+
		"\u0007\u0003\u0000\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001e\u001f"+
		"\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001"+
		"\u0000\u0000\u0000 (\u0001\u0000\u0000\u0000!#\u0005_\u0000\u0000\"!\u0001"+
		"\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000"+
		"$%\u0001\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000&(\u0007\u0004\u0000"+
		"\u0000\'\u0018\u0001\u0000\u0000\u0000\'\u001d\u0001\u0000\u0000\u0000"+
		"\'\"\u0001\u0000\u0000\u0000\'&\u0001\u0000\u0000\u0000(\u0004\u0001\u0000"+
		"\u0000\u0000)+\u0007\u0005\u0000\u0000*)\u0001\u0000\u0000\u0000+,\u0001"+
		"\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000"+
		"-\u0006\u0001\u0000\u0000\u0000./\u0007\u0006\u0000\u0000/0\u0001\u0000"+
		"\u0000\u000001\u0006\u0003\u0000\u00001\b\u0001\u0000\u0000\u000023\u0005"+
		" \u0000\u00003\n\u0001\u0000\u0000\u000045\u0005,\u0000\u00005\f\u0001"+
		"\u0000\u0000\u0000\b\u0000\u0012\u0015\u001a\u001f$\',\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}