package eapli.base.customermanagement.dto;

public class CustomerDTO {

    public String id;

    public String name;

    public String vat;

    public String email;

    public String phoneNumber;

    public String gender;

    public String billingAddress;

    public String deliveryAddress;

    public String birthDate;

    public String shoppingCart;

    public CustomerDTO(String id, String name, String vat, String email, String phoneNumber, String gender, String billingAddress, String deliveryAddress, String birthDate, String shoppingCart) {
        this.id = id;
        this.name = name;
        this.vat = vat;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.billingAddress = billingAddress;
        this.deliveryAddress = deliveryAddress;
        this.birthDate = birthDate;
        this.shoppingCart = shoppingCart;
    }

    public CustomerDTO(String id, String name, String vat, String email, String phoneNumber, String gender,  String birthDate, String shoppingCart) {
        this.id = id;
        this.name = name;
        this.vat = vat;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthDate = birthDate;
        this.shoppingCart = shoppingCart;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", name=" + name +
                ", vat=" + vat +
                ", email=" + email +
                ", phoneNumber=" + phoneNumber +
                ", gender=" + gender +
                ", billingAddress=" + billingAddress +
                ", deliveryAddress=" + deliveryAddress +
                ", birthDate=" + birthDate +
                ", shoppingCart=" + shoppingCart +
                '}';
    }
}
