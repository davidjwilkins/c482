package sample;

import java.util.ArrayList;

/**
 * Created by dave on 5/28/18.
 */
public class Product {
    protected ArrayList<Part> associatedParts;
    protected int productID;
    protected String name;
    protected double price;
    protected int inStock;
    protected int min;
    protected int max;

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
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
