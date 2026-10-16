package bookreview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// The heart of the platform: it has books, users and reviews (composition).
public class Library {
    private List<Book> books = new ArrayList<>();
    private Map<String, User> users = new HashMap<>();
    // Task 5: add a list for the reviews
    private List<Review> reviews = new ArrayList<>();

    // ----- Task 3: books and users -----

    // Adds the book and returns true. A book that is already there is refused: return false.
    public boolean addBook(Book book) {
        if (books.contains(book)) {
            return false;
        }
        books.add(book);
        return true;
    }

    public int bookCount() {
        return books.size();
    }

    // Stores the user under the username and returns true. A taken username is refused: return false.
    public boolean registerUser(User user) {
        if (users.containsKey(user.getUsername())) {
            return false;
        }
        users.put(user.getUsername(), user);
        return true;
    }

    // The user with this username, or null.
    public User findUser(String username) {
        return users.get(username);
    }

    // ----- Task 4: overloaded search -----

    // All books of this author. Upper and lower case do not matter.
    public List<Book> findBooks(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor() != null && book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // Same name, other parameters: an overload.
    // All books with fromYear <= year <= toYear.
    public List<Book> findBooks(int fromYear, int toYear) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() >= fromYear && book.getYear() <= toYear) {
                result.add(book);
            }
        }
        return result;
    }

    // ----- Task 5: reviews -----
    // Creates a Review and stores it. Returns false when the username is unknown
    // or when the book is not in this library.
    public boolean addReview(String username, Book book, int rating, String text) {
        User user = findUser(username);
        if (user == null || !books.contains(book)) {
            return false;
        }
        reviews.add(new Review(user, book, rating, text));
        return true;
    }

    // The average rating of this book, or 0.0 when it has no review.
    public double averageRating(Book book) {
        int sum = 0;
        int count = 0;
        for (Review review : reviews) {
            if (review.book().equals(book)) {
                sum += review.rating();
                count++;
            }
        }
        if (count == 0) {
            return 0.0;
        }
        return (double) sum / count;
    }

    // How many books each genre has. Use a TreeMap so the genres are sorted.
    public Map<String, Integer> countByGenre() {
        Map<String, Integer> counts = new TreeMap<>();
        for (Book book : books) {
            counts.put(book.getGenre(), counts.getOrDefault(book.getGenre(), 0) + 1);
        }
        return counts;
    }

    // ----- Stretch -----

    // The book with the highest average rating, or null when the library is empty.
    public Book topRated() {
        Book best = null;
        double bestAverage = -1;
        for (Book book : books) {
            double average = averageRating(book);
            if (average > bestAverage) {
                best = book;
                bestAverage = average;
            }
        }
        return best;
    }

    // Removes all books published before this year and returns how many were removed.
    // Careful: removing while looping. See the lecture.
    public int removeBooksOlderThan(int year) {
        int removed = 0;
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getYear() < year) {
                iterator.remove();
                removed++;
            }
        }
        return removed;
    }
}