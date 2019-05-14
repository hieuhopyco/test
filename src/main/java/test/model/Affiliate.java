package test.model;

import java.util.Date;

public class Affiliate extends User {
    public Affiliate() { }

    public Affiliate(final long id, final Date registeredDate) {
        super(id, registeredDate);
    }

    @Override
    public double getPercentageDiscount() {
        return 0.1;
    }
}
