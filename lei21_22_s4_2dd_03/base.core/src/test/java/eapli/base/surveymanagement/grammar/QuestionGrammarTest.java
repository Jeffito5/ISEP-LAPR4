package eapli.base.surveymanagement.grammar;

import eapli.base.surveymanagement.domain.QuestionType;
import eapli.base.surveymanagement.grammar.questionverifier.QuestionValidator;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionGrammarTest {

    @Test
    public void singleWordFreeTextQuestionTest() throws IOException {
        File file = new File("temp1");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("Enjoy?");
        fileWriter.close();
        try {
            QuestionValidator.validate(file, QuestionType.FREE_TEXT);
        }catch (Exception e){
            assert false;
        }
        finally {
            file.delete();
        }
    }

    @Test
    public void emptyWithFinalPeriodFreeTextQuestionTest() throws IOException {
        File file = new File("temp2");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("         .");
        fileWriter.close();
        try {
            QuestionValidator.validate(file, QuestionType.FREE_TEXT);
        }catch (Exception e){
            assertEquals(e.getClass(), RuntimeException.class);
            assertEquals(e.getMessage(), "Grammar Error:Something went wrong! (Most commonly due to sentence not finished with final punctuation (E.g. '.'(Period)))");
        }
        finally {
            file.delete();
        }
    }

    @Test
    public void freeTextQuestionTest() throws IOException {
        File file = new File("temp3");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("What do you think of our new product line?");
        fileWriter.close();
        try {
            QuestionValidator.validate(file, QuestionType.FREE_TEXT);
        }catch (Exception e){
            assert false;
        }
        finally {
            file.delete();
        }
    }

    @Test
    public void freeTextQuestionPunctuationErrorTest() throws IOException {
        File file = new File("temp4");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("What do you think of our new product line");  //Doesn't end with a punctuation signal
        fileWriter.close();

        try {
            QuestionValidator.validate(file, QuestionType.FREE_TEXT);
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
            assertEquals(e.getMessage(), "Grammar Error:Something went wrong! (Most commonly due to sentence not finished with final punctuation (E.g. '.'(Period)))");

        }
        finally {
            file.delete();
        }
    }

    @Test
    public void freeTextQuestionWithOptionsTest() throws IOException {
        File file = new File("temp5");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("What do you think of our new product line?\n" +
                "\n" +
                "a) It's really good!\n" +
                "b) I don't like it that much...\n");
        fileWriter.close();

        try {
            QuestionValidator.validate(file, QuestionType.FREE_TEXT);
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
            assertEquals(e.getMessage(), "ERROR: A Free-Text Question cannot have multiple options.");

        }
        finally {
            file.delete();
        }
    }

    @Test
    public void choiceQuestionTest() throws IOException {
        File file = new File("temp6");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("What do you think of our new product line?\n" +
                "\n" +
                "a) It's really good!\n" +
                "b) I don't like it that much...\n");
        fileWriter.close();

        try {
            QuestionValidator.validate(file, QuestionType.SINGLE_CHOICE);
        } catch (Exception e) {
           assert false;
        }
        finally {
            file.delete();
        }
    }

    @Test
    public void multipleLineFreeTextQuestionTest() throws IOException {
        File file = new File("temp7");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("What do you think of our new product line?\n" +
                "We've invested our greatest efforts trying to please you!\n");
        fileWriter.close();

        try {
            QuestionValidator.validate(file, QuestionType.FREE_TEXT);
        } catch (Exception e) {
            assert false;
        }
        finally {
            file.delete();
        }
    }

    @Test
    public void multiplePhraseFreeTextQuestionTest() throws IOException {
        File file = new File("temp8");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("What do you think of our new product line? We've invested our greatest efforts trying to please you! Thank you, for your attention. We appreciate it!\n");
        fileWriter.close();

        try {
            QuestionValidator.validate(file, QuestionType.FREE_TEXT);
        } catch (Exception e) {
            assert false;
        }
        finally {
            file.delete();
        }
    }

    @Test
    public void spacesChoiceQuestionTest() throws IOException {
        File file = new File("temp8");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("I would like you to ___ my _____.\n" +
                "\n" +
                "a) deliver ... package.\n" +
                "b) protect ... data.\n" +
                "c) keep ... money.\n");
        fileWriter.close();

        try {
            QuestionValidator.validate(file, QuestionType.MULTIPLE_CHOICE);
        } catch (Exception e) {

            assert false;
        }
        finally {
            file.delete();
        }
    }
}
