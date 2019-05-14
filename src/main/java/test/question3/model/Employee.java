package test.question3.model;

import java.util.Date;

public class Employee extends User {
    public Employee() { }

    public Employee(final long id, final Date registeredDate) {
        super(id, registeredDate);
    }

    @Override
    public double getPercentageDiscount() {
        return 0.3;
    }
}
