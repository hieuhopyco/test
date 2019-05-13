package test.application;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import test.model.Bill;
import test.model.Category;
import test.model.Product;
import test.model.User;
import test.questions.Question1;
import test.util.BillUtils;

public class MyApplication {

    public static void main(final String[] args) {
        System.out.println("Question 1. Data Store and Load\n\n");
        final String arrayInput = "key1=value1;key2=value2\nkey3=value3\nkey4=value4;key5=value5";
        System.out.println("Input:\n" + arrayInput);
        final Question1 question1 = new Question1();
        final HashMap<String, String>[] arr = question1.load(arrayInput);

        final String arrayOutput = question1.store(arr);
        System.out.println("Output:\n" + arrayOutput);


        System.out.println("Question 3\n\n");
        final Category cat1 = new Category(1, "category 1");
        final Category cat2 = new Category(2, "groceries");
        final Category cat3 = new Category(3, "category 3");

        final Product product1 = new Product(1, "Product1", 50, Arrays.asList(cat1));
        final Product product2 = new Product(2, "Product2", 20, Arrays.asList(cat2, cat3));
        final Product product3 = new Product(3, "Product3", 40, Arrays.asList(cat1, cat3));

        final List<Product> products = Arrays.asList(product1, product2, product3);

        final User customer = new User(1L, true, false, new Date());
        final Bill bill = new Bill();
        bill.setId(1);
        bill.setCustomer(customer);
        bill.setProducts(products);

        final double netAmount = BillUtils.calculateNetAmount(bill);
        System.out.println("Net amount: " + netAmount);
    }
}
