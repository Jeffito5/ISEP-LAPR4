package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.surveymanagement.application.CreateQuestionController;
import eapli.base.surveymanagement.application.CreateQuestionnaireController;
import eapli.base.surveymanagement.application.CreateSectionController;
import eapli.base.surveymanagement.domain.Obligatoriness;
import eapli.base.surveymanagement.domain.QuestionType;
import eapli.base.surveymanagement.domain.Repeatability;
import eapli.base.surveymanagement.dto.QuestionDTO;
import eapli.base.surveymanagement.dto.SectionDTO;
import eapli.framework.actions.Action;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guilherme Araújo Sencadas
 */
public class QuestionnaireBootstrapper implements Action {

    /**
     * Executes the bootstrap.
     * <p>For More information read Bootstraps' (US1900) README.md
     *
     * @return true if no error appeared.
     */
    @SneakyThrows
    @Override
    public boolean execute() {
        //=================================================================================================================Questionnaire 1

        List<QuestionDTO> questionList = new ArrayList<>();
        List<SectionDTO> sectionList = new ArrayList<>();
        //-------------------------------------------------------------------------------Create Questions
        CreateQuestionController questionController = new CreateQuestionController();
        questionList.add(questionController.createQuestion(
                "1",
                "What Type of Products would you enjoy to have in the app?\n" +
                        "\n" +
                        "a) Sports Type equipment.\n" +
                        "b) Camping Equipment.\n" +
                        "c) Beauty Products.\n" +
                        "d) None of the above.\n",
                "Choose an option.",
                Obligatoriness.OPTIONAL,
                null,
                QuestionType.SINGLE_CHOICE,
                null,
                null
        ));

        questionList.add(questionController.createQuestion(
                "2",
                "What Type of Products would you enjoy to us to add in the app?\n" +
                        "\n" +
                        "a) Electronics.\n" +
                        "b) Mountain Equipment.\n" +
                        "c) Health Products.\n" +
                        "d) None of the above.\n",
                "Choose 1 or more options.",
                Obligatoriness.OPTIONAL,
                null,
                QuestionType.MULTIPLE_CHOICE,
                null,
                null
        ));

        questionList.add(questionController.createQuestion(
                "3",
                "How many times do you go fishing per year?",
                "Type a value.",
                Obligatoriness.OPTIONAL,
                null,
                QuestionType.NUMERIC,
                null,
                null
        ));

        questionList.add(questionController.createQuestion(
                "4",
                "What Type of Products would you enjoy to have in the app?\n" +
                        "\n" +
                        "a) Drinks.\n" +
                        "b) Vegan Food.\n" +
                        "c) NBA jerseys.\n" +
                        "d) None of the above.\n",
                "Choose an option.",
                Obligatoriness.OPTIONAL,
                null,
                QuestionType.SINGLE_CHOICE_WITH_INPUT_VALUE,
                null,
                null
        ));

        questionList.add(questionController.createQuestion(
                "5",
                "What Type of Products would you enjoy to us to add in the app?\n" +
                        "\n" +
                        "a) Tobacco.\n" +
                        "b) Music equipment.\n" +
                        "c) NBA shoes.\n" +
                        "d) None of the above.\n",
                "Choose 1 or more options.",
                Obligatoriness.OPTIONAL,
                null,
                QuestionType.MULTIPLE_CHOICE_WITH_INPUT_VALUE,
                null,
                null
        ));

        questionList.add(questionController.createQuestion(
                "6",
                "What can we improve?\n",
                "Write freely.",
                Obligatoriness.OPTIONAL,
                null,
                QuestionType.FREE_TEXT,
                null,
                null
        ));

        questionList.add(questionController.createQuestion(
                "7",
                "Rank these products.\n" +
                        "\n" +
                        "a) Camping Equipment.\n" +
                        "b) Beauty Products.\n" +
                        "c) Sports Type Equipment.\n",
                "Rank these products in order.",
                Obligatoriness.OPTIONAL,
                null,
                QuestionType.SORTING,
                null,
                null
        ));

        questionList.add(questionController.createQuestion(
                "8",
                "Rank the Swimming Equipment from 1 to 3.\n" +
                        "\n" +
                        "a) 1.\n" +
                        "b) 2.\n" +
                        "c) 3.\n",
                "3 being the best and 1 the worst.",
                Obligatoriness.OPTIONAL,
                "Rank these products from 1 to 3.",
                QuestionType.SCALING,
                null,
                null
        ));

        questionList.add(questionController.createQuestion(
                "9",
                "What Type of Products would you enjoy to have in the app?\n" +
                        "\n" +
                        "a) Gaming equipment.\n" +
                        "b) Tennis Equipment.\n" +
                        "c) Hair Products.\n" +
                        "d) None of the above.\n",
                "Choose an option.",
                Obligatoriness.OPTIONAL,
                null,
                QuestionType.SINGLE_CHOICE,
                null,
                null
        ));

        questionList.add(questionController.createQuestion(
                "10",
                "What Type of Products would you enjoy to have in the app?\n" +
                        "\n" +
                        "a) Clothes.\n" +
                        "b) Rugby Equipment.\n" +
                        "c) Makeup Products.\n" +
                        "d) None of the above.\n",
                "Choose an option.",
                Obligatoriness.OPTIONAL,
                null,
                QuestionType.SINGLE_CHOICE,
                null,
                null
        ));

        questionList.add(questionController.createQuestion(
                "11",
                "What Type of Products would you enjoy to us to add in the app?\n" +
                        "\n" +
                        "a) Sunglasses.\n" +
                        "b) Flip Flops.\n" +
                        "c) Shoes.\n" +
                        "d) None of the above.\n",
                "Choose 1 or more options.",
                Obligatoriness.OPTIONAL,
                null,
                QuestionType.MULTIPLE_CHOICE,
                null,
                null
        ));

        //-------------------------------------------------------------------------------Create Sections
        CreateSectionController sectionController = new CreateSectionController();
        sectionList.add(sectionController.createSection(
                "1",
                "New Products in the App",
                "This sections addresses the topic of adding possible new items to the App.",
                Obligatoriness.OPTIONAL,
                Repeatability.NONE,
                questionList,
                null,
                null,
                null
        ));

        //-------------------------------------------------------------------------------Create Questionnaire
        CreateQuestionnaireController questionnaireController = new CreateQuestionnaireController();
        questionnaireController.createQuestionnaire(
                "1",
                "Customer's Opinion",
                "Welcome to the Questionnaire. Let us know your opinion!",
                "Thank you for your cooperation!",
                sectionList,
                questionList
        );

        //=================================================================================================================Questionnaire 1


        //=================================================================================================================Questionnaire 2
        questionList = new ArrayList<>();
        sectionList = new ArrayList<>();
        //-------------------------------------------------------------------------------Create Questions
        questionList.add(questionController.createQuestion(
                "12",
                "How many time do you go camping per year?",
                "Type a value.",
                Obligatoriness.MANDATORY,
                null,
                QuestionType.NUMERIC,
                null,
                null
        ));

        questionList.add(questionController.createQuestion(
                "13",
                "Does your camping equipment get deteriorated by the elements easily?\n" +
                        "\n" +
                        "a) Yes!\n" +
                        "b) No.\n",
                "Choose an Option.",
                Obligatoriness.OPTIONAL,
                null,
                QuestionType.SINGLE_CHOICE,
                questionList.get(0),
                null
        ));

        questionList.add(questionController.createQuestion(
                "14",
                "Does your camping equipment get deteriorated by the elements easily?\n" +
                        "\n" +
                        "a) Yes!\n" +
                        "b) No.\n",
                "Choose an Option.",
                Obligatoriness.OPTIONAL,
                null,
                QuestionType.SINGLE_CHOICE_WITH_INPUT_VALUE,
                null,
                null
        ));

        questionList.add(questionController.createQuestion(
                "15",
                "What products should we add?\n",
                "Write freely.",
                Obligatoriness.OPTIONAL,
                null,
                QuestionType.FREE_TEXT,
                null,
                null
        ));

        questionList.add(questionController.createQuestion(
                "16",
                "Rank these products.\n" +
                        "\n" +
                        "a) Swimming Equipment.\n" +
                        "b) Hair Products.\n" +
                        "c) Sports Shirts.\n",
                "Rank these products in order.",
                Obligatoriness.OPTIONAL,
                null,
                QuestionType.SORTING,
                null,
                null
        ));

        questionList.add(questionController.createQuestion(
                "17",
                "How many time do you go swimming per year?",
                "Type a value.",
                Obligatoriness.MANDATORY,
                null,
                QuestionType.NUMERIC,
                null,
                null
        ));

        questionList.add(questionController.createQuestion(
                "18",
                "Does your swimming equipment get deteriorated by the elements easily?\n" +
                        "\n" +
                        "a) Yes!\n" +
                        "b) No.\n",
                "Choose an Option.",
                Obligatoriness.OPTIONAL,
                null,
                QuestionType.SINGLE_CHOICE,
                null,
                null
        ));

        //-------------------------------------------------------------------------------Create Sections
        sectionList.add(sectionController.createSection(
                "2",
                "Camping Equipment",
                "This sections addresses the topic of camping equipment.",
                Obligatoriness.MANDATORY,
                Repeatability.NONE,
                questionList,
                null,
                null,
                null
        ));

        //-------------------------------------------------------------------------------Create Questionnaire
        questionnaireController.createQuestionnaire(
                "2",
                "Customer's Hobbies",
                "Welcome to the Questionnaire. Let us know your opinion!",
                "Thank you for your cooperation!",
                sectionList,
                questionList
        );
        //=================================================================================================================Questionnaire 2

        return true;
    }


}