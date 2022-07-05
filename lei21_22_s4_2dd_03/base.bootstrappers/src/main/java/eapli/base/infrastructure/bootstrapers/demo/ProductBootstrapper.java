package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.categorymanagement.builder.CategoryBuilder;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.application.SpecifyProductController;
import eapli.base.productmanagement.domain.ProductMeasurements;
import eapli.framework.actions.Action;

/**
 * @author Guilherme Araújo Sencadas
 */


public class ProductBootstrapper implements Action {

    /**
     * Executes the bootstrap.
     * <p>For More information read Bootstraps' (US1900) README.md
     *
     * @return true if no error appeared.
     */

    @Override
    public boolean execute() {
        SpecifyProductController controller = new SpecifyProductController();

        Category category1 = new CategoryBuilder().withCode("Food").build();
        Category category2 = new CategoryBuilder().withCode("Technology").build();


        //Create Product
        ProductMeasurements measurements = new ProductMeasurements(1, 1, 1, 30, 20, 30, 0.5);
        controller.specifyProductWithTheProductionCode(1L, "Water Bottle", "Bottle with water", "Plastic bottle filled with water", "Plastic bottle, with 500 mL almost full of water", measurements, "Barcode1", "Fastio", "Pingo Doce", 1, 1, "SPLASH", category1, "path1");

        measurements = new ProductMeasurements(1, 1, 2, 10, 10, 30, 0.8);
        controller.specifyProductWithTheProductionCode(1L,"Milk", "Box with milk", "Paperboard with milk", "PaperBoard with 1L of milk (15% lactose)", measurements,"Barcode2", "Mimosa", "Continente", 0.54, 0.40, "Bem Essencial", category1, "path2");

        measurements = new ProductMeasurements(1, 2, 3, 30, 20, 30, 1.2);
        controller.specifyProductWithTheProductionCode(1L,"Potato Chips", "Package with chips", "Plastic Package with potato chips", "Plastic Package with 85% of wind and 15% potato chips", measurements,"Barcode3", "Lays", "Continente", 1.40, 1.23, "Gourmet", category1, "path3");

        measurements = new ProductMeasurements(1, 2, 1, 38.1, 50.3, 40, 2.4);
        controller.specifyProductWithTheProductionCode(1L,"Laptop Computer", "A Portable Computer", "A Portable computer with a screen, keyboard and touchpad", "10th Gen Intel Core i3-10110U, Intel UHD Graphics, 8 GB + 256 GB, Windows 10 Home", measurements, "Barcode4","HUAWEI", "MateBook",615 , 500, "Gaming", category2, "path4");

        measurements = new ProductMeasurements(1, 2, 2, 10, 30,50 , 1);
        controller.specifyProductWithTheProductionCode(1L,"Screen", "A computer Screen", "A 30cm x 50cm computer screen.", "A new updated model of the brand, which supported High HD quality 60 fps. Can convert pixels into other pixels. Also has extra functionalities.", measurements, "Barcode5","ASUS", "Splendid",123 , 100, "Gaming", category2, "path5");

        measurements = new ProductMeasurements(1, 2, 3, 10, 30,50 , 1);
        controller.specifyProductWithTheProductionCode(1L,"Keyboard", "A computer Keyboard", "A 30cm x 10cm computer keyboard.", "A new updated model of the brand, which supported high values of tps. Has different colour settings.", measurements, "Barcode6","ASUS", "Splendid",80 , 69, "Gaming", category2, "path6");

        measurements = new ProductMeasurements(1, 3, 1, 10, 30,50 , 1);
        controller.specifyProductWithTheProductionCode(1L,"Mouse", "A computer mouse", "A 7cm x 5cm computer mouse.", "A new updated model of the brand, which has high mobility. Has different colour settings.", measurements, "Barcode7","ASUS", "Splendid",90 , 80, "Gaming", category2, "path7");

        measurements = new ProductMeasurements(1, 3, 2, 10, 30,50 , 1);
        controller.specifyProductWithTheProductionCode(1L,"ErgonomicMouse", "An ergonomic computer mouse", "A 7cm x 5cm computer mouse.", "A new updated model of the brand, which has high mobility. Has different colour settings. Creates a healthy work environment for those who work many ours straight.", measurements, "Barcode8","ASUS", "Erogonomic",230 , 200, "Work", category2, "path8");

        measurements = new ProductMeasurements(1, 3, 3, 10, 30,50 , 1);
        controller.specifyProductWithTheProductionCode(1L,"HeadSet", "A computer HeadSet", "A big and confortable HeadSet", "A high tech, updated model. With extra bass power and noise canceling.", measurements, "Barcode9","ASUS", "Sound",100 , 130, "Gaming", category2, "path9");

        measurements = new ProductMeasurements(2, 1, 1, 10, 30,50 , 1);
        controller.specifyProductWithTheProductionCode(1L,"Microphone", "A computer microphone", "A big and adjustable computer microphone", "A high tech, updated model. With extra noise canceling and adjustable options", measurements, "Barcode10","ASUS", "Sound",100 , 130, "Gaming", category2, "path10");

        return true;
    }
}
