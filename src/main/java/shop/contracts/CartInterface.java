package shop.contracts;

import shop.CartItem;
import shop.Product;

import java.util.List;

public interface CartInterface {
    public void addProduct(Product product, int amount);

    public List<CartItem> getItems();

    public int getTotal();

    public void deleteItem(int idx);

    public void clear();
}
