public class Pozycja{
    private double isbn;
    private String title;
    private String author;
    private String dzial;

    public Pozycja(String rodzajKsiazki, double isbn, String title, String author) {
        this.dzial = rodzajKsiazki;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
}
