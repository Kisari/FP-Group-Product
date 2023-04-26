package s3852307.entities;

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
