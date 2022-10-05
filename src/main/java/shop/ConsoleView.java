package shop;

import shop.contracts.ViewInterface;

import java.util.List;

public class ConsoleView implements ViewInterface {
    @Override
    public String greeting() {
        return "Добро пожаловать в наш клевый магазин!\n";
    }

    @Override
    public String showMenu() {
        return new StringBuilder()
                .append("1 - Список товаров\n")
                .append("2 - Посмотреть товар\n")
                .append("3 - Корзина\n")
                .append("0 - Выход\n")
                .toString();
    }

    @Override
    public String productsList(List<Product> products) {
        StringBuilder builder = new StringBuilder();

        if (!products.isEmpty()) {
            for (Product product : products) {
                builder
                        .append(product.getId())
                        .append(" - ")
                        .append(product.getTitle())
                        .append(" ")
                        .append(product.getPrice())
                        .append("р.\n");
            }
        } else {
            builder.append("Нет продуктов\n");
        }

        return builder.toString();
    }

    @Override
    public String requestProductId() {
        return new StringBuilder()
                .append("Введите идентификатор продукта. 0 - для отмены.")
                .toString();
    }

    @Override
    public String showProduct(Product product) {
        return new StringBuilder()
                .append("ID: ").append(product.getId()).append("\n")
                .append("Title: ").append(product.getTitle()).append("\n")
                .append("Price: ").append(product.getPrice()).append("\n")
                .append("Description: ").append(product.getDescription()).append("\n")
                .append("Image: ").append(product.getImage()).append("\n\n")
                .toString();
    }

    @Override
    public String requestProductAction() {
        return new StringBuilder()
                .append("1 - Добавить в корзину\n")
                .append("0 - Назад\n")
                .toString();
    }

    @Override
    public String requestProductAmount() {
        return "Введите количество";
    }

    @Override
    public String showCartItems(List<CartItem> cartItems) {
        StringBuilder builder = new StringBuilder();
        for (int idx = 0; idx < cartItems.size(); idx++) {
            CartItem item = cartItems.get(idx);
            Product product = item.getProduct();
            builder
                    .append(idx + 1)
                    .append(" - ")
                    .append(product.getTitle())
                    .append(" ")
                    .append(product.getPrice())
                    .append(" ")
                    .append(item.getAmount())
                    .append(" = ")
                    .append(item.getAmount() * product.getPrice())
                    .append("\n");
        }
        return builder.toString();
    }

    @Override
    public String showCartEmpty() {
        return "Корзина пуста";
    }

    @Override
    public String requestCartAction() {
        return new StringBuilder()
                .append("1 - Оплатить картой\n")
                .append("2 - Оплатить Спасибо\n")
                .append("3 - Удалить товар\n")
                .append("0 - Назад\n")
                .toString();
    }

    @Override
    public String showPaidMessage() {
        return "Заказ оплачен!";
    }

    @Override
    public String requestCartDeleteProductIdx() {
        return new StringBuilder()
                .append("Введите идентификатор продукта. 0 - для отмены.")
                .toString();
    }
}
