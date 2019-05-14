package test.model;

public class GroceryProduct extends Product {
    public GroceryProduct() { }

    public GroceryProduct(final long id, final String title, final double price) {
        super(id, title, price);
    }

    @Override
    public double getPriceAfterDiscount(final double percent) {
        return getPrice();
    }
}
