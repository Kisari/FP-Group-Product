package s3852307.util;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 * @author <Dinh Le Hong Tin - s3932134>
 * @author <Nguyen Ha Kieu Anh - s3818552>
 * @author <Truong Bach Minh - s3891909>
 */

import java.util.Scanner;

public class ScannerUtil {
    private static Scanner scanner;
    private ScannerUtil() {}
    public static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
