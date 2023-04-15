package s3852307.service;
/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */
import s3852307.entities.PhysicalProduct;
import s3852307.entities.Product;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ProductServiceTest {

    @org.junit.jupiter.api.Test
    void isProductExistWhenNothingInTheProductList() {
        assertEquals(null,ProductService.isProductExist("PHYSICAL - 1"));
    }
    @org.junit.jupiter.api.Test
    void isProductExistTrue() {
        ProductService.addTempProduct();
        Product product = ProductService.isProductExist("PHYSICAL - 1");
        assertEquals("PHYSICAL - 1",product.getName());
    }
}