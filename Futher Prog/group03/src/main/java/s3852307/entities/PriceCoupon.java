package s3852307.entities;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 * @author <Dinh Le Hong Tin - s3932134>
 * @author <Nguyen Ha Kieu Anh - s3818552>
 * @author <Truong Bach Minh - s3891909>
 */

public class PriceCoupon extends Coupon {
    private String type = "price";

    private double discount;
    public PriceCoupon(String code, double discount) {
        super(code);
        this.discount = discount;
    }
    @Override
    public String getType() {
        return this.type;
    }

    public String toString() {
        return " price coupon: " + discount;
    }


    @Override
    public double applyToPrice(double price) {
        return price - discount;
    }
}
