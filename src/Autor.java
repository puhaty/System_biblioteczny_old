import java.util.List;
import java.util.Objects;

public class Autor {
    String imieINazwisko;
    List<Double> ksiazki;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(imieINazwisko, autor.imieINazwisko) &&
                Objects.equals(ksiazki, autor.ksiazki);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imieINazwisko, ksiazki);
    }
}
