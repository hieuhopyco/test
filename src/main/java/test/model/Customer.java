package test.model;

import java.util.Date;

import test.util.DateTimeUtils;

public class Customer extends User {
    public Customer() { }

    public Customer(final long id, final Date registeredDate) {
        super(id, registeredDate);
    }

    @Override
    public double getPercentageDiscount() {
        return DateTimeUtils.yearDiffFromNow(getRegisteredDate()) > 2 ? 0.05 : 0;
    }
}
