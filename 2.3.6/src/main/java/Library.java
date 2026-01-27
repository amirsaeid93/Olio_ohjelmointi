import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayUsers() {
        System.out.println("Library Users:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void borrowBook(User user, Book book) {
        if (books.contains(book) && book.isAvailable()) {
            user.borrowBook(book);
            book.setAvailable(false);
            System.out.println(user.getName() + " has borrowed: " + book.getTitle());
        } else if (!book.isAvailable()){
            System.out.println("Sorry, " + book.getTitle() + " is currently not available.");
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public void returnBook(User user, Book book) {
        if (user.getBorrowedBooks().contains(book)) {
            user.returnBook(book);
            book.setAvailable(true);
            System.out.println(user.getName() + " has returned: " + book.getTitle());
        } else {
            System.out.println("This book was not borrowed by " + user.getName());
        }
    }

    public void displayBorrowedBooksByUser(User user){
        System.out.println("Books borrowed by " + user.getName() + ":");
        if (user.getBorrowedBooks().isEmpty()){
            System.out.println("No books borrowed.");
        } else {
            for (Book book : user.getBorrowedBooks()){
                System.out.println(book.getTitle());
            }
        }
    }
}
