package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import javax.swing.*;

public class PartsController {
    @FXML
    protected PartsFormController partsFormController;

    @FXML
    protected Button cancelButton;
    @FXML
    protected Button saveButton;
    @FXML
    protected RadioButton inHouseButton;


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

        EventHandler saveHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Part part;
                if (inHouseButton.isSelected()) {
                    part = new Inhouse();
                } else {
                    part = new Outsourced();
                }

                part.setPartID(partsFormController.getId());
                part.setName(partsFormController.getName());
                part.setInStock(partsFormController.getInv());
                part.setMin(partsFormController.getMin());
                part.setMax(partsFormController.getMax());
                part.setPrice(partsFormController.getPrice());

                inventory.addPart(part);
            }
        };
        saveButton.setOnAction(saveHandler);
    }
    public void setRootController(Main m) {
        this.rootController = m;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}
