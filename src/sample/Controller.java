package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class Controller {
    protected Main rootController;
    protected Inventory inventory;
    @FXML
    protected TableView partsTable;
    @FXML
    protected TableView productsTable;

    public void setRootController(Main m) {
        this.rootController = m;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
        this.partsTable.setItems(inventory.getParts());
        this.productsTable.setItems(inventory.getProducts());
        System.out.println("Set items!");
        System.out.println(inventory.getParts());
        System.out.println(inventory.getProducts());
    }
}

