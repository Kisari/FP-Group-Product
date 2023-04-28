package s3852307.entities;
/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */

public class PhysicalProduct extends Product{
    private double weight;

    public PhysicalProduct() {
    }

    public PhysicalProduct(String name, String description, int quantityAvailable, double price, double weight, TaxType taxRate, Coupon coupon) {
        super(name, description, quantityAvailable, price, taxRate,  coupon);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}

