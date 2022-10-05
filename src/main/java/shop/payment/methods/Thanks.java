package shop.payment.methods;

import shop.contracts.CartViewInterface;

public class Thanks {
    protected CartViewInterface view;
    public Thanks(CartViewInterface view) {
        this.view = view;
    }

    public void Pay() {
        System.out.println(this.view.showPaidMessage());
    }
}
