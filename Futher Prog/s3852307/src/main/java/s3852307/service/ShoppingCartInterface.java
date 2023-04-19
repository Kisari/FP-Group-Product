package s3852307.service;

/**
 * @author <Nguyen Ha Minh Duy - s3852307>
 */
import java.util.Set;

public interface ShoppingCartInterface {
    boolean addItem(Set<String> items, String productName);

    void removeItem(Set<String> items, String productName);

    Number[] cartAmount(Set<String> items);
}