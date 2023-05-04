package s3852307.entities;

public enum TaxType {
    TAX_FREE(0),
    TAX_NORMAL(0.1),
    TAX_LUXURY(0.2);

    private double taxRate;
    public double getTaxRate() {
        return taxRate;
    }
    TaxType(double taxRate) {
        this.taxRate = taxRate;
    }

    
}
