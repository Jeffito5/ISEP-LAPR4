package eapli.base.reportmanagement.mapper.dto;

import eapli.base.reportmanagement.domain.Report;
import eapli.base.reportmanagement.domain.ReportId;

/**
 * @author Luís Araújo
 */
public class ReportDTO {
    public ReportId id;
    public String toString;

    /**
     * Converts a report to a report DTO
     *
     * @param report report to be converted
     */
    public ReportDTO(Report report) {
        this.id = report.reportId();
        this.toString = report.toString();
    }

    @Override
    public String toString() {
        return toString;
    }
}
