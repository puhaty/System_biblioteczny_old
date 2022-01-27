import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private Catalog catalog = null, catalog2 = null;
    //List<Section> dzialy = new ArrayList<>();
    //List<Autor> autorzy = new ArrayList<>();
    //List<Tytul> tytuly = new ArrayList<>();

    public Library() {
        this.catalog = null;
    }

    public Catalog getTree2() {
        return catalog2;
    }

    public void createTree(String name, double bottomBorderId, double topBorderId) {
        catalog = new Catalog(name, bottomBorderId, topBorderId);
        catalog.addSection("Science fiction");
        catalog.addSection("Obyczajowe");
        catalog.addSection("Kryminalne");
        catalog.addSection("Naukowe");
        catalog.addSection("Sportowe");
        catalog.addSection("Poezja");
        catalog.addSection("Lektury");
        catalog.addSection("Psychologiczne");
            //pododdziały
        catalog.addSubsection("Książki", "Przygodowe");
        catalog.addSubsection("Obyczajowe", "Romanse");
        catalog.addSubsection("Science fiction", "Przyszłość");
        catalog.addSubsection("Science fiction", "Starożytność");
        catalog.addSubsection("Przyszłość", "Kosmos");
        catalog.addSubsection("Przyszłość", "Ziemia");
        catalog.addSubsection("Przyszłość", "Księżyc");
        catalog.addSubsection("Ziemia", "Nie wiem");
        catalog.addSubsection("Ziemia", "Wiem");
        catalog.addSubsection("Księżyc", "Xd");
        catalog.addSubsection("Naukowe", "Biologia");
        catalog.addSubsection("Naukowe", "Geografia");
        catalog.addSubsection("Naukowe", "Historia");
        catalog.addSubsection("Geografia", "Morza");
        catalog.addSubsection("Geografia", "Mapy");
        catalog.addSubsection("Asdfsa", "Asdw");
        catalog.editSection("Geografia", "Dupa");
        catalog.replaceSection("Przyszłość", "Nie wiem");
        catalog.replaceSection("Dupa", "Starożytność");
        catalog.replaceSection("Książki", "Mapy");
        catalog.replaceSection("Mapy", "Książki");
    }

    public void createTree2(String name, double bottomBorderId, double topBorderId) {
        catalog2 = new Catalog(name, bottomBorderId, topBorderId);
        //tree2.addSection("xd");

    }

    public void addNewBook(String sectionName, double isbn, String title, String author) {
        boolean ifAdded = false;
        for (Section i : catalog) {
            if (i != null) {
                if (i.getName().equals(sectionName)) {
                    i.addBook(sectionName, isbn, title, author);
                    ifAdded = true;
                }
            }
        }
        if (!ifAdded) System.out.println("nie ma takiego działu!!!");
    }

    public void showCatalogStructure(Catalog catalog) {
        String indentation = "______", tabulation = "  ";
        if (catalog.isEmpty()) {
            System.out.println("\nkatalog jest pusty!!");
        } else {
            System.out.println();
            for (Section i : catalog) {
                if (i == null) break; //wyrzucenie działu: STOP, który został utworzony tylko dla zatrzymania iteracji
                if (i.equals(catalog.getRoot())) {
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

    void saveCatalogToFile(String fileName, Catalog catalog) throws IOException {
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, false)));

        String indentation = "______", tabulation = "  ";
        if (catalog.isEmpty()) {
            System.out.println("\nkatalog jest pusty!!");
        } else {
            //System.out.println();
            for (Section i : catalog) {
                if (i == null) break; //wyrzucenie działu: STOP, który został utworzony tylko dla zatrzymania iteracji
                if (i.equals(catalog.getRoot())) {
                    printWriter.println(i);
                } else {
                    if (i.getLevel() == 1) {
                        tabulation = "  ";
                        for (int j = 0; j < i.getLevel(); j++) {
                            printWriter.print(tabulation);
                        }
                    } else {
                        tabulation = "    ";
                        for (int j = 0; j < i.getLevel(); j++) {
                            printWriter.print(tabulation);
                        }
                    }
                    printWriter.print("|");
                    printWriter.print(indentation);
                    printWriter.print(" " + i);
                    printWriter.println("");
                }
            }
            printWriter.println();
        }
        printWriter.close();
    }

    List<String> readCatalogFromFileToList(String fileName) throws IOException {
        BufferedReader bufferedReader = null;
        List<String> listCatalogFromFile = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            listCatalogFromFile = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listCatalogFromFile.add(line);
                //System.out.println(line);
            }
        }
        catch (Exception e) {
            System.err.println("Wystapil blad przy wczytywaniu danych");
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return listCatalogFromFile;
    }

    Catalog addToCatalogFromList() throws IOException {
        List<String> list = readCatalogFromFileToList("catalog.txt");
        Catalog catalog = null;
        String root;

        if (!list.isEmpty()) {
            root = list.get(0);
            catalog = new Catalog(root, 12,23);
            return catalog;
        }
        else {
            return null;
        }
    }


    public Catalog getCatalog() {
        return catalog;
    }
}
