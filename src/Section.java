import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Section {
    private String name;
    private double bottomBorrder;
    private double topBorrder;
    private int level = 0; //,childrenId = 0;  //zmienna level pokazuje poziom działu w strukturze drzewa
    private Section parent = null;
    private final List<Section> children = new ArrayList<>();

    public Section(String name) {//, double dolnyZakres, double gornyZakres) {
        this.name = name;
        //this.dolnyZakres = dolnyZakres;
        //this.gornyZakres = gornyZakres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Section getParent() {
        return parent;
    }

    public void setParent(Section parent) {
        this.parent = parent;
    }

    public List<Section> getChildren() {
        return children;
    }

    public void setChildren(Section children) {
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
        Section section = (Section) o;
        return Double.compare(section.bottomBorrder, bottomBorrder) == 0 &&
                Double.compare(section.topBorrder, topBorrder) == 0 &&
                Objects.equals(name, section.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bottomBorrder, topBorrder);
    }

    @Override
    public String toString() {
        return name;
    }
}
