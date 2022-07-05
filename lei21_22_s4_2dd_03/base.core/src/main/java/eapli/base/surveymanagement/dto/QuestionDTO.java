package eapli.base.surveymanagement.dto;

import java.util.List;
/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class QuestionDTO {
    public String questionId;
    public String toString;
    public List<String> options;

    public QuestionDTO(String questionId, String toString,List<String> options){
        this.questionId = questionId;
        this.toString = toString;
        this.options = options;
    }
}
