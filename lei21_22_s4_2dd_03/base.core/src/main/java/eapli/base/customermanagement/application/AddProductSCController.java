package eapli.base.customermanagement.application;

import eapli.base.customermanagement.domain.CartLine;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.domain.Email;
import eapli.base.customermanagement.dto.CustomerDTO;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.PriceWithTax;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;

import java.util.List;
import java.util.Objects;


public class AddProductSCController {

    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private final ProductRepository productRepository = PersistenceContext.repositories().products();

    /**
     * finds the custumer by email
     * @param emailString eamil
     * @return customer
     */
    public Customer findCustomerByEmail(String emailString) {
        Email email = Email.valueOf(emailString);
        if (customerRepository.findByEmail(email).isPresent())
            return customerRepository.findByEmail(email).get();
        return null;
    }

    /**
     * gets all the products
     * @return catalog
     */
    public String getCatalog() {
        List<Product> products = productRepository.findAll();
        String catalog="";
        for (Product p : products) {
            catalog = catalog + p.basicToString();
        }
        return catalog;
    }


    /**
     * finds a product
     * @param code code
     * @return product
     */
    public Product getProduct(String code) {
        InternalCode internalCode = new InternalCode(code);
        if (productRepository.findByCode(internalCode).isPresent())
            return productRepository.findByCode(internalCode).get();
        return null;
    }

    /**
     * adds the product to the shopping cart upgrages the total price and quantities
     * @param productId product id
     * @param quantity quantity
     * @param email customer email
     * @return customer
     */
    public CustomerDTO addProductToShoppingCart(String productId, String quantity, String email) {
        Customer customer = findCustomerByEmail(email);
        Product product = getProduct(productId);
        int total = 0;
        boolean exists = false;
        List<CartLine> cartLineList = customer.shoppingCart().cartLines();
        double price = customer.shoppingCart().total() + Double.parseDouble(String.valueOf(product.priceWithTax())) * Double.parseDouble(String.valueOf(quantity));
        customer.shoppingCart().updateTotal(price);
        CartLine needUpdate = null;
        for (CartLine cartLine : cartLineList) {
            if (Objects.equals(cartLine.product().identity().internalCode(), product.identity().internalCode())) {
                total = cartLine.quantity() + Integer.parseInt(quantity);
                needUpdate = cartLine;
                exists = true;
            }
        }
        CartLine cartLine;
        if (exists) {
            cartLineList.remove(needUpdate);
            cartLine = CartLine.valueOf(product, total);
        } else {
            cartLine = CartLine.valueOf(product, Integer.parseInt(quantity));
        }
        cartLineList.add(cartLine);
        customerRepository.save(customer);
        return customer.toDTO2();
    }
}
