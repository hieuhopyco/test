package test.unittest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import test.question3.RetailWebsite;
import test.question3.model.Affiliate;
import test.question3.model.Bill;
import test.question3.model.Customer;
import test.question3.model.Employee;
import test.question3.model.GroceryProduct;
import test.question3.model.NomalProduct;
import test.question3.model.Product;
import test.question3.model.User;

public class RetailWebsiteTest {
    private List<Product> products;
    private Bill bill;

    @Before
    public void prepareProductList() {
        final NomalProduct product1 = new NomalProduct(1, "Product1", 70);
        final GroceryProduct grocery = new GroceryProduct(2, "Grocery", 40);
        final NomalProduct product3 = new NomalProduct(3, "Product3", 80);

        products = Arrays.asList(product1, grocery, product3);

        bill = new Bill();
        bill.setId(1);
        bill.setProducts(products);
        bill.setCustomer(new Customer(1, new Date()));
    }

    @Test
    public void testCalculateNetAmountWithEmployee() {
        final User customer = new Employee(1, new Date());
        bill.setCustomer(customer);

        final RetailWebsite website = new RetailWebsite();
        final double netAmount = website.calculateBillAmount(bill);
        assertEquals(140, netAmount, 0.001);
    }

    @Test
    public void testCalculateNetAmountWithAffiliate() {
        final User customer = new Affiliate(1, new Date());
        bill.setCustomer(customer);

        final RetailWebsite website = new RetailWebsite();
        final double netAmount = website.calculateBillAmount(bill);
        assertEquals(170, netAmount, 0.001);
    }

    @Test
    public void testCalculateNetAmountWithCustomer() {
        final User customer = new Customer(1, new Date());
        bill.setCustomer(customer);

        final RetailWebsite website = new RetailWebsite();
        final double netAmount = website.calculateBillAmount(bill);
        assertEquals(185, netAmount, 0.001);
    }

    @Test
    public void testCalculateNetAmountWithLoyaltyCustomer() {
        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 3);

        //This user has been customer for 3 years
        final User customer = new Customer(1, cal.getTime());
        bill.setCustomer(customer);

        final RetailWebsite website = new RetailWebsite();
        final double netAmount = website.calculateBillAmount(bill);
        assertEquals(177.5, netAmount, 0.001);
    }
}
