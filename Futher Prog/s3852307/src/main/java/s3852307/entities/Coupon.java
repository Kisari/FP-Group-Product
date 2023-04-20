package s3852307.entities;

public abstract class Coupon {
    protected String code;

    public Coupon(String code) {
        this.code = code;
    }

    // getters and setters
    public abstract double applyToPrice(double price);
    public abstract String getType();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "code='" + code + '\'' +
                '}';
    }
}
