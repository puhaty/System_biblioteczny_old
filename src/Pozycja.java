public class Pozycja{
    double isbn;
    String title;
    String author;
    String dzial;

    public Pozycja(String rodzajKsiazki, double isbn, String title, String author) {
        this.dzial = rodzajKsiazki;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
}
