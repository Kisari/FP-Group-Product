package s3852307.entities;

import java.util.ArrayList;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */

public class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct() {
    }

    public PhysicalProduct(String name, String description, int quantityAvailable, double price, double weight,
            TaxType taxRate, ArrayList<Coupon> couponList) {
        super(name, description, quantityAvailable, price, taxRate, couponList);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
