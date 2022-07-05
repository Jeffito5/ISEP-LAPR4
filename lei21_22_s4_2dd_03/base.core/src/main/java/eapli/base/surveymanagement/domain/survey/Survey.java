package eapli.base.surveymanagement.domain.survey;

import com.sun.istack.NotNull;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.surveymanagement.builders.SurveyBuilder;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Author: Guilherme Sencadas - 1201180
 */

@Entity
public class Survey implements Serializable, AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Embedded
    private SurveyCode code;

    @Embedded
    private SurveyDescription description;

    @Embedded
    private TimeInterval timeInterval;

    @ManyToOne
    private Questionnaire questionnaire;

    @Embedded
    private TargetAudience targetAudience;

    @ManyToMany
    Set<Customer> audience;

    public SurveyCode code() {
        return code;
    }

    public void setCode(SurveyCode code) {
        this.code = code;
    }

    //Required by JPA
    protected Survey() {
    }

    public Survey(SurveyBuilder sb) {
        this.code = sb.code;
        this.description = sb.description;
        this.timeInterval = sb.timeInterval;
        this.targetAudience = sb.targetAudience;
        this.questionnaire = sb.questionnaire;
        this.audience = new HashSet<>(sb.audience);
    }

    public Long id() {
        return id;
    }

    public Questionnaire questionnaire() {
        return questionnaire;
    }

    public TargetAudience targetAudience() {
        return targetAudience;
    }

    public List<Customer> audience() {
        return new ArrayList<>(audience);
    }


    public String toString() {
        /*
        Survey:
        Code: 1
        Description: Put description here.
        Target Audience: Put target audience here.
        Time Interval: [Date1] - [Date2]

        Questionnaire 1: Put title here
        Welcome Message: Put welcome message here
        Final Message: Pu final message here

            List of Sections:

            Section 1:
            (Mandatory) - Put Section title here.
            Description: Put description text here.
            Repeatability: Put repeatability here.

            List of Questions:

                 Question:
                (MANDATORY) - 1. Put question text here. (Extra Info)
                Instructions: Put instructions here.

                 Question:
                (MANDATORY) - 2. Put question text here. (Extra Info)
                Instructions: Put instructions here.
         */

        StringBuilder sb = new StringBuilder();
        sb.append(basicString());
        sb.append("Target Audience: ").append(targetAudience.targetType()).append("\n");

        sb.append(questionnaire.toString());
        return sb.toString();
    }

    public String basicString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Survey:\nCode:").append(code.code()).append("\n")
                .append("Description: ").append(description.description()).append("\n")
                .append("Time Interval").append(timeInterval.toString()).append("\n");
        return sb.toString();
    }

    public String presentString() {
        return "Survey " + code.code() + ":\n\n" + questionnaire.presentationString();
    }

    @Override
    public boolean sameAs(Object other) {
        if (other.getClass() == this.getClass()) {
            return this.id.equals(((Survey) other).id) && this.toString().equals(other.toString());
        } else
            return false;
    }

    @Override
    public Long identity() {
        return id;
    }

    public TimeInterval timeInterval() {
        return timeInterval;
    }
}
