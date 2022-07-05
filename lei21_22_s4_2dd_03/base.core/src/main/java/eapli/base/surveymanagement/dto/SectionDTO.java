package eapli.base.surveymanagement.dto;

import java.util.List;
/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class SectionDTO {
    public String sectionId;
    public String toString;
    List<QuestionDTO> questions;

    public SectionDTO(String sectionId, String toString, List<QuestionDTO> questions){
        this.sectionId = sectionId;
        this.toString = toString;
        this.questions = questions;
    }
}
