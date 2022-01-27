import java.util.Objects;

public class Book {
    private final double isbn;
    private final String title;
    private final String author;
    private final String section;

    public Book(String sectionName, double isbn, String title, String author) {
        this.section = sectionName;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.isbn, isbn) == 0 && title.equals(book.title) && author.equals(book.author) && section.equals(book.section);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author, section);
    }
}