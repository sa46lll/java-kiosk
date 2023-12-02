package org.sa46lll.client;

import java.util.List;
import org.sa46lll.cafe.Cafe;
import org.sa46lll.product.CoffeeSize;
import org.sa46lll.product.Product;

public class TddKiosk implements Kiosk {

    private Cafe cafe;
    private List<Product> products;

    public TddKiosk(Cafe cafe) {
        this.cafe = cafe;
        this.products = loadProducts();
    }

    @Override
    public void run() {
        printStartMessage();
        Product product = askOrder();
        OutputView.printSelectedInfo(product);
        order(product, 4, CoffeeSize.TALL);
    }

    private void printStartMessage() {
        OutputView.printWelcomeMessage();
        OutputView.printProducts(products);
    }

    private Product askOrder() {
        String order = InputView.askOrder();
        return mapToProduct(order);
    }

    @Override
    public Product mapToProduct(String product) {
        validate(product);
        return this.products.stream()
                .filter(p -> p.getName().equals(product))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));
    }

    private static void validate(String name) {
        if (name == null) {
            throw new IllegalArgumentException("메뉴를 입력해 주세요.");
        }
    }

    private void order(Product product, int quantity, CoffeeSize size) {
        cafe.order(product, quantity, size);
        OutputView.printOrderCompleted();
    }

    private List<Product> loadProducts() {
        return List.of(
                new Product("아메리카노", 4000),
                new Product("카페라떼", 4500),
                new Product("에스프레소", 3500)
        );
    }
}
