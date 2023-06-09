package s3852307.entities;

import java.util.ArrayList;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 * @author <Dinh Le Hong Tin - s3932134>
 * @author <Nguyen Ha Kieu Anh - s3818552>
 * @author <Truong Bach Minh - s3891909>
 */

public abstract class Product {
    private String name;
    private String description;
    private int quantityAvailable;
    private TaxType tax;
    private double price;
    private ArrayList<Coupon> couponList = new ArrayList<Coupon>();
    private Coupon applyCouponCode;

    public Product() {
    }

    public Product(String name, String description, int quantityAvailable, double price, TaxType taxRate,
            ArrayList<Coupon> couponList) {
        this.name = name;
        this.description = description;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
        this.couponList = couponList;
        this.tax = taxRate;
    }

    public void printCouponList() {
        for (Coupon coupon : couponList) {
            System.out.println(coupon);
        }
    }

    public void addCoupon(Coupon coupon) {
        this.couponList.add(coupon);
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
        double price = this.price;
//        if (applyCouponCode != null) {
//            price = applyCouponCode.applyToPrice(this.price);
//        }

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void decreaseQuantity(int quantity) {
        this.quantityAvailable -= quantity;
    }

    public TaxType getTaxType() {
        return tax;
    }

    public void setTaxType(TaxType taxType) {
        this.tax = taxType;
    }

    public ArrayList<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(ArrayList<Coupon> couponList) {
        this.couponList = couponList;
    }

    public Coupon getApplyCouponCode() {
        return applyCouponCode;
    }

    public void setApplyCouponCode(Coupon applyCouponCode) {
        this.applyCouponCode = applyCouponCode;
    }

    @Override
    public String toString() {
        return "Product: " +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", taxType=" + tax;
    }
}
