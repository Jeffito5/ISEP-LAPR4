package eapli.base.ordermanagement.application;

import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;
import eapli.framework.util.Utility;

/**
 * @author Luís Araújo
 */

/**
 * A simple factory to obtain the desired implementation of the
 * {@link //}.
 */
@Utility
public final class UpdateOrderToDeliveredFactory {
    private UpdateOrderToDeliveredFactory() {
        // ensure utility
    }

    public static UpdateOrderToDeliveredController build() {
        //1 approach- event
        // for pedagogical purposes: play around with the 2 approaches
        //if (Application.settings().getUseEventfulControllers()) {
        return new UpdateOrderToDeliveredControllerEventfulImpl(InProcessPubSub.publisher());
        //}
        //System.out.println("ASDDASDASDASDASD");
        //return null;
    }
}