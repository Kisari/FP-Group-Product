package s3852307.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CouponService {
    private static ArrayList<Coupon> couponList = new ArrayList<Coupon>();


    private static Scanner scanner = new Scanner(System.in);

    public static boolean isCouponExisted(String code) {
        for (Coupon coupon : couponList) {
            if (coupon.getCode().equals(code)) {
                System.out.println("This coupon code already exists");
                return true;
            }
        }
        return false;
    }
}




