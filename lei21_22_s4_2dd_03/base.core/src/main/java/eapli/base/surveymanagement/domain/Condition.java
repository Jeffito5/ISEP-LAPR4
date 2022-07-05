package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Author: 1201180 - Guilherme Sencadas
 */

@Embeddable
public class Condition implements ValueObject, Serializable {
   private String conditionSection;
   private String conditionQuestion;
   private String conditionOption;

   public Condition(String conditionSection, String conditionQuestion, String conditionOption){
       this.conditionSection = conditionSection;
       this.conditionQuestion = conditionQuestion;
       this.conditionOption = conditionOption;
   }

    protected Condition() {}
}
