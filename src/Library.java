import java.util.ArrayList;
import java.util.List;

public class Library {
    private Tree tree = null, tree2 = null;
    //List<Section> dzialy = new ArrayList<>();
    //List<Autor> autorzy = new ArrayList<>();
    //List<Tytul> tytuly = new ArrayList<>();

    public Library() {
        this.tree = null;
    }

    public Tree getTree2() {
        return tree2;
    }

    public void createTree(String name, double bottomBorderId, double topBorderId) {
        tree = new Tree(name, bottomBorderId, topBorderId);
        tree.addSection("Science fiction");
        tree.addSection("Obyczajowe");
        tree.addSection("Kryminalne");
        tree.addSection("Naukowe");
        tree.addSection("Sportowe");
        tree.addSection("Poezja");
        tree.addSection("Lektury");
        tree.addSection("Psychologiczne");
            //pododdziały
        tree.addSubsection("Książki", "Przygodowe");
        tree.addSubsection("Obyczajowe", "Romanse");
        tree.addSubsection("Science fiction", "Przyszłość");
        tree.addSubsection("Science fiction", "Starożytność");
        tree.addSubsection("Przyszłość", "Kosmos");
        tree.addSubsection("Przyszłość", "Ziemia");
        tree.addSubsection("Przyszłość", "Księżyc");
        tree.addSubsection("Ziemia", "Nie wiem");
        tree.addSubsection("Ziemia", "Wiem");
        tree.addSubsection("Księżyc", "Xd");
        tree.addSubsection("Naukowe", "Biologia");
        tree.addSubsection("Naukowe", "Geografia");
        tree.addSubsection("Naukowe", "Historia");
        tree.addSubsection("Geografia", "Morza");
        tree.addSubsection("Geografia", "Mapy");
        tree.addSubsection("Asdfsa", "Asdw");
    }

    public void createTree2(String name, double bottomBorderId, double topBorderId) {
        tree2 = new Tree(name, bottomBorderId, topBorderId);
        //tree2.addSection("xd");

    }

    public void showCatalogStructure(Tree tree) {
        String indentation = "______", tabulation = "  ";
        if (tree.isEmpty()) {
            System.out.println("\nkatalog jest pusty!!");
        } else {
            System.out.println();
            for (Section i : tree) {
                if (i.getName().equals("STOP")) break; //wyrzucenie działu: STOP, który został utworzony tylko dla zatrzymania iteracji
                if (i.equals(tree.getRoot())) {
                    System.out.println(i);
                } else {
                    if (i.getLevel() == 1) {
                        tabulation = "  ";
                        for (int j = 0; j < i.getLevel(); j++) {
                            System.out.print(tabulation);
                        }
                    } else {
                        tabulation = "    ";
                        for (int j = 0; j < i.getLevel(); j++) {
                            System.out.print(tabulation);
                        }
                    }
                    System.out.print("|");
                    System.out.print(indentation);
                    System.out.print(" " + i);
                    System.out.println();
                }
            }
        }
    }



    public Tree getTree() {
        return tree;
    }
}
