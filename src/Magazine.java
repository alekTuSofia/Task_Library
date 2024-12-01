public class Magazine extends AbstractLibraryItem {
    public String issue;
    public String publisher;

    public Magazine(
            String id,
            String title,
            String issue,
            String publisher
    ) throws InvalidIdException {
        super(id, title);

        this.issue = issue;
        this.publisher = publisher;
    }

    public String getIssue() {
        return issue;
    }

    public Magazine setIssue(String issue) {
        this.issue = issue;

        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public Magazine setPublisher(String publisher) {
        this.publisher = publisher;

        return this;
    }

    @Override
    public void displayInfo() {
        System.out.printf(
                "Id: %s%nTitle: %s%nIssue: %s%nPublisher: %s%n",
                this.getId(),
                this.getTitle(),
                this.getIssue(),
                this.getPublisher()
        );
    }
}
