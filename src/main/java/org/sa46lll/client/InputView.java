package org.sa46lll.client;

import java.util.Scanner;
import org.sa46lll.product.Product;

public class InputView {

    private static final String ORDER_SELECTION_MESSAGE = "주문할 상품을 선택하세요: ";
    private static final String ORDER_CONFIRMATION_MESSAGE = "%s는 %d원 입니다. 결제하시겠습니까? (y/n) ";
    private static final String ORDER_RECONFIRMATION_MESSAGE = "올바른 입력이 아닙니다. 다시 입력해주세요. (y/n) ";
    private static final String CONTINUE_MESSAGE = "계속 주문하시겠습니까? (y/n) ";

    private static final Scanner scanner = new Scanner(System.in);

    static String askOrder() {
        System.out.print(ORDER_SELECTION_MESSAGE);
        return scanner.nextLine();
    }

    static boolean askOrderConfirmation(Product product) {
        System.out.printf(ORDER_CONFIRMATION_MESSAGE, product.getName(), product.getPrice());
        String answer = scanner.nextLine();
        validate(answer);
        return answer.equals("y");
    }

    private static void validate(String answer) {
        while (!"y".equals(answer) && !"n".equals(answer)) {
            System.out.print(ORDER_RECONFIRMATION_MESSAGE);
            answer = scanner.nextLine();
        }
    }

    static boolean askContinue() {
        System.out.print(CONTINUE_MESSAGE);
        String answer = scanner.nextLine();
        validate(answer);
        return answer.equals("y");
    }
}
