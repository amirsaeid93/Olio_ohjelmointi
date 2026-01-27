public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println("Library Catalog:");
        library.displayBooks();

        System.out.println("\nChecking availability of 'Data Structures and Algorithms':");
        System.out.println(library.isBookAvailable("Data Structures and Algorithms"));

        System.out.println("\nBorrowing 'Data Structures and Algorithms':");
        library.borrowBook("Data Structures and Algorithms");

        System.out.println("\nChecking availability of 'Data Structures and Algorithms' after borrowing:");
        System.out.println(library.isBookAvailable("Data Structures and Algorithms"));

        System.out.println("\nReturning 'Data Structures and Algorithms':");
        library.returnBook(book2);

        System.out.println("\nChecking availability of 'Data Structures and Algorithms' after returning:");
        System.out.println(library.isBookAvailable("Data Structures and Algorithms"));
    }
}