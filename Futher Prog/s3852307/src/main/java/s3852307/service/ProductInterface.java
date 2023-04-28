package s3852307.service;
/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */

public interface ProductInterface {
    void createProduct(String type);
    void updateProduct() ;
    void deleteProduct();
    void streamProduct();
}

