package org.sa46lll.client;

import java.util.Scanner;

public class InputView {

    private static final String ORDER_SELECTION_MESSAGE = "주문할 상품을 선택하세요: ";

    private static final Scanner scanner = new Scanner(System.in);

    static String askOrder() {
        System.out.print(ORDER_SELECTION_MESSAGE);
        return scanner.nextLine();
    }
}
