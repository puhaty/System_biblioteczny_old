import java.util.Scanner;


public class MainTUI {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner in = new Scanner(System.in);

        println("Witaj w programie do obsługi biblioteki");
        println("Menu:");
        println("0 : Wyjdź z programu");
        println("1 : Pokaż katalog");
        println("2 : Pokaż katalog z książkami");
        println("3 : Dodaj pozycję");
        println("4 : Edytuj pozycję");
        println("5 : Usuń pozycję");
        println("6 : Zapisz do pliku");
        println("7 : Odczytaj z pliku");
        println("8 : Pokaż menu");

        String option = null;
        do {
            System.out.print("podaj opcję: ");
            option = in.nextLine();
            switch (option) {
                case "0":
                    println("Dziękujemy za poświęcony czas...\nDo zobaczenia!");
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    println("Menu:");
                    println("0 : Wyjdź z programu");
                    println("1 : Pokaż katalog");
                    println("2 : Pokaż katalog z książkami");
                    println("3 : Dodaj pozycję");
                    println("4 : Edytuj pozycję");
                    println("5 : Usuń pozycję");
                    println("6 : Zapisz do pliku");
                    println("7 : Odczytaj z pliku");
                    println("8 : Pokaż menu");
                    break;
                default:
                    println("niepoprawna opcja");
            }
        } while (!option.equals("0"));

    }

    public static void println(String line) {
        System.out.println(line);
    }
}
