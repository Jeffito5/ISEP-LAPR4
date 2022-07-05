package eapli.base.surveymanagement.domain;

import com.sun.istack.NotNull;
import eapli.base.surveymanagement.builders.QuestionnaireBuilder;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: 1201180 - Guilherme Sencadas
 */

@Entity
public class Questionnaire implements Serializable, AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    private String questionnaireId;
    private String title;
    private String welcomeMessage;
    private String finalMessage;

    @OneToMany
    private List<Section> sections;

    //Required by JPA
    protected Questionnaire() {
    }

    public Questionnaire(QuestionnaireBuilder sb) {
        this.questionnaireId = sb.questionnaireId;
        this.title = sb.title;
        this.welcomeMessage = sb.welcomeMessage;
        this.finalMessage = sb.finalMessage;
        this.sections = sb.sections;
    }

    public Long id(){return id;}

    public String questionnaireId(){
        return questionnaireId;
    }

    public List<Section> sections(){
        return new ArrayList<>(sections);
    }

    public String toString() {
        /*
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
        sb.append("Questionnaire ").append(questionnaireId).append(": ");
        sb.append(title).append("\n");

        if (welcomeMessage != null && !welcomeMessage.isEmpty() && !welcomeMessage.isBlank())
            sb.append("Welcome Message: ").append(welcomeMessage).append("\n");

        sb.append("Final Message: ").append(finalMessage).append("\n");
        sb.append("\nList of Sections:\n");
        for (Section section : sections)
            sb.append(section.toString()).append("\n");

        return sb.toString();
    }

    @Override
    public boolean sameAs(Object other) {
        if (other.getClass() == this.getClass()){
            return this.id.equals(((Questionnaire) other).id()) && this.toString().equals(other.toString());
        }
        else
            return false;
    }

    @Override
    public Long identity() {
        return id;
    }

    public String presentationString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Questionnaire ").append(questionnaireId).append(": ");
        sb.append(title).append("\n");

        if (welcomeMessage != null && !welcomeMessage.isEmpty() && !welcomeMessage.isBlank())
            sb.append("Welcome Message: ").append(welcomeMessage).append("\n");

        sb.append("\nList of Sections:\n");
        for (Section section : sections)
            sb.append(section.presentationString()).append("\n");


        sb.append("\nQuestionnaire Final Message: ").append(finalMessage).append("\n");
        return sb.toString();
    }
}
