import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public double getAverageBookRating() {
        if (books.isEmpty()) {
            return 0.0;
        }

        double totalRating = 0.0;
        for (Book book : books) {
            totalRating += book.getRating();
        }

        return totalRating / books.size();
    }

    public Book getMostReviewedBook() {
        if (books.isEmpty()) {
            return null;
        }

        Book mostReviewed = books.get(0);
        int maxReviews = mostReviewed.getNumberOfReviews();

        for (int i = 1; i < books.size(); i++) {
            Book currentBook = books.get(i);
            int currentReviews = currentBook.getNumberOfReviews();
            if (currentReviews > maxReviews) {
                maxReviews = currentReviews;
                mostReviewed = currentBook;
            }
        }

        return mostReviewed;
    }
}
