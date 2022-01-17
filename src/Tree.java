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
        int depth = 1;
        boolean stopIteration = true, returnIteration = false;

        while (current != null) {
            if(current.getNazwa().equals(nazwaDzialu) && current == root) { //sprawddzanie i dodanie kolejnego poddodzialu, jesłi dodajemy do roota
                current.setChildren(nowypodOddzial);
                for (int i = 0; i < current.getChildren().size(); i++) { // ustawianie rodzica
                    current.getChildren().get(i).setParent(current);
                    nowypodOddzial.setLevel(depth);
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
                    for (Dzial temp : currents) { //iteracja po dzieciach
                        if (temp.getNazwa().equals(nazwaDzialu)) { //sprawddzanie i dodanie kolejnego poddodzialu
                            temp.setChildren(nowypodOddzial);
                            nowypodOddzial.setLevel(depth);
                            for (int i = 0; i < temp.getChildren().size(); i++) {
                                temp.getChildren().get(i).setParent(temp);
                            }
                            stopIteration = false;
                            break;
                        }
                    }
                    if (stopIteration == false) break;

                    if (current.getChildren().size() > 0 && returnIteration == false) { //wejście w kolejne dziecko od lewej
                        currents = current.getChildren();
                        current = currents.get(0);
                        depth++;
                        returnIteration = false;
                    }
                    else if (currents.size() > 1 && current.equals(currents.get(currents.size() - 1)) == false){ //przejście na kolejne dzieckood lewej //current != currents.get(-1) to sprawdza, czy current nie jest już ostatnim elementem na liście, wtedy przechodzimy do rodzica
                        returnIteration = false;
                        int count = 0;
                        for (Dzial temp : currents) { //wyszukanie poprzedniej lokalizacji działu na podstawie pozycji rodzica
                            if (current.equals(temp)) {
                                current = currents.get(++count);         //przejście na kolejnego rodzica
                                break;
                            }
                            count++;
                        }
                    } else {                                                        //powrót do rodzica
                        if (depth > 0) {
                            current = current.getParent();
                            currents = current.getParent().getChildren();
                            depth--;
                            returnIteration = true; // zmienna informuje, że current został przypisany do rodzica
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
        private int depth = 0, currentElement = 0;
        private boolean stopIteration = false, returnIteration = false, nextParent = false, nextChildren = false;

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
                        nextParent = false;
                        returnIteration = false;
                        nextChildren = true;
                        return current;
                    } else if (current.getChildren().size() > 0 && returnIteration == false) { //Wejście w kolejne dziecko od lewej
                        nextParent = false;
                        nextChildren = false;
                        currents = current.getChildren();
                        current = currents.get(0);
                        depth++;
                    } else if (currents.size() > 1 && current.equals(currents.get(currents.size() - 1)) == false) {//Przejście na kolejnego rodzica
                        currentElement = 0;
                        returnIteration = false;
                        nextParent = true; //zmienna informuje nas, że przechodzimy do kolejnego rodzica
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
                        currentElement = 0;
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
    /*
    @Override
    public Iterator iterator() {
        Iterator it = new Iterator<>() {
            private Dzial current = null;
            private List<Dzial> currents = null;
            private int currentElement = 0;

            @Override
        public boolean hasNext() {
                if (current == null && root != null) {
                    return  true;
                }
                else if (current != null) {
                    return true;
                }
                return false;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public Dzial next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                //String nazwa = current.getNazwa();
                //int counter = 0;
                if (current != null) {
                    if (currentElement > currents.size() - 1) {
                        currents = current.getChildren();
                        current = current.getChildren().get(0);
                        currentElement = 0;
                    }
                    return currents.get(currentElement++);
                }
                else {
                    current = root;
                    currents = current.getChildren();
                    current = current.getChildren().get(0);
                    return root;
                }
                    //while (current.getChildren() != null) {
                        //counter++;
                        //if (current.getChildren().get(0) == null) {
                            //System.out.println("dupa" + counter);
                          //  return currents.get(currentElement++);
                        //}
                        //for (Dzial i : current.getChildren()) {
                        //    nazwa = i.getNazwa();
                            //System.out.println(nazwa);
                        //}


                        //if (current.getChildren().get(0) == null) {
                        //    System.out.println("nie było dzieci");
                            //break;
                        //}
                    //}
                //return current;
            }
        };
        return it;
    }




}
/*
class LibraryIterator implements Iterator<Dzial> {
    private List<Dzial> currentListChildren = null;
    private List<Dzial> treeElements = new ArrayList<>();
    private int currentElement = 0;

    public LibraryIterator() {

            /*
            if (current == null && root != null) {
                iterators.add(root.iterator());
            }
            else if (current != null)
            {
                currentListChildren = current.getChildren();
                for (Dzial i : currentListChildren) {
                    tempList.add(i);
                }
                current = current.getChildren().get(0);
                return tempList.;
            }

             */
        /*}

        @Override
        public boolean hasNext() {
            return (currentElement < treeElements.size());
            /*
            if (current == null && root != null)
            {
                return true;
            }
            else if (current != null)
            {
                return current.getChildren() != null;
            }
            return false;

             */
            /*
        }

        @Override
        public Dzial next() {
            if (root != null) {
                return root;
            }
            else {
                return treeElements.get(currentElement++);
            }
            /*
            if (current == null && root != null) {
                current = root;
                return root;
            }
            else if (current != null)
            {
                currentListChildren = current.getChildren();
                for (Dzial i : currentListChildren) {
                    tempList.add(i);
                }
                current = current.getChildren().get(0);
                return tempList.;
            }
            throw new NoSuchElementException();


        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

             */