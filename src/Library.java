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
        catalog.addSection("Dramat");
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

    public void addNewBook(String sectionName, long isbn, String title, String author) {
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

    public void showCatalogStructure(Catalog catalog) throws NullPointerException {
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

    public void showCatalogStructureWithBooks(Catalog catalog) throws NullPointerException {
        String indentation = "______", tabulation = "  ", sign = "* ";
        if (catalog.isEmpty()) {
            System.out.println("\nkatalog jest pusty!!");
        } else {
            System.out.println();
            for (Section i : catalog) {
                if (i == null) break; //wyrzucenie działu: STOP, który został utworzony tylko dla zatrzymania iteracji
                if (i.equals(catalog.getRoot())) {
                    System.out.println(i);
                    for (Book b : i.getBooks()) {
                        System.out.print(tabulation + tabulation + sign + b);
                    }
                } else {
                    if (i.getLevel() == 1) {
                        tabulation = "  ";
                        for (int j = 0; j < i.getLevel(); j++) {
                            System.out.print(tabulation);
                        }
                    } else {
                        tabulation = "       ";
                        for (int j = 0; j < i.getLevel(); j++) {
                            System.out.print(tabulation);
                        }
                    }
                    System.out.print("|");
                    System.out.print(indentation);
                    System.out.print(" " + i);
                    for (Book b : i.getBooks()) {
                        if (i.getLevel() == 1) {
                            System.out.println();
                            tabulation = "   ";
                            for (int j = 0; j < i.getLevel(); j++) {
                                System.out.print(tabulation);
                            }
                        } else {
                            System.out.println();
                            tabulation = "       ";
                            for (int j = 0; j < i.getLevel(); j++) {
                                System.out.print(tabulation);
                            }
                        }
                        System.out.print(tabulation + sign + b);
                    }
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

    Catalog addToCatalogFromList(String separator, String filename) throws IOException {
        List<String> list = readCatalogFromFileToList(filename);
        Catalog catalog;
        List<String[]> arrayList;
        if (!list.isEmpty() && list.get(0).length() > 1) {
            arrayList = new ArrayList<>();
            catalog = new Catalog(null, 0, 0);

            for (String s : list) {
                String[] strip = s.split(separator);
                if (strip.length > 1) {
                    strip[0] = strip[0].strip();
                    strip[1] = strip[1].strip();
                }
                arrayList.add(strip);
            }

            for (String[] t : arrayList) {
                if (t.length > 1) {
                    if (t[0].equals("root")) {
                        catalog = new Catalog(t[1], 0, 0);
                    } else {
                        catalog.addSubsection(t[1], t[0]);
                    }
                }
            }
            return catalog;
        }
        else {
            return null;
        }
    }

    List<String> readBooksFromFileToList(String fileName) throws IOException {
        BufferedReader bufferedReader = null;
        List<String> BooksListFromFile = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            BooksListFromFile = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                BooksListFromFile.add(line);
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
        return BooksListFromFile;
    }

    void addBooksFromList(String separator, String fileName, Catalog catalog) throws IOException {
        List<String> list = readBooksFromFileToList(fileName);
        List<String[]> arrayList;
        if (!list.isEmpty() && list.get(0).length() > 1) {
            arrayList = new ArrayList<>();
            String sectionName = null, tittle = null, isbn = null, author = null;
            for (String s : list) {
                String[] strip = s.split(separator);
                if (strip.length > 3) {
                    for (String t : strip) {
                        t = t.strip();
                    }
                    arrayList.add(strip);
                }
            }

            for (String[] t : arrayList) {
                if (t.length > 3) {
                    sectionName = t[0];
                    isbn = t[1];
                    tittle = t[2];
                    author = t[3];
                    Section section = catalog.searchSection(sectionName);
                    if (section != null) {
                        section.addBook(sectionName, Long.parseLong(isbn), tittle, author);
                    } else {
                        System.out.println("niepoprawna nazwa działu, sprawdź czy dział znajduje się w katalogu");
                    }

                }
            }
        } else {
            System.out.println("brak danych z pliku lub niepoprawne dane!!!");
        }
    }

    List<Book> searchBookForAuthor(String author, Catalog catalog) {
        List<Book> list = new ArrayList<>();
        for (Section s : catalog) {
            for (Book b : s.getBooks()) {
                if (b.getAuthor().equals(author)) {
                    list.add(b);
                }
            }
        }
        if (!list.isEmpty()) {
            return list;
        } else {
            System.out.println("nie ma takiej książki w tym katalogu!!");
            return null;
        }
    }

    List<Book> searchBookForIsbn(long isbn, Catalog catalog) {
        List<Book> list = new ArrayList<>();
        for (Section s : catalog) {
            for (Book b : s.getBooks()) {
                if (b.getIsbn() == isbn) {
                    list.add(b);
                }
            }
        }
        if (!list.isEmpty()) {
            return list;
        } else {
            System.out.println("nie ma takiej książki w tym katalogu!!");
            return null;
        }
    }

    List<Book> searchBookForTittle(String tittle, Catalog catalog) {
        List<Book> list = new ArrayList<>();
        for (Section s : catalog) {
            for (Book b : s.getBooks()) {
                if (b.getTitle().equals(tittle)) {
                    list.add(b);
                }
            }
        }
        if (!list.isEmpty()) {
            return list;
        } else {
            System.out.println("nie ma takiej książki w tym katalogu!!");
            return null;
        }

    //void searchFilter() {
    //
    //    }
    }



    public Catalog getCatalog() {
        return catalog;
    }
}
