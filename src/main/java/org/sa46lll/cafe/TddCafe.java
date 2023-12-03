package org.sa46lll.cafe;

import java.util.Optional;
import org.sa46lll.order.Order;
import org.sa46lll.product.Product;

public class TddCafe implements Cafe {

    @Override
    public Optional<Order> order(Product product, int quantity, Enum<?> size) {
        return Optional.of(
                new Order(product, quantity, size)
        );
    }
}
