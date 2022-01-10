import java.util.List;
import java.util.Objects;

public class Tytul {
    private String tytul;
    List<Double> ksiazki;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tytul tytul1 = (Tytul) o;
        return Objects.equals(tytul, tytul1.tytul) &&
                Objects.equals(ksiazki, tytul1.ksiazki);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tytul, ksiazki);
    }
}
