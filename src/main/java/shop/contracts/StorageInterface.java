package shop.contracts;

import shop.Product;

import java.util.List;

public interface StorageInterface {
    public List<Product> getProductList();

    public Product getProduct(int id);
}
