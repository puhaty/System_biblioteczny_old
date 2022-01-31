import java.io.IOException;

public class Test{
    public static void main(String[] args) throws IOException {
        Library library = new Library();
        library.createTree("Książki1", 123, 456);
        library.showCatalogStructure(library.getCatalog("Książki1"));
        library.addNewBook(library.getCatalog("Książki1"), "Nie wiem", 87345, "Xddddddddd", "Mateusz Chechłowski");
        library.addNewBook(library.getCatalog("Książki1"), "xdddd", 87345, "Xddddddddd", "Mateusz Chechłowski");
        library.showCatalogStructureWithBooks(library.getCatalog("Książki1"));
        library.saveCatalogListToFile("catalog1.txt", library.getCatalog("Książki1"));
        library.saveCatalogStructureToFile("catalog2.txt", library.getCatalog("Książki1"));
        Catalog catalog = library.addToCatalogFromList(":", "catalogToRead.txt");
        library.showCatalogStructure(catalog);
        catalog.addSubsection("Pieśń", "Xd");
        library.saveCatalogListToFile("catalog_list.txt", catalog);
        library.addToCatalogFromList(":", "catalogToRead.txt", catalog);
        library.showCatalogStructure(catalog);
        library.addBooksFromList(";", "booksToRead.txt", library.getCatalog("Książki1"));
        library.showCatalogStructureWithBooks(library.getCatalog("Książki1"));
    }
}