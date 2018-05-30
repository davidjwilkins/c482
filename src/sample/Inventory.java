package sample;

import java.util.ArrayList;

/**
 * Created by dave on 5/28/18.
 */
public class Inventory {
    protected ArrayList<Part> allParts;
    protected ArrayList<Product> products;

    public Inventory() {
        this.allParts = new ArrayList<Part>();
        this.products = new ArrayList<Product>();
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
