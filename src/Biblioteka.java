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
        tree.dodajDzial("Naukowe");
        tree.dodajDzial("Sportowe");
            //pododdziały
        tree.dodajPodOddzial("Książki", "Przygodowe");
        tree.dodajPodOddzial("Obyczajowe", "Romanse");
        tree.dodajPodOddzial("Science fiction", "Przyszłość");
        tree.dodajPodOddzial("Przyszłość", "Kosmos");
        tree.dodajPodOddzial("Przyszłość", "Ziemia");
        tree.dodajPodOddzial("Przyszłość", "Księżyc");
        tree.dodajPodOddzial("Ziemia", "Nie wiem");
        tree.dodajPodOddzial("Ziemia", "Wiem");
        tree.dodajPodOddzial("Księżyc", "Xd");
        tree.dodajPodOddzial("Xd", "Dx");
        tree.dodajPodOddzial("Naukowe", "Biologia");
        tree.dodajPodOddzial("Naukowe", "Geografia");
        tree.dodajPodOddzial("Naukowe", "Historia");
        tree.dodajPodOddzial("Geografia", "Morza");
        tree.dodajPodOddzial("Geografia", "Mapy");

    }

    public void showCatalogStructure() {
        if (tree.isEmpty()) {
            System.out.println("katalog jest pusty!!");
        } else {
            for (Dzial i : tree) {
                if (i.getNazwa().equals("STOP")) break;
                for (int j = 0; j < i.getLevel(); j++) {
                    System.out.print("-");
                }
                System.out.print(i);
                System.out.println();
            }
        }
    }
}
