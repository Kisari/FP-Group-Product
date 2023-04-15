package s3852307.entities;
/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */

public abstract class Product {
    private String name;
    private String description;
    private int quantityAvailable;
    private double price;

    public Product() {
    }
    public Product(String name, String description, int quantityAvailable, double price) {
        this.name = name;
        this.description = description;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
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

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantityAvailable=" + quantityAvailable +
                ", price=" + price;
    }
}
