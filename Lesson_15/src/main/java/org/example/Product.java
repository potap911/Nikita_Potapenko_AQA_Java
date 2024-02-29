package org.example;

import java.util.Objects;

public class Product implements Comparable<Product>{
    private String name;
    private String price;

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.getName()) && price.equals(product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "name: " + name + " | price: " + price;
    }

    @Override
    public int compareTo(Product o) {
        return this.name.compareTo(o.getName());
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
