package s3852307.service;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */
import s3852307.entities.*;
import s3852307.entities.DigitalProduct;
import s3852307.entities.PhysicalProduct;
import s3852307.entities.Product;
import s3852307.entities.ShoppingCart;
import s3852307.util.Constant;
import s3852307.util.Validation;

import java.util.List;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class ShoppingCartService implements ShoppingCartInterface {
    private Product product;
    private List<Product> items;
    private Coupon coupon;

    @Override
    public boolean addItem(Set<String> items, String productName) {
        Product product = ProductService.isProductExist(productName);
        if (product == null) {
            System.out.println("Product does not exist!");
            return false;
        } else if (items.isEmpty()) {
            items.add(productName);
            product.decreaseQuantity(1);
            System.out.println("Product added to cart!");
            return true;
        } else if (items.contains(productName) && !items.isEmpty()) {
            System.out.println("Product is already in cart!");
            return false;
        } else if (product.getQuantityAvailable() == 0) {
            System.out.println("Product is out of stock!");
            return false;
        } else {
            items.add(productName);
            product.decreaseQuantity(1);
            System.out.println("Product added to cart!");
            return true;
        }
    }

    @Override
    public void removeItem(Set<String> items, String productName) {
        Product product = ProductService.isProductExist(productName);
        if (product == null) {
            System.out.println("Product does not exist!");
        } else if (!items.contains(productName)) {
            System.out.println("Product is not in cart!");
        } else {
            items.remove(productName);
            System.out.println("Product removed from cart!");
            product.decreaseQuantity(-1);
        }
    }

    @Override
    public Number[] cartAmount(Set<String> items) {
        Number[] results = new Number[] { 0, 0, 0 };
        if (items == null || items.size() == 0)
            return results;
        double amount = 0;
        double totalWeight = 0;

        double tax = 0;
        for (String productName : items) {
            Product product = ProductService.isProductExist(productName);

            if(product.getApplyCouponCode() != null) {
                amount +=  product.getApplyCouponCode().applyToPrice(product.getPrice());
            } else {
                amount += product.getPrice();
            }

            if (product instanceof PhysicalProduct) {
                totalWeight += ((PhysicalProduct) product).getWeight();
            }
            tax += (product.getPrice() * product.getTaxType().getTaxRate());
        }
        double shippingFee = totalWeight * Constant.baseFee;
        amount += shippingFee + tax;
        results = new Number[] { amount, tax, shippingFee };
        return results;
    }

    public boolean applyCoupon(Set<String> items) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        Product product = null;

        for (String productName : items) {
            if (productName.equalsIgnoreCase(name)) {
                product = ProductService.isProductExist(name);
                break;
            }
        }
        if (product == null) {
            System.out.println("Product does not exist!");
            return false;
        }
        if (!items.contains(name)) {
            System.out.println("Product is not in cart!");
            return false;
        }
        product.toString();
        product.printCouponList();

        System.out.print("Enter coupon code: ");
        String code = scanner.next();
        for (Coupon coupon : product.getCouponList()) {
            if (coupon.getCode().equals(code)) {
                product.setApplyCouponCode(coupon);
                System.out.println("Coupon applied!");
                break;
            }
        }
        if (product.getApplyCouponCode() == null) {
            System.out.println("Coupon does not exist!");
            return false;
        }
        return true;
    }

    public void printCart(Set<String> items) {
        if (items == null || items.size() == 0) {
            System.out.println("Cart is empty!");
            return;
        }
        System.out.println("Items in cart:");
        for (String productName : items) {
            Product product = ProductService.isProductExist(productName);
            System.out.println(product);
        }
    }

    public void printReceipt(ShoppingCart shoppingCart, boolean paidStatus) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        this.printCart(shoppingCart.getItems());
        if ((shoppingCart.getItems() == null) || shoppingCart.getItems().size() == 0)
            return;
        System.out.println("Total tax :" + this.cartAmount(shoppingCart.getItems())[1]);
        System.out.println("Total shipping fee :" + this.cartAmount(shoppingCart.getItems())[2]);
        Validation.printDelimiter();
        System.out.println("Date of purchase :" + dateFormat.format(date));
        Validation.printDelimiter();
        shoppingCart.setPaid(paidStatus);
    }
}
