import java.util.Comparator;

public class Book {
    private final String title;
    private final String author;
    private final int year;

    // Constructor
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Getter and Setter for Title
    public String getTitle() { return title; }

    // Getter and Setter for Author
    public String getAuthor() { return author; }

    // Getter and Setter for Year
    public int getYear() { return year; }

    // compareTo method for comparing books by title
    public static class compareTitle implements Comparator<Book> {
        public int compare(Book o1, Book o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public static class compareAuthor implements Comparator<Book> {
        public int compare(Book o1, Book o2) {
            return o1.getAuthor().compareTo(o2.getAuthor());
        }
    }

    public static class compareYear implements Comparator<Book> {
        public int compare(Book o1, Book o2) {
            return o1.getYear() - o2.getYear();
        }
    }
}