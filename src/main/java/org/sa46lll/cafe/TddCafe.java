package org.sa46lll.cafe;

import org.sa46lll.order.Order;
import org.sa46lll.product.CoffeeSize;
import org.sa46lll.product.Product;

public class TddCafe implements Cafe {

    @Override
    public Order order(Product product, int quantity, CoffeeSize size) {
        return new Order(product, quantity, size);
    }
}
