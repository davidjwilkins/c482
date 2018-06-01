package sample;
import java.lang.Integer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PartsController {
    @FXML
    protected Button cancelButton;
    @FXML
    protected Button saveButton;
    @FXML
    protected RadioButton inHouse;
    @FXML
    protected TextField id, name, inv, price, max, min, companyName;

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
                if (inHouse.isSelected()) {
                    part = new Inhouse();
                } else {
                    part = new Outsourced();
                }

                part.setName(name.getText());
                part.setInStock(Integer.parseInt(inv.getText()));
                part.setMin(Integer.parseInt(min.getText()));
                part.setMax(Integer.parseInt(max.getText()));
                part.setPrice(Double.parseDouble(price.getText()));

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
