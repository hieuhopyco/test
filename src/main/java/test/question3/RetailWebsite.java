package test.question3;

import test.question3.model.Bill;

public class RetailWebsite {
    public double calculateBillAmount(final Bill bill) {
        return bill.calculateNetAmount();
    }
}
