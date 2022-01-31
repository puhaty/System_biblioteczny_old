import java.util.Scanner;


public class MainTUI {
    private static final String tab = "    ";

    public static void main(String[] args) {
        Library library = new Library();
        Scanner in = new Scanner(System.in);

        println("Witaj w programie do obsługi biblioteki");
        println("Menu:");
        printlnTab("0 : Wyjdź z programu");
        printlnTab("1 : Pokaż katalog");
        printlnTab("2 : Pokaż katalog z książkami");
        printlnTab("3 : Dodaj pozycję");
        printlnTab("4 : Edytuj pozycję");
        printlnTab("5 : Usuń pozycję");
        printlnTab("6 : Zapisz do pliku");
        printlnTab("7 : Odczytaj z pliku");
        printlnTab("m : Pokaż menu");

        String option = null, catalogName = null, sectionName = null, subsectionName = null;
        Catalog catalog;
        Section section;

        do {
            print("\npodaj opcję: ");
            option = in.nextLine();
            switch (option) {
                case "0":
                    println("Dziękujemy za poświęcony czas...\nDo zobaczenia!");
                    break;
                case "1":
                    library.showCatalogs();
                    if(library.getCatalogs().size() > 0) {
                        println("podaj nazwę katalogu:");
                        catalogName = in.nextLine();
                        if (library.isCatalog(catalogName)) {
                            library.showCatalogStructure(library.getCatalog(catalogName));
                        } else {
                            println("wprowadzono niepoprawną nazwę!");
                        }
                    }
                    break;
                case "2":
                    library.showCatalogs();
                    if(library.getCatalogs().size() > 0) {
                        println("podaj nazwę katalogu:");
                        catalogName = in.nextLine();
                        library.showCatalogStructureWithBooks(library.getCatalog(catalogName));
                    }
                    break;
                case "3":
                    String option1 = null;
                    println("Opcje: ");
                    printlnTab("a : Dodaj katalog");
                    printlnTab("b : Dodaj dział");
                    printlnTab("c : Dodaj pododdział");
                    printlnTab("d : Dodaj książkę");
                    printlnTab("m : Pokaż opcje");
                    printlnTab("q : Powrót");
                    do {
                        print("\nwybierz opcję: ");
                        option1 = in.nextLine();
                        switch (option1) {
                            case "q":
                                break;
                            case "a":
                                print("podaj nazwę Katalogu: ");
                                library.addCatalog(in.nextLine());
                                break;
                            case "b":
                                println("Katalogi w bibliotece: ");
                                library.showCatalogs();
                                if(library.getCatalogs().size() > 0) {
                                    println("podaj nazwę katalogu:");
                                    catalogName = in.nextLine();
                                    if (library.isCatalog(catalogName)) {
                                        print("podaj nazwę działu: ");
                                        library.getCatalog(catalogName).addSection(in.nextLine());
                                    } else {
                                        println("wprowadzono niepoprawną nazwę!");
                                        break;
                                    }
                                }
                                break;
                            case "c":
                                println("Katalogi w bibliotece: ");
                                library.showCatalogs();
                                if(library.getCatalogs().size() > 0) {
                                    println("podaj nazwę katalogu:");
                                    catalogName = in.nextLine();
                                    if (library.isCatalog(catalogName)) {
                                        catalog = library.getCatalog(catalogName);
                                        println("Działy w katalogu: ");
                                        catalog.showSections();
                                        print("podaj nazwę działu: ");
                                        sectionName = in.nextLine();
                                        if (catalog.isSection(sectionName)) {
                                            print("podaj nzawę pododdziału: ");
                                            subsectionName = in.nextLine();
                                            library.getCatalog(catalogName).addSubsection(sectionName, subsectionName);
                                        } else {
                                            println("wprowadzono niepoprawną nazwę: " + subsectionName);
                                        }
                                    } else {
                                        println("wprowadzono niepoprawną nazwę: " + sectionName);
                                    }
                                }
                                break;
                            case "d":
                                break;
                            case "m":
                                println("Opcje: ");
                                printlnTab("a : Dodaj katalog");
                                printlnTab("b : Dodaj dział");
                                printlnTab("c : Dodaj pododdział");
                                printlnTab("d : Dodaj książkę");
                                printlnTab("e : Pokaż opcje");
                                printlnTab("q : Powrót");
                                break;
                            default:
                                println("niepoprawna opcja!");
                        }
                    } while (!(option1.equals("q")));
                    //break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "m":
                    println("Menu:");
                    printlnTab("0 : Wyjdź z programu");
                    printlnTab("1 : Pokaż katalog");
                    printlnTab("2 : Pokaż katalog z książkami");
                    printlnTab("3 : Dodaj pozycję");
                    printlnTab("4 : Edytuj pozycję");
                    printlnTab("5 : Usuń pozycję");
                    printlnTab("6 : Zapisz do pliku");
                    printlnTab("7 : Odczytaj z pliku");
                    printlnTab("m : Pokaż menu");
                    break;
                default:
                    println("niepoprawna opcja");
            }
        } while (!option.equals("0"));

    }

    public static void println(String line) {
        System.out.println(line);
    }

    public static void printlnTab(String line) {
        System.out.println(tab + line);
    }

    public static void print(String line) {
        System.out.print(line);
    }
}
