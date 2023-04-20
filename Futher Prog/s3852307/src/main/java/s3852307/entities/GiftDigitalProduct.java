package s3852307.entities;
/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */

public class GiftDigitalProduct extends DigitalProduct{
    private String message;

    public GiftDigitalProduct() {
    }

    public GiftDigitalProduct(String message) {
        this.message = message;
    }

    public GiftDigitalProduct(String name, String description, int quantityAvailable, double price, String message, CouponType type) {
        super(name, description, quantityAvailable, price, type);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
