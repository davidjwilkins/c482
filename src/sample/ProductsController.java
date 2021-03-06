package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ProductsController {
    @FXML
    protected Button cancelButton;
    protected Main rootController;
    protected Inventory inventory;
    public void initialize() {
        EventHandler cancelHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                rootController.mainScene();
            }
        };
        cancelButton.setOnAction(cancelHandler);
    }
    public void setRootController(Main m) {
        this.rootController = m;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
