package shop.payment.methods;

import shop.contracts.CartViewInterface;

public class ThanksPaymentMethod extends DefaultPaymentMethod {
    public ThanksPaymentMethod(CartViewInterface view) {
        super(view);
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("Спасибо!");
        return super.pay(amount);
    }
}
