package eapli.base.productmanagement.domain;

import com.sun.istack.NotNull;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.builder.ProductBuilder;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Luís Araújo
 */

@Entity
public class Product implements Serializable, AggregateRoot<InternalCode> {
    /**
     * Product's internal code
     */
    @Id
    @NotNull
    @EmbeddedId
    private InternalCode internalCode;
    /**
     * Product's short description
     */
    @NotNull
    @Embedded
    private ShortDescription shortDescription;
    /**
     * Product's extended description
     */
    @Embedded
    @NotNull
    private ExtendedDescription extendedDescription;
    /**
     * Product's technical description
     */
    @Embedded
    @NotNull
    private TechnicalDescription technicalDescription;
    /**
     * Product's photo
     */
    @Embedded
    @NotNull
    private Photo photo;
    /**
     * Product's barcode
     */
    @NotNull
    @Embedded
    private Barcode barcode;

    /**
     * Product's category
     */
    @OneToOne
    @NotNull
    private Category category;

    /**
     * Product's measurements
     */

    @JoinColumn(name = "product_measurements_id")
    @NotNull
    @Embedded
    private ProductMeasurements productMeasurements;
    /**
     * Product's brand name
     */
    @NotNull
    @Embedded
    private BrandName brandName;
    /**
     * Product's reference
     */
    @Embedded
    @NotNull
    private Reference reference;
    /**
     * Product's price with tax
     */
    @NotNull
    @Embedded
    private PriceWithTax priceWithTax;
    /**
     * Product's price without tax
     */
    @NotNull
    @Embedded
    private PriceWithoutTax priceWithoutTax;
    /**
     * Product's production code
     */
    @Embedded
    private ProductionCode productionCode;


    /**
     * Constructor that calls the ProductBuild that will help to create instances of Product with optional attributes
     *
     * @param builder
     */
    public Product(ProductBuilder builder) {
        this.internalCode = builder.code;
        this.shortDescription = builder.shortDescription;
        this.extendedDescription = builder.extendedDescription;
        this.technicalDescription = builder.technicalDescription;
        this.barcode = builder.barcode;
        this.category = builder.category;
        this.productMeasurements = builder.productMeasurements;
        this.brandName = builder.brandName;
        this.reference = builder.reference;
        this.priceWithTax = builder.priceWithTax;
        this.priceWithoutTax = builder.priceWithoutTax;
        this.productionCode = builder.productionCode;
    }

    /**
     * Empty constructor
     */
    protected Product() {

    }

    /**
     * Method that returns the internal code
     *
     * @return the internal code
     */
    public InternalCode internalCode() {
        return internalCode;
    }

    /**
     * Method that returns the short description
     *
     * @return the short description
     */
    public ShortDescription shortDescription() {
        return shortDescription;
    }

    /**
     * Method that modifies the short description
     *
     * @param shortDescription
     */
    public void changeShortDescription(ShortDescription shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * Method that returns the extended description
     *
     * @return the extended description
     */
    public ExtendedDescription extendedDescription() {
        return extendedDescription;
    }

    /**
     * Method that modifies the extended description
     *
     * @param extendedDescription
     */
    public void changeExtendedDescription(ExtendedDescription extendedDescription) {
        this.extendedDescription = extendedDescription;
    }

    /**
     * Method that returns the technical description
     *
     * @return the technical description
     */
    public TechnicalDescription technicalDescription() {
        return technicalDescription;
    }

    /**
     * Method that modifies the technical description
     *
     * @param technicalDescription
     */
    public void changeTechnicalDescription(TechnicalDescription technicalDescription) {
        this.technicalDescription = technicalDescription;
    }

    /**
     * Method that returns the photo
     *
     * @return the photo
     */
    public Photo photo() {
        return photo;
    }

    /**
     * Method that modifies the photo
     *
     * @param photo
     */
    public void changePhoto(Photo photo) {
        this.photo = photo;
    }

    /**
     * Method that returns the barcode
     *
     * @return the barcode
     */
    public Barcode barcode() {
        return barcode;
    }

    /**
     * Method that modifies the barcode
     *
     * @param barcode
     */
    public void changeBarcode(Barcode barcode) {
        this.barcode = barcode;
    }

    /**
     * Method that returns the category
     *
     * @return the category
     */
    public Category category() {
        return category;
    }

    /**
     * Method that modifies the category
     *
     * @param category
     */
    public void changeCategory(Category category) {
        this.category = category;
    }

    /**
     * Method that returns the product measurements
     *
     * @return the product measurements
     */
    public ProductMeasurements productMeasurements() {
        return productMeasurements;
    }

    /**
     * Method that modifies the product measurements
     *
     * @param productMeasurements
     */
    public void changeProductMeasurements(ProductMeasurements productMeasurements) {
        this.productMeasurements = productMeasurements;
    }

    /**
     * Method that returns the brand name
     *
     * @return the brand name
     */
    public BrandName brandName() {
        return brandName;
    }

    /**
     * Method that modifies the brand name
     *
     * @param brandName
     */
    public void changeBrandName(BrandName brandName) {
        this.brandName = brandName;
    }

    /**
     * Method that returns the reference
     *
     * @return the reference
     */
    public Reference reference() {
        return reference;
    }

    /**
     * Method that modifies the reference
     *
     * @param reference
     */
    public void changeReference(Reference reference) {
        this.reference = reference;
    }

    /**
     * Method that returns the price with tax
     *
     * @return the price with tax
     */
    public PriceWithTax priceWithTax() {
        return priceWithTax;
    }

    /**
     * Method that modifies the price with tax
     *
     * @param priceWithTax
     */
    public void changePriceWithTax(PriceWithTax priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    /**
     * Method that returns the price without tax
     *
     * @return the price without tax
     */
    public PriceWithoutTax priceWithoutTax() {
        return priceWithoutTax;
    }

    /**
     * Method that modifies the price without tax
     *
     * @param priceWithoutTax
     */
    public void changePriceWithoutTax(PriceWithoutTax priceWithoutTax) {
        this.priceWithoutTax = priceWithoutTax;
    }

    /**
     * Method that returns the product's production code
     *
     * @return the product's production code
     */
    public ProductionCode productionCode() {
        return productionCode;
    }

    /**
     * Method that modifies the product's production code
     *
     * @param productionCode
     */
    public void changeProductionCode(ProductionCode productionCode) {
        this.productionCode = productionCode;
    }

    public String basicToString() {
        return "\nInternal code: " + internalCode.internalCode() + "\n" +
                "Short Description: " + shortDescription.shortDescription() + "\n" +
                "Price: " + priceWithTax.priceWithTax() + "€\n\n";
    }

    @Override
    public String toString() {
        return String.format("/----------------------------------------------------------------------------Product Information-------------------------------------------------------------------------------\\\n" +
                        "|        Internal Code           | " + "%140s|\n" +
                        "|        Short Description       | " + "%140s|\n" +
                        "|        Extended Description    | " + "%140s|\n" +
                        "|        Technical Description   | " + "%140s|\n" +
                        "|        Photo's path            | " + "%140s|\n" +
                        "|        Barcode                 | " + "%140s|\n" +
                        "|        Category                | " + "%140s|\n" +
                        "|        Brand Name              | " + "%140s|\n" +
                        "|        Reference               | " + "%140s|\n" +
                        "|        Price With Tax          | " + "%140s|\n" +
                        "|        Price Without Tax       | " + "%140s|\n" +
                        "|        Production Code         | " + "%140s|\n" +
                        productMeasurements.toString() +
                        "\\------------------------------------------------------------------------------------------------------------------------------------------------------------------------------/\n",
                internalCode, shortDescription, extendedDescription, technicalDescription, photo, barcode, category, brandName, reference, priceWithTax, priceWithoutTax, productionCode);
    }

    /**
     * Method that verifies if two objects are equal
     *
     * @param other
     * @return true if are equal and false otherwise
     */
    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    /**
     * Method that returns the identity
     *
     * @return identity
     */
    @Override
    public InternalCode identity() {
        return this.internalCode;
    }
}
