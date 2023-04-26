package s3852307.entities;

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
