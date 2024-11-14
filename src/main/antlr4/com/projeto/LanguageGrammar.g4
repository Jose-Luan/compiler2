grammar LanguageGrammar;

program : (declaration | statement)* EOF;

declaration     : varDeclaration;

statement       : assignment
                | ifStatement
                | whileStatement
                | printStatement
                | inputStatement
                ;

varDeclaration  : VAR ID ('=' expression)? SEMICOLON;
assignment      : ID '=' arithExpression SEMICOLON;
ifStatement     : IF LPAREN condition RPAREN block;
whileStatement  : WHILE LPAREN condition RPAREN block;
block           : LBRACE declaration* statement* RBRACE;

printStatement  : PRINT LPAREN (STRING_LITERAL | expression) RPAREN SEMICOLON;
inputStatement  : INPUT LPAREN ID RPAREN SEMICOLON;


expression      : arithExpression | condition | STRING_LITERAL | term;

arithExpression : term ((PLUS | MINUS) term)* | STRING_LITERAL ('+' arithExpression)?;

term            : factor ((MULT | DIV) factor)*;

factor          : atom (EXP factor)?;

atom            : NUMBER
                | ID
                | LPAREN arithExpression RPAREN
                | MINUS atom
                | TRUE
                | FALSE
                ;

condition       : andCondition (OR andCondition)*;

andCondition    : compareCondition (AND compareCondition)*;

compareCondition: arithExpression comparisonOp arithExpression 
                | LPAREN condition RPAREN; 

comparisonOp    : LT | LE | GT | GE | EQUALS | NOT_EQUALS;

VAR             : 'var';
IF              : 'if';
WHILE           : 'while';
PRINT           : 'print';
INPUT           : 'input';
AND             : 'and';
OR              : 'or';
TRUE            : 'true';
FALSE           : 'false';

ID              : [a-zA-Z_][a-zA-Z0-9_]*;
NUMBER          : [0-9]+ ('.' [0-9]+)?;
STRING_LITERAL  : '"' (~["])* '"';
SEMICOLON       : ';';
PLUS            : '+';
MINUS           : '-';
MULT            : '*';
DIV             : '/';
EXP             : '^';
LT              : '<';
LE              : '<=';
GT              : '>';
GE              : '>=';
EQUALS          : '==';
NOT_EQUALS      : '!=';
LPAREN          : '(';
RPAREN          : ')';
LBRACE          : '{';
RBRACE          : '}';
WS              : [ \t\r\n]+ -> skip;
COMMENT         : '//' ~[\r\n]* -> skip;
