package eapli.base.app.backoffice.console.presentation.salesmanager;

import eapli.base.surveymanagement.application.CreateQuestionController;
import eapli.base.surveymanagement.application.CreateQuestionnaireController;
import eapli.base.surveymanagement.application.CreateSectionController;
import eapli.base.surveymanagement.domain.*;
import eapli.base.surveymanagement.dto.QuestionDTO;
import eapli.base.surveymanagement.dto.QuestionnaireDTO;
import eapli.base.surveymanagement.dto.SectionDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;
/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class CreateQuestionnaireUI extends AbstractUI {

    @Override
    protected boolean doShow() {
        boolean error = false;
        do {
            CreateQuestionnaireController controller = new CreateQuestionnaireController();

            String questionnaireId = Console.readLine("Insert the Questionnaire Id: ");
            if (questionnaireId.equalsIgnoreCase("exit")) return true;

            String title = Console.readLine("Insert the Questionnaire Title: ");
            if (title.equalsIgnoreCase("exit")) return true;

            String welcomeMessage = Console.readLine("(Optional) Insert the Questionnaire Welcome Message: ");
            if (welcomeMessage.equalsIgnoreCase("exit")) return true;

            String finalMessage = Console.readLine("Insert the Questionnaire Final Message: ");
            if (finalMessage.equalsIgnoreCase("exit")) return true;

            List<SectionDTO> sections = new ArrayList<>();
            List<QuestionDTO> questions = new ArrayList<>();

            List<SectionDTO> selected = new ArrayList<>();
            boolean repeat = true;
            do {
                System.out.println("Select Section(s):\n");

                int i = 1;
                for (SectionDTO obj : sections) {
                    System.out.println(i + ". " + obj.toString);
                    i++;
                }
                System.out.println((sections.size() + 1) + ". Create a new Section.");
                System.out.println("\n0. Leave");

                int option = Console.readOption(0, sections.size() + 1, 0);


                if (option == sections.size() + 1) {
                    System.out.println("\nCreate New Section - Type 'exit' at any moment to leave.\n");
                    List<QuestionDTO> newQuestions = new ArrayList<>();
                    createSection(sections, newQuestions);
                    questions.addAll(newQuestions);
                } else {
                    if (option == 0) {
                        if (selected.isEmpty()) {
                            return false;
                        } else repeat = false;
                    } else {
                        selected.add(sections.get(option - 1));
                        sections.removeAll(selected);
                    }
                }
            } while (repeat);

            //------------------------------------Create Questionnaire
            try {
                QuestionnaireDTO dto = controller.createQuestionnaire(questionnaireId, title, welcomeMessage, finalMessage, selected,questions);

                System.out.println("\nOperation Success:");
                System.out.println(dto.toString);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                error = true;
            }
        } while (error);
        return true;
    }

    @Override
    public String headline() {
        return "Create New Questionnaire - Type 'exit' at any moment to leave.";
    }


    //--------------------------------------------------------------------------------------SECTION

    public boolean createSection(List<SectionDTO> sectionList, List<QuestionDTO> questionList) {
        boolean error = false;
        do {
            CreateSectionController controller = new CreateSectionController();
            String sectionId = Console.readLine("Insert the Section Id: ");
            if (sectionId.equalsIgnoreCase("exit"))
                return false;       //Return false to signal the main method that the user wants to leave.

            String title = Console.readLine("Insert the Section Title: ");
            if (title.equalsIgnoreCase("exit")) return false;

            String description = Console.readLine("(Optional) Insert the Section Description: ");
            if (description.equalsIgnoreCase("exit")) return false;
            //---------------------------------------------------------------------------Repeatability

            System.out.println("Select the Sections repeatability:");
            List<Repeatability> repeatabilityList = controller.repeatabilityList();
            int i = 1;
            for (Repeatability obj : repeatabilityList) {
                System.out.println(i + ". " + obj);
                i++;
            }
            System.out.println("\n0. Leave");
            int option = Console.readOption(0, repeatabilityList.size(), 0);
            if (option == 0) return true;
            Repeatability repeatability = repeatabilityList.get(option - 1);

            List<QuestionDTO> selected = new ArrayList<>();
            boolean repeat = true;
            do {
                System.out.println("Select Question(s):\n");
                i = 1;
                for (QuestionDTO obj : questionList) {
                    System.out.println(i + ". " + obj.toString);
                    i++;
                }
                System.out.println((questionList.size() + 1) + ". Create a new Question.");
                System.out.println("\n0. Leave");

                option = Console.readOption(0, questionList.size() + 1, 0);


                if (option == questionList.size() + 1) {
                    System.out.println("\nCreate New Question - Type 'exit' at any moment to leave.\n");
                    createQuestion(questionList);

                } else {
                    if (option == 0) {
                        if (selected.isEmpty()) return false;
                        else repeat = false;
                    } else {
                        selected.add(questionList.get(option - 1));
                        questionList.removeAll(selected);
                    }
                }
            } while (repeat);
            //---------------------------------------------------------------------------Obligatoriness and condition
            System.out.println("Select the Sections obligatoriness:");
            List<Obligatoriness> obligatorinessList = controller.obligatorinessList();
            i = 1;
            for (Obligatoriness obj : obligatorinessList) {
                System.out.println(i + ". " + obj);
                i++;
            }
            System.out.println("\n0. Leave");
            option = Console.readOption(0, obligatorinessList.size(), 0);

            if (option == 0) return false;
            Obligatoriness obligatoriness = obligatorinessList.get(option - 1);

            SectionDTO conditionSection = null;
            QuestionDTO conditionQuestion = null;
            String conditionOption = null;
            if (obligatoriness == Obligatoriness.CONDITIONAL) {
                System.out.println("Condition: (Select a Section to specify a condition)");
                if (sectionList.isEmpty()) {
                    System.out.println("No sections to choose from. Leaving.");
                    return false;
                }
                i = 1;
                for (SectionDTO section : sectionList) {     //Select an already created Section
                    System.out.println(i + ". " + section.toString);
                    i++;
                }
                System.out.println("\n0. Leave");

                option = Console.readOption(0, sectionList.size(), 0);
                if (option == 0)
                    return false;

                System.out.println("Select a Question:");
                i = 1;
                conditionSection = sectionList.get(option - 1);
                List<QuestionDTO> sectionQuestionList = controller.sectionQuestionList(conditionSection.sectionId);
                for (QuestionDTO q : sectionQuestionList) { //Select a Question from the selected Section
                    System.out.println(i + ". " + q.toString);
                    i++;
                }
                System.out.println("\n0. Leave");
                option = Console.readOption(0, sectionQuestionList.size(), 0);
                if (option == 0)
                    return false;

                conditionQuestion = sectionQuestionList.get(option - 1);

                List<String> options;
                if (conditionQuestion.options != null && !conditionQuestion.options.isEmpty()) {
                    options = conditionQuestion.options;
                    i = 1;
                    for (String o : options) { //Select an option
                        System.out.println(i + ") \t" + o);
                        i++;
                    }
                    System.out.println("\n0. Leave");

                    option = Console.readOption(0, options.size(), 0);
                    if (option == 0)
                        return false;
                    conditionOption = options.get(option - 1);
                }
            }
            //---------------------------------------------------------------------------Obligatoriness and condition


            //------------------------------------Create Section
            try {
                SectionDTO section = controller.createSection(sectionId, title, description, obligatoriness, repeatability, selected, conditionSection, conditionQuestion, conditionOption);
                sectionList.add(section);
                questionList.clear();
                questionList.addAll(selected);
                System.out.println("\nOperation Success:");
                System.out.println(section.toString);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                error = true;
            }
        } while (error);
        return true;
    }
    //--------------------------------------------------------------------------------------SECTION


    //--------------------------------------------------------------------------------------Question

    public void createQuestion(List<QuestionDTO> questions) {
        boolean error;
        do {
            CreateQuestionController controller = new CreateQuestionController();

            String questionId = Console.readLine("Insert the Question Id: ");
            if (questionId.equalsIgnoreCase("exit")) return;

            String instructions = Console.readLine("(Optional) Insert the Question Instructions: ");
            if (instructions.equalsIgnoreCase("exit")) return;

            List<QuestionType> types = controller.typeList();
            System.out.println("Select a Question Type:");

            int i = 1;
            for (QuestionType obj : types) {
                System.out.println(i + ". " + obj);
                i++;
            }
            System.out.println("\n0. Leave");
            int option = Console.readOption(0, types.size(), 0);
            if (option == 0) return;
            QuestionType type = types.get(option - 1);

            String text = Console.readLine("Insert the Question Text: (Multiple line input supported! When you're finished type 'leave'.)");
            StringBuilder sb = new StringBuilder();
            while (!(text.equalsIgnoreCase("exit") || text.equalsIgnoreCase("leave"))) {
                sb.append(text).append("\n");
                text = Console.readLine("");
            }
            if (text.equalsIgnoreCase("exit")) return;
            text = sb.toString();

            String info = Console.readLine("(Optional) Insert the Question Info: ");
            if (info.equalsIgnoreCase("exit")) return;


            //-------------------------------------------------------------------Obligatoriness and Condition
            System.out.println("Select the Questions obligatoriness");
            List<Obligatoriness> obligatorinessList = controller.obligatorinessList();
            i = 1;
            for (Obligatoriness obj : obligatorinessList) {
                System.out.println(i + ". " + obj);
                i++;
            }
            System.out.println("\n0. Leave");
            option = Console.readOption(0, obligatorinessList.size(), 0);


            if (option == 0) return;
            Obligatoriness obligatoriness = obligatorinessList.get(option - 1);

            String conditionOption = null;
            QuestionDTO conditionQuestion = null;
            if (obligatoriness == Obligatoriness.CONDITIONAL) {
                System.out.println("Condition: (Select a Question to specify a condition)");
                if (questions.isEmpty()) {
                    System.out.println("No questions to choose from. Leaving.");
                    return;
                }
                i = 1;
                for (QuestionDTO q : questions) {
                    System.out.println(i + ". " + q.toString);
                    i++;
                }
                System.out.println("\n0. Leave");
                option = Console.readOption(0, questions.size(), 0);
                if (option == 0)
                    return;

                conditionQuestion = questions.get(option - 1);
                List<String> options;
                if (conditionQuestion.options != null && !conditionQuestion.options.isEmpty()) {
                    options = conditionQuestion.options;
                    i = 1;
                    for (String o : options) { //Select an option
                        System.out.println(i + ") \t" + o);
                        i++;
                    }
                    System.out.println("\n0. Leave");

                    option = Console.readOption(0, options.size(), 0);
                    if (option == 0)
                        return;
                    conditionOption = options.get(option - 1);
                }
            }
            //-------------------------------------------------------------------Obligatoriness and Condition


            try {
                QuestionDTO question = controller.createQuestion(questionId, text, instructions, obligatoriness, info, type, conditionQuestion, conditionOption);
                questions.add(question);
                System.out.println("\nOperation Success:");
                System.out.println(question.toString);
                error = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                error = true;
            }
        } while (error);
    }
}
//--------------------------------------------------------------------------------------Question

