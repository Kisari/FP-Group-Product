package s3852307.main;

import s3852307.entities.Coupon;
import s3852307.entities.CouponService;
import s3852307.entities.ShoppingCart;
import s3852307.service.ProductService;
import s3852307.service.ShoppingCartService;
import s3852307.util.Validation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 * @author <Dinh Le Hong Tin - s3932134>
 * @author <Nguyen Ha Kieu Anh - s3818552>
 * @author <Truong Bach Minh - s3891909>
 */

public class main {
    private static List<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();

    public static void main(String[] args) throws IOException {
        int choice;
        ProductService productService = new ProductService();
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        ShoppingCart shoppingCart = new ShoppingCart();
        productService.streamProduct();
        do {
            System.out.println("============================================================");
            System.out.println("|                  FURTHER MANAGEMENT                      |");
            System.out.println("|==========================================================|");
            System.out.println("|==========================================================|");
            System.out.println("|1. Create new products                                    |");
            System.out.println("|2. View Product                                           |");
            System.out.println("|3. Edit Product                                           |");
            System.out.println("|4. View gift's message                                    |");
            System.out.println("|5. Edit gift's message                                    |");
            System.out.println("|6. Display the cart amount                                |");
            System.out.println("|7. Create a new shopping cart                             |");
            System.out.println("|8. View exist cart (excluding the current one)            |");
            System.out.println("|9. Add products to the current shopping cart              |");
            System.out.println("|10. Remove products from the current shopping cart        |");
            System.out.println("|11. Apply Coupon                                          |");
            System.out.println("|12. Select unpaid cart to view details                    |");
            System.out.println("|13. Display all shopping carts based on their total weight|");
            System.out.println("|14. Print the shopping cart receipt                       |");
            System.out.println("|15. Exit                                                  |");
            System.out.println("============================================================");
            System.out.println("\n");

            choice = Validation.inputChoice(1, 15);

            switch (choice) {
                case 1:
                    System.out.println("|=========================|");
                    System.out.println("1. Create new products:");
                    System.out.println("|=========================|");
                    System.out.println("-- 1. Digital product");
                    System.out.println("-- 2. Physical product");
                    System.out.println("-- 3. Gift Digital product");
                    System.out.println("-- 4. Gift Physical product");
                    choice = Validation.inputChoice(1, 4);
                    switch (choice) {
                        case 1:
                            productService.createProduct("DIGITAL");
                            break;
                        case 2:
                            productService.createProduct("PHYSICAL");
                            break;
                        case 3:
                            productService.createProduct("GIFT DIGITAL");
                            break;
                        case 4:
                            productService.createProduct("GIFT PHYSICAL");
                            break;
                    }
                    break;
                case 2:
                    productService.streamProduct();
                    break;
                case 3:
                    System.out.println("|=========================|");
                    System.out.println("3. Edit products:");
                    System.out.println("|=========================|");
                    productService.updateProduct();
                    break;
                case 4:
                    productService.viewProductMessage();
                    break;
                case 5:
                    productService.editProductMessage();
                    break;
                case 6:
                    System.out.println("|=========================|");
                    System.out.println("6. Display the cart amount");
                    System.out.println("|=========================|");
                    System.out.println("Total amount: " + shoppingCartService.cartAmount(shoppingCart.getItems())[0]);
                    break;
                case 7:
                    System.out.println("|=========================|");
                    System.out.println("7. Create a new shopping cart:");
                    System.out.println("|=========================|");
                    if (!shoppingCart.getItems().isEmpty() && !shoppingCarts.contains(shoppingCart)) {
                        shoppingCarts.add(shoppingCart);
                    }
                    shoppingCart = new ShoppingCart();
                    System.out.println("Created a new shopping cart successfully!");
                    break;
                case 8:
                    shoppingCartService.streamCart(shoppingCart);
                    break;
                case 9:
                    System.out.println("|=========================|");
                    System.out.println("8. Add products to the current shopping cart");
                    System.out.println("|=========================|");
                    productService.printProduct();
                    System.out.println("|=========================|");
                    shoppingCartService.addItem(shoppingCart.getItems(),
                            Validation.inputProductName("Enter product name(Format: DIGITAL - NAME) : "));
                    break;
                case 10:
                    System.out.println("|=========================|");
                    System.out.println("10. Remove products from the current shopping cart");
                    System.out.println("|=========================|");
                    productService.printProduct();
                    System.out.println("|=========================|");
                    shoppingCartService.removeItem(shoppingCart.getItems(),
                            Validation.inputProductName("Enter product name: "));
                    shoppingCartService.removeItem(shoppingCart.getItems(),
                            Validation.inputProductName("Enter product name:"));
                    break;
                case 11:
                    System.out.println("|=========================|");
                    System.out.println("11. Apply Coupon");
                    System.out.println("|=========================|");
                    shoppingCartService.applyCoupon(shoppingCart.getItems());
                    break;
                case 12:
                    System.out.println("|=========================|");
                    System.out.println("12. Select unpaid cart to view details ");
                    System.out.println("|=========================|");
                    if (!shoppingCart.getItems().isEmpty() && !shoppingCarts.contains(shoppingCart)) {
                        shoppingCarts.add(shoppingCart);
                    }
                    if (shoppingCarts.size() == 0) {
                        System.out.println("No shopping cart can be selected");
                        break;
                    }
                    System.out.println("There are " + shoppingCarts.size() + " in the store.");
                    int selectedIndex = Validation.inputChoice(1, shoppingCarts.size());
                    if (shoppingCarts.get(selectedIndex - 1).getPaid()) {
                        System.out.println("Cannot select and view this cart since it has paid!! Try again");
                    } else {

                        shoppingCart = shoppingCarts.get(selectedIndex - 1);
                        shoppingCartService.printCart(shoppingCart.getItems());
                        System.out
                                .println("Total amount: " + shoppingCartService.cartAmount(shoppingCart.getItems())[0]);
                        System.out.println("Total tax :" + shoppingCartService.cartAmount(shoppingCart.getItems())[1]);
                        System.out.println(
                                "Total shipping fee :" + shoppingCartService.cartAmount(shoppingCart.getItems())[2]);
                        System.out.println("Successfully change to cart " + selectedIndex);
                    }
                    break;
                case 13:
                    System.out.println("|=========================|");
                    System.out.println("13. Display all shopping carts based on their total weight");
                    System.out.println("|=========================|");
                    if (shoppingCarts.size() != 0) {
                        if (shoppingCart.getItems().size() != 0 && shoppingCarts.contains(shoppingCart) == false)
                            shoppingCarts.add(shoppingCart);
                        Collections.sort(shoppingCarts);
                        for (ShoppingCart shoppingCartInLoop : shoppingCarts) {
                            shoppingCartService.printCart(shoppingCartInLoop.getItems());
                        }
                    } else {
                        System.out.println("No shopping cart!");
                    }
                    break;
                case 14:
                    System.out.println("|=========================|");
                    System.out.println("14. Print the shopping cart receipt");
                    System.out.println("|=========================|");
                    shoppingCartService.printReceipt(shoppingCart, true);
                    shoppingCart.setPaid(true);
                    if (shoppingCart != null) {
                        shoppingCarts.add(shoppingCart);
                    }
                    shoppingCart = new ShoppingCart();
                    System.out.println("Printing receipt successfully! Creating a new shopping cart!");
                    break;
                case 15:
                    System.err.println("Exited!");
                    System.exit(0);
            }
            System.out.println("\n");
        } while (choice != 15);
    }
}
