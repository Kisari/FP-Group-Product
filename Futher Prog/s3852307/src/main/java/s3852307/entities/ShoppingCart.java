package s3852307.entities;

import s3852307.service.ProductService;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */

public class ShoppingCart implements Comparable<ShoppingCart> {
    private Set<String> items;
    private boolean isPaid = false;

    public ShoppingCart() {
        this.items = new HashSet<>();
    }

    public ShoppingCart(Set<String> items) {
        this.items = items;
    }

    public Set<String> getItems() {
        return items;
    }

    public void setItems(Set<String> items) {
        this.items = items;
    }

    public boolean getPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    @Override
    public int compareTo(ShoppingCart otherCart) {
        double thisTotalWeight = this.getTotalWeight();
        double otherTotalWeight = otherCart.getTotalWeight();
        
        if (thisTotalWeight < otherTotalWeight) {
            return -1;
        } else if (thisTotalWeight > otherTotalWeight) {
            return 1;
        } else {
            return 0;
        }
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (String productName : items) {
            Product product = ProductService.isProductExist(productName);
            if (product instanceof PhysicalProduct) {
                totalWeight += ((PhysicalProduct) product).getWeight();
            }
        }
        return totalWeight;
    }
}