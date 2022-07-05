package eapli.base.surveymanagement.application;

import eapli.base.surveymanagement.builders.SectionBuilder;
import eapli.base.surveymanagement.domain.Obligatoriness;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.Repeatability;
import eapli.base.surveymanagement.domain.Section;
import eapli.base.surveymanagement.dto.QuestionDTO;
import eapli.base.surveymanagement.dto.SectionDTO;
import eapli.base.surveymanagement.mapper.QuestionMapper;
import eapli.base.surveymanagement.mapper.SectionMapper;
import eapli.base.surveymanagement.repositories.QuestionRepository;
import eapli.base.surveymanagement.repositories.SectionRepository;

import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Guilherme Sencadas - 1201180
 */

public class CreateSectionController {

    /**
     * Creates a new instance of Section
     *
     * @param sectionId         Section ID to be used
     * @param title             Section Title to be used
     * @param description       Section Title to be used
     * @param obli              Section Obligatoriness to be used
     * @param repeatability     Section Repeatability to be used
     * @param questions         Section Questions to be used
     * @param conditionSection  Condition Section to be used
     * @param conditionQuestion Condition Question to be used
     * @param conditionOption   Condition Question's Option to be used
     * @return Instance of SectionDTO with new Section's toString()
     * @throws InvalidAttributesException Thrown by SectionBuilder
     */
    public SectionDTO createSection(String sectionId, String title,
                                    String description, Obligatoriness obli,
                                    Repeatability repeatability, List<QuestionDTO> questions, SectionDTO conditionSection, QuestionDTO conditionQuestion, String conditionOption) throws InvalidAttributesException {

        List<Question> questionList = new ArrayList<>();
        for (QuestionDTO dto : questions)
            questionList.add(QuestionRepository.getQuestion(dto.questionId));

        SectionBuilder sb = new SectionBuilder(true)
                .withSectionId(sectionId)
                .withTitle(title)
                .withDescription(description)
                .withRepeatability(repeatability)
                .withObligatoriness(obli)
                .withQuestions(questionList);

        if (conditionSection != null && conditionQuestion != null)
            sb.withCondition(conditionSection.sectionId, conditionQuestion.questionId, conditionOption);
        Section section = sb.build();

        SectionRepository.add(section);
        return new SectionMapper().toDTO(section);
    }

    /**Converts the values of the ENUM Obligatoriness into a list
     *
     * @return List with all Obligatoriness values.
     */
    public List<Obligatoriness> obligatorinessList() {
        return Arrays.asList(Obligatoriness.values());
    }

    /**Converts the values of the ENUM Repeatability into a list
     *
     * @return List with all Repeatability.
     */
    public List<Repeatability> repeatabilityList() {
        return Arrays.asList(Repeatability.values());
    }

    /**Gets the List of Questions in a given Section
     *
     * @param sectionId Section ID to be used in the search
     * @return List with QuestionDTO with Question's toString()
     */
    public List<QuestionDTO> sectionQuestionList(String sectionId) {

        return new QuestionMapper().toDTO(SectionRepository.getSection(sectionId).questions());
    }
}
