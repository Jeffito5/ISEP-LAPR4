package eapli.base.surveymanagement.domain;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.surveymanagement.domain.survey.Survey;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Author: 1201180 - Guilherme Sencadas
 */

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"survey_id", "customer_id", "section_id", "question_id"})})
public class Answer implements Serializable, AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Survey survey;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Section section;

    @ElementCollection
    private List<String> options;

    @ManyToOne
    private Customer customer;

    protected Answer() {
    }

    public Answer(Survey survey, Section section, Question question, List<String> options, Customer customer) {
        this.survey = survey;
        this.section = section;
        this.question = question;
        this.options = options;
        this.customer = customer;
    }

    public List<String> options() {
        return options;
    }

    public Survey survey() {
        return survey;
    }

    public Question question() {
        return question;
    }

    @Override
    public boolean sameAs(Object other) {
        if (other.getClass() == this.getClass()) {
            return this.id.equals(((Answer) other).id) && this.toString().equals(other.toString());
        } else
            return false;
    }

    @Override
    public Long identity() {
        return id;
    }
}
