import java.util.Objects;

public class Dzial {
    String nazwa;
    double dolnyZakres;
    double gornyZakres;

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
}
