public abstract class AbstractLibraryItem {
    private String id;
    private String title;

    public AbstractLibraryItem(
            String id,
            String title
    ) throws InvalidIdException {
        this.validateId(id);
        this.id = id;
        this.title = title.substring(0, 1).toUpperCase() + title.substring(1);
    }

    public String getId() {
        return id;
    }

    public AbstractLibraryItem setId(String id) {
        this.id = id;

        return this;
    }

    public String getTitle() {
        return title;
    }

    public AbstractLibraryItem setTitle(String title) {
        this.title = title;

        return this;
    }

    public abstract void displayInfo();

    public void validateId(String id) throws InvalidIdException {
        if (!id.matches("L-\\d{4}")) {
            throw new InvalidIdException(String.format("Invalid ID: %s. Expected ID format L-1234", id));
        }
    }
}
