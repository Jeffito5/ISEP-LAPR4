package eapli.base.surveymanagement.builder;

import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.surveymanagement.application.AnswerSurveyController;
import eapli.base.surveymanagement.builders.QuestionBuilder;
import eapli.base.surveymanagement.builders.QuestionnaireBuilder;
import eapli.base.surveymanagement.builders.SectionBuilder;
import eapli.base.surveymanagement.domain.*;
import eapli.base.surveymanagement.domain.survey.Survey;
import org.junit.Test;

import javax.naming.directory.InvalidAttributesException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionnaireBuilderTest {
    @Test
    public void questionnaireIdExceptionsTest() {
        QuestionnaireBuilder builder = new QuestionnaireBuilder(true);

        builder.withId(null);
        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing questionnaire id!");

        builder.withId("");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing questionnaire id!");

        builder.withId("   ");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing questionnaire id!");

        builder.withId("    ");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing questionnaire id!");
    }

    @Test
    public void titleExceptionsTest() {
        QuestionnaireBuilder builder = new QuestionnaireBuilder(true);
        builder.withId("Test Questionnaire 1 Id");

        builder.withTitle(null);
        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing questionnaire title!");

        builder.withTitle("");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing questionnaire title!");

        builder.withTitle("      ");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing questionnaire title!");
    }

    @Test
    public void finalMessageExceptionsTest() {
        QuestionnaireBuilder builder = new QuestionnaireBuilder(true);
        builder.withId("Test Questionnaire 1 Id");
        builder.withTitle("Test Questionnaire 1 Title");

        builder.withFinalMessage(null);
        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing questionnaire final message!");

        builder.withFinalMessage("");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing questionnaire final message!");

        builder.withFinalMessage("      ");
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! Missing questionnaire final message!");
    }

    @Test
    public void sectionsExceptionsTest() throws InvalidAttributesException {
        QuestionnaireBuilder builder = new QuestionnaireBuilder(true);
        builder.withId("Test Questionnaire 1 Id");
        builder.withTitle("Test Questionnaire 1 Title");
        builder.withFinalMessage("Test Questionnaire 1 Final Message");

        Exception exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! List of sections is empty!");

        builder.withSections(new ArrayList<>());
        exception = assertThrows(InvalidAttributesException.class, builder::build);
        assertEquals(exception.getMessage(), "ERROR: Cannot complete operation! List of sections is empty!");

    }

    @Test
    public void successCase() throws InvalidAttributesException {
        QuestionnaireBuilder questionnaireBuilder = new QuestionnaireBuilder(true);
        questionnaireBuilder.withId("Test Questionnaire 1 Id");
        questionnaireBuilder.withTitle("Test Questionnaire 1 Title");
        questionnaireBuilder.withFinalMessage("Test Questionnaire 1 Final Message");
        questionnaireBuilder.withWelcomeMessage("Test Questionnaire 1 Welcome Message");


        SectionBuilder sectionBuilder = new SectionBuilder(false);

        sectionBuilder.withSectionId("Test Section 1 Id")
                .withDescription("Test Section 1 Description")
                .withRepeatability(Repeatability.NONE)
                .withObligatoriness(Obligatoriness.MANDATORY)
                .withTitle("Test Section 1 Title")
                .withCondition(null, null, null);

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
        sectionBuilder.withQuestions(questions);

        List<Section> sections = new ArrayList<>();
        sections.add(sectionBuilder.build());

        questionnaireBuilder.withSections(sections);

        assertNotNull(questionBuilder.build());
    }
}
