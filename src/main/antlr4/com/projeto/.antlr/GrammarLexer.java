// Generated from c:/Users/LUANF/compiler2/src/main/antlr4/com/projeto/grammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, VAR=2, IF=3, WHILE=4, PRINT=5, INPUT=6, AND=7, OR=8, ID=9, NUMBER=10, 
		STRING_LITERAL=11, SEMICOLON=12, PLUS=13, MINUS=14, MULT=15, DIV=16, EXP=17, 
		LT=18, LE=19, GT=20, GE=21, EQUALS=22, NOT_EQUALS=23, LPAREN=24, RPAREN=25, 
		LBRACE=26, RBRACE=27, WS=28, COMMENT=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "VAR", "IF", "WHILE", "PRINT", "INPUT", "AND", "OR", "ID", "NUMBER", 
			"STRING_LITERAL", "SEMICOLON", "PLUS", "MINUS", "MULT", "DIV", "EXP", 
			"LT", "LE", "GT", "GE", "EQUALS", "NOT_EQUALS", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'var'", "'if'", "'while'", "'print'", "'input'", "'and'", 
			"'or'", null, null, null, "';'", "'+'", "'-'", "'*'", "'/'", "'^'", "'<'", 
			"'<='", "'>'", "'>='", "'=='", "'!='", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "VAR", "IF", "WHILE", "PRINT", "INPUT", "AND", "OR", "ID", 
			"NUMBER", "STRING_LITERAL", "SEMICOLON", "PLUS", "MINUS", "MULT", "DIV", 
			"EXP", "LT", "LE", "GT", "GE", "EQUALS", "NOT_EQUALS", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "WS", "COMMENT"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "grammar.g4"; }

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
		"\u0004\u0000\u001d\u00b0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\b`\b\b\n\b\f\bc\t\b\u0001"+
		"\t\u0004\tf\b\t\u000b\t\f\tg\u0001\t\u0001\t\u0004\tl\b\t\u000b\t\f\t"+
		"m\u0003\tp\b\t\u0001\n\u0001\n\u0005\nt\b\n\n\n\f\nw\t\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0004\u001b\u00a0\b\u001b\u000b\u001b\f\u001b\u00a1\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u00aa"+
		"\b\u001c\n\u001c\f\u001c\u00ad\t\u001c\u0001\u001c\u0001\u001c\u0000\u0000"+
		"\u001d\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u00193\u001a5\u001b7\u001c9\u001d\u0001\u0000\u0006\u0003\u0000"+
		"AZ__az\u0004\u000009AZ__az\u0001\u000009\u0001\u0000\"\"\u0003\u0000\t"+
		"\n\r\r  \u0002\u0000\n\n\r\r\u00b6\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001"+
		"\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000"+
		"\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0001"+
		";\u0001\u0000\u0000\u0000\u0003=\u0001\u0000\u0000\u0000\u0005A\u0001"+
		"\u0000\u0000\u0000\u0007D\u0001\u0000\u0000\u0000\tJ\u0001\u0000\u0000"+
		"\u0000\u000bP\u0001\u0000\u0000\u0000\rV\u0001\u0000\u0000\u0000\u000f"+
		"Z\u0001\u0000\u0000\u0000\u0011]\u0001\u0000\u0000\u0000\u0013e\u0001"+
		"\u0000\u0000\u0000\u0015q\u0001\u0000\u0000\u0000\u0017z\u0001\u0000\u0000"+
		"\u0000\u0019|\u0001\u0000\u0000\u0000\u001b~\u0001\u0000\u0000\u0000\u001d"+
		"\u0080\u0001\u0000\u0000\u0000\u001f\u0082\u0001\u0000\u0000\u0000!\u0084"+
		"\u0001\u0000\u0000\u0000#\u0086\u0001\u0000\u0000\u0000%\u0088\u0001\u0000"+
		"\u0000\u0000\'\u008b\u0001\u0000\u0000\u0000)\u008d\u0001\u0000\u0000"+
		"\u0000+\u0090\u0001\u0000\u0000\u0000-\u0093\u0001\u0000\u0000\u0000/"+
		"\u0096\u0001\u0000\u0000\u00001\u0098\u0001\u0000\u0000\u00003\u009a\u0001"+
		"\u0000\u0000\u00005\u009c\u0001\u0000\u0000\u00007\u009f\u0001\u0000\u0000"+
		"\u00009\u00a5\u0001\u0000\u0000\u0000;<\u0005=\u0000\u0000<\u0002\u0001"+
		"\u0000\u0000\u0000=>\u0005v\u0000\u0000>?\u0005a\u0000\u0000?@\u0005r"+
		"\u0000\u0000@\u0004\u0001\u0000\u0000\u0000AB\u0005i\u0000\u0000BC\u0005"+
		"f\u0000\u0000C\u0006\u0001\u0000\u0000\u0000DE\u0005w\u0000\u0000EF\u0005"+
		"h\u0000\u0000FG\u0005i\u0000\u0000GH\u0005l\u0000\u0000HI\u0005e\u0000"+
		"\u0000I\b\u0001\u0000\u0000\u0000JK\u0005p\u0000\u0000KL\u0005r\u0000"+
		"\u0000LM\u0005i\u0000\u0000MN\u0005n\u0000\u0000NO\u0005t\u0000\u0000"+
		"O\n\u0001\u0000\u0000\u0000PQ\u0005i\u0000\u0000QR\u0005n\u0000\u0000"+
		"RS\u0005p\u0000\u0000ST\u0005u\u0000\u0000TU\u0005t\u0000\u0000U\f\u0001"+
		"\u0000\u0000\u0000VW\u0005a\u0000\u0000WX\u0005n\u0000\u0000XY\u0005d"+
		"\u0000\u0000Y\u000e\u0001\u0000\u0000\u0000Z[\u0005o\u0000\u0000[\\\u0005"+
		"r\u0000\u0000\\\u0010\u0001\u0000\u0000\u0000]a\u0007\u0000\u0000\u0000"+
		"^`\u0007\u0001\u0000\u0000_^\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000"+
		"\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b\u0012\u0001"+
		"\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000df\u0007\u0002\u0000\u0000"+
		"ed\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000"+
		"\u0000gh\u0001\u0000\u0000\u0000ho\u0001\u0000\u0000\u0000ik\u0005.\u0000"+
		"\u0000jl\u0007\u0002\u0000\u0000kj\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000np\u0001"+
		"\u0000\u0000\u0000oi\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000"+
		"p\u0014\u0001\u0000\u0000\u0000qu\u0005\"\u0000\u0000rt\b\u0003\u0000"+
		"\u0000sr\u0001\u0000\u0000\u0000tw\u0001\u0000\u0000\u0000us\u0001\u0000"+
		"\u0000\u0000uv\u0001\u0000\u0000\u0000vx\u0001\u0000\u0000\u0000wu\u0001"+
		"\u0000\u0000\u0000xy\u0005\"\u0000\u0000y\u0016\u0001\u0000\u0000\u0000"+
		"z{\u0005;\u0000\u0000{\u0018\u0001\u0000\u0000\u0000|}\u0005+\u0000\u0000"+
		"}\u001a\u0001\u0000\u0000\u0000~\u007f\u0005-\u0000\u0000\u007f\u001c"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0005*\u0000\u0000\u0081\u001e\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0005/\u0000\u0000\u0083 \u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0005^\u0000\u0000\u0085\"\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0005<\u0000\u0000\u0087$\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0005<\u0000\u0000\u0089\u008a\u0005=\u0000\u0000\u008a&\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0005>\u0000\u0000\u008c(\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0005>\u0000\u0000\u008e\u008f\u0005=\u0000\u0000\u008f*"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\u0005=\u0000\u0000\u0091\u0092\u0005"+
		"=\u0000\u0000\u0092,\u0001\u0000\u0000\u0000\u0093\u0094\u0005!\u0000"+
		"\u0000\u0094\u0095\u0005=\u0000\u0000\u0095.\u0001\u0000\u0000\u0000\u0096"+
		"\u0097\u0005(\u0000\u0000\u00970\u0001\u0000\u0000\u0000\u0098\u0099\u0005"+
		")\u0000\u0000\u00992\u0001\u0000\u0000\u0000\u009a\u009b\u0005{\u0000"+
		"\u0000\u009b4\u0001\u0000\u0000\u0000\u009c\u009d\u0005}\u0000\u0000\u009d"+
		"6\u0001\u0000\u0000\u0000\u009e\u00a0\u0007\u0004\u0000\u0000\u009f\u009e"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u009f"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0006\u001b\u0000\u0000\u00a48\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0005/\u0000\u0000\u00a6\u00a7\u0005/\u0000"+
		"\u0000\u00a7\u00ab\u0001\u0000\u0000\u0000\u00a8\u00aa\b\u0005\u0000\u0000"+
		"\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ad\u0001\u0000\u0000\u0000"+
		"\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ae\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0006\u001c\u0000\u0000\u00af:\u0001\u0000\u0000\u0000\b"+
		"\u0000agmou\u00a1\u00ab\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}