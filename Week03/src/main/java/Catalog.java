// The first runnable program of the Book Review Platform.
// Optional program argument: a genre, for example  Classic
//
// Expected output when started with the argument Classic:
//   Books on the shelf: 4
//   #1 Dune by Frank Herbert (1965), Science fiction
//   #2 Emma by Jane Austen (1815), Classic
//   #3 Neuromancer by William Gibson (1984), Science fiction
//   #4 Jane Eyre by Charlotte Bronte (1847), Classic
//   Oldest: #2 Emma by Jane Austen (1815), Classic
//   Classic: 2
public class Catalog {
    void main(String[] args) {
        Book[] shelf = new Book[6];
        shelf[0] = new Book("Dune", "Frank Herbert", "Science fiction", 1965);
        shelf[2] = new Book("Emma", "Jane Austen", "Classic", 1815);
        shelf[3] = new Book("Neuromancer", "William Gibson", "Science fiction", 1984);
        shelf[5] = new Book("Jane Eyre", "Charlotte Bronte", "Classic", 1847);

        IO.println("Books on the shelf: " + CatalogTools.countBooks(shelf));

        for (Book book : shelf) {
            if (book != null) {
                IO.println(book);
            }
        }

        IO.println("Oldest: " + CatalogTools.oldest(shelf));

        if (args.length > 0) {
            IO.println(args[0] + ": " + CatalogTools.countByGenre(shelf, args[0]));
        }
    }
}