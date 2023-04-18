package s3852307.service;
/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */
import s3852307.entities.DigitalProduct;
import s3852307.entities.PhysicalProduct;
import s3852307.entities.Product;
import s3852307.util.ScannerUtil;
import s3852307.util.Validation;
import java.util.ArrayList;
import java.util.List;

import static s3852307.entities.TaxType.NORMAL_TAX;
import static s3852307.entities.TaxType.TAX_FREE;
import static s3852307.entities.TaxType.LUXURY_TAX;

public class ProductService implements ProductInterface{
    private static List<Product> products = new ArrayList<Product>();
    public static Product isProductExist(String productName) {
        if(products == null) return null;
        for (Product product : products) {
            if (product.getName().equals(productName)) return product;
        }
        return null;
    }
    @Override
    public void createProduct(String type) {
        Product product = null;
        String productName = "";
        if (type.equals("DIGITAL")) {
            product = new DigitalProduct();
            productName = Validation.inputProductName("Enter digital product name: ");
        } else if (type.equals("PHYSICAL")) {
            product = new PhysicalProduct();
            productName = Validation.inputProductName("Enter physical product name: ");
        }
        if (isProductExist(productName) != null) {
            System.out.println("Product already exists!");
            return;
        }
        product.setName(productName);
        System.out.print("Enter product description: ");
        product.setDescription(ScannerUtil.getInstance().nextLine());
        product.setQuantityAvailable(Validation.inputInt("Enter product quantity: "));
        product.setPrice(Validation.inputDouble("Enter product price: "));
        if (product instanceof PhysicalProduct) {
            ((PhysicalProduct) product).setWeight(Validation.inputDouble("Enter product weight: "));
        }
        product.setTaxType(Validation.inputTaxType("Tax type options ..."));
        products.add(product);
        System.out.println("Product created successfully!");
    }
    @Override
    public void updateProduct() {
        String productName = Validation.inputProductName("Enter product name: ");
        Product product = isProductExist(productName);
        if (product == null) {
            System.out.println("Product does not exist!");
            return;
        }
        System.out.print("Enter product description: ");
        product.setDescription(ScannerUtil.getInstance().nextLine());
        product.setQuantityAvailable(Validation.inputInt("Enter product quantity: "));
        product.setPrice(Validation.inputDouble("Enter product price: "));
        if (product instanceof PhysicalProduct) {
            ((PhysicalProduct) product).setWeight(Validation.inputDouble("Enter product weight: "));
        }
        product.setTaxType(Validation.inputTaxType("Tax type options ..."));
        System.out.println("Product updated successfully!");
    }
    @Override
    public void deleteProduct() {
        String productName = Validation.inputProductName("Enter product name: ");
        Product product = isProductExist(productName);
        if (product == null) {
            System.out.println("Product does not exist!");
            return;
        }
        products.remove(product);
    }

    public static void addTempProduct(){ // for testing purposes
        Product product = new PhysicalProduct("PHYSICAL - 1","1",1,1,1, TAX_FREE);
        Product product1 = new PhysicalProduct("PHYSICAL - 2","2",5,10,5, NORMAL_TAX);
        Product product2 = new PhysicalProduct("PHYSICAL - 3","3",4,11,7, LUXURY_TAX);
        Product product3 = new PhysicalProduct("PHYSICAL - 4","4",7,12,8,TAX_FREE);
        Product product4 = new DigitalProduct("DIGITAL - 1","1",1,1,TAX_FREE);
        Product product5 = new DigitalProduct("DIGITAL - 2","2",5,10,LUXURY_TAX);
        Product product6 = new DigitalProduct("DIGITAL - 3","3",4,11, NORMAL_TAX);
        Product product7 = new DigitalProduct("DIGITAL - 4","4",7,12,LUXURY_TAX);
        products.add(product);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
    }

}

