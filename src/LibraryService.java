import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LibraryService {
    public void borrowItem(
            String id,
            List<AbstractLibraryItem> libraryItems
    ) throws ItemNotFoundException {
        for (AbstractLibraryItem item: libraryItems) {
            if (id.equals(item.getId())) {
                System.out.printf("Item with ID: %s found.%n", id);

                return;
            }
        }

        throw new ItemNotFoundException(
                String.format("Item with ID: %s found.", id)
        );
    }

    public List<AbstractLibraryItem> filterByKeyword(
            String keyword,
            List<AbstractLibraryItem> libraryItems
    ) {
        List<AbstractLibraryItem> matching = new ArrayList<>();

        for (AbstractLibraryItem item: libraryItems) {
            if (item.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                matching.add(item);
            }
        }

        return matching;
    }

    public List<AbstractLibraryItem> generateLibraryItems(int count) throws InvalidIdException {
        List<AbstractLibraryItem> libraryItems = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            libraryItems.add(i % 2 == 0
                    ? this.generateRandomBook()
                    : this.generateRandomMagazine()
            );
        }

        return libraryItems;
    }

    public Book generateRandomBook() throws InvalidIdException {
        Random r = new Random();
        int num = r.nextInt(10000);
        String id = "L-" + String.format("%04d", num);
        String title = "title " + num;

        return new Book(
                id,
                title,
                "Author",
                "Genre"
        );
    }

    public Magazine generateRandomMagazine() throws InvalidIdException {
        Random r = new Random();
        int num = r.nextInt(10000);
        String id = "L-" + String.format("%04d", num);
        String title = "title " + num;

        return new Magazine(
                id,
                title,
                "Issue",
                "Publisher"
        );
    }
}
