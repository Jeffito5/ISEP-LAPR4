package eapli.base.surveymanagement.eventhandlers;

import eapli.base.surveymanagement.application.NotifyCustomerController;
import eapli.framework.domain.events.DomainEvent;
import eapli.framework.infrastructure.pubsub.EventHandler;

/**
 * Author:1201180 - Guilherme Sencadas
 */

public class NewSurveyWatchDog implements EventHandler {
    @Override
    public void onEvent(DomainEvent domainEvent) {
        final NewSurveyEvent event = (NewSurveyEvent) domainEvent;
        new NotifyCustomerController().notifyCustomer(event);
    }
}
