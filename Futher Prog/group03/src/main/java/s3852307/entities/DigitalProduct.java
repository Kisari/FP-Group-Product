package s3852307.entities;
import java.util.ArrayList;
/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 * @author <Dinh Le Hong Tin - s3932134>
 * @author <Nguyen Ha Kieu Anh - s3818552>
 * @author <Truong Bach Minh - s3891909>
 */

public class DigitalProduct extends Product {
    public DigitalProduct() {
    }

    public DigitalProduct(String name, String description, int quantityAvailable, double price, TaxType taxRate,
            ArrayList<Coupon> couponList) {
        super(name, description, quantityAvailable, price, taxRate, couponList);
    }
}
