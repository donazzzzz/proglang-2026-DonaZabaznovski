public class Book {
    private static int nextId = 1;
    private int id;
    private String title;
    private String author;
    private String genre;
    private int year;

    public Book(String title, String author, String genre, int year) {
        if (title == null || title.isBlank()) {
            this.title = "Untitled";
        } else {
            this.title = title;
        }
        this.author = author;
        this.genre = genre;
        setYear(year);
        this.id = nextId;
        nextId++;
    }
    public static int getCreatedCount() {
        return nextId - 1;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }
    public int getYear() {
        return year;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    // Accepts only years from 1450 to 2100. Anything else is ignored.
    public void setYear(int year) {
        if (year >= 1450 && year <= 2100) {
            this.year = year;
        }
    }
    // true when this book was published before the other book
    public boolean isOlderThan(Book other) {
        return this.year < other.year;
    }
    // Format:  #1 Dune by Frank Herbert (1965), Science fiction
    @Override
    public String toString() {
        return "#" + id + " " + title + " by " + author + " (" + year + "), " + genre;
    }
}