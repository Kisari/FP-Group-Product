package s3852307.service;
import org.junit.jupiter.api.Test;
import s3852307.entities.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 * @author <Dinh Le Hong Tin - s3932134>
 * @author <Nguyen Ha Kieu Anh - s3818552>
 * @author <Truong Bach Minh - s3891909>
 */

class ShoppingCartServiceTest {
    @Test
    void addTwoCoupon() {
        PhysicalProduct product = new PhysicalProduct("test", "test", 5, 50, 1, TaxType.LUXURY_TAX,
                new ArrayList<Coupon>());
        Coupon coupon = new PriceCoupon("SAVE10", 10);
        Coupon coupon1 = new PercentCoupon("DEAL15", 15);
        product.addCoupon(coupon);
        product.addCoupon(coupon1);
        assertEquals(2, product.getCouponList().size());
    }

}