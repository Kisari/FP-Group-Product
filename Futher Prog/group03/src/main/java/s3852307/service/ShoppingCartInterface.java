package s3852307.service;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 * @author <Dinh Le Hong Tin - s3932134>
 * @author <Nguyen Ha Kieu Anh - s3818552>
 * @author <Truong Bach Minh - s3891909>
 */

import java.util.Set;

import s3852307.entities.CouponService;

public interface ShoppingCartInterface {
    boolean addItem(Set<String> items, String productName);

    void removeItem(Set<String> items, String productName);

    Number[] cartAmount(Set<String> items);

    CouponService streamCart(CouponService couponService);
}