public class Book extends AbstractLibraryItem {
    private String author;
    private String genre;

    public Book(
            String id,
            String title,
            String author,
            String genre
    ) throws InvalidIdException {
        super(id, title);

        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;

        return this;
    }

    public String getGenre() {
        return genre;
    }

    public Book setGenre(String genre) {
        this.genre = genre;

        return this;
    }

    @Override
    public void displayInfo() {
        System.out.printf(
                "Id: %s%nTitle: %s%nAuthor: %s%nGenre: %s%n",
                this.getId(),
                this.getTitle(),
                this.getAuthor(),
                this.getGenre()
        );
    }
}
