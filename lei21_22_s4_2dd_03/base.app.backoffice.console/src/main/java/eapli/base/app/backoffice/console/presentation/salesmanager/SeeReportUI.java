package eapli.base.app.backoffice.console.presentation.salesmanager;


import eapli.base.Utils;
import eapli.base.reportmanagement.application.SeeReportController;
import eapli.base.reportmanagement.mapper.dto.ReportDTO;
import eapli.base.surveymanagement.domain.survey.SurveyCode;
import eapli.base.surveymanagement.dto.SurveyDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Luís Araújo
 */
public class SeeReportUI extends AbstractUI {

    private SeeReportController seeReportController = new SeeReportController();

    @Override
    protected boolean doShow() {
        try {
            List<String> options = new ArrayList<>();
            int option, surveyOption, reportOption;

            options.add("Generate a report");

            option = Utils.showAndSelectIndex(options, "\n\nSee a report");

            if (option == -1) {
                return false;
            }

            List<SurveyDTO> surveyDTOList = seeReportController.findSurveys();

            if (surveyDTOList.isEmpty()) {
                System.out.println("\nThere are no surveys available");
                return false;
            }

            surveyOption = Utils.showAndSelectIndex(surveyDTOList, "\nSelect the intended survey");

            if (surveyOption == -1) {
                return false;
            }

            SurveyDTO surveyDTO = surveyDTOList.get(surveyOption);

            SurveyCode surveyCode = new SurveyCode(surveyDTO.id.toString());

            String id = Console.readLine("Enter an ID for the report");
            Date firstDate = Console.readDate("Enter a first date for the report (dd-MM-yyyy)", "dd-MM-yyyy");
            Date secondDate = Console.readDate("Enter a second date for the report (dd-MM-yyyy)", "dd-MM-yyyy");

            ReportDTO reportDTO = seeReportController.calculateReportPercentages(surveyCode, firstDate, secondDate, id);

            System.out.println(reportDTO.toString);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "See a statistical report regarding a previously set up questionnaire";
    }
}
