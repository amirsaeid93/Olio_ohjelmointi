public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);
        Book book4 = new Book("Advanced Algorithms", "Bob Williams", 2022);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        book1.setRating(4.5);
        book1.addReview("Excellent book for beginners.");
        book1.addReview("A must-read for Java learners.");
        book2.setRating(4.0);
        book2.addReview("Great book for understanding data structures.");
        book3.setRating(3.8);
        book3.addReview("Interesting read on fiction writing.");
        book3.addReview("Helped me improve my writing.");
        book3.addReview("A bit slow at times.");
        book4.setRating(4.9);
        book4.addReview("Very challenging but rewarding.");

        System.out.println("Library Catalog:");
        library.displayBooks();

        System.out.println("\nReviews for 'Introduction to Java Programming':");
        for (String review : book1.getReviews()) {
            System.out.println(review);
        }

        System.out.println("\nReviews for 'Data Structures and Algorithms':");
        for (String review : book2.getReviews()) {
            System.out.println(review);
        }

        System.out.println("\nReviews for 'The Art of Fiction':");
        for (String review : book3.getReviews()) {
            System.out.println(review);
        }

        System.out.println("\nReviews for 'Advanced Algorithms':");
        for (String review : book4.getReviews()) {
            System.out.println(review);
        }

        System.out.println("\nLibrary Statistics:");
        System.out.println("Average Book Rating: " + library.getAverageBookRating());
        System.out.println("Most Reviewed Book: " + library.getMostReviewedBook().getTitle());
    }
}