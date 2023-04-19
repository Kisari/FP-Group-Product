package s3852307.util;

import s3852307.entities.TaxType;

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
                if (isPositive(integer))
                    return integer;
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
                if (isPositive(inputNumber))
                    return inputNumber;
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
                else
                    System.out
                            .println("Invalid input! Please enter a valid physical product name (e.g. PHYSICAL - 1))");
            } else if (message.contains("digital product")) {
                if (isDigitalProductName(inputString))
                    return inputString;
                else
                    System.out.println("Invalid input! Please enter a valid digital product name (e.g. DIGITAL - 1))");
            } else {
                if (isDigitalProductName(inputString) || isPhysicalProductName(inputString))
                    return inputString;
                else
                    System.out.println(
                            "Invalid input! Please enter a valid product name (e.g. PHYSICAL - 1 or DIGITAL - 1))");
            }
        }
    }

    public static int inputChoice(int min, int max) {
        int integer = 0;
        while (true) {
            try {
                System.out.print("Enter your choice (" + min + "-" + max + "): ");
                integer = Integer.parseInt(ScannerUtil.getInstance().nextLine());
                if (integer >= min && integer <= max)
                    return integer;
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input! Please enter a valid choice");
            }
        }
    }

    // public static TaxType inputTaxType() {
    // int choice = Validation.inputChoice(1, TaxType.values().length);
    // return TaxType.values()[choice-1];
    // }

    public static TaxType inputTaxType(String message) {
        System.out.println(message);
        System.out.println("1. Tax-free");
        System.out.println("2. NORMAL TAX (10%)");
        System.out.println("3. LUXURY_TAX (20%)");
        int choice = Validation.inputChoice(1, 3);
        switch (choice) {
            case 1:
                return TaxType.TAX_FREE;
            case 2:
                return TaxType.NORMAL_TAX;
            case 3:
                return TaxType.LUXURY_TAX;
            default:
                return TaxType.TAX_FREE;
        }
    }

    public static void printDelimiter() {
        System.out.println("|=========================|");
    }

}
