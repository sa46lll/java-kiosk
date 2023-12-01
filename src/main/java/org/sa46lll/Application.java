package org.sa46lll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.sa46lll.cafe.Cafe;
import org.sa46lll.cafe.TddCafe;
import org.sa46lll.kiosk.Kiosk;
import org.sa46lll.kiosk.TddKiosk;
import org.sa46lll.product.Product;

public class Application {

    public static void main(String[] args) throws IOException {
        Cafe cafe = new TddCafe();
        Kiosk kiosk = new TddKiosk(cafe);

        kiosk.run();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String selected = br.readLine();
        Product product = kiosk.selectProduct(selected);
        System.out.printf("%s는 %d원 입니다.", product.getName(), product.getPrice());

    }
}
