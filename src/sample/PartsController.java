package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

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

        EventHandler inHouseButtonChangeHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (inHouseButton.isSelected()) {
                    partsFormController.setCompanyNameEnabled(false);
                } else {
                    partsFormController.setCompanyNameEnabled(true);
                }
            }
        };
        inHouseButton.setOnAction(inHouseButtonChangeHandler);
        inHouseButton.setSelected(true);
        partsFormController.setCompanyNameEnabled(false);
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
                partsFormController.clear();
                inHouseButton.setSelected(true);
                rootController.mainScene();
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
    public void setPart(Part part) {
        this.inHouseButton.setSelected(part instanceof Inhouse);
        partsFormController.setPart(part);
    }

}
