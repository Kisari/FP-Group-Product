package s3852307.entities;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 * @author <Dinh Le Hong Tin - s3932134>
 * @author <Nguyen Ha Kieu Anh - s3818552>
 * @author <Truong Bach Minh - s3891909>
 */

public enum TaxType {
    TAX_FREE(0),
    NORMAL_TAX(0.1),
    LUXURY_TAX(0.2);

    private double taxRate;

    TaxType(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTaxRate() {
        return taxRate;
    }

    
}
