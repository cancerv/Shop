package storage;

import com.google.gson.Gson;
import shop.Product;
import shop.contracts.StorageInterface;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class JsonStorage implements StorageInterface {
    private final String storageFilename;
    private List<Product> products = new ArrayList<>();

    public JsonStorage(String filename) {
        this.storageFilename = filename;
    }

    @Override
    public List<Product> getProductList() {
        if (products.isEmpty()) {
            Gson gson = new Gson();
            try (Reader reader = new FileReader(this.storageFilename)) {
                Product[] staff = gson.fromJson(reader, Product[].class);
                this.products = Arrays.stream(staff).toList();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return new ArrayList<>();
            }
        }

        return this.products;
    }

    @Override
    public Product getProduct(int id) throws RuntimeException {
        Optional<Product> product = this.getProductList()
                .stream()
                .filter((Product prod) -> prod.getId() == id)
                .findFirst();

        if (product.isEmpty()) {
            throw new RuntimeException("Нет продукта с таким идентификатором");
        }

        return product.get();
    }
}
