package s3852307.service;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 * @author <Dinh Le Hong Tin - s3932134>
 * @author <Nguyen Ha Kieu Anh - s3818552>
 * @author <Truong Bach Minh - s3891909>
 */

import s3852307.entities.DigitalProduct;
import s3852307.entities.GiftDigitalProduct;
import s3852307.entities.GiftPhysicalProduct;
import s3852307.entities.PhysicalProduct;
import s3852307.entities.Product;
import s3852307.entities.TaxType;
import s3852307.util.ScannerUtil;
import s3852307.util.Validation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import s3852307.entities.CouponService;

public class ProductService implements ProductInterface {
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

    public static List<Product> getProducts() {
        return products;
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
        } else if (type.equals("GIFT DIGITAL")) {
            product = new GiftDigitalProduct();
            productName = Validation.inputProductName("Enter gift digital product name: ");
        } else if (type.equals("GIFT PHYSICAL")) {
            product = new GiftPhysicalProduct();
            productName = Validation.inputProductName("Enter gift physical product name: ");
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
        } else if (product instanceof GiftDigitalProduct) {
            ((GiftDigitalProduct) product).setMessage(Validation.inputMessage("Enter gift digital product message: "));
        } else if (product instanceof GiftPhysicalProduct) {
            ((GiftPhysicalProduct) product).setWeight(Validation.inputDouble("Enter gift physical product weight: "));
            ((GiftPhysicalProduct) product)
                    .setMessage(Validation.inputMessage("Enter gift physical product message: "));
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
        } else if (product instanceof GiftDigitalProduct) {
            ((GiftDigitalProduct) product).setMessage(Validation.inputMessage("Enter gift digital product message: "));
        } else if (product instanceof GiftPhysicalProduct) {
            ((GiftPhysicalProduct) product).setWeight(Validation.inputDouble("Enter gift product weight: "));
            ((GiftPhysicalProduct) product)
                    .setMessage(Validation.inputMessage("Enter gift physical product message: "));
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

    @Override
    public void streamProduct() {
        String fileName = "Futher Prog/group03/src/main/java/s3852307/entities/product.txt";
        try {
            Files.lines(Paths.get(fileName)).filter(l -> l.length() > 0).map(line -> line.toString()).forEach(
                    c -> {
                        Product p = parseProduct(c);
                        products.add(p);
                        System.out.println(p);
                    });
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public Product parseProduct(String product) {
        String[] array = product.split("[,]", 0);
        String[] couponStringList = null;
        if (array[0].contains("GiftDigitalProduct")) {
            couponStringList = Arrays.copyOfRange(array, 6, array.length);
            return new GiftDigitalProduct(array[0],
                    array[1],
                    Integer.parseInt(array[2]),
                    Double.parseDouble(array[3]),
                    array[4],
                    TaxType.valueOf(array[5]),
                    CouponService.parseFromStringToCoupon(couponStringList));
        } else if (array[0].contains("GiftPhysicalProduct")) {
            couponStringList = Arrays.copyOfRange(array, 7, array.length);
            return new GiftPhysicalProduct(array[0],
                    array[1],
                    Integer.parseInt(array[2]),
                    Double.parseDouble(array[3]),
                    Double.parseDouble(array[4]),
                    array[5],
                    TaxType.valueOf(array[6]),
                    CouponService.parseFromStringToCoupon(couponStringList));
        } else if (array[0].contains("PHYSICAL")) {
            couponStringList = Arrays.copyOfRange(array, 6, array.length);
            return new PhysicalProduct(array[0],
                    array[1],
                    Integer.parseInt(array[2]),
                    Double.parseDouble(array[3]),
                    Double.parseDouble(array[4]),
                    TaxType.valueOf(array[5]),
                    CouponService.parseFromStringToCoupon(couponStringList));
        } else {
            couponStringList = Arrays.copyOfRange(array, 5, array.length);
            return new DigitalProduct(array[0],
                    array[1],
                    Integer.parseInt(array[2]),
                    Double.parseDouble(array[3]),
                    TaxType.valueOf(array[4]),
                    CouponService.parseFromStringToCoupon(couponStringList));
        }
    }

    public static boolean checkProduct(String product) {
        return product.contains("PHYSICAL") || product.contains("DIGITAL") || product.contains("GiftPhysicalProduct");
    }

    public void printProduct() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + "." + products.get(i).getName());
        }
    }

    public void viewProductMessage() {
        String productName = Validation.inputProductName("Enter product name: ");
        Product product = isProductExist(productName);
        if (product == null) {
            System.out.println("Product does not exist!");
            return;
        } else if (product instanceof GiftDigitalProduct) {
            System.out.println("The message of " + productName + " is :" + ((GiftDigitalProduct) product).getMessage());
            ;
        } else if (product instanceof GiftPhysicalProduct) {
            System.out
                    .println("The message of " + productName + " is :" + ((GiftPhysicalProduct) product).getMessage());
            ;
        } else {
            System.out.println("This product is not a gift so it doesn't have message!");
        }

    }

    public void editProductMessage() {
        String productName = Validation.inputProductName("Enter product name: ");
        Product product = isProductExist(productName);
        if (product == null) {
            System.out.println("Product does not exist!");
            return;
        } else if (product instanceof GiftDigitalProduct) {
            ((GiftDigitalProduct) product).setMessage(Validation.inputMessage("Enter new product message: "));
        } else if (product instanceof GiftPhysicalProduct) {
            ((GiftPhysicalProduct) product).setMessage(Validation.inputMessage("Enter new product message: "));
        } else {
            System.out.println("This product is not a gift so it doesn't have message!");
        }
    }
}
