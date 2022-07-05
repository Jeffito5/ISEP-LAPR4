package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.surveymanagement.application.CreateSurveyController;
import eapli.base.surveymanagement.domain.survey.TargetType;
import eapli.base.surveymanagement.dto.QuestionnaireDTO;
import eapli.framework.actions.Action;
import lombok.SneakyThrows;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Guilherme Araújo Sencadas
 */
public class SurveyBootstrapper implements Action {

    /**
     * Executes the bootstrap.
     * <p>For More information read Bootstraps' (US1900) README.md
     *
     * @return true if no error appeared.
     */
    @SneakyThrows
    @Override
    public boolean execute() {
        PrintWriter fileWriter = new PrintWriter("email.txt");
        fileWriter.write("");
        fileWriter.close();

        CreateSurveyController controller = new CreateSurveyController();
        List<QuestionnaireDTO> list = controller.getQuestionnaires();

        List<String> codes = new ArrayList<>();
        codes.add("Male");
        controller.createSurvey("1",
                "Description",
                TargetType.GENDER,
                codes,
                new Date("07/06/2022"),
                new Date("10/06/2022"),
                new Date("2022/06/10"),
                new Date("2022/06/30"),
                list.get(0));

        codes = new ArrayList<>();
        codes.add("EUA");
        controller.createSurvey("2",
                "Description",
                TargetType.COUNTRY,
                codes,
                new Date("07/06/2022"),
                new Date("10/06/2022"),
                new Date("2022/06/10"),
                new Date("2022/06/30"),
                list.get(1));


        codes = new ArrayList<>();
        codes.add("Food");
        controller.createSurvey("3",
                "Description",
                TargetType.CATEGORY,
                codes,
                new Date("2022/06/10"),
                new Date("2022/06/20"),
                new Date("2022/06/10"),
                new Date("2022/06/30"),
                list.get(0));

        codes = new ArrayList<>();
        codes.add("Milk");
        controller.createSurvey("4",
                "Description",
                TargetType.PRODUCT,
                codes,
                new Date("2022/06/10"),
                new Date("2022/06/20"),
                new Date("2022/06/10"),
                new Date("2022/06/30"),
                list.get(1));


        codes = new ArrayList<>();
        codes.add("Mimosa");
        controller.createSurvey("5",
                "Description",
                TargetType.BRAND,
                codes,
                new Date("2022/06/10"),
                new Date("2022/06/20"),
                new Date("2022/06/10"),
                new Date("2022/06/14"),
                list.get(0));
        return true;
    }


}