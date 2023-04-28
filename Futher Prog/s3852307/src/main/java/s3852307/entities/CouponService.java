package s3852307.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CouponService {
    private static ArrayList<Coupon> couponList = new ArrayList<Coupon>();

    public CouponService() {
    }

    public static ArrayList<Coupon> getCouponList() {
        return couponList;
    }

    public static void setCouponList(ArrayList<Coupon> couponList) {
        CouponService.couponList = couponList;
    }

    public static boolean isCouponExisted(String code) {
        for (Coupon coupon : couponList) {
            if (coupon.getCode().equals(code)) {
                System.out.println("This coupon code already exists");
                return true;
            }
        }
        return false;
    }

    // public static Coupon findCoupon(String code) {
    // for (Coupon coupon : couponList) {
    // if (coupon.getCode().equals(code)) {
    // System.out.println("This coupon code already exists");
    // return coupon;
    // }
    // }
    // return null;
    // }

    public static ArrayList<Coupon> parseFromStringToCoupon(String[] couponStringList) {
        if (couponStringList.length == 0) {
            return null;
        }
        ArrayList<Coupon> couponList = new ArrayList<>();
        for (String couponString : couponStringList) {
            Coupon newCoupon = null;
            String[] coupon = couponString.split("[ ]", 0);
            if (coupon[1].equalsIgnoreCase("price")) {
                newCoupon = new PriceCoupon(coupon[0], Double.parseDouble(coupon[2]));
            } else if (coupon[1].equalsIgnoreCase("percent")) {
                newCoupon = new PercentCoupon(coupon[0], Integer.parseInt(coupon[2]));
            }
            if (newCoupon != null)
                couponList.add(newCoupon);
        }
        return couponList;
    }
}
