package shop;

import shop.contracts.CartInterface;
import shop.contracts.PaymentInterface;
import shop.contracts.StorageInterface;
import shop.contracts.ViewInterface;

import java.util.List;
import java.util.Scanner;

public class ConsoleController {
    private final ViewInterface view;
    private final CartInterface cart;
    private final StorageInterface storage;
    private final PaymentInterface payment;
    private final Scanner scanner;

    public ConsoleController(ViewInterface view, CartInterface cart, StorageInterface storage, PaymentInterface payment) {
        this.view = view;
        this.cart = cart;
        this.storage = storage;
        this.payment = payment;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println(this.view.greeting());
        while (true) {
            System.out.println(this.view.showMenu());
            int action = this.scanner.nextInt();
            if (action == 0) {
                return;
            }

            switch (action) {
                case 1:
                    this.productsListAction();
                    break;
                case 2:
                    this.productAction();
                    break;
                case 3:
                    this.cartAction();
                    break;
                default:
                    System.out.println("Нет такого пункта");
            }
            System.out.println();
        }
    }

    public void productsListAction() {
        System.out.println(this.view.productsList(this.storage.getProductList()));
    }

    public void productAction() {
        System.out.println(this.view.requestProductId());
        int productId = this.scanner.nextInt();
        if (productId != 0) {
            try {
                Product product = this.storage.getProduct(productId);
                System.out.println(this.view.showProduct(product));
                System.out.println(this.view.requestProductAction());
                int productAction = this.scanner.nextInt();
                if (productAction == 1) {
                    System.out.println(this.view.requestProductAmount());
                    int amount = this.scanner.nextInt();
                    this.cart.addProduct(product, amount);
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void cartAction() {
        List<CartItem> cartItems = this.cart.getItems();
        System.out.println(this.view.showCartItems(cartItems));
        if (!cartItems.isEmpty()) {
            System.out.println(this.view.requestCartAction());
            int cartAction = this.scanner.nextInt();
            if (cartAction == 1) {
                if (this.payment.pay("card", this.cart.getTotal())) {
                    this.cart.clear();
                }
            }
            if (cartAction == 2) {
                if (this.payment.pay("thanks", this.cart.getTotal())) {
                    this.cart.clear();
                }
            }

            if (cartAction == 3) {
                System.out.println(this.view.requestCartDeleteProductIdx());
                int deleteIdx = this.scanner.nextInt();
                if (deleteIdx > 0) {
                    this.cart.deleteItem(deleteIdx - 1);
                }
            }
        } else {
            System.out.println(this.view.showCartEmpty());
        }
    }
}
