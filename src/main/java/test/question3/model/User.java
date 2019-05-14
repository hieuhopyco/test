package test.question3.model;

import java.util.Date;

public abstract class User {
    private long id;
    private Date registeredDate;

    public User() { }

    public User(final long id, final Date registeredDate) {
        this.id = id;
        this.registeredDate = registeredDate;
    }

    public abstract double getPercentageDiscount();

    // Getter - Setter
    public Date getRegisteredDate() {
        return registeredDate;
    }
    public void setRegisteredDate(final Date registeredDate) {
        this.registeredDate = registeredDate;
    }
    public long getId() {
        return id;
    }
    public void setId(final long id) {
        this.id = id;
    }
}
