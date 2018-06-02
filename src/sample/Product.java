package sample;

import javafx.beans.property.*;

import java.util.ArrayList;

/**
 * Created by dave on 5/28/18.
 */
public class Product {
    protected ArrayList<Part> associatedParts;
    protected IntegerProperty productID;
    protected SimpleStringProperty name;
    protected DoubleProperty price;
    protected IntegerProperty inStock;
    protected IntegerProperty min;
    protected IntegerProperty max;

    public ArrayList<Part> getAssociatedParts() {
        return associatedParts;
    }

    public void setAssociatedParts(ArrayList<Part> associatedParts) {
        this.associatedParts = associatedParts;
    }

    public void addAssociatedPart(Part part) {
        this.associatedParts.add(part);
    }

    public boolean removeAssociatedPart(int index) {
        try {
            this.associatedParts.remove(index);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public Part lookupAssociatedPart(int index) {
        return this.associatedParts.get(index);
    }

    public int getProductID() {
        return productID.get();
    }

    public void setProductID(int productID) {
        this.productID.set(productID);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public int getInStock() {
        return inStock.get();
    }

    public void setInStock(int inStock) {
        this.inStock.set(inStock);
    }

    public int getMin() {
        return min.get();
    }

    public void setMin(int min) {
        this.min.set(min);
    }

    public int getMax() {
        return max.get();
    }

    public void setMax(int max) {
        this.max.set(max);
    }

    public final StringProperty nameProperty() { return new SimpleStringProperty(this.getName()); }
    public final DoubleProperty priceProperty() { return new SimpleDoubleProperty(this.getPrice()); }
    public final IntegerProperty minProperty() { return new SimpleIntegerProperty(this.getMin()); }
    public final IntegerProperty maxProperty() { return new SimpleIntegerProperty(this.getMax()); }
    public final IntegerProperty inStockProperty() { return new SimpleIntegerProperty(this.getInStock()); }
}
