import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Tree implements Iterable<String>{
    private Dzial root;
    private double bottomBorrderId;
    private double topBorderId;
    List<Pozycja> pozycje;

    public Tree(double bottomBorrderId, double topBorderId) {
        this.root = null;
        this.bottomBorrderId = bottomBorrderId;
        this.topBorderId = topBorderId;
    }

    public void dodajDzial(String nazwa) {
        Dzial nowyDzial = new Dzial(nazwa);

        if (isEmpty()) {
            root = nowyDzial;
        } else if (root.getChildren() == null){
            root.setChildren(nowyDzial);
            root.setParent(root);
            nowyDzial.setChildren(null);
        }
        else {
            Dzial kolejnyDzial = new Dzial(nazwa);

        }
    }

    public boolean isEmpty() { return root == null; }


    @Override
    public Iterator iterator() {
        Iterator it = new Iterator<>() {
            private Dzial current = root;

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
                current = current.getChildren();
                return nazwa;
            }
        };
        return it;
    }


}