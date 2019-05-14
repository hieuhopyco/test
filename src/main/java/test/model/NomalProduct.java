package test.model;

public class NomalProduct extends Product{

    public NomalProduct() { }

    public NomalProduct(final long id, final String title, final double price) {
        super(id, title, price);
    }

    @Override
    public double getPriceAfterDiscount(final double percent) {
        return getPrice()  * (1 - percent);
    }
}
