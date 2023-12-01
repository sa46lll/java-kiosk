package org.sa46lll;

import org.sa46lll.cafe.Cafe;
import org.sa46lll.cafe.TddCafe;
import org.sa46lll.client.Kiosk;
import org.sa46lll.client.TddKiosk;

public class Application {

    public static void main(String[] args) {
        Cafe cafe = new TddCafe();
        Kiosk kiosk = new TddKiosk(cafe);

        kiosk.run();
    }
}
