package s3852307.service;
/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 * @author <Dinh Le Hong Tin - s3932134>
 * @author <Nguyen Ha Kieu Anh - s3818552>
 * @author <Truong Bach Minh - s3891909>
 */

public interface ProductInterface {
    void createProduct(String type);
    void updateProduct() ;
    void deleteProduct();
    void streamProduct();
}

