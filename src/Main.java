import java.util.List;

public class Main {
    public static void main(String[] args) throws ItemNotFoundException, InvalidIdException {
        LibraryService service = new LibraryService();

        List<AbstractLibraryItem> libraryItems = service.generateLibraryItems(20);
        System.out.println("Displaying info");

        for (AbstractLibraryItem item: libraryItems) {
            item.displayInfo();
            System.out.println("===================");
        }

        // Borrow item with existing ID
        System.out.println("Borrowing item");
        String id1 = libraryItems.get(0).getId();
        service.borrowItem(id1, libraryItems);
        System.out.println("===================");

         // Borrow item with non-existing ID
        try {
            System.out.println("Borrowing item with non-existing ID");
            String id2 = "123456";
            service.borrowItem(id2, libraryItems);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("===================");

        // Search by keyword
        System.out.println("Searching by keyword");
        String keyword1 = "Title 1";
        List<AbstractLibraryItem> filtered = service.filterByKeyword(keyword1, libraryItems);
        System.out.printf("Total items count: %d%n", libraryItems.size());
        System.out.printf("Filtered items count: %d%n", filtered.size());
        System.out.println("===================");

        // Create item with invalid ID
        try {
            System.out.println("Creating a book with invalid ID");
            new Book("test-id", "Title", "Author", "Genre");
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        }
    }
}