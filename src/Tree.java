import java.util.*;

public class Tree implements Iterable<Dzial> {
    private Dzial root;
    private String nazwa;
    private double bottomBorrderId;
    private double topBorderId;
    List<Pozycja> pozycje;

    public Tree(String nazwa, double bottomBorrderId, double topBorderId) {
        this.root = new Dzial(nazwa);
        this.root.setParent(null);
        this.nazwa = nazwa;
        this.bottomBorrderId = bottomBorrderId;
        this.topBorderId = topBorderId;
    }

    public void dodajDzial(String nazwa) {
        Dzial nowyDzial = new Dzial(nazwa);

        if (isEmpty()) {
            root = nowyDzial;
            root.setParent(null);
            root.setLevel(0);
        } else {
            root.setChildren(nowyDzial);
            for (int i = 0; i < root.getChildren().size(); i++) {
                root.getChildren().get(i).setParent(root);
            }
            nowyDzial.setLevel(1);
            //nowyDzial.setChildren(null); dzieci to lista, więc bez sensu
        }
    }

    public void dodajPodOddzial(String nazwaDzialu, String nazwaPodOddzialu) {
        Dzial nowypodOddzial = new Dzial(nazwaPodOddzialu);
        Dzial current = root;
        List<Dzial> currents = null;
        int depth = 0;
        boolean stopIteration = true, returnIteration = false, nextChildren = false;

        while (current != null) {
            if(current.getNazwa().equals(nazwaDzialu) && current == root) { //sprawddzanie i dodanie kolejnego poddodzialu, jesłi dodajemy do roota
                current.setChildren(nowypodOddzial);
                for (int i = 0; i < current.getChildren().size(); i++) { // ustawianie rodzica
                    current.getChildren().get(i).setParent(current);
                    nowypodOddzial.setLevel(depth + 1);
                }
                break;
            }

            if (current == root) {
                currents = current.getChildren();
                current = currents.get(0);
                depth++;
            }
            if (currents.size() > 0) {
                while (stopIteration) {
                    if (stopIteration == false) break;

                    if (currents.size() > 0 && returnIteration == false && nextChildren == false) {
                        returnIteration = false;
                        nextChildren = true;
                        if (current.getNazwa().equals(nazwaDzialu)) { //sprawddzanie i dodanie kolejnego poddodzialu
                            current.setChildren(nowypodOddzial);
                            nowypodOddzial.setLevel(depth + 1);
                            for (int i = 0; i < current.getChildren().size(); i++) {
                                current.getChildren().get(i).setParent(current);
                            }
                            stopIteration = false;
                            break;
                        }
                    }
                    else if (current.getChildren().size() > 0 && returnIteration == false) { //wejście w kolejne dziecko od lewej
                        nextChildren = false;
                        returnIteration = false;
                        currents = current.getChildren();
                        current = currents.get(0);
                        depth++;
                    }
                    else if (currents.size() > 1 && current.equals(currents.get(currents.size() - 1)) == false){ //przejście na kolejne dzieckood lewej //current != currents.get(-1) to sprawdza, czy current nie jest już ostatnim elementem na liście, wtedy przechodzimy do rodzica
                        returnIteration = false;
                        nextChildren = false;
                        int count = 0;
                        for (Dzial temp : currents) { //wyszukanie poprzedniej lokalizacji działu na podstawie pozycji rodzica
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
                                System.out.println("Wprowadzono Błędne dane, Nie ma takiego działu!!!");
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
            if (stopIteration == false) break;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Dzial getRoot() {
        return root;
    }

    @Override
    public Iterator<Dzial> iterator() {
        return new LibraryIterator();
    }

    class LibraryIterator implements Iterator<Dzial> {

        private Dzial current = null, stop = null;
        private List<Dzial> currents = null;
        private int depth = 0;
        private boolean stopIteration = false, returnIteration = false, nextChildren = false;

        @Override
        public boolean hasNext() {
            if (root.getChildren().size() == 0) {
                return false;
            }
            if (current != null) {
                  if (stopIteration) {
                      return false;
                  }
                  else {
                      return true;
                  }
            } else {
                return true;
            }
        }

        @Override
        public Dzial next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            while (true) {
                if (current != null) {
                    if (currents.size() > 0 && returnIteration == false && nextChildren == false) { //przejście przez listę dzieci
                        returnIteration = false;
                        nextChildren = true;
                        return current;
                    } else if (current.getChildren().size() > 0 && returnIteration == false) { //Wejście w kolejne dziecko od lewej
                        nextChildren = false;
                        returnIteration = false;
                        currents = current.getChildren();
                        current = currents.get(0);
                        depth++;
                    } else if (currents.size() > 1 && current.equals(currents.get(currents.size() - 1)) == false) {//Przejście na kolejnego rodzica
                        returnIteration = false;
                        nextChildren = false;
                        int count = 0;
                        for (Dzial temp : currents) { //wyszukanie poprzedniej lokalizacji działu na podstawie pozycji rodzica
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
                                stop = new Dzial("STOP");
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