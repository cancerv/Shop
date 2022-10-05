import shop.ConsoleController;
import shop.Cart;
import shop.ConsoleView;
import shop.contracts.CartInterface;
import shop.contracts.StorageInterface;
import shop.contracts.ViewInterface;
import storage.JsonStorage;

public class Main {

    public static void main(String[] args) {
        StorageInterface storage = new JsonStorage("./data/products.json");
        CartInterface cart = new Cart();
        ViewInterface view = new ConsoleView();

        ConsoleController controller = new ConsoleController(view, cart, storage);
        controller.run();
    }
}
