package eapli.base.reportmanagement.domain;

import eapli.base.productmanagement.domain.InternalCode;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Luís Araújo
 */
@Embeddable
public class ReportId implements ValueObject, Comparable<ReportId>, Serializable {
    /**
     * Report's id
     */
    private String reportId;

    /**
     * Empty constructor
     */
    public ReportId() {
    }

    /**
     * Constructor with the parameter reportId
     *
     * @param reportId
     */
    public ReportId(String reportId) {
        this.reportId = reportId;
    }

    @Override
    public String toString() {
        return reportId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InternalCode)) return false;
        ReportId that = (ReportId) o;
        return Objects.equals(reportId, that.reportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId);
    }

    @Override
    public int compareTo(ReportId o) {
        return 0;
    }
}
