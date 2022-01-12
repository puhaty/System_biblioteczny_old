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
        } else {
            root.setChildren(nowyDzial);
            root.setParent(root);
            nowyDzial.setChildren(null);
        }
    }

    public void dodajPodOddzial(String nazwaDzialu, String nazwaPodOddzialu) {
        Dzial nowypodOddzial = new Dzial(nazwaPodOddzialu);
        Dzial current = root;
        List<Dzial> currents = null;
        int currentElement = 0;
        while (current != null) {
            if(current.getNazwa().equals(nazwaDzialu)) {
                current.setChildren(nowypodOddzial);
                break;
            }

            if (current == root) {
                currents = current.getChildren();
            }

            if (currentElement == currents.size()) {
                currentElement = 0;
                currents = current.getChildren();
                current = current.getChildren().get(currentElement);
            }

            current = currents.get(currentElement);
            currentElement++;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Iterator<Dzial> iterator() {
        return new LibraryIterator();
    }

    class LibraryIterator implements Iterator<Dzial> {

        private Dzial current = null;
        private List<Dzial> currents = null;
        private int currentElement = 0;
        private boolean stopIteration = false;

        @Override
        public boolean hasNext() {
            if (current == null && root != null) {
                return true;
            } else if (current != null) {
                if (currentElement == currents.size()) {
                    return false;
                }
                if (stopIteration) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override
        public Dzial next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            if (current != null) {
                if (currentElement == currents.size()) {
                    currents = current.getChildren();
                    current = current.getChildren().get(0);
                    currentElement = 0;
                    if (current == null) {
                        stopIteration = true;
                    }
                }
                return currents.get(currentElement++);
            } else {
                current = root;
                currents = current.getChildren();
                current = current.getChildren().get(0);
                return root;
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