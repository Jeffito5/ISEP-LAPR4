package eapli.base.ordermanagement.application.eventhandlers;

import eapli.base.ordermanagement.domain.events.UpdatedOrderToDeliveredEvent;
import eapli.framework.domain.events.DomainEvent;
import eapli.framework.infrastructure.pubsub.EventHandler;
import eapli.framework.validations.Preconditions;

/**
 * @author Luís Araújo
 */
public class OrderUpdatedToDeliveredWatchDog implements EventHandler {

    /*
     * (non-Javadoc)
     *
     * @see eapli.framework.domain.events.EventHandler#onEvent(eapli.framework.
     * domain. events.DomainEvent)
     */

    /**
     * Watchdog that, when activated, calls the method that changes the status of the order
     *
     * @param domainevent
     */
    @Override
    public void onEvent(final DomainEvent domainevent) {
        Preconditions.ensure(domainevent instanceof UpdatedOrderToDeliveredEvent);

        final UpdatedOrderToDeliveredEvent event = (UpdatedOrderToDeliveredEvent) domainevent;

        final var controller = new OrderUpdatedToDeliveredController();
        controller.changeOrderStatusToReceived(event);
    }
}
