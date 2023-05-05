package s3852307.entities;
/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 * @author <Dinh Le Hong Tin - s3932134>
 * @author <Nguyen Ha Kieu Anh - s3818552>
 * @author <Truong Bach Minh - s3891909>
 */

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
