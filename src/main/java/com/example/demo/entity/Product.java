package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Product {

    private Long id;

    private String name;

    private String sku;

    private double price;
    @Id//chi dinh id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//khoa tu tang
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(Long id, String name, String sku, double price) {
        super();
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.price = price;
    }

    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

}
