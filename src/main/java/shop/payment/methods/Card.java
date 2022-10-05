package shop.payment.methods;

import shop.contracts.CartViewInterface;

public class Card extends Thanks {

    public Card(CartViewInterface view) {
        super(view);
    }

    @Override
    public void Pay() {
        System.out.println("Карта принята");
        super.Pay();
    }
}
