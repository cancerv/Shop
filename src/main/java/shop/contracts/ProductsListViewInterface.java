package shop.contracts;

import shop.Product;

import java.util.List;

public interface ProductsListViewInterface {
    public String productsList(List<Product> products);
}
