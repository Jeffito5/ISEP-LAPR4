package eapli.base.app.backoffice.console.presentation.salesclerk;

import eapli.base.Utils;
import eapli.base.categorymanagement.mapper.dto.CategoryDTO;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.Code;
import eapli.base.productmanagement.application.SpecifyProductController;
import eapli.base.productmanagement.domain.ProductMeasurements;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

/**
 * @author Luís Araújo
 */
public class SpecifyProductUI extends AbstractUI {

    private final SpecifyProductController specifyProductController = new SpecifyProductController();

    @Override
    protected boolean doShow() {
        try {
            int categoryOption = Utils.showAndSelectIndex(specifyProductController.chooseCategory(), "Choose a category");
            Code categoryCode = specifyProductController.chooseCategory().get(categoryOption).code;
            CategoryDTO category = specifyProductController.category(categoryCode);
            Category aux = specifyProductController.categoryByCategoryDTO(category);

            String code = Console.readLine("Insert a code to the product (max. 23 chars)");
            String shortDescription = Console.readLine("Insert a short description to the product (max. 30 chars)");
            String extendedDescription = Console.readLine("Insert a extended description to the product (min. 20 chars and max. 100 chars)");
            String technicalDescription = Console.readLine("Insert a technical description to the product");
            String photo = Console.readLine("Insert the path to the photo (png, jpeg, svg)");
            String barcode = Console.readLine("Insert the barcode (max. 11 chars)");
            String brandName = Console.readLine("Insert a brand name to the product (max. 50 chars)");
            String reference = Console.readLine("Insert a reference to the product (max. 23 chars)");
            double priceWithTax = Console.readDouble("Insert a price with tax to the product");
            double priceWithoutTax = Console.readDouble("Insert a price without tax to the product");

            System.out.println("Product Measurements");
            int aisleID = Console.readInteger("Insert the ID of the aisle");
            int rowID = Console.readInteger("Insert the ID of the row");
            int shelfID = Console.readInteger("Insert the ID of the shelf");
            double width = Console.readDouble("Insert the width of the product (millimeters)");
            double length = Console.readDouble("Insert the length of the product (millimeters)");
            double height = Console.readDouble("Insert the height of the product (millimeters)");
            double weight = Console.readDouble("Insert the weight of the product (grams)");
            ProductMeasurements productMeasurements = specifyProductController.createInstanceOfProductMeasurements(aisleID, rowID, shelfID, width, length, height, weight);

            Long id = Console.readLong("Insert the code of the catalog");

            if (Console.readBoolean("Do you want to add the production code? [y/n]")) {
                String productionCode = Console.readLine("Insert the production code (max. 23 chars)(xxx.yyyy)");
                specifyProductController.specifyProductWithTheProductionCode(id, code, shortDescription, extendedDescription, technicalDescription, productMeasurements, barcode, brandName, reference, priceWithTax, priceWithoutTax, productionCode, aux, photo);
            } else {
                specifyProductController.specifyProductWithoutTheProductionCode(id, code, shortDescription, extendedDescription, technicalDescription, productMeasurements, barcode, brandName, reference, priceWithTax, priceWithoutTax, aux, photo);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Specify a new product";
    }
}
