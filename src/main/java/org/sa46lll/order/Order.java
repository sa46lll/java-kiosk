package org.sa46lll.order;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;
import org.sa46lll.product.Product;

public class Order {

    private static final AtomicLong index = new AtomicLong(1L);

    private Long orderNumber;
    private Product product;
    private int quantity;
    private Enum<?> size;
    private int totalPrice;
    private LocalDateTime createdAt;

    public Order(Product product, int quantity, Enum<?> size) {
        this.orderNumber = index.getAndIncrement();
        this.product = product;
        this.quantity = quantity;
        this.size = size;
        this.totalPrice = product.getPrice() * quantity;
        this.createdAt = LocalDateTime.now();
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Enum<?> getSize() {
        return size;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
