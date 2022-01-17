public class Test{
    public static void main(String[] args){
        Library library = new Library();
        library.createTree("Książki", 123, 456);
        library.showCatalogStructure(library.getTree());
        library.createTree2("Xd", 123, 456);
        library.showCatalogStructure(library.getTree2());
    }
}