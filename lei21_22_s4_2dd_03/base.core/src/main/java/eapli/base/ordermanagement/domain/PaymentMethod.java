package eapli.base.ordermanagement.domain;

/**
 * @author 1201217 Marco Ramos
 */
public enum PaymentMethod {
    PAYPAL(0, "PAYPAL"),
    APPLEPAY(1, "APPLEPAY"),
    MBWAY(2, "MBWAY");

    final String s;
    final int i;

    PaymentMethod(int i, String s) {
        this.i = i;
        this.s = s;
    }

    public int getI() {
        return i;
    }

    @Override
    public String toString() {
        return s;
    }
}
