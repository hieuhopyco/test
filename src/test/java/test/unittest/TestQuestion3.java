package test.unittest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import test.model.Bill;
import test.model.Category;
import test.model.Product;
import test.model.User;
import test.util.BillUtils;

public class TestQuestion3 {
    @Test
    public void testCase1() {
        final Category cat1 = new Category(1, "category 1");
        // This is "groceries"
        final Category cat2 = new Category(2, "groceries");
        final Category cat3 = new Category(3, "category 3");

        final Product product1 = new Product(1, "Product1", 70, Arrays.asList(cat1));
        // product2 will not applied percentage discount
        final Product product2 = new Product(2, "Product2", 40, Arrays.asList(cat2, cat3));
        final Product product3 = new Product(3, "Product3", 80, Arrays.asList(cat1, cat3));

        final List<Product> products = Arrays.asList(product1, product2, product3);

        final User customer = new User(1L, true, false, new Date());
        final Bill bill = new Bill();
        bill.setId(1);
        bill.setCustomer(customer);
        bill.setProducts(products);

        final double netAmount = BillUtils.calculateNetAmount(bill);
        assertEquals(140, netAmount, 0.001);
    }
}
