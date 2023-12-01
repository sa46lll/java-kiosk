package org.sa46lll.kiosk;

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
        System.out.println(cafe.getName() + "에 오신 것을 환영합니다.");
        System.out.println("상품을 선택해 주세요.");
        showProducts();
    }

    private void showProducts() {
        this.products.forEach(
                product -> System.out.println("- " + product.getName())
        );
        System.out.print("상품을 입력해주세요: ");
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
