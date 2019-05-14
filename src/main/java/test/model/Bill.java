package test.model;

import java.util.List;

public class Bill {
    private long id;
    private User customer;
    private List<Product> products;

    public double calculateNetAmount() {
        final double percentDiscount = customer.getPercentageDiscount();

        final double totalBillAmountAfterPercentDiscount = products.stream().mapToDouble(o -> o.getPriceAfterDiscount(percentDiscount)).sum();
        final double amountBaseDiscount = (int) totalBillAmountAfterPercentDiscount / 100 * 5;

        System.out.println("totalBillAmountAfterPercentDiscount: " + totalBillAmountAfterPercentDiscount);
        System.out.println("amountBaseDiscount: " + amountBaseDiscount);

        return totalBillAmountAfterPercentDiscount - amountBaseDiscount;
    }

    //Getter - Setter
    public long getId() {
        return id;
    }
    public void setId(final long id) {
        this.id = id;
    }
    public User getCustomer() {
        return customer;
    }
    public void setCustomer(final User customer) {
        this.customer = customer;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(final List<Product> products) {
        this.products = products;
    }
}
