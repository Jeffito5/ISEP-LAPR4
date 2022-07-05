package eapli.base.surveymanagement.dto;

/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class QuestionnaireDTO {
    public Long id;
    public String toString;

    public QuestionnaireDTO(Long id,String toString){
        this.id = id;
        this.toString = toString;
    }
}
