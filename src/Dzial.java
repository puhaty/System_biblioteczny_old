import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Dzial {
    private String nazwa;
    private double dolnyZakres;
    private double gornyZakres;
    private int childrenId = 0, level = 0; //zmienna level pokazuje poziom działu w strukturze drzewa
    private Dzial parent = null;
    private List<Dzial> children = new ArrayList<>();

    public Dzial(String nazwa) {//, double dolnyZakres, double gornyZakres) {
        this.nazwa = nazwa;
        //this.dolnyZakres = dolnyZakres;
        //this.gornyZakres = gornyZakres;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Dzial getParent() {
        return parent;
    }

    public void setParent(Dzial parent) {
        this.parent = parent;
    }

    public List<Dzial> getChildren() {
        return children;
    }

    public void setChildren(Dzial children) {
        this.children.add(children);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dzial dzial = (Dzial) o;
        return Double.compare(dzial.dolnyZakres, dolnyZakres) == 0 &&
                Double.compare(dzial.gornyZakres, gornyZakres) == 0 &&
                Objects.equals(nazwa, dzial.nazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, dolnyZakres, gornyZakres);
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
