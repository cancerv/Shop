import shop.ConsoleController;
import shop.Cart;
import shop.ConsoleView;
import shop.contracts.CartInterface;
import shop.contracts.PaymentInterface;
import shop.contracts.StorageInterface;
import shop.contracts.ViewInterface;
import shop.payment.Payment;
import shop.payment.methods.CardPaymentMethod;
import shop.payment.methods.DefaultPaymentMethod;
import shop.payment.methods.ThanksPaymentMethod;
import storage.JsonStorage;

public class Main {

    public static void main(String[] args) {
        StorageInterface storage = new JsonStorage("./data/products.json");
        CartInterface cart = new Cart();
        ViewInterface view = new ConsoleView();

        PaymentInterface payment = new Payment();
        payment.addMethod("default", new DefaultPaymentMethod(view));
        payment.addMethod("card", new CardPaymentMethod(view));
        payment.addMethod("thanks", new ThanksPaymentMethod(view));

        ConsoleController controller = new ConsoleController(view, cart, storage, payment);
        controller.run();
    }
}
