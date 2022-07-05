grammar QuestionVerifier;

question: free_text_question | multiple_choice_question;    //A question can either be just a piece of text or have different options.-

//-----------------------------------------------------------------------------------------Multiple-Choice

multiple_choice_question: free_text_question choices EOF;       //A Multiple-Choice Question is made by one or more sentences and some options until the EOF

choices: choice choices | choice ;                              //For Listener purpose.

choice:OPTION SPACE* phrase+;                                     //Has a single choice text

//-----------------------------------------------------------------------------------------Multiple-Choice

//-----------------------------------------------------------------------------------------Free-Text

free_text_question:text;    //When is free text, we want to use the text read

text: phrase text
    |phrase SPACE text
    | phrase; // Reads multiple sentences

//-----------------------------------------------------------------------------------------Free-Text

phrase: WORD phrase                  //A phrase is a group of one or more words with multiple spaces or commas and a final period, for example.
        |WORD PUNCTUATION
        |PUNCTUATION SPACE phrase
        |PUNCTUATION
        |WORD SPACE phrase
        |COMMA SPACE phrase;

OPTION: ([a-z]')') | ([1-9]+')');                   //Defines how an option begins

WORD: [a-zA-Z]+ | [0-9]+ | '_'+ | '\'' | '"';    //A word can be either some letters or numbers. The underline is to allow multiple-choice questions to use a 'blank space'

PUNCTUATION: [.!?;:-]+;                //Supported Phrase ends.

IGNORE: [\t\r\n]-> skip;            //Ignores any other formatation

SPACE:' ';                          //To process spaces

COMMA:',';                          //To process commas
