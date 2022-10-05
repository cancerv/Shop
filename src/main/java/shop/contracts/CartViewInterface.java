package shop.contracts;

import shop.CartItem;

import java.util.List;

public interface CartViewInterface {
    public String showCartItems(List<CartItem> cartItems);

    public String showCartEmpty();

    public String requestCartAction();

    public String showPaidMessage();

    public String requestCartDeleteProductIdx();
}
