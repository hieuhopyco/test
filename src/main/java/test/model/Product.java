package test.model;

public abstract class Product {
    private long id;
    private String title;
    private double price;

    public Product() { }

    public Product(final long id, final String title, final double price) {
        super();
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public abstract double getPriceAfterDiscount(final double percent);

    // Getter - Setter
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
}
