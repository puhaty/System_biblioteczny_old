import java.util.Scanner;


public class MainTUI {
    private static final String tab = "    ";

    public static void main(String[] args) {
        Library library = new Library();
        Scanner in = new Scanner(System.in);

        println("Witaj w programie do obsługi biblioteki");
        println("Menu:");
        printlnTab("0 : Wyjdź z programu");
        printlnTab("1 : Pokaż katalog"); //Done
        printlnTab("2 : Pokaż katalog z książkami"); //Done
        printlnTab("3 : Dodaj pozycję");     //Done
        printlnTab("4 : Edytuj pozycję");
        printlnTab("5 : Usuń pozycję");
        printlnTab("6 : Zapis do pliku");
        printlnTab("7 : Odczyt z pliku");
        printlnTab("m : Pokaż menu");

        String option = null, catalogName = null, sectionName = null, subsectionName = null;
        String tittle = null, author = null, isbn = null;
        Catalog catalog;
        Section section;
        Book book;

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
                            println("wprowadzono niepoprawną nazwę: " + catalogName);
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
                    printlnTab("m : Pokaż menu");
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
                                        catalog = library.getCatalog(catalogName);
                                        print("podaj nazwę działu: ");
                                        catalog.addSection(in.nextLine());
                                    } else {
                                        println("wprowadzono niepoprawną nazwę: " + catalogName);
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
                                            println("wprowadzono niepoprawną nazwę: " + sectionName);
                                        }
                                    } else {
                                        println("wprowadzono niepoprawną nazwę: " + catalogName);
                                    }
                                }
                                break;
                            case "d":
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
                                            section = catalog.getSection(sectionName);
                                            print("podaj tytuł książki: ");
                                            tittle = in.nextLine();
                                            print("podaj autora: ");
                                            author = in.nextLine();
                                            print("podaj nr ISBN: ");
                                            isbn = in.nextLine();
                                            if (isbn.matches("[0-9]+") && isbn.length() == 13) {
                                                section.addBook(sectionName, Long.parseLong(isbn), tittle, author);
                                            } else {
                                                println("niepoprawny nr ISBN: " + isbn);
                                            }
                                        } else {
                                            println("wprowadzono niepoprawną nazwę: " + sectionName);
                                        }
                                    } else {
                                        println("wprowadzono niepoprawną nazwę: " + catalogName);
                                    }
                                }
                                break;
                            case "m":
                                println("Opcje: ");
                                printlnTab("a : Dodaj katalog");
                                printlnTab("b : Dodaj dział");
                                printlnTab("c : Dodaj pododdział");
                                printlnTab("d : Dodaj książkę");
                                printlnTab("m : Pokaż menu");
                                printlnTab("q : Powrót");
                                break;
                            default:
                                println("niepoprawna opcja!");
                        }
                    } while (!(option1.equals("q")));
                    break;
                case "4":
                    String option2 = null;
                    println("Opcje: ");
                    printlnTab("a : Edytuj katalog");
                    printlnTab("b : Edytuj dział");
                    printlnTab("c : Edytuj książkę");
                    printlnTab("m : Pokaż menu");
                    printlnTab("q : Powrót");
                    do {
                        print("\nwybierz opcję: ");
                        option2 = in.nextLine();
                        switch (option2) {
                            case "a":
                                println("Katalogi w bibliotece: ");
                                library.showCatalogs();
                                if(library.getCatalogs().size() > 0) {
                                    println("podaj nazwę katalogu:");
                                    catalogName = in.nextLine();
                                    if (library.isCatalog(catalogName)) {
                                        catalog = library.getCatalog(catalogName);
                                        String option3 = null;
                                        println("Opcje: ");
                                        printlnTab("a : zmień nazwę");
                                        printlnTab("q : Powrót");
                                        do {
                                            print("\nwybierz opcję: ");
                                            option3 = in.nextLine();
                                            switch (option3) {
                                                case "a":
                                                    print("podaj nazwę: ");
                                                    library.getCatalog(catalogName).setName(in.nextLine());
                                                    break;
                                                case "m":
                                                    println("Opcje: ");
                                                    printlnTab("a : zmień nazwę");
                                                    printlnTab("m : pokaż menu");
                                                    printlnTab("q : Powrót");
                                                    break;
                                                case "q":
                                                    break;
                                                default:
                                                    println("niepoprawna opcja!");
                                            }
                                        } while(!(option3.equals("q")));
                                        break;
                                    } else {
                                        println("wprowadzono niepoprawną nazwę: " + catalogName);
                                    }
                                }
                            case "b":
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
                                            section = catalog.getSection(sectionName);
                                            String option3 = null;
                                            println("Opcje: ");
                                            printlnTab("a : zmień nazwę");
                                            printlnTab("b : przenieś dział");
                                            printlnTab("m : menu");
                                            printlnTab("q : Powrót");
                                            do {
                                                print("\nwybierz opcję: ");
                                                option3 = in.nextLine();
                                                switch (option3) {
                                                    case "a":
                                                        print("podaj nazwę: ");
                                                        section.setName(in.nextLine());
                                                        break;
                                                    case "b":
                                                        println("Działy w katalogu: ");
                                                        catalog.showSections();
                                                        print("podaj nazwę działu docelowego: ");
                                                        String targetSectionName = in.nextLine();
                                                        if (catalog.isSection(targetSectionName)) {
                                                            catalog.replaceSection(subsectionName, targetSectionName);
                                                        } else {
                                                            println("wprowadzono niepoprawną nazwę: " + targetSectionName);
                                                        }
                                                        break;
                                                    case "m":
                                                        println("Opcje: ");
                                                        printlnTab("a : zmień nazwę");
                                                        printlnTab("b : przenieś dział");
                                                        printlnTab("m : menu");
                                                        printlnTab("q : Powrót");
                                                        break;
                                                    case "q":
                                                        break;
                                                    default:
                                                        println("niepoprawna opcja!");
                                                }
                                            } while (!(option3.equals("q")));
                                            break;
                                        }  else {
                                            println("wprowadzono niepoprawną nazwę: " + sectionName);
                                        }
                                    } else {
                                        println("wprowadzono niepoprawną nazwę: " + catalogName);
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
                                        println("Książki w katalogu");
                                        library.showBooks(catalog);
                                        if (catalog.getBooks().size() > 0) {
                                            print("podaj tytuł książki: ");
                                            tittle = in.nextLine();
                                            if (library.isBook(catalog, tittle)) {
                                                book = library.getBook(catalog, tittle);
                                                String option4 = null;
                                                println("Opcje: ");
                                                printlnTab("a : Przenieś książkę");
                                                printlnTab("m : menu");
                                                printlnTab("q : Powrót");
                                                do {
                                                    print("\nwybierz opcję: ");
                                                    option4 = in.nextLine();
                                                    switch (option4) {
                                                        case "a":
                                                            println("Działy w katalogu: ");
                                                            library.showSections(catalog);
                                                            print("podaj nazwę działu: ");
                                                            sectionName = in.nextLine();
                                                            if (library.isSection(catalog, sectionName)) {
                                                                library.replaceBook(catalog, sectionName, tittle);
                                                            } else {
                                                                println("wprowadzono niepoprawną nazwę: " + sectionName);
                                                            }
                                                            break;

                                                        case "m":
                                                            println("Opcje: ");
                                                            printlnTab("a : Przenieś książkę");
                                                            printlnTab("m : menu");
                                                            printlnTab("q : Powrót");
                                                            break;
                                                        case "q":
                                                            break;
                                                        default:
                                                            println("niepoprawna opcja!");
                                                    }
                                                } while (!(option4.equals("q")));
                                                break;
                                            } else {
                                                println("wprowadzono niepoprawną nazwę: " + tittle);
                                            }
                                        }
                                    } else {
                                        println("wprowadzono niepoprawną nazwę: " + catalogName);
                                    }
                                }
                                break;
                            case "m":println("Opcje: ");
                                printlnTab("a : Edytuj katalog");
                                printlnTab("b : Edytuj dział");
                                printlnTab("c : Edytuj książkę");
                                printlnTab("m : Pokaż opcje");
                                printlnTab("q : Powrót");
                                break;
                            case "q":
                                break;
                            default:
                                println("niepoprawna opcja!");
                        }
                    } while(!(option2.equals("q")));
                    break;
                case "5":
                    String option3 = null;
                    println("Opcje: ");
                    printlnTab("a : Usuń katalog");
                    printlnTab("b : Usuń dział");
                    printlnTab("c : Usuń książkę");
                    printlnTab("m : Pokaż menu");
                    printlnTab("q : Powrót");
                    do {
                        print("\nwybierz opcję: ");
                        option3 = in.nextLine();
                        switch (option3) {
                            case "a":
                                println("Katalogi w bibliotece: ");
                                library.showCatalogs();
                                if (library.getCatalogs().size() > 0) {
                                    println("podaj nazwę katalogu:");
                                    catalogName = in.nextLine();
                                    if (library.isCatalog(catalogName)) {
                                        catalog = library.getCatalog(catalogName);
                                        library.removeCatalog(catalog);
                                    } else {
                                        println("wprowadzono niepoprawną nazwę: " + catalogName);
                                    }
                                }
                                break;
                            case "b":
                                println("Katalogi w bibliotece: ");
                                library.showCatalogs();
                                if (library.getCatalogs().size() > 0) {
                                    println("podaj nazwę katalogu:");
                                    catalogName = in.nextLine();
                                    if (library.isCatalog(catalogName)) {
                                        catalog = library.getCatalog(catalogName);
                                        println("Działy w katalogu: ");
                                        library.showSections(catalog);
                                        print("podaj nazwę działu: ");
                                        sectionName = in.nextLine();
                                        if (library.isSection(catalog, sectionName)) {
                                            catalog.removeSection(sectionName);
                                        } else {
                                            println("wprowadzono niepoprawną nazwę: " + sectionName);
                                        }
                                    } else {
                                        println("wprowadzono niepoprawną nazwę: " + catalogName);
                                    }
                                }
                                break;
                            case "c":
                                println("Katalogi w bibliotece: ");
                                library.showCatalogs();
                                if (library.getCatalogs().size() > 0) {
                                    println("podaj nazwę katalogu:");
                                    catalogName = in.nextLine();
                                    if (library.isCatalog(catalogName)) {
                                        catalog = library.getCatalog(catalogName);
                                        println("Książki w katalogu");
                                        library.showBooks(catalog);
                                        if (catalog.getBooks().size() > 0) {
                                            print("podaj tytuł książki: ");
                                            tittle = in.nextLine();
                                            if (library.isBook(catalog, tittle)) {
                                                book = library.getBook(catalog, tittle);
                                                library.removeBook(catalog, book);
                                            } else {
                                                println("wprowadzono niepoprawną nazwę: " + tittle);
                                            }
                                        }
                                    } else {
                                        println("wprowadzono niepoprawną nazwę: " + catalogName);
                                    }
                                }
                                break;
                            case "m":
                                println("Opcje: ");
                                printlnTab("a : Usuń katalog");
                                printlnTab("b : Usuń dział");
                                printlnTab("c : Usuń książkę");
                                printlnTab("m : Pokaż menu");
                                printlnTab("q : Powrót");
                                break;
                            case "q":
                                break;
                            default:
                                println("niepoprawna opcja!");
                        }
                    } while(!(option3.equals("q")));
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
