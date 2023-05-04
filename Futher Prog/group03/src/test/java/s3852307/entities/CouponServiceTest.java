package s3852307.entities;
import org.junit.jupiter.api.Test;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 * @author <Dinh Le Hong Tin - s3932134>
 * @author <Nguyen Ha Kieu Anh - s3818552>
 * @author <Truong Bach Minh - s3891909>
 */

import static org.junit.jupiter.api.Assertions.*;
class CouponServiceTest {
    @Test
    void applyToPrice() {
        Coupon coupon = new PriceCoupon("SAVE10", 10);
        assertEquals(90, coupon.applyToPrice(100));
        Coupon coupon1 = new PercentCoupon("DEAL15", 15);
        assertEquals(76.5, coupon1.applyToPrice(90));
    }

    @Test
    void getType() {
        Coupon coupon = new PriceCoupon("SAVE10", 10);
        assertEquals("price", coupon.getType());
        Coupon coupon1 = new PercentCoupon("DEAL15", 15);
        assertEquals("percent", coupon1.getType());
    }

    @Test
    void getCode() {
        Coupon coupon = new PriceCoupon("SAVE10", 10);
        assertEquals("SAVE10", coupon.getCode());
        Coupon coupon1 = new PercentCoupon("DEAL15", 15);
        assertEquals("DEAL15", coupon1.getCode());
    }

    @Test
    void isCouponExisted() {
        Coupon coupon = new PriceCoupon("SAVE10", 10);
        CouponService.getCouponList().add(coupon);
        assertTrue(CouponService.isCouponExisted("SAVE10"));
        assertFalse(CouponService.isCouponExisted("SAVE11"));

    }
}