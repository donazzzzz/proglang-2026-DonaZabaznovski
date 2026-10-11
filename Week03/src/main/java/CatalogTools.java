import java.util.Arrays;

// Helper methods that work on a shelf: an array of books in which some places may be empty (null).
public class CatalogTools {

    // How many places of the shelf hold a book.
    public static int countBooks(Book[] shelf) {
        int count = 0;
        for (Book book : shelf) {
            if (book != null) {
                count++;
            }
        }
        return count;
    }

    // The book with the smallest year. null when the shelf holds no book.
    public static Book oldest(Book[] shelf) {
        Book oldest = null;
        for (Book book : shelf) {
            if (book != null && (oldest == null || book.isOlderThan(oldest))) {
                oldest = book;
            }
        }
        return oldest;
    }

    // How many books have this genre. Upper and lower case do not matter.
    public static int countByGenre(Book[] shelf, String genre) {
        int count = 0;
        for (Book book : shelf) {
            if (book != null && book.getGenre() != null && book.getGenre().equalsIgnoreCase(genre)) {
                count++;
            }
        }
        return count;
    }

    // Stretch: a NEW array with all books, without empty places, sorted by year, oldest first.
    // The shelf itself stays unchanged.
    public static Book[] sortedByYear(Book[] shelf) {
        Book[] result = new Book[countBooks(shelf)];
        int index = 0;
        for (Book book : shelf) {
            if (book != null) {
                result[index] = book;
                index++;
            }
        }
        Arrays.sort(result, (a, b) -> Integer.compare(a.getYear(), b.getYear()));
        return result;
    }
}