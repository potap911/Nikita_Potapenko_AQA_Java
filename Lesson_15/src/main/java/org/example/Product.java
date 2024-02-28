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
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        System.out.println(name);
        System.out.println(product.getName());
        System.out.println(price);
        System.out.println(product.getPrice());
        System.out.println("----------");
        return name.equals(product.getName()) && price.equals(product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
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
