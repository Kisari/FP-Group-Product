package s3852307.entities;

import java.util.ArrayList;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 * @author <Dinh Le Hong Tin - s3932134>
 * @author <Nguyen Ha Kieu Anh - s3818552>
 * @author <Truong Bach Minh - s3891909>
 */

public class GiftDigitalProduct extends DigitalProduct {
    private String message;

    public GiftDigitalProduct() {
    }

    public GiftDigitalProduct(String message) {
        this.message = message;
    }

    public GiftDigitalProduct(String name, String description, int quantityAvailable, double price, String message,
            TaxType taxRate, ArrayList<Coupon> couponList) {
        super(name, description, quantityAvailable, price, taxRate, couponList);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
