import java.util.HashSet;
import java.util.Set;

public class Book implements ComparableBook {
    private String title;
    private String author;
    private int year;

    // Constructor
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Getter and Setter for Title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for Author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter and Setter for Year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }



    // compareTo method for comparing books by title
    @Override
    public int compareAuthor(Book other) {
        return this.author.compareTo(other.getAuthor());
    }

    // compareTo method for comparing books by title
    @Override
    public int compareTitle(Book other) {
        return this.title.compareTo(other.getTitle());
    }

    // compareTo method for comparing books by title
    @Override
    public int compareYear(Book other) {
        return Integer.compare(this.year, other.getYear());
    }

    // To display book details
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Year: " + year;
    }
}
