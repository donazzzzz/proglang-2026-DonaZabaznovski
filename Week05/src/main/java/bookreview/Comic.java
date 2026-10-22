package bookreview;

public class Comic extends PrintedBook {
    private boolean colour;

    public Comic(String title, String author, int year, int pages, boolean colour) {
        super(title, author, "Comic", year, pages);
        this.colour = colour;
    }

    public boolean isColour() {
        return colour;
    }

    // The genre of a comic cannot be changed.
    @Override
    public void setGenre(String genre) {
        // ignored
    }

    @Override
    public String format() {
        return "comic";
    }

    @Override
    public String sizeInfo() {
        return super.sizeInfo() + (colour ? ", colour" : ", black and white");
    }
}