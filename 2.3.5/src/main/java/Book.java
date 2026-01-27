import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private int year;
    private double rating;
    private List<String> reviews;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.rating = 0.0;
        this.reviews = new ArrayList<>();
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void addReview(String review) {
        this.reviews.add(review);
    }

    public int getNumberOfReviews(){
        return this.reviews.size();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}


