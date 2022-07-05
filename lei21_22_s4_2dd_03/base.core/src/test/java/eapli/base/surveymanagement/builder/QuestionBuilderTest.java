package eapli.base.surveymanagement.builder;

import eapli.base.surveymanagement.builders.QuestionBuilder;
import eapli.base.surveymanagement.domain.Obligatoriness;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.QuestionType;
import org.junit.Test;

import javax.naming.directory.InvalidAttributesException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionBuilderTest {


    @Test
    public void questionIdExceptionsTest() {
        QuestionBuilder builder = new QuestionBuilder(true);

        builder.withQuestionId(null);
        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing question id!");

        builder.withQuestionId("");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing question id!");

        builder.withQuestionId("   ");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing question id!");

        builder.withQuestionId("    ");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing question id!");
    }

    @Test
    public void textExceptionsTest() {
        QuestionBuilder builder = new QuestionBuilder(true);
        builder.withQuestionId("Test Question 1 Id");

        builder.withText(null);
        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing question text!");

        builder.withText("");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing question text!");

        builder.withText("      ");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing question text!");
    }

    @Test
    public void obligatorinessExceptionsTest() {
        QuestionBuilder builder = new QuestionBuilder(true);
        builder.withQuestionId("Test Question 1 Id");
        builder.withText("Test Question 1 Text");

        builder.withObligatoriness(null);
        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing question obligatoriness!");
    }

    @Test
    public void conditionExceptionsTest() throws InvalidAttributesException {
        QuestionBuilder builder = new QuestionBuilder(true);
        builder.withQuestionId("Test Question 1 Id");
        builder.withText("Test Question 1 Text");
        builder.withObligatoriness(Obligatoriness.CONDITIONAL);

        try {
            builder.withCondition(null, null);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "ERROR: Cannot complete operation! Missing condition question!");
        }

        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing 'condition' due to obligatoriness is set to 'Conditional'!");

        builder.withObligatoriness(Obligatoriness.MANDATORY);
        builder.withCondition("Test Question 0 Id", "a) First Option.");
        assertNull(builder.condition);

        builder.withObligatoriness(Obligatoriness.OPTIONAL);
        builder.withCondition("Test Question 0 Id", "a) First Option.");
        assertNull(builder.condition);
    }

    @Test
    public void typeExceptionsTest() throws InvalidAttributesException {
        QuestionBuilder builder = new QuestionBuilder(true);
        builder.withQuestionId("Test Question 1 Id");
        builder.withText("Test Question 1 Text");
        builder.withObligatoriness(Obligatoriness.MANDATORY);
        builder.withCondition(null, null);


        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing question type!");
    }

    @Test
    public void optionsExceptionsTest() throws InvalidAttributesException {
        QuestionBuilder builder = new QuestionBuilder(true);
        builder.withQuestionId("Test Question 1 Id");
        builder.withText("Test Question 1 Text");
        builder.withObligatoriness(Obligatoriness.MANDATORY);
        builder.withCondition(null, null);


        QuestionType type = QuestionType.MULTIPLE_CHOICE;
        builder.withType(type);

        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! " + type + " type Questions must have a list of options!");

        List<String> options = new ArrayList<>();
        builder.withOptions(options);
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! " + type + " type Questions must have a list of options!");


        type = QuestionType.FREE_TEXT;
        builder.withType(type);

        options = new ArrayList<>();
        options.add("a) First Option.");
        builder.withOptions(options);

        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! " + type + " type Questions cannot have a list of options!");
    }

    @Test
    public void successCase() throws InvalidAttributesException {
        QuestionBuilder builder = new QuestionBuilder(false);

        List<String> options = new ArrayList<>();
        options.add("a) First Option.");
        options.add("c) Second Option.");

        builder.withQuestionId("Test Question 1 Id")
                .withText("Test Question 1 Text.")
                .withObligatoriness(Obligatoriness.CONDITIONAL)
                .withCondition("Test Question 0 Id", "b) Second Option.")
                .withType(QuestionType.MULTIPLE_CHOICE)
                .withOptions(options)
                .withInfo("Test Question 1 Info")
                .withInstructions("Test Question 1 Instructions");

        Question question = builder.build();
        assertNotNull(question);

        builder.withObligatoriness(Obligatoriness.OPTIONAL);
        question = builder.build();
        assertNotNull(question);

        builder.withType(QuestionType.FREE_TEXT)
                .withOptions(null);
        question = builder.build();
        assertNotNull(question);

        builder.withInfo(null);
        question = builder.build();
        assertNotNull(question);

        builder.withInstructions(null);
        question = builder.build();
        assertNotNull(question);
    }
}
