package org.example.session05.common;


public class Dish {
    private Long id;
    private String name;
    private Double price;
    private Boolean isAvailable;

    public Dish(Long id, String name, Double price, Boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getPrice() { return price; }
    public Boolean getIsAvailable() { return isAvailable; }
}