package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by dave on 5/28/18.
 */
public class Inventory {
    protected ObservableList<Part> allParts;
    protected ObservableList<Product> products;
    protected static int nextID = 1;
    public Inventory() {
        this.allParts = FXCollections.observableArrayList(new ArrayList<Part>());
        this.products = FXCollections.observableArrayList(new ArrayList<Product>());
    }

    public ObservableList<Part> getParts() {
        return this.allParts;
    }

    public ObservableList<Product> getProducts() {
        return this.products;
    }
    public void addProduct(Product product) {
        this.products.add(product);
    }

    public boolean removeProduct(int index) {
        try {
            this.products.remove(index);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public Product lookupProduct(int index) {
        return this.products.get(index);
    }

    public void updateProduct(int index) {
        // TODO
    }

    public void addPart(Part part) {
        if (part.getPartID() == 0) {
            part.setPartID(nextID++);
        }
        this.allParts.add(part);
    }

    public boolean deletePart(int index) {
        try {
            this.allParts.remove(index);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public Part lookupPart(int index) {
        return this.allParts.get(index);
    }

    public void updatePart(int index) {
        // TODO
    }
}
