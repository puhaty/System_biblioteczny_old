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

    public void stworzDrzewo(double bottomBorder, double topBorder) {
        tree = new Tree(bottomBorder, topBorder);
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
