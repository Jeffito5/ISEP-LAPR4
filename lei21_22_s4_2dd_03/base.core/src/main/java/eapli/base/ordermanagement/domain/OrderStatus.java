package eapli.base.ordermanagement.domain;

/**
 * @author 1201217 Marco Ramos
 */
public enum OrderStatus {
    PAID("Paid"),
    DEVELOPING("In development"),
    DEPLOYED("Deployed"),
    RECEIVED("Received"),
    DELIVERED("Delivered");

    private String s;

    OrderStatus(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
