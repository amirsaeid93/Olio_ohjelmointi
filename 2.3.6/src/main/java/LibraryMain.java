public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();


        Book book1 = new Book("Introduction to Java", "John Smith", 2020);
        Book book2 = new Book("Data Structures", "Jane Doe", 2018);
        Book book3 = new Book("Algorithms", "Alice Johnson", 2019);


        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);


        User user1 = new User("Bob Williams", 25);
        User user2 = new User("Carol Davis", 30);


        library.addUser(user1);
        library.addUser(user2);


        library.displayBooks();
        library.displayUsers();


        library.borrowBook(user1, book1);
        library.borrowBook(user2, book2);
        library.borrowBook(user1, book3);
        library.borrowBook(user2, book1);


        library.displayBorrowedBooksByUser(user1);
        library.displayBorrowedBooksByUser(user2);


        library.returnBook(user1, book1);
        library.returnBook(user2, book3);
        library.returnBook(user2, book2);


        library.displayBooks();
        library.displayUsers();
        library.displayBorrowedBooksByUser(user1);
        library.displayBorrowedBooksByUser(user2);
    }
}