package shop.contracts;

public interface PaymentInterface {
    public void addMethod(String name, PaymentMethodInterface method);

    public boolean pay(String method, int amount);
}
