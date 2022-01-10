import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Tree implements Iterable<String>{
    private Dzial root;
    //private List<Dzial> dzialy = new ArrayList<>();
    private String nazwa;
    private double bottomBorrderId;
    private double topBorderId;
    List<Pozycja> pozycje;

    public Tree(String nazwa, double bottomBorrderId, double topBorderId) {
        this.root = new Dzial(nazwa);
        this.nazwa = nazwa;
        this.bottomBorrderId = bottomBorrderId;
        this.topBorderId = topBorderId;
    }

    public void dodajDzial(String nazwa) {
        Dzial nowyDzial = new Dzial(nazwa);

        if (isEmpty()) {
            root = nowyDzial;
        } else {
            root.setChildren(nowyDzial);
            root.setParent(root);
            nowyDzial.setChildren(null);
        }
    }

    public boolean isEmpty() { return root == null; }


    @Override
    public Iterator iterator() {
        Iterator it = new Iterator<>() {
            private Dzial current = root;
            private List<Dzial> currents = null;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                String nazwa = current.getNazwa();
                if (current.getChildren() != null) {
                    currents = current.getChildren();
                    for (Dzial i : currents) {
                        nazwa = i.getNazwa();
                        return nazwa;
                    }
                }
                return nazwa;
            }
        };
        return it;
    }


}