package org.sa46lll.client;

import java.util.List;
import org.sa46lll.product.Product;

public class OutputView {

    private static final String WELCOME_MESSAGE = "환영합니다! 주문을 시작해볼까요?";
    private static final String SELECTED_INFO_MESSAGE = "%s는 %d원 입니다.";

    static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    static void printProducts(List<Product> products) {
        products.forEach(
                product -> System.out.println("- " + product.getName())
        );
    }

    static void printSelectedInfo(Product product) {
        System.out.printf(SELECTED_INFO_MESSAGE, product.getName(), product.getPrice());
    }
}
