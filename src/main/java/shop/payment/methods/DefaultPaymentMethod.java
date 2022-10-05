package shop.payment.methods;

import shop.contracts.CartViewInterface;
import shop.contracts.PaymentMethodInterface;

public class DefaultPaymentMethod implements PaymentMethodInterface {
    private final CartViewInterface view;

    public DefaultPaymentMethod(CartViewInterface view) {
        this.view = view;
    }

    @Override
    public boolean pay(int amount) {
        System.out.println(this.view.showPaidMessage());
        return true;
    }
}
