package eapli.base.productmanagement.builder;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.domain.*;

/**
 * @author Luís Araújo
 */
public class ProductBuilder {
    /**
     * Product's internal code
     */
    public InternalCode code;
    /**
     * Product's short description
     */
    public ShortDescription shortDescription;
    /**
     * Product's extended description
     */
    public ExtendedDescription extendedDescription;
    /**
     * Product's technical description
     */
    public TechnicalDescription technicalDescription;
    /**
     * Product's photo
     */
    public Photo photo;
    /**
     * Product's barcode
     */
    public Barcode barcode;
    /**
     * Product's category
     */
    public Category category;
    /**
     * Product's measurements
     */
    public ProductMeasurements productMeasurements;
    /**
     * Product's brand name
     */
    public BrandName brandName;
    /**
     * Product's reference
     */
    public Reference reference;
    /**
     * Product's price with tax
     */
    public PriceWithTax priceWithTax;
    /**
     * Product's tax without tax
     */
    public PriceWithoutTax priceWithoutTax;
    /**
     * Product's production code
     */
    public ProductionCode productionCode;

    /**
     * Constructor with all the parameters
     *
     * @param code
     */
    public ProductBuilder(String code) {
        this.code = new InternalCode(code);
    }

    /**
     * Method that returns a product with the short description added before
     *
     * @param shortDescription
     * @return product with the short description added before
     */
    public ProductBuilder shortDescription(String shortDescription) {
        if (shortDescription == null) {
            throw new IllegalArgumentException("Short description cannot be null.");
        } else if (shortDescription.length() > 30) {
            throw new IllegalArgumentException("Short description cannot have more than 30 characters.");
        } else {
            this.shortDescription = new ShortDescription(shortDescription);
        }
        return this;
    }

    /**
     * Method that returns a product with the extended description added before
     *
     * @param extendedDescription
     * @return product with the extended description added before
     */
    public ProductBuilder extendedDescription(String extendedDescription) {
        if (extendedDescription == null) {
            throw new IllegalArgumentException("Extended description cannot be null.");
        } else if (extendedDescription.length() < 20 || extendedDescription.length() > 100) {
            throw new IllegalArgumentException("Extended description cannot have less than 20 characters and cannot have more than 100 characters.");
        } else {
            this.extendedDescription = new ExtendedDescription(extendedDescription);
        }
        return this;
    }

    /**
     * Method that returns a product with the technical description added before
     *
     * @param technicalDescription
     * @return product with the technical description added before
     */
    public ProductBuilder technicalDescription(String technicalDescription) {
        if (technicalDescription == null) {
            throw new IllegalArgumentException("Technical description cannot be null.");
        } else {
            this.technicalDescription = new TechnicalDescription(technicalDescription);
        }
        return this;
    }

    /**
     * Method that returns a product with the photo added before
     *
     * @param photo
     * @return product with the photo added before
     */
    public ProductBuilder photo(String photo) {
        if (photo == null) {
            throw new IllegalArgumentException("Photo's path cannot be null.");
        } else {
            this.photo = new Photo(photo);
        }
        return this;
    }

    /**
     * Method that returns a product with the barcode added before
     *
     * @param barcode
     * @return product with the barcode added before
     */
    public ProductBuilder barcode(String barcode) {
        if (barcode == null) {
            throw new IllegalArgumentException("Barcode cannot be null.");
        } else if (barcode.length() > 11) {
            throw new IllegalArgumentException("Barcode cannot have more than 11 characters.");
        } else {
            this.barcode = new Barcode(barcode);
        }
        return this;
    }

    /**
     * Method that returns a product with the category added before
     *
     * @param category
     * @return product with the category added before
     */
    public ProductBuilder category(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null.");
        } else {
            this.category = category;
        }
        return this;
    }

    /**
     * Method that returns a product with the product measurements added before
     *
     * @param productMeasurements
     * @return product with the product measurements added before
     */
    public ProductBuilder productMeasurements(ProductMeasurements productMeasurements) {
        if (productMeasurements == null) {
            throw new IllegalArgumentException("Product Measurements cannot be null.");
        } else {
            this.productMeasurements = productMeasurements;
        }
        return this;
    }

    /**
     * Method that returns a product with the brand name added before
     *
     * @param brandName
     * @return product with the brand name added before
     */
    public ProductBuilder brandName(String brandName) {
        if (brandName == null) {
            throw new IllegalArgumentException("Brand Name cannot be null.");
        } else if (brandName.length() > 50) {
            throw new IllegalArgumentException("Brand Name cannot have more than 50 characters.");
        } else {
            this.brandName = new BrandName(brandName);
        }
        return this;
    }

    /**
     * Method that returns a product with the reference added before
     *
     * @param reference
     * @return product with the reference added before
     */
    public ProductBuilder reference(String reference) {
        if (reference == null) {
            throw new IllegalArgumentException("Reference cannot be null.");
        } else if (reference.length() > 23) {
            throw new IllegalArgumentException("Reference cannot have more than 23 characters.");
        } else {
            this.reference = new Reference(reference);
        }
        return this;
    }

    /**
     * Method that returns a product with the price with tax added before
     *
     * @param priceWithTax
     * @return product with the price with tax added before
     */
    public ProductBuilder priceWithTax(double priceWithTax) {
        if (priceWithTax <= 0) {
            throw new IllegalArgumentException("Price with tax cannot be less or equal to 0.");
        } else {
            this.priceWithTax = new PriceWithTax(priceWithTax);
        }
        return this;
    }

    /**
     * Method that returns a product with the price without tax added before
     *
     * @param priceWithoutTax
     * @return product with the tax added before
     */
    public ProductBuilder priceWithoutTax(double priceWithoutTax) {
        if (priceWithoutTax <= 0) {
            throw new IllegalArgumentException("Price without tax cannot be less or equal to 0.");
        } else {
            this.priceWithoutTax = new PriceWithoutTax(priceWithoutTax);
        }
        return this;
    }

    /**
     * Method that returns a product with the production code added before
     *
     * @param productionCode
     * @return product with the production code added before
     */
    public ProductBuilder productionCode(String productionCode) {
        if (productionCode == null) {
            throw new IllegalArgumentException("Production code cannot be null.");
        } else if (productionCode.length() > 23) {
            throw new IllegalArgumentException("Production code cannot have more than 23 characters.");
        } else {
            this.productionCode = new ProductionCode(productionCode);
        }
        return this;
    }

    /**
     * Returns the finally constructed object
     *
     * @return the finally constructed object
     */
    public Product build() {
        Product product = new Product(this);
        validateObject(product);
        return product;
    }

    /**
     * Method that validates the object constructed
     *
     * @param product
     */
    private void validateObject(Product product) {
        //Do some basic validations to check
        //if the object does not break any assumption of the system
        if (product == null) {
            System.out.println("Product cannot be null. Try again.");
        }
    }
}
