package s3852307.entities;

public abstract class Coupon {
    private String code;
    private Product product;

    public Coupon(String code, Product product) {
        this.code = code;
        this.product = product;
    }

    public abstract double getDiscount();

    // getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
