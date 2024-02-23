package com.example.springbootquiz.product;

public class Product {
    private Long id;
    private String name;
    private String description;
    private String category;
    private String creation_date;

    public Product() {

    }

    public Product(Long id, String name, String description, String category, String creation_date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.creation_date = creation_date;
    }

    public Product(String name, String description, String category, String creation_date) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.creation_date = creation_date;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description=" + description +
                ", category='" + category + '\'' +
                ", creation_date='" + creation_date + '\'' +
                '}';
    }
}
