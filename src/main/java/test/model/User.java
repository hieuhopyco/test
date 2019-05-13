package test.model;

import java.util.Date;

public class User {
    private long id;
    private boolean employee;
    private boolean affiliate;
    private Date registeredDate;

    public User() {
    }

    public User(final long id, final boolean employee, final boolean affiliate, final Date registeredDate) {
        super();
        this.id = id;
        this.employee = employee;
        this.affiliate = affiliate;
        this.registeredDate = registeredDate;
    }

    public boolean isEmployee() {
        return employee;
    }
    public void setEmployee(final boolean employee) {
        this.employee = employee;
    }
    public boolean isAffiliate() {
        return affiliate;
    }
    public void setAffiliate(final boolean affiliate) {
        this.affiliate = affiliate;
    }
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
