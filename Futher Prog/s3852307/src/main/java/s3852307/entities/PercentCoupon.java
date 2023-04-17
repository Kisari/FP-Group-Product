package s3852307.entities;

public class PercentCoupon extends Coupon {

    private int discount;

    public PercentCoupon(String code, Product product, int discount) {
        super(code, product);
        this.discount = discount;
    }

    public String toString() {
        return " percent coupon: " + discount + "%";
    }

    @Override
    public double getDiscount() {
        return getProduct().getPrice() * discount / 100;
    }
}
