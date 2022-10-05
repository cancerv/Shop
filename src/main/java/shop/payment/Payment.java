package shop.payment;

import shop.contracts.PaymentInterface;
import shop.contracts.PaymentMethodInterface;

import java.util.HashMap;
import java.util.Map;

public class Payment implements PaymentInterface {
    private Map<String, PaymentMethodInterface> methods = new HashMap<>();

    @Override
    public void addMethod(String name, PaymentMethodInterface method) {
        this.methods.put(name, method);
    }

    @Override
    public boolean pay(String method, int amount) {
        return this.methods.get(method).pay(amount);
    }
}
