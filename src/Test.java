import java.io.IOException;

public class Test{
    public static void main(String[] args) throws IOException {
        Library library = new Library();
        library.createTree("Książki", 123, 456);
        library.showCatalogStructure(library.getCatalog());
        library.createTree2("Xd", 123, 456);
        library.showCatalogStructure(library.getTree2());
        library.addNewBook("Nie wiem", 87345, "Xddddddddd", "Mateusz Chechłowski");
        //library.addNewBook("xdddd", 87345, "Xddddddddd", "Mateusz Chechłowski");
        library.saveCatalogToFile("catalog.txt", library.getCatalog());
        Catalog catalog = library.addToCatalogFromList(":", "catalogToRead.txt");
        library.showCatalogStructure(catalog);
        library.readBooksFromFileToList("booksToRead.txt");
        library.addBooksFromList(";", "booksToRead.txt", library.getCatalog());
        library.showCatalogStructureWithBooks(library.getCatalog());
    }
}