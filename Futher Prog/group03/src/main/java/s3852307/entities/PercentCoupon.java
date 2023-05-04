package s3852307.entities;

public class PercentCoupon extends Coupon {

    private String type = "percent";
    private int discount;

    public PercentCoupon(String code, int discount) {
        super(code);
        if (discount < 1 || discount > 99) {
            throw new IllegalArgumentException("Percent Coupon must be between 1 and 99");
        }
        this.discount = discount;
    }


    public String toString() {
        return " percent coupon: " + discount + "%";
    }

    @Override
    public double applyToPrice(double price) {
        return price * (100 - discount) / 100;
    }

    @Override
    public String getType() {
        return this.type;
    }
}
