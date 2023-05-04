package s3852307.entities;

import java.util.ArrayList;

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

    public GiftPhysicalProduct(String name, String description, int quantityAvailable, double price, double weight,
            String message, TaxType taxRate, ArrayList<Coupon> couponList) {
        super(name, description, quantityAvailable, price, weight, taxRate, couponList);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
