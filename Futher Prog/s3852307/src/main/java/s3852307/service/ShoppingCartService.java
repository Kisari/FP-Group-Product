package s3852307.service;
/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */
import s3852307.entities.DigitalProduct;
import s3852307.entities.PhysicalProduct;
import s3852307.entities.Product;
import s3852307.util.Constant;

import java.util.Set;

public class ShoppingCartService implements ShoppingCartInterface {
    @Override
    public boolean addItem(Set<String> items, String productName) {
        Product product = ProductService.isProductExist(productName);
        if (product == null) {
            System.out.println("Product does not exist!");
            return false;
        }else if (items.isEmpty()) {
            items.add(productName);
            product.decreaseQuantity(1);
            System.out.println("Product added to cart!");
            return true;
        }  else if (items.contains(productName)&&!items.isEmpty()) {
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
    public void removeItem(Set<String> items,String productName) {
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
    public double cartAmount(Set<String> items) {
        if (items == null || items.size() == 0)
            return 0;
        double amount = 0;
        double totalWeight = 0;
        double tax = 0;
        for (String productName : items) {
            Product product = ProductService.isProductExist(productName);
            if(product instanceof PhysicalProduct) {
                amount += product.getPrice() + ((PhysicalProduct) product).getWeight()*Constant.baseFee;
                totalWeight += ((PhysicalProduct) product).getWeight()*Constant.baseFee;}
            else if(product instanceof DigitalProduct) {
                amount += product.getPrice();}
            tax = product.getPrice() * product.getTaxType().getTaxRate();
        }
        double shippingFee = totalWeight * Constant.baseFee;
        amount += shippingFee + tax;
        return amount;
    }
    public void printCart(Set<String> items){
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
}
