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
        catalog.replaceSection("Przyszłość", "Dupa");
    }

    public void createTree2(String name, double bottomBorderId, double topBorderId) {
        catalog2 = new Catalog(name, bottomBorderId, topBorderId);
        //tree2.addSection("xd");

    }

    public void addNewBook(String sectionName, double isbn, String title, String author) {
        boolean ifAdded = false;
        for (Section i : catalog) {
            if (i.getName().equals(sectionName)) {
                i.addBook(sectionName, isbn, title, author);
                ifAdded = true;
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
                if (i.getName().equals("STOP")) break; //wyrzucenie działu: STOP, który został utworzony tylko dla zatrzymania iteracji
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



    public Catalog getTree() {
        return catalog;
    }
}
