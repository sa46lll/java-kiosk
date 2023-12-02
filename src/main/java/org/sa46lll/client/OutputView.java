package org.sa46lll.client;

import java.util.List;
import org.sa46lll.product.Product;

public class OutputView {

    private static final String WELCOME_MESSAGE = "환영합니다! 주문을 시작해볼까요?";
    private static final String ORDER_COMPLETED_MESSAGE = "주문이 성공적으로 완료되었습니다, 주문 번호는 %d입니다. 감사합니다!\n";


    static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    static void printProducts(List<Product> products) {
        products.forEach(
                product -> System.out.println("- " + product.getName())
        );
    }

    static void printOrderCompleted(Long orderNumber) {
        System.out.printf(ORDER_COMPLETED_MESSAGE, orderNumber);
    }
}
