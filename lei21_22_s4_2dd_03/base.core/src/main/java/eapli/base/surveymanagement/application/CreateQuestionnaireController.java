package eapli.base.surveymanagement.application;

import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.base.surveymanagement.builders.QuestionnaireBuilder;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.Section;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.dto.QuestionDTO;
import eapli.base.surveymanagement.dto.QuestionnaireDTO;
import eapli.base.surveymanagement.dto.SectionDTO;
import eapli.base.surveymanagement.mapper.QuestionnaireMapper;
import eapli.base.surveymanagement.repositories.QuestionRepository;
import eapli.base.surveymanagement.repositories.SectionRepository;

import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Guilherme Sencadas - 1201180
 */

public class CreateQuestionnaireController {

    /**Creates a new instance of Questionnaire
     * <p>
     *     Given that the created Sections and Questions need to be available in the DataBase only when the Questionnaire is successfully created, it's here that everything is committed.
     *     If be any reason the Questionnaire creationg fails, everything committed will be removed.
     *
     * @param questionnaireId Questionnaire ID to be used
     * @param title QQuestionnaire Title to be used
     * @param welcomeMessage Questionnaire Welcome Message to be used
     * @param finalMessage Questionnaire Final Message to be used
     * @param sectionsDTO List with all the selected Sections to be added.
     * @param questionDTOS List with all the questions within the sections, that will be added.
     * @return An instance of QuestionnaireDTO with the new Questionnaire's toString()
     * @throws InvalidAttributesException Thrown by the QuestionnaireBuilder.build() method.
     */
    public QuestionnaireDTO createQuestionnaire(String questionnaireId, String title,
                                                String welcomeMessage, String finalMessage,
                                                List<SectionDTO> sectionsDTO, List<QuestionDTO> questionDTOS) throws InvalidAttributesException {

        List<Question> questions = new ArrayList<>();
        for (QuestionDTO dto : questionDTOS)
            questions.add(QuestionRepository.getQuestion(dto.questionId));

        List<Section> sections = new ArrayList<>();
        for (SectionDTO dto : sectionsDTO)
            sections.add(SectionRepository.getSection(dto.sectionId));

        JpaRepository<Question, Long> questionRepo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        for (Question question : questions)
            questionRepo.add(question);

        JpaRepository<Section, Long> sectionRepo = new JpaRepository<>() {
            @Override
            protected String persistenceUnitName() {
                return null;
            }
        };
        for (Section section : sections)
            sectionRepo.add(section);

        try {
            Questionnaire questionnaire = new QuestionnaireBuilder(true)
                    .withId(questionnaireId)
                    .withTitle(title)
                    .withWelcomeMessage(welcomeMessage)
                    .withFinalMessage(finalMessage)
                    .withSections(sections)
                    .build();

            JpaRepository<Questionnaire, Long> questionnaireRepo = new JpaRepository<>() {
                @Override
                protected String persistenceUnitName() {
                    return null;
                }
            };
            questionnaireRepo.add(questionnaire);
            QuestionRepository.clear();
            return new QuestionnaireMapper().toDTO(questionnaire);
        } catch (Exception e) {
            questionRepo.removeAll(QuestionRepository.questions);
            sectionRepo.removeAll(sections);
            SectionRepository.clear();
            throw e;
        }

    }
}
