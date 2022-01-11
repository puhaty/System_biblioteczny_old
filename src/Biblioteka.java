import java.util.ArrayList;
import java.util.Iterator;
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
        //Iterator it = tree.iterator();
        /*while (it.hasNext()) {
            System.out.println(it.next().toString());
        }

         */
        for (Dzial i : tree) {
            System.out.println(i);
        }

    }
}
