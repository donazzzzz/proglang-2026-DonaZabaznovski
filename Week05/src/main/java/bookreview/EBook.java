package bookreview;

// A digital book.
// Task 2: finish this class. Use PrintedBook, which you wrote in Task 1, as your model.
public class EBook extends Book {
    private double megabytes;

    public EBook(String title, String author, String genre, int year, double megabytes) {
        super(title, author, genre, year);
        this.megabytes = megabytes;
    }

    public double getMegabytes() {
        return megabytes;
    }

    // override format() so that it returns "ebook"
    @Override
    public String format() {
        return "ebook";
    }

    // override sizeInfo() so that it returns for example "1.4 MB"
    @Override
    public String sizeInfo() {
        return megabytes + " MB";
    }
}