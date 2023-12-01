package org.sa46lll.kiosk;

import static org.sa46lll.client.InputView.askOrder;
import static org.sa46lll.client.OutputView.printProducts;
import static org.sa46lll.client.OutputView.printSelectedInfo;
import static org.sa46lll.client.OutputView.printWelcomeMessage;

import java.util.List;
import org.sa46lll.cafe.Cafe;
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
        printWelcomeMessage(cafe.getName());
        printProducts(products);
        String order = askOrder();
        Product product = selectProduct(order);
        printSelectedInfo(product);
    }

    @Override
    public Product selectProduct(String name) {
        if (name == null) {
            throw new IllegalArgumentException("메뉴를 입력해 주세요.");
        }
        return this.products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));
    }

    private List<Product> loadProducts() {
        return List.of(
                new Product("아메리카노", 4000),
                new Product("카페라떼", 4500),
                new Product("에스프레소", 3500)
        );
    }
}
