package eapli.base.surveymanagement.domain;

import eapli.base.surveymanagement.application.AnswerSurveyController;
import eapli.base.surveymanagement.builders.SectionBuilder;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Author: 1201180 - Guilherme Sencadas
 */

@Entity
public class Section implements ValueObject, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sectionId;
    private String sectionTitle;
    private String sectionDescription;

    @Enumerated(EnumType.STRING)
    private Repeatability repeatability;

    @Embedded
    private Condition condition;

    @Enumerated(EnumType.STRING)
    private Obligatoriness obligatoriness;

    @OneToMany
    private List<Question> questions;

    //Required by JPA
    protected Section() {
    }

    public Section(SectionBuilder sb) {
        this.sectionId = sb.sectionId;
        this.sectionTitle = sb.title;
        this.repeatability = sb.repeatability;
        this.sectionDescription = sb.description;
        this.condition = sb.condition;
        this.obligatoriness = sb.obligatoriness;
        this.questions = sb.questions;
    }

    public Long id() {
        return id;
    }


    public String sectionId() {
        return sectionId;
    }

    public List<Question> questions() {
        return new ArrayList<>(questions);
    }

    public String toString() {
        /*
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

        sb.append("Section ").append(sectionId).append(":\n");
        sb.append("(").append(obligatoriness).append(") - ");
        sb.append(sectionTitle).append("\n");

        if (sectionDescription != null && !sectionDescription.isBlank() && !sectionDescription.isEmpty())
            sb.append("Description: ").append(sectionDescription).append("\n");

        sb.append("Repeatability: ").append(repeatability).append("\n");

        sb.append("\nList of Questions:\n");
        for (Question question : questions) {
            sb.append(question.toString());
        }
        return sb.toString();
    }

    public String presentationString() {
        StringBuilder sb = new StringBuilder();
        List<String> items = new AnswerSurveyController().getRepeatabilityItems(repeatability);

        if (items != null) {
            for (String code :items) {
                sb.append("Section ").append(sectionId).append(": (About ").append(repeatability).append(" ").append(code).append(" .)\n");
                sb.append("(").append(obligatoriness).append(") - ");
                sb.append(sectionTitle).append("\n");

                if (sectionDescription != null && !sectionDescription.isBlank() && !sectionDescription.isEmpty())
                    sb.append("Description: ").append(sectionDescription).append("\n");

                sb.append("\nList of Questions:\n");
                for (Question question : questions) {
                    sb.append(question.presentString());
                }
            }
            return sb.toString();
        }
        else{
            sb.append("Section ").append(sectionId).append(":\n");
            sb.append("(").append(obligatoriness).append(") - ");
            sb.append(sectionTitle).append("\n");

            if (sectionDescription != null && !sectionDescription.isBlank() && !sectionDescription.isEmpty())
                sb.append("Description: ").append(sectionDescription).append("\n");

            sb.append("\nList of Questions:\n");
            for (Question question : questions) {
                sb.append(question.presentString());
            }
        }
        return sb.toString();
    }
}
