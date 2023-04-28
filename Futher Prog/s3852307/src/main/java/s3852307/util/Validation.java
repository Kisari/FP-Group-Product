package s3852307.util;


import s3852307.entities.*;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */

public class Validation {
    public static boolean isPositive(int value) {
        return value > 0;
    }
    public static boolean isPositive(double value) {
        return value > 0;
    }
    public static boolean isPhysicalProductName(String productName) {
        return productName.matches(Constant.PHYSICAL_PRODUCT_REGEX);
    }
    public static boolean isDigitalProductName(String productName) {
        return productName.matches(Constant.DIGITAL_PRODUCT_REGEX);
    }

    public static int inputInt(String message) {
        int integer = 0;
        while (true) {
            try {
                System.out.print(message);
                integer = Integer.parseInt(ScannerUtil.getInstance().nextLine());
                if (isPositive(integer)) return integer;
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input! Please enter a positive integer");
            }
        }
    }
    public static double inputDouble(String message) {
        double inputNumber = 0;
        while (true) {
            try {
                System.out.print(message);
                inputNumber = Double.parseDouble(ScannerUtil.getInstance().nextLine());
                if (isPositive(inputNumber)) return inputNumber;
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input! Please enter a positive number");
            }
        }
    }
    public static String inputProductName(String message) {
        String inputString = "";
        while (true) {
            System.out.print(message);
            inputString = ScannerUtil.getInstance().nextLine();
            if (message.contains("physical product")) {
                if (isPhysicalProductName(inputString))
                    return inputString;
                else System.out.println("Invalid input! Please enter a valid physical product name (e.g. PHYSICAL - 1))");
            } else if (message.contains("digital product")) {
                if (isDigitalProductName(inputString)) return inputString;
                else System.out.println("Invalid input! Please enter a valid digital product name (e.g. DIGITAL - 1))");
            } else {
                if (isDigitalProductName(inputString)||isPhysicalProductName(inputString)) return inputString;
                else System.out.println("Invalid input! Please enter a valid product name (e.g. PHYSICAL - 1 or DIGITAL - 1))");
            }
        }
    }
    public static int inputChoice(int min, int max) {
        int integer = 0;
        while (true) {
            try {
                System.out.print("Enter your choice ("+min+"-"+max+"): ");
                integer = Integer.parseInt(ScannerUtil.getInstance().nextLine());
                if (integer >= min && integer <= max) return integer;
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input! Please enter a valid choice");
            }
        }
    }


    public static Coupon inputCode(String message, CouponService couponList) {

        String inputCode = "";
        System.out.println(message);
        System.out.println("1. PERCENT COUPON");
        System.out.println("2. PRICE COUPON");
        int choice = Validation.inputChoice(1, 2);
        switch (choice) {
            case 1:
                System.out.println("Enter the code of the coupon: ");
                inputCode = ScannerUtil.getInstance().nextLine();
                if (couponList.isCouponExisted(inputCode)) {
                    System.out.println("This code: " + inputCode + " already exists.");
                    return null;
                }

                Coupon coupon1 = new PercentCoupon(inputCode, Validation.inputInt("Enter the discount percent: "));
                couponList.getCouponList().add(coupon1);
                return coupon1;

            case 2:
                System.out.println("Enter the code of the coupon: ");
                inputCode = ScannerUtil.getInstance().nextLine();
                if (couponList.isCouponExisted(inputCode)) {
                    System.out.println("This code: " + inputCode + " already exists.");
                    return null;
                }

                Coupon coupon2 = new PriceCoupon(inputCode, Validation.inputDouble("Enter the discount price: "));
                couponList.getCouponList().add(coupon2);
                return coupon2;
            default:
                System.out.println("Invalid input! Please enter a valid choice");
        }
        return null;
    }


    public static TaxType inputTaxType(String message) {
        System.out.println(message);
        System.out.println("1. Tax-free");
        System.out.println("2. Normal tax (10%)");
        System.out.println("3. Luxury tax (20%)");
        int choice = Validation.inputChoice(1, 3);
        switch (choice) {
            case 1:
                return TaxType.TAX_FREE;
            case 2:
                return TaxType.TAX_NORMAL;
            case 3:
                return TaxType.TAX_LUXURY;
            default:
                return TaxType.TAX_FREE;
        }
    }


}

