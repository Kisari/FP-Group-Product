//package s3852307.service;
//
//import org.junit.Test;
//import org.junit.Assert;
//import s3852307.entities.*;
//import s3852307.service.ShoppingCartService;
//
//import java.util.*;
//
//import static s3852307.entities.TaxType.TAX_FREE;
//
//public class ShoppingCartServiceTest {
//
//    @Test
//    public void testAddItem() {
//        ShoppingCartService cart = new ShoppingCartService();
//        Set<String> items = new HashSet<>();
//        String productName = "Product 1";
//        boolean result = cart.addItem(items, productName);
//        Assert.assertTrue(result);
//        Assert.assertEquals(1, items.size());
//    }
//
//    @Test
//    public void testCartAmount() {
//        ShoppingCartService cart = new ShoppingCartService();
//        Set<String> items = new HashSet<>();
//        String productName1 = "Product 1";
//        String productName2 = "Product 2";
//
//        items.add(String.valueOf(new PhysicalProduct("PHYSICAL - SamsungS21", "256GB", 7, 5.0, 2.0, TAX_FREE, new ArrayList<Coupon>())));
//        items.add(String.valueOf(new PhysicalProduct("PHYSICAL - Book", "Novel", 5, 20, 1.0, TAX_FREE, new ArrayList<Coupon>())));
//        cart.addItem(items, productName1);
//        cart.addItem(items, productName2);
//        Number[] result = cart.cartAmount(items);
//        Assert.assertEquals(169.0, result[0].doubleValue(), 0.001);
//        Assert.assertEquals(15.0, result[1].doubleValue(), 0.001);
//        Assert.assertEquals(5.0, result[2].doubleValue(), 0.001);
//    }
//
//    @Test
//    public void testStreamCart() {
////        ShoppingCartService cart = new ShoppingCartService();
////        CouponService couponService = new CouponService();
////        couponService.addCoupon(new PercentCoupon("CODE1", 20));
////        couponService.addCoupon(new PriceCoupon("CODE2", 50));
////        couponService.addCoupon(new PercentCoupon("CODE3", 30));
////        CouponService result = cart.streamCart(couponService);
////        Assert.assertEquals(3, result.getCouponList().size());
////        Assert.assertEquals("CODE1", result.getCouponList().get(0).getCode());
////        Assert.assertEquals("CODE2", result.getCouponList().get(1).getCode());
////        Assert.assertEquals("CODE3", result.getCouponList().get(2).getCode());
//    }
//}
