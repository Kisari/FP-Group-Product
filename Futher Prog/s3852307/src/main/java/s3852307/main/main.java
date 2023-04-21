package s3852307.main;
import s3852307.entities.Coupon;
import s3852307.entities.ShoppingCart;
import s3852307.service.ProductService;
import s3852307.service.ShoppingCartService;
import s3852307.util.Validation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import static s3852307.entities.Coupon.code;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */

public class main {
    private static List<ShoppingCart>  shoppingCarts = new ArrayList<ShoppingCart>();
    public static void main(String[] args) throws IOException{
        int choice;
        ProductService productService = new ProductService();
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        ShoppingCart shoppingCart = new ShoppingCart();
        do {
            System.out.println("===========================================================");
            System.out.println("|                  FURTHER MANAGEMENT                     |");
            System.out.println("|=========================================================|");
            System.out.println("|=========================================================|");
            System.out.println("|1. Create new products:                                  |");
            System.out.println("|2. Edit products:                                        |");
            System.out.println("|3. Create a new shopping cart:                           |");
            System.out.println("|4. Add products to the current shopping cart             |");
            System.out.println("|5. Remove products from the current shopping cart        |");
            System.out.println("|6. Display the cart amount                               |");
            System.out.println("|7. Display all shopping carts based on their total weight|");
            System.out.println("|8. Exit                                                  |");
            System.out.println("|9. Apply Coupon                                          |");
            System.out.println("===========================================================");
            System.out.println("\n");

            choice = Validation.inputChoice(1, 9);

            switch (choice) {
                case 1:
                    System.out.println("|=========================|");
                    System.out.println("1. Create new products:");
                    System.out.println("|=========================|");
                    System.out.println("-- 1. Digital product");
                    System.out.println("-- 2. Physical product");
                    choice = Validation.inputChoice(1, 2);
                    switch (choice) {
                        case 1:
                            productService.createProduct("DIGITAL");
                            break;
                        case 2:
                            productService.createProduct("PHYSICAL");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("|=========================|");
                    System.out.println("2. Edit products:");
                    System.out.println("|=========================|");
                    productService.updateProduct();
                    break;

                case 3:
                    System.out.println("|=========================|");
                    System.out.println("3. Create a new shopping cart:");
                    System.out.println("|=========================|");
                    if(shoppingCart != null) {
                        shoppingCarts.add(shoppingCart);
                    }
                    shoppingCart = new ShoppingCart();
                    System.out.println("Created a new shopping cart successfully!");
                    break;

                case 4:
                    System.out.println("|=========================|");
                    System.out.println("4. Add products to the current shopping cart");
                    System.out.println("|=========================|");
                    shoppingCartService.addItem(shoppingCart.getItems(), Validation.inputProductName("Enter product name: "));
                        break;
                case 5:
                    System.out.println("|=========================|");
                    System.out.println("5. Remove products from the current shopping cart");
                    System.out.println("|=========================|");
                    shoppingCartService.removeItem(shoppingCart.getItems(),Validation.inputProductName("Enter product name: "));
                    break;
                case 6:
                    System.out.println("|=========================|");
                    System.out.println("6. Display the cart amount");
                    System.out.println("|=========================|");

                    System.out.println("Total amount: " + shoppingCartService.cartAmount(shoppingCart.getItems()));
                    break;
                case 7:
                    System.out.println("|=========================|");
                    System.out.println("7. Display all shopping carts based on their total weight");
                    System.out.println("|=========================|");
                    if(shoppingCarts != null) {
                        if(shoppingCart != null && shoppingCarts.contains(shoppingCart) == false)
                            shoppingCarts.add(shoppingCart);
                        Collections.sort(shoppingCarts);
                        for (ShoppingCart shoppingCartInLoop: shoppingCarts) {
                            shoppingCartService.printCart(shoppingCartInLoop.getItems());
                        }
                    } else {
                        System.out.println("No shopping cart!");
                    }
                    break;
                case 9:
                    System.out.println("|=========================|");
                    System.out.println("9. Apply Coupon");
                    System.out.println("|=========================|");
                    shoppingCartService.applyCoupon(shoppingCart.getItems());
                    break;
                case 8:
                    System.err.println("Exited!");
                    break;
            }
            System.out.println("\n");
        } while (choice != 8);
    }
}

