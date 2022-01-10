import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Tree implements Iterable<String>{
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

    public boolean isEmpty() { return root == null; }


    @Override
    public Iterator iterator() {
        Iterator it = new Iterator<>() {
            private Dzial current = root;
            private List<Dzial> currents = null;

            @Override
            public boolean hasNext() {
                return current.getChildren() != null;
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
                String nazwa = current.getNazwa();
                int counter = 0;
                if (current.getChildren() != null) {
                    while (current.getChildren() != null) {
                        counter++;
                        if (current.getChildren().get(0) == null) {
                            System.out.println("dupa" + counter);
                            return current;
                        }
                        for (Dzial i : current.getChildren()) {
                            nazwa = i.getNazwa();
                            //System.out.println(nazwa);
                        }
                        current = current.getChildren().get(0);
                        if (current.getChildren().get(0) == null) {
                            System.out.println("nie było dzieci");
                            break;
                        }
                    }
                }
                return current;
            }
        };
        return it;
    }


}