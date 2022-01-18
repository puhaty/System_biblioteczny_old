public class Book {
    private double isbn;
    private String title;
    private String author;
    private String section;

    public Book(String sectionName, double isbn, String title, String author) {
        this.section = sectionName;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
}
