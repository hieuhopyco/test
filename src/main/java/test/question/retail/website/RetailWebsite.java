package test.question.retail.website;

import test.model.Bill;

public class RetailWebsite {
    public double calculateBillAmount(final Bill bill) {
        return bill.calculateNetAmount();
    }
}
