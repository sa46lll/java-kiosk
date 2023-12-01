package org.sa46lll.client;

import org.sa46lll.product.Product;

public interface Kiosk {

    void run();

    Product selectProduct(String menu);
}
