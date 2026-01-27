public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        book1.setRating(4.5);
        book1.addReview("Excellent book for beginners.");
        book2.setRating(4.0);
        book2.addReview("Great book for understanding data structures.");

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
    }
}