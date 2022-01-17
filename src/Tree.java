import java.util.*;

public class Tree implements Iterable<Section> {
    private final Section root;
    private String name;
    private double bottomBorrderId;
    private double topBorderId;

    public Tree(String name, double bottomBorrderId, double topBorderId) {
        this.root = new Section(name);
        this.root.setParent(null);
        this.name = name;
        this.bottomBorrderId = bottomBorrderId;
        this.topBorderId = topBorderId;
    }

    public void addSection(String nazwa) {
        Section newSection = new Section(nazwa);

        root.setChildren(newSection);
        for (int i = 0; i < root.getChildren().size(); i++) {
            root.getChildren().get(i).setParent(root);
        }
        newSection.setLevel(1);
        //nowyDzial.setChildren(null); dzieci to lista, więc bez sensu
    }

    public void addSubsection(String nazwaDzialu, String nazwaPodOddzialu) {
        Section newSubsection = new Section(nazwaPodOddzialu);
        Section current = root;
        List<Section> currents = null;
        int depth = 0;
        boolean stopIteration = true, returnIteration = false, nextChildren = false;

        while (current != null) {
            if(current.getName().equals(nazwaDzialu) && current == root) { //sprawddzanie i dodanie kolejnego poddodzialu, jesłi dodajemy do roota
                current.setChildren(newSubsection);
                for (int i = 0; i < current.getChildren().size(); i++) { // ustawianie rodzica
                    current.getChildren().get(i).setParent(current);
                    newSubsection.setLevel(depth + 1);
                }
                break;
            }

            if (current == root) {
                currents = current.getChildren();
                current = currents.get(0);
                depth++;
            }
            if (!isEmpty()) {
                while (true) {

                    if (currents.size() > 0 && !returnIteration && !nextChildren) {
                        nextChildren = true;
                        if (current.getName().equals(nazwaDzialu)) { //sprawddzanie i dodanie kolejnego poddodzialu
                            current.setChildren(newSubsection);
                            newSubsection.setLevel(depth + 1);
                            for (int i = 0; i < current.getChildren().size(); i++) {
                                current.getChildren().get(i).setParent(current);
                            }
                            stopIteration = false;
                            break;
                        }
                    }
                    else if (current.getChildren().size() > 0 && !returnIteration) { //wejście w kolejne dziecko od lewej
                        nextChildren = false;
                        currents = current.getChildren();
                        current = currents.get(0);
                        depth++;
                    }
                    else if (currents.size() > 1 && !current.equals(currents.get(currents.size() - 1))){ //przejście na kolejne dzieckood lewej //current != currents.get(currents.size() - 1) to sprawdza, czy current nie jest już ostatnim elementem na liście, wtedy przechodzimy do rodzica
                        returnIteration = false;
                        nextChildren = false;
                        int count = 0;
                        for (Section temp : currents) { //wyszukanie poprzedniej lokalizacji działu na podstawie pozycji rodzica
                            if (current.equals(temp)) {
                                current = currents.get(++count);         //przejście na kolejnego rodzica
                                break;
                            }
                            count++;
                        }
                    } else {               //powrót do rodzica
                        if (depth > 0) {
                            depth--;
                            if (depth == 0) {
                                System.out.println("\nWprowadzono Błędne dane, Nie ma takiego działu!!!");
                                stopIteration = false;
                                break;
                            } else {
                                current = current.getParent();
                                currents = current.getParent().getChildren();
                                returnIteration = true; // zmienna informuje, że current został przypisany do rodzica
                            }
                        }
                    }
                }
            }
            if (!stopIteration) break;
        }
    }
    public boolean isEmpty() {
        return root.getChildren().isEmpty();
    }

    public Section getRoot() {
        return root;
    }

    @Override
    public Iterator<Section> iterator() {
        return new LibraryIterator();
    }

    class LibraryIterator implements Iterator<Section> {

        private Section current = null;
        private List<Section> currents = null;
        private int depth = 0;
        private boolean stopIteration = false, returnIteration = false, nextChildren = false;

        @Override
        public boolean hasNext() {
            if (isEmpty()) {
                return false;
            }
            if (current != null) {
                return !stopIteration;
            } else {
                return true;
            }
        }

        @Override
        public Section next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            while (true) {
                if (current != null) {
                    if (currents.size() > 0 && !returnIteration && !nextChildren) { //przejście przez listę dzieci
                        nextChildren = true;
                        return current;
                    } else if (current.getChildren().size() > 0 && !returnIteration) { //Wejście w kolejne dziecko od lewej
                        nextChildren = false;
                        currents = current.getChildren();
                        current = currents.get(0);
                        depth++;
                    } else if (currents.size() > 1 && !current.equals(currents.get(currents.size() - 1))) {//Przejście na kolejnego rodzica
                        returnIteration = false;
                        nextChildren = false;
                        int count = 0;
                        for (Section temp : currents) { //wyszukanie poprzedniej lokalizacji działu na podstawie pozycji rodzica
                            if (current.equals(temp)) {
                                current = currents.get(++count);         //trzeba zmienić żeby brał następną wartość;
                                break;
                            }
                            count++;
                        }
                    } else { //powrót do rodzica
                        if (depth > 0) {
                            depth--;
                            if (depth == 0) {
                                Section stop = new Section("STOP");
                                stopIteration = true;
                                return stop;
                            } else {
                                current = current.getParent();
                                currents = current.getParent().getChildren();
                                returnIteration = true;
                            }
                        }
                    }
                } else { //jeśli nie ma przypisania do current to bierzemy root'a
                    current = root;
                    currents = current.getChildren();
                    current = currents.get(0);
                    depth++;
                    return root;
                }
            }
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}