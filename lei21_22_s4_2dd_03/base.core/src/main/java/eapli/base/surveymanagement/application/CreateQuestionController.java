package eapli.base.surveymanagement.application;

import eapli.base.surveymanagement.builders.QuestionBuilder;
import eapli.base.surveymanagement.domain.Obligatoriness;
import eapli.base.surveymanagement.domain.QuestionType;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.dto.QuestionDTO;
import eapli.base.surveymanagement.grammar.questionverifier.QuestionValidator;
import eapli.base.surveymanagement.mapper.QuestionMapper;
import eapli.base.surveymanagement.repositories.QuestionRepository;

import javax.naming.directory.InvalidAttributesException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Author: Guilherme Sencadas - 1201180
 */

public class CreateQuestionController {

    /**Creates a new instance of Question
     * <p>
     *     Creates a temporary file with the question's text and verifies text grammar using ANTLR.
     * @param questionId Question ID to be used
     * @param text Question Text to be used
     * @param instructions Question Instructions to be used
     * @param obli Question Obligatoriness to be used
     * @param info Question Extra Information to be used
     * @param type Question Type to be used
     * @param conditionQuestion Question that specifies the condition
     * @param conditionOption Question's option that specifies the condition
     * @return Instance of QuestionDTO with newly created Question toString()
     * @throws InvalidAttributesException Thrown by QuestionBuilder
     * @throws IOException Thrown by FileWriter
     */
    public QuestionDTO createQuestion(String questionId, String text,
                                      String instructions, Obligatoriness obli,
                                      String info, QuestionType type,
                                      QuestionDTO conditionQuestion, String conditionOption) throws InvalidAttributesException, IOException {

        File file = new File("question.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(text);
        fileWriter.close();
        QuestionValidator.validate(file,type);

        file.delete();

        QuestionBuilder builder = new QuestionBuilder(true).withQuestionId(questionId)
                .withInfo(info)
                .withInstructions(instructions)
                .withObligatoriness(obli)
                .withType(type)
                .withText(QuestionValidator.text)
                .withOptions(QuestionValidator.options);

        if (conditionQuestion != null)
            builder.withCondition(conditionQuestion.questionId,conditionOption);

        QuestionValidator.reset();
        Question question = builder.build();
        QuestionRepository.questions.add(question);
        return new QuestionMapper().toDTO(question);
    }

    /**Gets the List of values in the ENUM class
     *
     * @return List with all values of Obligatoriness
     */
    public List<Obligatoriness> obligatorinessList() {
        return Arrays.asList(Obligatoriness.values());
    }

    /**Gets the List of values in the ENUM class
     *
     * @return List with all values of QuestionTypes
     */
    public List<QuestionType> typeList() {
        return Arrays.asList(QuestionType.values());
    }
}
