// Generated from c:/Users/LUANF/compiler2/src/main/antlr4/com/projeto/LanguageGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LanguageGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, VAR=2, IF=3, WHILE=4, PRINT=5, INPUT=6, AND=7, OR=8, TRUE=9, FALSE=10, 
		ID=11, NUMBER=12, STRING_LITERAL=13, SEMICOLON=14, PLUS=15, MINUS=16, 
		MULT=17, DIV=18, EXP=19, LT=20, LE=21, GT=22, GE=23, EQUALS=24, NOT_EQUALS=25, 
		LPAREN=26, RPAREN=27, LBRACE=28, RBRACE=29, WS=30, COMMENT=31;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_statement = 2, RULE_varDeclaration = 3, 
		RULE_assignment = 4, RULE_ifStatement = 5, RULE_whileStatement = 6, RULE_block = 7, 
		RULE_printStatement = 8, RULE_inputStatement = 9, RULE_expression = 10, 
		RULE_arithExpression = 11, RULE_term = 12, RULE_factor = 13, RULE_atom = 14, 
		RULE_condition = 15, RULE_andCondition = 16, RULE_compareCondition = 17, 
		RULE_comparisonOp = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "statement", "varDeclaration", "assignment", 
			"ifStatement", "whileStatement", "block", "printStatement", "inputStatement", 
			"expression", "arithExpression", "term", "factor", "atom", "condition", 
			"andCondition", "compareCondition", "comparisonOp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'var'", "'if'", "'while'", "'print'", "'input'", "'and'", 
			"'or'", "'true'", "'false'", null, null, null, "';'", "'+'", "'-'", "'*'", 
			"'/'", "'^'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'('", "')'", 
			"'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "VAR", "IF", "WHILE", "PRINT", "INPUT", "AND", "OR", "TRUE", 
			"FALSE", "ID", "NUMBER", "STRING_LITERAL", "SEMICOLON", "PLUS", "MINUS", 
			"MULT", "DIV", "EXP", "LT", "LE", "GT", "GE", "EQUALS", "NOT_EQUALS", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "LanguageGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LanguageGrammarParser.EOF, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2172L) != 0)) {
				{
				setState(40);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(38);
					declaration();
					}
					break;
				case IF:
				case WHILE:
				case PRINT:
				case INPUT:
				case ID:
					{
					setState(39);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			varDeclaration();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public InputStatementContext inputStatement() {
			return getRuleContext(InputStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				assignment();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				ifStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				whileStatement();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 4);
				{
				setState(52);
				printStatement();
				}
				break;
			case INPUT:
				enterOuterAlt(_localctx, 5);
				{
				setState(53);
				inputStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclarationContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LanguageGrammarParser.VAR, 0); }
		public TerminalNode ID() { return getToken(LanguageGrammarParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(LanguageGrammarParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(VAR);
			setState(57);
			match(ID);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(58);
				match(T__0);
				setState(59);
				expression();
				}
			}

			setState(62);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageGrammarParser.ID, 0); }
		public ArithExpressionContext arithExpression() {
			return getRuleContext(ArithExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(LanguageGrammarParser.SEMICOLON, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(ID);
			setState(65);
			match(T__0);
			setState(66);
			arithExpression();
			setState(67);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LanguageGrammarParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(LanguageGrammarParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LanguageGrammarParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(IF);
			setState(70);
			match(LPAREN);
			setState(71);
			condition();
			setState(72);
			match(RPAREN);
			setState(73);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(LanguageGrammarParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(LanguageGrammarParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LanguageGrammarParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(WHILE);
			setState(76);
			match(LPAREN);
			setState(77);
			condition();
			setState(78);
			match(RPAREN);
			setState(79);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(LanguageGrammarParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LanguageGrammarParser.RBRACE, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(LBRACE);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR) {
				{
				{
				setState(82);
				declaration();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2168L) != 0)) {
				{
				{
				setState(88);
				statement();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatementContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(LanguageGrammarParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(LanguageGrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LanguageGrammarParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(LanguageGrammarParser.SEMICOLON, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(LanguageGrammarParser.STRING_LITERAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(PRINT);
			setState(97);
			match(LPAREN);
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(98);
				match(STRING_LITERAL);
				}
				break;
			case 2:
				{
				setState(99);
				expression();
				}
				break;
			}
			setState(102);
			match(RPAREN);
			setState(103);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InputStatementContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(LanguageGrammarParser.INPUT, 0); }
		public TerminalNode LPAREN() { return getToken(LanguageGrammarParser.LPAREN, 0); }
		public TerminalNode ID() { return getToken(LanguageGrammarParser.ID, 0); }
		public TerminalNode RPAREN() { return getToken(LanguageGrammarParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(LanguageGrammarParser.SEMICOLON, 0); }
		public InputStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputStatement; }
	}

	public final InputStatementContext inputStatement() throws RecognitionException {
		InputStatementContext _localctx = new InputStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_inputStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(INPUT);
			setState(106);
			match(LPAREN);
			setState(107);
			match(ID);
			setState(108);
			match(RPAREN);
			setState(109);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ArithExpressionContext arithExpression() {
			return getRuleContext(ArithExpressionContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(LanguageGrammarParser.STRING_LITERAL, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				arithExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				condition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				match(STRING_LITERAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				term();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArithExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(LanguageGrammarParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(LanguageGrammarParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(LanguageGrammarParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(LanguageGrammarParser.MINUS, i);
		}
		public TerminalNode STRING_LITERAL() { return getToken(LanguageGrammarParser.STRING_LITERAL, 0); }
		public ArithExpressionContext arithExpression() {
			return getRuleContext(ArithExpressionContext.class,0);
		}
		public ArithExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithExpression; }
	}

	public final ArithExpressionContext arithExpression() throws RecognitionException {
		ArithExpressionContext _localctx = new ArithExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arithExpression);
		int _la;
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case ID:
			case NUMBER:
			case MINUS:
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				term();
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PLUS || _la==MINUS) {
					{
					{
					setState(118);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(119);
					term();
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(STRING_LITERAL);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS) {
					{
					setState(126);
					match(PLUS);
					setState(127);
					arithExpression();
					}
				}

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

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(LanguageGrammarParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(LanguageGrammarParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(LanguageGrammarParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(LanguageGrammarParser.DIV, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			factor();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIV) {
				{
				{
				setState(133);
				_la = _input.LA(1);
				if ( !(_la==MULT || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(134);
				factor();
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode EXP() { return getToken(LanguageGrammarParser.EXP, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			atom();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXP) {
				{
				setState(141);
				match(EXP);
				setState(142);
				factor();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(LanguageGrammarParser.NUMBER, 0); }
		public TerminalNode MINUS() { return getToken(LanguageGrammarParser.MINUS, 0); }
		public TerminalNode ID() { return getToken(LanguageGrammarParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(LanguageGrammarParser.LPAREN, 0); }
		public ArithExpressionContext arithExpression() {
			return getRuleContext(ArithExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LanguageGrammarParser.RPAREN, 0); }
		public TerminalNode TRUE() { return getToken(LanguageGrammarParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(LanguageGrammarParser.FALSE, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_atom);
		int _la;
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(145);
					match(MINUS);
					}
				}

				setState(148);
				match(NUMBER);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(ID);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				match(LPAREN);
				setState(151);
				arithExpression();
				setState(152);
				match(RPAREN);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 5);
				{
				setState(155);
				match(FALSE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public List<AndConditionContext> andCondition() {
			return getRuleContexts(AndConditionContext.class);
		}
		public AndConditionContext andCondition(int i) {
			return getRuleContext(AndConditionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(LanguageGrammarParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(LanguageGrammarParser.OR, i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			andCondition();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(159);
				match(OR);
				setState(160);
				andCondition();
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AndConditionContext extends ParserRuleContext {
		public List<CompareConditionContext> compareCondition() {
			return getRuleContexts(CompareConditionContext.class);
		}
		public CompareConditionContext compareCondition(int i) {
			return getRuleContext(CompareConditionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(LanguageGrammarParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(LanguageGrammarParser.AND, i);
		}
		public AndConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andCondition; }
	}

	public final AndConditionContext andCondition() throws RecognitionException {
		AndConditionContext _localctx = new AndConditionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_andCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			compareCondition();
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(167);
				match(AND);
				setState(168);
				compareCondition();
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CompareConditionContext extends ParserRuleContext {
		public List<ArithExpressionContext> arithExpression() {
			return getRuleContexts(ArithExpressionContext.class);
		}
		public ArithExpressionContext arithExpression(int i) {
			return getRuleContext(ArithExpressionContext.class,i);
		}
		public ComparisonOpContext comparisonOp() {
			return getRuleContext(ComparisonOpContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(LanguageGrammarParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LanguageGrammarParser.RPAREN, 0); }
		public TerminalNode TRUE() { return getToken(LanguageGrammarParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(LanguageGrammarParser.FALSE, 0); }
		public CompareConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareCondition; }
	}

	public final CompareConditionContext compareCondition() throws RecognitionException {
		CompareConditionContext _localctx = new CompareConditionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_compareCondition);
		try {
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				arithExpression();
				setState(175);
				comparisonOp();
				setState(176);
				arithExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(LPAREN);
				setState(179);
				condition();
				setState(180);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				match(TRUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(183);
				match(FALSE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonOpContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(LanguageGrammarParser.LT, 0); }
		public TerminalNode LE() { return getToken(LanguageGrammarParser.LE, 0); }
		public TerminalNode GT() { return getToken(LanguageGrammarParser.GT, 0); }
		public TerminalNode GE() { return getToken(LanguageGrammarParser.GE, 0); }
		public TerminalNode EQUALS() { return getToken(LanguageGrammarParser.EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(LanguageGrammarParser.NOT_EQUALS, 0); }
		public ComparisonOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOp; }
	}

	public final ComparisonOpContext comparisonOp() throws RecognitionException {
		ComparisonOpContext _localctx = new ComparisonOpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_comparisonOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 66060288L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u00bd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0001\u0000\u0001\u0000\u0005\u0000)\b\u0000\n\u0000\f\u0000,\t"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00027\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003=\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0005\u0007T\b\u0007\n\u0007\f\u0007W\t"+
		"\u0007\u0001\u0007\u0005\u0007Z\b\u0007\n\u0007\f\u0007]\t\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\be\b\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\nt\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000by\b\u000b\n\u000b\f\u000b|\t\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u0081\b\u000b\u0003\u000b\u0083\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0005\f\u0088\b\f\n\f\f\f\u008b\t\f\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u0090\b\r\u0001\u000e\u0003\u000e\u0093\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u009d\b\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u00a2\b\u000f\n\u000f\f\u000f\u00a5\t\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u00aa\b\u0010\n\u0010\f\u0010\u00ad"+
		"\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00b9"+
		"\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0000\u0000\u0013\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$\u0000\u0003\u0001\u0000\u000f\u0010\u0001\u0000\u0011\u0012\u0001"+
		"\u0000\u0014\u0019\u00c5\u0000*\u0001\u0000\u0000\u0000\u0002/\u0001\u0000"+
		"\u0000\u0000\u00046\u0001\u0000\u0000\u0000\u00068\u0001\u0000\u0000\u0000"+
		"\b@\u0001\u0000\u0000\u0000\nE\u0001\u0000\u0000\u0000\fK\u0001\u0000"+
		"\u0000\u0000\u000eQ\u0001\u0000\u0000\u0000\u0010`\u0001\u0000\u0000\u0000"+
		"\u0012i\u0001\u0000\u0000\u0000\u0014s\u0001\u0000\u0000\u0000\u0016\u0082"+
		"\u0001\u0000\u0000\u0000\u0018\u0084\u0001\u0000\u0000\u0000\u001a\u008c"+
		"\u0001\u0000\u0000\u0000\u001c\u009c\u0001\u0000\u0000\u0000\u001e\u009e"+
		"\u0001\u0000\u0000\u0000 \u00a6\u0001\u0000\u0000\u0000\"\u00b8\u0001"+
		"\u0000\u0000\u0000$\u00ba\u0001\u0000\u0000\u0000&)\u0003\u0002\u0001"+
		"\u0000\')\u0003\u0004\u0002\u0000(&\u0001\u0000\u0000\u0000(\'\u0001\u0000"+
		"\u0000\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001"+
		"\u0000\u0000\u0000+-\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000"+
		"-.\u0005\u0000\u0000\u0001.\u0001\u0001\u0000\u0000\u0000/0\u0003\u0006"+
		"\u0003\u00000\u0003\u0001\u0000\u0000\u000017\u0003\b\u0004\u000027\u0003"+
		"\n\u0005\u000037\u0003\f\u0006\u000047\u0003\u0010\b\u000057\u0003\u0012"+
		"\t\u000061\u0001\u0000\u0000\u000062\u0001\u0000\u0000\u000063\u0001\u0000"+
		"\u0000\u000064\u0001\u0000\u0000\u000065\u0001\u0000\u0000\u00007\u0005"+
		"\u0001\u0000\u0000\u000089\u0005\u0002\u0000\u00009<\u0005\u000b\u0000"+
		"\u0000:;\u0005\u0001\u0000\u0000;=\u0003\u0014\n\u0000<:\u0001\u0000\u0000"+
		"\u0000<=\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0005\u000e"+
		"\u0000\u0000?\u0007\u0001\u0000\u0000\u0000@A\u0005\u000b\u0000\u0000"+
		"AB\u0005\u0001\u0000\u0000BC\u0003\u0016\u000b\u0000CD\u0005\u000e\u0000"+
		"\u0000D\t\u0001\u0000\u0000\u0000EF\u0005\u0003\u0000\u0000FG\u0005\u001a"+
		"\u0000\u0000GH\u0003\u001e\u000f\u0000HI\u0005\u001b\u0000\u0000IJ\u0003"+
		"\u000e\u0007\u0000J\u000b\u0001\u0000\u0000\u0000KL\u0005\u0004\u0000"+
		"\u0000LM\u0005\u001a\u0000\u0000MN\u0003\u001e\u000f\u0000NO\u0005\u001b"+
		"\u0000\u0000OP\u0003\u000e\u0007\u0000P\r\u0001\u0000\u0000\u0000QU\u0005"+
		"\u001c\u0000\u0000RT\u0003\u0002\u0001\u0000SR\u0001\u0000\u0000\u0000"+
		"TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000"+
		"\u0000V[\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000XZ\u0003\u0004"+
		"\u0002\u0000YX\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\^\u0001\u0000\u0000\u0000"+
		"][\u0001\u0000\u0000\u0000^_\u0005\u001d\u0000\u0000_\u000f\u0001\u0000"+
		"\u0000\u0000`a\u0005\u0005\u0000\u0000ad\u0005\u001a\u0000\u0000be\u0005"+
		"\r\u0000\u0000ce\u0003\u0014\n\u0000db\u0001\u0000\u0000\u0000dc\u0001"+
		"\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0005\u001b\u0000\u0000"+
		"gh\u0005\u000e\u0000\u0000h\u0011\u0001\u0000\u0000\u0000ij\u0005\u0006"+
		"\u0000\u0000jk\u0005\u001a\u0000\u0000kl\u0005\u000b\u0000\u0000lm\u0005"+
		"\u001b\u0000\u0000mn\u0005\u000e\u0000\u0000n\u0013\u0001\u0000\u0000"+
		"\u0000ot\u0003\u0016\u000b\u0000pt\u0003\u001e\u000f\u0000qt\u0005\r\u0000"+
		"\u0000rt\u0003\u0018\f\u0000so\u0001\u0000\u0000\u0000sp\u0001\u0000\u0000"+
		"\u0000sq\u0001\u0000\u0000\u0000sr\u0001\u0000\u0000\u0000t\u0015\u0001"+
		"\u0000\u0000\u0000uz\u0003\u0018\f\u0000vw\u0007\u0000\u0000\u0000wy\u0003"+
		"\u0018\f\u0000xv\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000\u0000zx\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\u0083\u0001\u0000\u0000"+
		"\u0000|z\u0001\u0000\u0000\u0000}\u0080\u0005\r\u0000\u0000~\u007f\u0005"+
		"\u000f\u0000\u0000\u007f\u0081\u0003\u0016\u000b\u0000\u0080~\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0083\u0001\u0000"+
		"\u0000\u0000\u0082u\u0001\u0000\u0000\u0000\u0082}\u0001\u0000\u0000\u0000"+
		"\u0083\u0017\u0001\u0000\u0000\u0000\u0084\u0089\u0003\u001a\r\u0000\u0085"+
		"\u0086\u0007\u0001\u0000\u0000\u0086\u0088\u0003\u001a\r\u0000\u0087\u0085"+
		"\u0001\u0000\u0000\u0000\u0088\u008b\u0001\u0000\u0000\u0000\u0089\u0087"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0019"+
		"\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u008f"+
		"\u0003\u001c\u000e\u0000\u008d\u008e\u0005\u0013\u0000\u0000\u008e\u0090"+
		"\u0003\u001a\r\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001"+
		"\u0000\u0000\u0000\u0090\u001b\u0001\u0000\u0000\u0000\u0091\u0093\u0005"+
		"\u0010\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0092\u0093\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u009d\u0005"+
		"\f\u0000\u0000\u0095\u009d\u0005\u000b\u0000\u0000\u0096\u0097\u0005\u001a"+
		"\u0000\u0000\u0097\u0098\u0003\u0016\u000b\u0000\u0098\u0099\u0005\u001b"+
		"\u0000\u0000\u0099\u009d\u0001\u0000\u0000\u0000\u009a\u009d\u0005\t\u0000"+
		"\u0000\u009b\u009d\u0005\n\u0000\u0000\u009c\u0092\u0001\u0000\u0000\u0000"+
		"\u009c\u0095\u0001\u0000\u0000\u0000\u009c\u0096\u0001\u0000\u0000\u0000"+
		"\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000"+
		"\u009d\u001d\u0001\u0000\u0000\u0000\u009e\u00a3\u0003 \u0010\u0000\u009f"+
		"\u00a0\u0005\b\u0000\u0000\u00a0\u00a2\u0003 \u0010\u0000\u00a1\u009f"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u001f"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00ab"+
		"\u0003\"\u0011\u0000\u00a7\u00a8\u0005\u0007\u0000\u0000\u00a8\u00aa\u0003"+
		"\"\u0011\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00aa\u00ad\u0001\u0000"+
		"\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ac!\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ae\u00af\u0003\u0016\u000b\u0000\u00af\u00b0\u0003$\u0012\u0000"+
		"\u00b0\u00b1\u0003\u0016\u000b\u0000\u00b1\u00b9\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0005\u001a\u0000\u0000\u00b3\u00b4\u0003\u001e\u000f\u0000"+
		"\u00b4\u00b5\u0005\u001b\u0000\u0000\u00b5\u00b9\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b9\u0005\t\u0000\u0000\u00b7\u00b9\u0005\n\u0000\u0000\u00b8"+
		"\u00ae\u0001\u0000\u0000\u0000\u00b8\u00b2\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9"+
		"#\u0001\u0000\u0000\u0000\u00ba\u00bb\u0007\u0002\u0000\u0000\u00bb%\u0001"+
		"\u0000\u0000\u0000\u0012(*6<U[dsz\u0080\u0082\u0089\u008f\u0092\u009c"+
		"\u00a3\u00ab\u00b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}