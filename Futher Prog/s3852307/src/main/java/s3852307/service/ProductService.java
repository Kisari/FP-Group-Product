package s3852307.service;
/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */
import s3852307.entities.*;
import s3852307.util.ScannerUtil;
import s3852307.util.Validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import static s3852307.entities.TaxType.NORMAL_TAX;
import static s3852307.entities.TaxType.TAX_FREE;
import static s3852307.entities.TaxType.LUXURY_TAX;

public class ProductService implements ProductInterface{
    private static List<Product> products = new ArrayList<Product>();
    private static CouponService couponList = new CouponService();


    public static Product isProductExist(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void createProduct(String type) {
        Scanner scanner = new Scanner(System.in);
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
        product.addCoupon(Validation.inputCode("Coupon Type Options...", couponList));
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
}

