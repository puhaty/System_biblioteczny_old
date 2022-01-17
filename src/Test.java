public class Test{
    public static void main(String[] args){
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.stworzDrzewo("Książki", 123, 456);
        biblioteka.showCatalogStructure(biblioteka.getTree());
    }
}