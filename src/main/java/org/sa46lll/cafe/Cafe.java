package org.sa46lll.cafe;

import org.sa46lll.order.Order;
import org.sa46lll.product.CoffeeSize;
import org.sa46lll.product.Product;

public interface Cafe {

    Order order(Product product, int quantity, CoffeeSize size);
}
