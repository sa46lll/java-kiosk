package org.sa46lll.cafe;

public abstract class Cafe {

    private String name;

    protected Cafe(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
