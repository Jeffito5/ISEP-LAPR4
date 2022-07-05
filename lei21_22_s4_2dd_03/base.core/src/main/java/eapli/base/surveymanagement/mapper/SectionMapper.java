package eapli.base.surveymanagement.mapper;

import eapli.base.surveymanagement.domain.Section;
import eapli.base.surveymanagement.dto.SectionDTO;

/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class SectionMapper {

    public SectionDTO toDTO(Section section){
        return new SectionDTO(section.sectionId(),section.toString(),new QuestionMapper().toDTO(section.questions()));
    }
}
