package bookreview;

public record Review(User user, Book book, int rating, String text) {
    public Review {
        if (rating < 1) {
            rating = 1;
        }
        if (rating > 5) {
            rating = 5;
        }
        if (text == null) {
            text = "";
        }
    }
}