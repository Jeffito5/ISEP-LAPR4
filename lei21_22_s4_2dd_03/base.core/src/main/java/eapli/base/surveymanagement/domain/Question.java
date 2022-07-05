package eapli.base.surveymanagement.domain;

import eapli.base.surveymanagement.builders.QuestionBuilder;
import eapli.base.surveymanagement.dto.QuestionDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Author: 1201180 - Guilherme Sencadas
 */
@Entity
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    private String questionId;
    private String text;
    private String instructions;

    @Enumerated(EnumType.STRING)
    private Obligatoriness obligatoriness;

    @Embedded
    private Condition condition;
    private String info;

    @ElementCollection
    private List<String> options;

    //Required by JPA
    protected Question() {
    }

    public Question(QuestionBuilder builder) {
        this.questionId = builder.questionId;
        this.text = builder.text;
        this.instructions = builder.instructions;
        this.obligatoriness = builder.obligatoriness;
        this.condition = builder.condition;
        this.info = builder.info;
        this.type = builder.type;
        this.options = builder.options;
    }

    public Long id(){return id;}

    public String questionId(){return questionId;}

    public boolean isOptional() {
        return this.obligatoriness == Obligatoriness.OPTIONAL;
    }

    public boolean isMandatory() {
        return this.obligatoriness == Obligatoriness.MANDATORY;
    }

    public List<String> options(){return this.options;}

    public QuestionType type(){return this.type;}

    @Override
    public String toString() {
        /*
            Question:
            (MANDATORY) - 1. Put question text here. (Extra Info)
            Instructions: Put instructions here.

         */
        StringBuilder sb = new StringBuilder();
        sb.append("Question:\n");
        sb.append("(").append(obligatoriness).append(") - ");

        sb.append(questionId).append(". ");
        sb.append(text);

        if (info != null && !info.isBlank() && !info.isEmpty())   //Optional
            sb.append(" (").append(info).append(")");

        if (instructions != null && !instructions.isEmpty() && !instructions.isBlank())   //Optional
            sb.append("\nInstructions: ").append(instructions).append("\n\n");

        if (options!=null && !options.isEmpty() ){  //On multiple option questions
            sb.append("Options:\n");
            for (String option : options)
            {
                sb.append(option).append("\n");
            }
        }
        sb.append("\n");
        return sb.toString();
    }

   public String presentString(){
        return this + "A:\n\n";
   }
}
