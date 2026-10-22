package bookreview;

// A book that is read to you.
// Task 2: finish this class. Use PrintedBook, which you wrote in Task 1, as your model.
public class AudioBook extends Book {
    private int minutes;

    public AudioBook(String title, String author, String genre, int year, int minutes) {
        super(title, author, genre, year);
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    // override format() so that it returns "audio"
    @Override
    public String format() {
        return "audio";
    }

    // override sizeInfo() so that it returns for example "1260 min"
    @Override
    public String sizeInfo() {
        return minutes + " min";
    }
}