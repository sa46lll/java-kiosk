package org.sa46lll.cafe;

import java.util.Optional;
import org.sa46lll.order.Order;
import org.sa46lll.product.Product;

public interface Cafe {

    Optional<Order> order(Product product, int quantity, Enum<?> size);
}
