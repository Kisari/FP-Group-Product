package s3852307.util;

import java.util.InputMismatchException;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 * @author <Dinh Le Hong Tin - s3932134>
 * @author <Nguyen Ha Kieu Anh - s3818552>
 * @author <Truong Bach Minh - s3891909>
 */

public class Constant {
    public static double baseFee = 0.1;
    public static final String PHYSICAL_PRODUCT_REGEX = "PHYSICAL - (.*)";
    public static final String DIGITAL_PRODUCT_REGEX = "DIGITAL - (.*)";
    public static final String PHYSICAL_PRODUCT_GIFT_REGEX = "GiftPhysicalProduct - (.*)";
    public static final String DIGITAL_PRODUCT_GIFT_REGEX = "GiftDigitalProduct - (.*)";

    public static void setBaseFee() {
        double fee = 0;
        boolean valid = false;
        do {
            System.out.println("Please enter new value for base fee:");
            try {
                fee = ScannerUtil.getInstance().nextDouble();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a double number.");
                ScannerUtil.getInstance().nextLine();
            }
        } while (!valid);
        baseFee = fee;
        System.out.println("New base fee has been set to " + fee + "successfully!");
    }

    public static double getBaseFee() {
        return baseFee;
    }
}
