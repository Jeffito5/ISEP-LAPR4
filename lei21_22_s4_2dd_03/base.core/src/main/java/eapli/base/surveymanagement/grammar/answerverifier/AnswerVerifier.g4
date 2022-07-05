grammar AnswerVerifier;

//======================================================Main Components
readSurvey: SURVEY SPACE  surveyID ':' readQuestionnaire;

readQuestionnaire: QUESTIONNAIRE SPACE questionnaireID ':' SPACE title
                    welcomeMessage
                    LIST_OF_SECTIONS
                    readSection
                  QUESTIONNAIRE SPACE* finalMessage| EOF;

readSection: SECTION SPACE sectionID ':' repeatInfo
               obli SPACE '-' SPACE title
               description
               LIST_OF_QUESTIONS
               readQuestion readSection |;

readQuestion: QUESTION':'
              obli SPACE* '-' SPACE* questionID PUNCTUATION SPACE* question
              readAnswer readQuestion |;

readAnswer: ANSWER answerText| ANSWER answerOptions PUNCTUATION
                            |ANSWER answerOptions{throw new RuntimeException("GRAMMAR ERROR: Missing Final Punctuation! E.g. Period '.'");}
                            |ANSWER;
//======================================================Main Components


//======================================================Complex Tokens
question: free_text_question | multiple_choice_question;

multiple_choice_question: free_text_question LIST_OF_OPTIONS choices;

choices: choice choices | choice ;

choice:OPTION SPACE* phrase+;

free_text_question:text PUNCTUATION* SPACE* extraInfo instructions;

answerText: text;

answerOptions: option (COMMA SPACE* answerOptions)*;

option: OPTION;

text: phrase text
    |phrase SPACE text
    | phrase;

phrase: WORD phrase
        |WORD PUNCTUATION
        |PUNCTUATION SPACE phrase
        |PUNCTUATION
        |WORD SPACE phrase
        |COMMA SPACE phrase
        |QUESTIONNAIRE phrase
        |SURVEY phrase
        |QUESTION phrase
        |SECTION phrase
        |WELCOME_MESSAGE phrase
        |FINAL_MESSAGE phrase
        |LIST_OF_OPTIONS phrase
        |LIST_OF_QUESTIONS phrase
        |LIST_OF_SECTIONS
        |CATEGORY
        |BRAND
        |MANDATORY
        |OPTIONAL
        |CONDITIONAL
        |DESCRIPTION
        |INSTRUCTIONS
        |ABOUT
        |ANSWER;

title: WORD | WORD SPACE* title;

repeatInfo:SPACE '('ABOUT SPACE repeatability SPACE* repeatID')'
            |;//Welcome Message is Optional

extraInfo:'(' text ')'
            |; //Info is Optional

obli:'('obligatoriness')'
    | {throw new RuntimeException("GRAMMAR ERROR: Missing Obligatoriness!");};

welcomeMessage:WELCOME_MESSAGE text
                |;//Welcome Message is Optional

finalMessage: FINAL_MESSAGE text
              | {throw new RuntimeException("GRAMMAR ERROR: Missing Final Message!");};

description:DESCRIPTION text
            |;//Description is Optional

instructions:INSTRUCTIONS text
            |;//Instructions is Optional
//======================================================Complex Tokens

//======================================================IDs and ENUMs
surveyID:WORD
        |{throw new RuntimeException("GRAMMAR ERROR: Missing SURVEY ID!");};

questionnaireID:WORD
        |{throw new RuntimeException("GRAMMAR ERROR: Missing Questionnaire ID!");};

sectionID:WORD
            |{throw new RuntimeException("GRAMMAR ERROR: Missing Section ID!");};

questionID:WORD
            |{throw new RuntimeException("GRAMMAR ERROR: Missing Question ID!");};

obligatoriness:MANDATORY | OPTIONAL | CONDITIONAL
                |{throw new RuntimeException("GRAMMAR ERROR: Invalid Obligatoriness!");};

repeatability: CATEGORY | BRAND
                |{throw new RuntimeException("GRAMMAR ERROR: Invalid Repeatability!");};

repeatID: WORD
          |{throw new RuntimeException("GRAMMAR ERROR: Missing Repeated Attribute ID!");};
//======================================================IDs and ENUMs



//===========================================================================Word Constants
SURVEY: S U R V E Y;

QUESTIONNAIRE: Q U E S T I O N N A I R E;

QUESTION: Q U E S T I O N;

SECTION: S E C T I O N;

WELCOME_MESSAGE: W E L C O M E SPACE+ M E S S A G E ':' SPACE*;

FINAL_MESSAGE:F I N A L SPACE+ M E S S A G E ':' SPACE*;

MANDATORY: M A N D A T O R Y;

OPTIONAL: O P T I O N A L;

CONDITIONAL: C O N D I T I O N A L;

DESCRIPTION: D E S C R I P T I O N ':' SPACE*;

ABOUT: A B O U T;

CATEGORY: C A T E G O R Y;

BRAND: B R A N D;

INSTRUCTIONS: I N S T R U C T I O N S ':' SPACE*;

ANSWER: A ':' SPACE*;

LIST_OF_SECTIONS: L I S T SPACE+ O F SPACE+ S E C T I O N S ':';


LIST_OF_QUESTIONS: L I S T SPACE+ O F SPACE+ Q U E S T I O N S ':';

LIST_OF_OPTIONS: O P T I O N S ':';
//===========================================================================Word Constants


//======================================================Basic Tokens
WORD: (LETTER | NUMBER)+ | '_'+ | '\'' | '"'     //A word can be either some letters or numbers. The underline is to allow multiple-choice questions to use a 'blank space'
        |QUESTIONNAIRE
        |SURVEY
        |QUESTION;
PUNCTUATION: [.!?;:-]+;                //Supported Phrase ends.

SPACE:' ';

COMMA:',';                          //To process commas

IGNORE: [\t\r\n]-> skip;            //Ignores any other formatation

OPTION: (LETTER | NUMBER) SPACE*')';

LETTER: [a-zA-Z];

NUMBER:[0-9];
//======================================================Basic Tokens

//======================================================Fragments
fragment A:[aA];
fragment B:[bB];
fragment C:[cC];
fragment D:[dD];
fragment E:[eE];
fragment F:[fF];
fragment G:[gG];
fragment H:[hH];
fragment I:[iI];
fragment J:[jJ];
fragment K:[kK];
fragment L:[lL];
fragment M:[mM];
fragment N:[nN];
fragment O:[oO];
fragment P:[pP];
fragment Q:[qQ];
fragment R:[rR];
fragment S:[sS];
fragment T:[tT];
fragment U:[uU];
fragment V:[vV];
fragment W:[wW];
fragment X:[xX];
fragment Y:[yY];
fragment Z:[zZ];
//======================================================Fragments