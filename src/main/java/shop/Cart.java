package shop;

import shop.contracts.CartInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart implements CartInterface {
    private final List<CartItem> items = new ArrayList<>();

    @Override
    public void addProduct(Product product, int amount) {
        Optional<CartItem> itemInCart = this.items.stream()
                .filter(item -> item.getProduct().getId() == product.getId())
                .findFirst();

        if (!itemInCart.isEmpty()) {
            itemInCart.get().setAmount(amount + itemInCart.get().getAmount());
        } else {
            this.items.add(new CartItem(product, amount));
        }
    }

    @Override
    public void deleteItem(int idx) {
        if (idx < this.items.size()) {
            this.items.remove(idx);
        }
    }

    @Override
    public List<CartItem> getItems() {
        return this.items;
    }

    @Override
    public int getTotal() {
        int total = 0;
        for (CartItem item : this.items) {
            total += item.getProduct().getPrice() * item.getAmount();
        }
        return total;
    }

    @Override
    public void clear() {
        this.items.clear();
    }
}
