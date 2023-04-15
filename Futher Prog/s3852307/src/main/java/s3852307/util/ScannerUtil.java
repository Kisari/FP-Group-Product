package s3852307.util;
/**
 * @author <Nguyen Ha Minh Duy - s3852307>
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
