package eapli.base.surveymanagement.builder;

import eapli.base.surveymanagement.builders.QuestionBuilder;
import eapli.base.surveymanagement.builders.SectionBuilder;
import eapli.base.surveymanagement.domain.Obligatoriness;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.QuestionType;
import eapli.base.surveymanagement.domain.Repeatability;
import org.junit.Test;

import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SectionBuilderTest {


    @Test
    public void sectionIdExceptionsTest() {
        SectionBuilder builder = new SectionBuilder(true);

        builder.withSectionId(null);
        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing section id!");

        builder.withSectionId("");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing section id!");

        builder.withSectionId("   ");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing section id!");

        builder.withSectionId("    ");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing section id!");
    }

    @Test
    public void titleExceptionsTest() {
        SectionBuilder builder = new SectionBuilder(true);
        builder.withSectionId("Test Section 1 Id");

        builder.withTitle(null);
        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing section title!");

        builder.withTitle("");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing section title!");

        builder.withTitle("      ");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing section title!");
    }

    @Test
    public void obligatorinessExceptionsTest() {
        SectionBuilder builder = new SectionBuilder(true);
        builder.withSectionId("Test Section 1 Id");
        builder.withTitle("Test Question 1 Title");

        builder.withObligatoriness(null);
        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing section obligatoriness!");
    }

    @Test
    public void conditionExceptionsTest() throws InvalidAttributesException {
        SectionBuilder builder = new SectionBuilder(true);
        builder.withSectionId("Test Section 1 Id");
        builder.withTitle("Test Question 1 Title");
        builder.withObligatoriness(Obligatoriness.CONDITIONAL);

        try {
            builder.withCondition(null, null, null);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "ERROR: Cannot complete operation! Missing condition section!");
        }

        try {
            builder.withCondition("Test Section 0 Id", null, null);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "ERROR: Cannot complete operation! Missing condition question!");
        }

        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing 'condition' due to obligatoriness is set to 'Conditional'!");

        builder.withObligatoriness(Obligatoriness.MANDATORY);
        builder.withCondition("Test Section 0 Id", "Test Question 0 Id", "a) First Option.");
        assertNull(builder.condition);

        builder.withObligatoriness(Obligatoriness.OPTIONAL);
        builder.withCondition("Test Section 0 Id", "Test Question 0 Id", "a) First Option.");
        assertNull(builder.condition);
    }

    @Test
    public void typeExceptionsTest() throws InvalidAttributesException {
        SectionBuilder builder = new SectionBuilder(true);
        builder.withSectionId("Test Section 1 Id");
        builder.withTitle("Test Question 1 Title");
        builder.withObligatoriness(Obligatoriness.MANDATORY);
        builder.withCondition(null, null, null);


        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! List of questions is empty!");
    }

    @Test
    public void questionsExceptionsTest() throws InvalidAttributesException {
        SectionBuilder builder = new SectionBuilder(true);
        builder.withSectionId("Test Section 1 Id");
        builder.withTitle("Test Question 1 Title");
        builder.withObligatoriness(Obligatoriness.MANDATORY);
        builder.withCondition(null, null, null);

        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! List of questions is empty!");

        try {
            builder.withQuestions(new ArrayList<>());
        }catch (Exception e){
            assertEquals(e.getMessage(), "ERROR: Cannot complete operation! List of questions is empty!");
        }

        builder.withObligatoriness(Obligatoriness.OPTIONAL);
        List<Question> questions = new ArrayList<>();
        QuestionBuilder questionBuilder = new QuestionBuilder(false)
                .withQuestionId("Test Question 0")
                .withText("Test Question 0 Text.")
                .withType(QuestionType.FREE_TEXT)
                .withObligatoriness(Obligatoriness.MANDATORY)
                .withOptions(null)
                .withInfo("Test Question 0 Info")
                .withInstructions("Test Question 0 Instructions")
                .withCondition(null, null);
        questions.add(questionBuilder.build());
        try {
            builder.withQuestions(questions);
        }catch (Exception e) {
            assertEquals(e.getMessage(), "ERROR: An 'Optional' Section can oly have 'Optional' Questions!");
        }


        builder.withObligatoriness(Obligatoriness.MANDATORY);
        questions = new ArrayList<>();
        questions.add(questionBuilder.withObligatoriness(Obligatoriness.OPTIONAL).build());
        try {
            builder.withQuestions(questions);
        }catch (Exception e){
            assertEquals(e.getMessage(), "ERROR: A 'Mandatory' Section requires at least one Mandatory Question!");
        }
    }

    @Test
    public void repeatabilityExceptionsTest() throws InvalidAttributesException {
        SectionBuilder builder = new SectionBuilder(true);
        builder.withSectionId("Test Section 1 Id");
        builder.withTitle("Test Question 1 Title");
        builder.withObligatoriness(Obligatoriness.MANDATORY);
        builder.withCondition(null, null, null);

        List<Question> questions = new ArrayList<>();
        QuestionBuilder questionBuilder = new QuestionBuilder(false)
                .withQuestionId("Test Question 0")
                .withText("Test Question 0 Text.")
                .withType(QuestionType.FREE_TEXT)
                .withObligatoriness(Obligatoriness.MANDATORY)
                .withOptions(null)
                .withInfo("Test Question 0 Info")
                .withInstructions("Test Question 0 Instructions")
                .withCondition(null, null);
        questions.add(questionBuilder.build());

        builder.withQuestions(questions);
        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing repeatability!");
    }

    @Test
    public void successCase() throws InvalidAttributesException {
        SectionBuilder builder = new SectionBuilder(false);

        builder.withSectionId("Test Section 1 Id")
                .withDescription("Test Section 1 Description")
                .withRepeatability(Repeatability.NONE)
                .withObligatoriness(Obligatoriness.MANDATORY)
                .withTitle("Test Section 1 Title")
                .withCondition(null,null,null);

        List<Question> questions = new ArrayList<>();
        QuestionBuilder questionBuilder = new QuestionBuilder(false)
                .withQuestionId("Test Question 0")
                .withText("Test Question 0 Text.")
                .withType(QuestionType.FREE_TEXT)
                .withObligatoriness(Obligatoriness.MANDATORY)
                .withOptions(null)
                .withInfo("Test Question 0 Info")
                .withInstructions("Test Question 0 Instructions")
                .withCondition(null, null);
        questions.add(questionBuilder.build());
        builder.withQuestions(questions);

        assertNotNull(builder.build());




        builder.withObligatoriness(Obligatoriness.OPTIONAL)
                .withCondition(null,null,null);
        assertNotNull(builder.build());

        builder.withObligatoriness(Obligatoriness.OPTIONAL)
                .withCondition("Test Section 0 Id","Test Question 0 Id","a) First Option.");
        assertNull(builder.condition);
        assertNotNull(builder.build());
    }
}
