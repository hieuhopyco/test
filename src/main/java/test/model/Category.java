package test.model;

public class Category {
    private long id;
    private String title;

    public Category() { }

    public Category(final long id, final String title) {
        super();
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }
    public void setId(final long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(final String title) {
        this.title = title;
    }
}
