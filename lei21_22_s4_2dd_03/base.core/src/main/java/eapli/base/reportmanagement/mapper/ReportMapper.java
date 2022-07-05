package eapli.base.reportmanagement.mapper;

import eapli.base.reportmanagement.domain.Report;
import eapli.base.reportmanagement.mapper.dto.ReportDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luís Araújo
 */
public class ReportMapper {
    /**
     * Converts a report to a report dto
     *
     * @param report report to be converted
     * @return new report dto
     */
    public ReportDTO toDTO(Report report) {
        return new ReportDTO(report);
    }

    /**
     * Converts a list of reports to a list of reports dto
     *
     * @param reportList report list to be converted
     * @return new report dto list
     */
    public List<ReportDTO> toDTO(List<Report> reportList) {
        List<ReportDTO> dtoList = new ArrayList<>();
        for (Report report : reportList) {
            dtoList.add(new ReportDTO(report));
        }
        return dtoList;
    }
}
