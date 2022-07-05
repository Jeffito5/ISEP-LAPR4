package eapli.base.surveymanagement.eventhandlers;

import eapli.base.surveymanagement.domain.survey.Survey;
import eapli.framework.domain.events.DomainEventBase;

/**
 * Author:1201180 - Guilherme Sencadas
 */

public class NewSurveyEvent extends DomainEventBase{

    private final Survey survey;

    public NewSurveyEvent(Survey survey){
        this.survey =survey;
    }

   public Survey survey(){
        return survey;
   }
}
