package org.sa46lll.kiosk;

import org.sa46lll.product.Product;

public interface Kiosk {

    void run();

    Product selectProduct(String menu);
}
