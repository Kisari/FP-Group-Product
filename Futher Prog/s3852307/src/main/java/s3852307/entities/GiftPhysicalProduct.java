package s3852307.entities;
/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */

public class GiftPhysicalProduct extends PhysicalProduct {
    private String message;

    public GiftPhysicalProduct() {
    }
    public GiftPhysicalProduct(String message) {
        this.message = message;
    }

    public GiftPhysicalProduct(String name, String description, int quantityAvailable, double price, double weight, String message, TaxType taxRate, Coupon coupon) {
        super(name, description, quantityAvailable, price, weight, taxRate, coupon);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

