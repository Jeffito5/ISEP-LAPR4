package eapli.base.surveymanagement.repositories;

import eapli.base.surveymanagement.domain.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 1201180 - Guilherme Sencadas
 * <p>
 Class that stores (in memory) the current state of questions. It's not being stored in the Data Base because, if the questionnaire creating is canceled, this repository is reset.
 <p>
 Also is reset every time a Questionnaire is successfully created.
 *
 */
public class QuestionRepository {

    public static List<Question> questions = new ArrayList<>();

    /**Adds a Question to the current List
     *
     * @param question Question to be added.
     * @throws IllegalArgumentException Thrown if there is already a question with such code in the current list.
     */
    public static void add(Question question) throws IllegalArgumentException{
        if (!containsQuestionId(question.questionId()))
            questions.add(question);
        else
            throw new IllegalArgumentException("ERROR: Question with code" + question.questionId() + "already defined in scope!");
    }

    /**Checks if a Question is in the current List
     *
     * @param questionId Question ID to be used in the search
     * @return TRUE if it contains the Question, FALSE otherwise
     */
    public static boolean containsQuestionId(String questionId){
        for (Question question : questions){
            if (question.questionId().equals(questionId))
                return true;
        }
        return false;
    }

    /**
     * Clears the Question List
     */
    public static void clear(){
        questions = new ArrayList<>();
    }

    /**Searches a specific Question through its ID
     *
     * @param questionId Question ID to be used in the search
     * @return Question instance if found, NULL otherwise
     */
    public static Question getQuestion(String questionId){
        for (Question question : questions){
            if (question.questionId().equals(questionId))
                return question;
        }
        return null;
    }
}
