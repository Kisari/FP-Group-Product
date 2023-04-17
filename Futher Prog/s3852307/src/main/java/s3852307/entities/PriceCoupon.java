package s3852307.entities;

public class PriceCoupon extends Coupon {
    private double discount;

    public PriceCoupon(String code, Product product, double discount) {
        super(code, product);
        this.discount = discount;
    }
    public String toString() {
        return " price coupon: " + discount;
    }

    @Override
    public double getDiscount() {
        return discount;
    }
}
