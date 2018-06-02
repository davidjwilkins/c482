package sample;
import java.lang.Integer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PartsFormController {
    @FXML
    protected TextField id, name, inv, price, max, min, companyName;

    public int getId() {
        String i = id.getText();
        System.out.println(i);
        if (i.isEmpty() || i.equals("Auto Gen - Disabled")) {
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
}
