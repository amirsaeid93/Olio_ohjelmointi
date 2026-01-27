import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true; // Initially available
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", available=" + available +
                '}';
    }
}

class User {
    private String name;
    private int age;
    private List<Book> borrowedBooks;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", borrowedBooks=" + borrowedBooks.size() +
                '}';
    }
}

