package org.sa46lll.product;

public class Product {

    private String name;
    private int price;
    private Enum<?> size;

    public Product(String name, int price, Enum<?> size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public Enum<?> getSize() {
        return this.size;
    }
}
