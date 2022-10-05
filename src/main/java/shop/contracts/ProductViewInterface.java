package shop.contracts;

import shop.Product;

public interface ProductViewInterface {
    public String requestProductId();

    public String showProduct(Product product);

    public String requestProductAction();

    public String requestProductAmount();
}
