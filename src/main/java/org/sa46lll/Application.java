package org.sa46lll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.sa46lll.cafe.Cafe;
import org.sa46lll.cafe.TddCafe;
import org.sa46lll.kiosk.Kiosk;
import org.sa46lll.kiosk.TddKiosk;

public class Application {

    public static void main(String[] args) {
        Cafe cafe = new TddCafe();
        Kiosk kiosk = new TddKiosk(cafe);

        kiosk.run();
    }
}
