package shop.payment.methods;

import shop.contracts.CartViewInterface;

public class CardPaymentMethod extends DefaultPaymentMethod {

    private static final int MAX_AMOUNT = 1000;

    public CardPaymentMethod(CartViewInterface view) {
        super(view);
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("Карта принята");
        if (amount < MAX_AMOUNT) {
            return super.pay(amount);
        } else {
            System.out.println("Недостаточно средств");
            return false;
        }
    }
}
