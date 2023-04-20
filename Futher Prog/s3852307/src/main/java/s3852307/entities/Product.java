package s3852307.entities;
/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */

public abstract class Product {
    private String name;
    private String description;
    private int quantityAvailable;
    private double price;
    private Coupon coupon;

    public Product() {
    }

    public Product(String name, String description, int quantityAvailable, double price, Coupon coupon) {
        this.name = name;
        this.description = description;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
        this.coupon = coupon;
//        this.taxType = taxType;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void decreaseQuantity(int quantity) {
        this.quantityAvailable -= quantity;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    @Override
    public String toString() {
        return "Product: " +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantityAvailable=" + quantityAvailable +
                ", price=" + price +
                ", coupon=" + coupon.toString() +
                '.';
    }
}
