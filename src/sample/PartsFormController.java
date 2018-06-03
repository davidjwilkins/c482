package sample;
import java.lang.Integer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PartsFormController {
    @FXML
    protected TextField id, name, inv, price, max, min, companyName;
    private final String NO_ID = "Auto Gen - Disabled";

    public void setCompanyNameEnabled(boolean enabled) {
        companyName.setDisable(!enabled);
        companyName.setEditable(enabled);
        if (!enabled) {
            companyName.clear();
        }
    }

    public int getId() {
        String i = id.getText();
        System.out.println(i);
        if (i.isEmpty() || i.equals(NO_ID)) {
            return 0;
        }
        return Integer.parseInt(id.getText());
    }

    public int getInv() {
        String i = inv.getText();
        if (i.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(inv.getText());
    }

    public int getMin() {
        String i = min.getText();
        if (i.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(min.getText());
    }

    public int getMax() {
        String i = max.getText();
        if (i.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(max.getText());
    }

    public double getPrice() {
        String i = price.getText();
        if (i.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(inv.getText());
    }

    public String getName() {
        return name.getText();
    }

    public String getCompanyName() {
        return companyName.getText();
    }

    public void setPart(Part part) {
        if (part.getPartID() == 0) {
            this.id.setText(NO_ID);
        } else {
            this.id.setText(Integer.toString(part.getPartID()));
        }
        this.inv.setText(Integer.toString(part.getInStock()));
        this.price.setText(Double.toString(part.getPrice()));
        this.name.setText(part.getName());
        this.min.setText(Integer.toString(part.getMin()));
        this.max.setText(Integer.toString(part.getMax()));
    }

    public void clear() {
        this.id.setText(NO_ID);
        this.inv.clear();
        this.name.clear();
        this.price.clear();
        this.min.clear();
        this.max.clear();
        this.companyName.clear();
    }
}
