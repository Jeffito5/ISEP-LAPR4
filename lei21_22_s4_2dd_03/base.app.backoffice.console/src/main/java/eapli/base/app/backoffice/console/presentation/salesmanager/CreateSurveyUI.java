package eapli.base.app.backoffice.console.presentation.salesmanager;

import eapli.base.categorymanagement.mapper.dto.CategoryDTO;
import eapli.base.productmanagement.mapper.dto.ProductDTO;
import eapli.base.surveymanagement.application.CreateSurveyController;
import eapli.base.surveymanagement.domain.survey.SurveyCode;
import eapli.base.surveymanagement.domain.survey.SurveyDescription;
import eapli.base.surveymanagement.domain.survey.TargetType;
import eapli.base.surveymanagement.dto.QuestionnaireDTO;
import eapli.base.surveymanagement.dto.SurveyDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Author: 1201180 - Guilherme Sencadas
 */
public class CreateSurveyUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        boolean error;
        do {
            CreateSurveyController controller = new CreateSurveyController();

            String surveyCode = Console.readLine("Insert the Survey Code: (Max: " + SurveyCode.CODE_MAX_LENGTH + " chars)");
            if (surveyCode.equalsIgnoreCase("exit"))
                return true;

            String surveyDescription = Console.readLine("Insert the Survey Description: (Max: " + SurveyDescription.DESCRIPTION_MAX_LENGTH + " chars)");
            if (surveyDescription.equalsIgnoreCase("exit"))
                return true;

            Date firstDate = Console.readDate("Insert the Survey First Date: (dd/MM/yyyy) ", "dd/MM/yyyy");

            Date secondDate = Console.readDate("Insert the Questionnaire Second Date: (dd/MM/yyyy)", "dd/MM/yyyy");

            List<QuestionnaireDTO> questionnaires = controller.getQuestionnaires();
            QuestionnaireDTO selected = null;
            boolean repeat = true;
            do {
                System.out.println("Select Questionnaire(s):\n");

                int i = 1;
                for (QuestionnaireDTO obj : questionnaires) {
                    System.out.println(i + ". " + obj.toString);
                    i++;
                }
                System.out.println((questionnaires.size() + 1) + ". Create a new Questionnaire.");
                System.out.println("\n0. Leave");

                int option = Console.readOption(0, questionnaires.size() + 1, 0);


                if (option == questionnaires.size() + 1) {
                    System.out.println("\nCreate New Section - Type 'exit' at any moment to leave.\n");
                    if (!new CreateQuestionnaireUI().doShow())
                        return false;
                    else
                        questionnaires = controller.getQuestionnaires();
                } else {
                    if (option == 0) {
                        return false;
                    } else {
                        selected = questionnaires.get(option - 1);
                        repeat = false;
                    }
                }
            } while (repeat);

            //-----------------------------------------------------------------------------------------------Target Audience
            System.out.println("Target Audience:\nChoose a Target Type:");

            List<TargetType> targetTypeList = controller.targetTypeList();

            int i = 1;
            for (TargetType targetType : targetTypeList) {
                System.out.println(i + ". " + targetType);
                i++;
            }
            System.out.println("\n0. Leave");

            int option = Console.readOption(0, targetTypeList.size(), 0);
            if (option == 0)
                return false;

            TargetType targetTypeType = targetTypeList.get(option - 1);
            List<String> codes = new ArrayList<>();
            repeat = true;
            Date targetFirstDate=null;
            Date targetSecondtDate=null;
            switch (targetTypeType) {
                case PRODUCT:
                    List<ProductDTO> products = controller.products();

                    System.out.println("Select a Product:");
                    do {
                        i = 1;
                        for (ProductDTO product : products) {
                            System.out.println(i + ". " + product.toString);
                            i++;
                        }
                        System.out.println("\n0. Leave");

                        option = Console.readOption(0, products.size(), 0);
                        if (option == 0) {
                            if (codes.isEmpty())
                                return false;
                            else
                                repeat = false;
                        } else {
                            ProductDTO chosen = products.get(option - 1);
                            codes.add(chosen.code.internalCode());
                            products.remove(chosen);
                        }
                    } while (repeat);
                     targetFirstDate = Console.readDate("Insert the First Date: (dd/MM/yyyy) ", "dd/MM/yyyy");
                     targetSecondtDate = Console.readDate("Insert the First Date: (dd/MM/yyyy) ", "dd/MM/yyyy");

                    break;

                case CATEGORY:
                    List<CategoryDTO> categoryList = controller.categories();

                    System.out.println("Select a Category:");
                    do {
                        i = 1;
                        for (CategoryDTO category : categoryList) {
                            System.out.println(i + ". " + category.toString);
                            i++;
                        }
                        System.out.println("\n0. Leave");

                        option = Console.readOption(0, categoryList.size(), 0);
                        if (option == 0) {
                            if (codes.isEmpty())
                                return false;
                            else
                                repeat = false;
                        } else {
                            CategoryDTO chosen = categoryList.get(option - 1);
                            codes.add(chosen.code.valueOf());
                            categoryList.remove(chosen);
                        }
                    } while (repeat);
                    targetFirstDate = Console.readDate("Insert the First Date: (dd/MM/yyyy) ", "dd/MM/yyyy");
                    targetSecondtDate = Console.readDate("Insert the First Date: (dd/MM/yyyy) ", "dd/MM/yyyy");
                    break;

                case BRAND:
                    List<String> brands = controller.brands();

                    System.out.println("Select a Brand:");
                    do {
                        i = 1;
                        for (String brand : brands) {
                            System.out.println(i + ". " + brand);
                            i++;
                        }
                        System.out.println("\n0. Leave");

                        option = Console.readOption(0, brands.size(), 0);
                        if (option == 0) {
                            if (codes.isEmpty())
                                return false;
                            else
                                repeat = false;
                        } else {
                            String chosen = brands.get(option - 1);
                            codes.add(chosen);
                            brands.remove(chosen);
                        }
                    } while (repeat);
                    targetFirstDate = Console.readDate("Insert the First Date: (dd/MM/yyyy) ", "dd/MM/yyyy");
                    targetSecondtDate = Console.readDate("Insert the First Date: (dd/MM/yyyy) ", "dd/MM/yyyy");
                    break;

                case GENDER:
                    List<String> genders = controller.genders();

                    System.out.println("Select a Category:");

                    i = 1;
                    for (String gender : genders) {
                        System.out.println(i + ". " + gender);
                        i++;
                    }
                    System.out.println("\n0. Leave");

                    option = Console.readOption(0, genders.size(), 0);
                    if (option == 0) {
                        if (codes.isEmpty())
                            return false;
                    } else {
                        String chosen = genders.get(option - 1);
                        codes.add(chosen);
                        genders.remove(chosen);
                    }
                    break;

                case COUNTRY:
                    List<String> countries = controller.countries();

                    System.out.println("Select a Country:");
                    do {
                        i = 1;
                        for (String country : countries) {
                            System.out.println(i + ". " + country);
                            i++;
                        }
                        System.out.println("\n0. Leave");

                        option = Console.readOption(0, countries.size(), 0);
                        if (option == 0) {
                            if (codes.isEmpty())
                                return false;
                            else
                                repeat = false;
                        } else {
                            String chosen = countries.get(option - 1);
                            codes.add(chosen);
                            countries.remove(chosen);
                        }
                    } while (repeat);
                    break;


                default:
                    System.out.println("Target Type not supported!");
                    return false;
            }


            //-----------------------------------------------------------------------------------------------Target Audience


            //------------------------------------Create Survey
            try {
                SurveyDTO dto = controller.createSurvey(surveyCode, surveyDescription, targetTypeType, codes, targetFirstDate,targetSecondtDate, firstDate, secondDate, selected);

                System.out.println("\nOperation Success:");
                System.out.println(dto.toString);
                error = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                error = true;
            }
        } while (error);
        return true;
    }

    @Override
    public String headline() {
        return "Create New Survey - Type 'exit' at any moment to leave.";
    }

}

