package eapli.base.app.backoffice.console.presentation.salesclerk;

import eapli.base.Utils;
import eapli.base.catalogmanagement.application.ViewCatalogController;
import eapli.base.catalogmanagement.mapper.dto.CatalogDTO;
import eapli.base.productmanagement.mapper.dto.ProductDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luís Araújo
 */
public class ViewCatalogUI extends AbstractUI {

    private final ViewCatalogController viewCatalogController = new ViewCatalogController();

    @Override
    protected boolean doShow() {
        List<String> options = new ArrayList<>();
        int option;
        Long catalogCode;

        try {
            options.add("Search for the catalog");
            options.add("Search for a product of the catalog by its code");
            options.add("Search for a product of the catalog by its category");
            options.add("Search for a product of the catalog by its short description");
            options.add("Search for a product of the catalog by its brand");

            option = Utils.showAndSelectIndex(options, "\n\nView Catalog");

            switch (option) {
                case 0:
                    catalogCode = Console.readLong("Insert the code of the catalog");
                    CatalogDTO catalog = viewCatalogController.viewCatalogByItsCode(catalogCode);

                    for (ProductDTO p : viewCatalogController.listOfProducts(catalog)) {
                        System.out.println(p.toString());
                    }
                    break;
                case 1:
                    catalogCode = Console.readLong("Insert the code of the catalog");
                    String productCode = Console.readLine("Insert the code of the product in the catalog");
                    System.out.println(viewCatalogController.viewProductOfTheCatalogByCode(productCode, catalogCode).toString());
                    break;
                case 2:
                    catalogCode = Console.readLong("Insert the code of the catalog");
                    String productCategory = Console.readLine("Insert the category of the product in the catalog");
                    System.out.println(viewCatalogController.viewProductOfTheCatalogByCategory(productCategory, catalogCode).toString());
                    break;
                case 3:
                    catalogCode = Console.readLong("Insert the code of the catalog");
                    String productDescription = Console.readLine("Insert the short description of the product in the catalog");
                    System.out.println(viewCatalogController.viewProductOfTheCatalogByDescription(productDescription, catalogCode).toString());
                    break;
                case 4:
                    catalogCode = Console.readLong("Insert the code of the catalog");
                    String productBrand = Console.readLine("Insert the brand of the product in the catalog");
                    System.out.println(viewCatalogController.viewProductOfTheCatalogByBrand(productBrand, catalogCode).toString());
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Option not chosen");
                    break;
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "View Catalog";
    }
}
