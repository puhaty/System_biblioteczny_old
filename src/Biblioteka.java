import java.util.ArrayList;
import java.util.List;

public class Biblioteka {
    private Tree tree;
    List<Dzial> dzialy = new ArrayList<>();
    List<Autor> autorzy = new ArrayList<>();
    List<Tytul> tytuly = new ArrayList<>();

    public Biblioteka() {
        this.tree = null;
    }

    public void stworzDrzewo(String nazwa, double bottomBorderId, double topBorderId) {
        tree = new Tree(nazwa, bottomBorderId, topBorderId);
        tree.dodajDzial("Science fiction");
        tree.dodajDzial("Obyczajowe");
        tree.dodajDzial("Kryminalne");
        tree.dodajDzial("naukowe");
        tree.dodajDzial("sportowe");
        for (String i : tree) {
            System.out.println(i);
        }

    }
}
