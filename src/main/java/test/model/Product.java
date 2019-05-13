package test.model;

import java.util.List;

public class Product {
    private long id;
    private String title;
    private double price;
    private List<Category> categories;

    public Product() { }

    public Product(final long id, final String title, final double price, final List<Category> categories) {
        super();
        this.id = id;
        this.title = title;
        this.price = price;
        this.categories = categories;
    }

    public long getId() {
        return id;
    }
    public void setId(final long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(final String title) {
        this.title = title;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(final double price) {
        this.price = price;
    }
    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(final List<Category> categories) {
        this.categories = categories;
    }
}
