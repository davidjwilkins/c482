package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class Controller {
    protected Main rootController;
    protected Inventory inventory;
    @FXML
    protected TableView partsTable;
    @FXML
    protected TableView productsTable;

    @FXML
    protected Button deletePartButton;

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

    public Part getSelectedPart() {
        return (Part)partsTable.getSelectionModel().getSelectedItem();
    }

    public void initialize() {
        EventHandler deletePartHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                inventory.deletePart(partsTable.getSelectionModel().getSelectedIndex());
            }
        };
        deletePartButton.setOnAction(deletePartHandler);
    }
}

