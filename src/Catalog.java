import java.util.*;

public class Catalog implements Iterable<Section> {
    private final Section root;
    private String name;
    private double bottomBorrderId;
    private double topBorderId;


    /**
     *konstruktor drzewa
     * @param name - nazwa drzewa
     * @param bottomBorrderId - początek zakresu drzewa
     * @param topBorderId - koniec zakresu drzewa
     */
    public Catalog(String name, double bottomBorrderId, double topBorderId) {
        this.root = new Section(name);
        this.root.setParent(null);
        this.name = name;
        this.bottomBorrderId = bottomBorrderId;
        this.topBorderId = topBorderId;
    }

    /**
     *funkcja dodaje główne działy do głównego węzła: root
     * @param name - nazwa dodawanego działu
     */
    public void addSection(String name) {
        Section newSection = new Section(name);
        addChildren(root, newSection, 0);
    }

    /**
     *funkcja dodaje nowy podkatalog do istniejącego już katalogu
     * @param sectionName - nawa działu do którego dodajemy pododdział
     * @param subsectionName - nazwa pododdziału
     */
    public void addSubsection(String sectionName, String subsectionName) {
        Section newSubsection = new Section(subsectionName);
        Section tempSection = searchSection(sectionName);
        if (tempSection != null) {
            int level = tempSection.getLevel();
            addChildren(tempSection, newSubsection, level);
        } else {
            System.out.println("\nWprowadzono Błędne dane, Nie ma takiego działu!!!");
        }
    }

    /**
     * funkcja dodaje dziecko do wskazanego węzła
     * @param current - węzeł do którego będziemy dodawali
     * @param newChildren - nazwa dziecka które dodajemy
     * @param depth - głębokość(poziom) drzewa
     */
    private void addChildren(Section current, Section newChildren, int depth) {
        current.setChildren(newChildren);
        newChildren.setLevel(depth + 1);
        for (int i = 0; i < current.getChildren().size(); i++) {
            current.getChildren().get(i).setParent(current);
        }
    }

    public void editSection(String sectionName, String newSectionName) {
        Section edit = searchSection(sectionName);
        if (edit != null) {
            edit.setName(newSectionName);
        } else {
            System.out.println("\nWprowadzono Błędne dane, Nie ma takiego działu!!!");
        }

    }

    public void replaceSection(String replaceSectionName, String targetSectionName) {
        Section section1 = searchSection(replaceSectionName);
        Section section2 = searchSection(targetSectionName);

        if (section1 != null && section2 != null) {
            Section parentSection1 = section1.getParent();
            parentSection1.getChildren().remove(section1);
            section1.setParent(section2);
            section2.setChildren(section1);
            releveling(section1);
            System.out.println();
        } else {
            System.out.println("\nWprowadzono Błędne dane, Nie ma takiego działuxd!!!");
        }
    }

    void releveling(Section section) {
        Section current = null;
        List<Section> currents = null;

        boolean stopIteration = true, returnIteration = false, nextChildren = false;

        if((section.getLevel() - section.getParent().getLevel()) != 1) {
            section.setLevel(section.getParent().getLevel() + 1);
        }
        current = section;
        if (current.getChildren().size() > 0) {
            currents = current.getChildren();
            current = currents.get(0);

            while (true) {
                if (current.equals(section) && returnIteration) break;

                if ((current.getLevel() - current.getParent().getLevel()) != 1) {
                    current.setLevel(current.getParent().getLevel() + 1);
                }

                if (current.getChildren().size() > 0 && !returnIteration) { //wejście w kolejne dziecko od lewej
                    nextChildren = false;
                    currents = current.getChildren();
                    current = currents.get(0);
                } else if (currents.size() > 1 && !current.equals(currents.get(currents.size() - 1))) { //przejście na kolejne dzieckood lewej //current != currents.get(currents.size() - 1) to sprawdza, czy current nie jest już ostatnim elementem na liście, wtedy przechodzimy do rodzica
                    returnIteration = false;
                    nextChildren = false;
                    int count = 0;
                    for (Section temp : currents) { //wyszukanie poprzedniej lokalizacji działu na podstawie pozycji rodzica
                        if (current.equals(temp)) {
                            current = currents.get(++count);         //przejście na kolejnego rodzica
                            break;
                        }
                        count++;
                    }
                } else {               //powrót do rodzica
                    current = current.getParent();
                    currents = current.getParent().getChildren();
                    returnIteration = true; // zmienna informuje, że current został przypisany do rodzica
                }
            }
        }
    }

    //szukanie działu po nazwie
    public Section searchSection(String sectionName) {
        Section current = root;
        List<Section> currents = null;
        int level = 0;
        boolean stopIteration = true, returnIteration = false, nextChildren = false;

        while (current != null) {
            if(current.getName().equals(sectionName) && current == root) { //sprawddzanie i dodanie kolejnego poddodzialu, jesłi dodajemy do roota
                return current;
            }

            if (current == root) {
                currents = current.getChildren();
                current = currents.get(0);
                level++;
            }
            if (!isEmpty()) {
                while (true) {

                    if (currents.size() > 0 && !returnIteration && !nextChildren) {
                        nextChildren = true;
                        if (current.getName().equals(sectionName)) { //sprawddzanie i dodanie kolejnego poddodzialu
                            return current;
                        }
                    }
                    else if (current.getChildren().size() > 0 && !returnIteration) { //wejście w kolejne dziecko od lewej
                        nextChildren = false;
                        currents = current.getChildren();
                        current = currents.get(0);
                        level++;
                    }
                    else if (currents.size() > 1 && !current.equals(currents.get(currents.size() - 1))){ //przejście na kolejne dzieckood lewej //current != currents.get(currents.size() - 1) to sprawdza, czy current nie jest już ostatnim elementem na liście, wtedy przechodzimy do rodzica
                        returnIteration = false;
                        nextChildren = false;
                        int count = 0;
                        for (Section temp : currents) { //wyszukanie poprzedniej lokalizacji działu na podstawie pozycji rodzica
                            if (current.equals(temp)) {
                                current = currents.get(++count);         //przejście na kolejnego rodzica
                                break;
                            }
                            count++;
                        }
                    } else {               //powrót do rodzica
                        if (level > 0) {
                            level--;
                            if (level == 0) { //nic nie znaleziono
                                //System.out.println("\nWprowadzono Błędne dane, Nie ma takiego działu!!!");
                                stopIteration = false;
                                break;
                            } else {
                                current = current.getParent();
                                currents = current.getParent().getChildren();
                                returnIteration = true; // zmienna informuje, że current został przypisany do rodzica
                            }
                        }
                    }
                }
            }
            if (!stopIteration) break;
        }
        return null;
    }

    /**
     * przeciążenie metody aby wyszukiwała po dziale
     * @param section
     * @return
     */
    public Section searchSection(Section section) {
        Section current = root;
        List<Section> currents = null;
        int level = 0;
        boolean stopIteration = true, returnIteration = false, nextChildren = false;

        while (current != null) {
            if(current.equals(section) && current == root) { //sprawddzanie i dodanie kolejnego poddodzialu, jesłi dodajemy do roota
                return current;
            }

            if (current == root) {
                currents = current.getChildren();
                current = currents.get(0);
                level++;
            }
            if (!isEmpty()) {
                while (true) {

                    if (currents.size() > 0 && !returnIteration && !nextChildren) {
                        nextChildren = true;
                        if (current.equals(section)) { //sprawddzanie i dodanie kolejnego poddodzialu
                            return current;
                        }
                    }
                    else if (current.getChildren().size() > 0 && !returnIteration) { //wejście w kolejne dziecko od lewej
                        nextChildren = false;
                        currents = current.getChildren();
                        current = currents.get(0);
                        level++;
                    }
                    else if (currents.size() > 1 && !current.equals(currents.get(currents.size() - 1))){ //przejście na kolejne dzieckood lewej //current != currents.get(currents.size() - 1) to sprawdza, czy current nie jest już ostatnim elementem na liście, wtedy przechodzimy do rodzica
                        returnIteration = false;
                        nextChildren = false;
                        int count = 0;
                        for (Section temp : currents) { //wyszukanie poprzedniej lokalizacji działu na podstawie pozycji rodzica
                            if (current.equals(temp)) {
                                current = currents.get(++count);         //przejście na kolejnego rodzica
                                break;
                            }
                            count++;
                        }
                    } else {               //powrót do rodzica
                        if (level > 0) {
                            level--;
                            if (level == 0) { //nic nie znaleziono
                                //System.out.println("\nWprowadzono Błędne dane, Nie ma takiego działu!!!");
                                stopIteration = false;
                                break;
                            } else {
                                current = current.getParent();
                                currents = current.getParent().getChildren();
                                returnIteration = true; // zmienna informuje, że current został przypisany do rodzica
                            }
                        }
                    }
                }
            }
            if (!stopIteration) break;
        }
        return null;
    }

    /**
     * sprawdza czy jest drzewo jest puste
     */
    public boolean isEmpty() {
        return root.getChildren().isEmpty();
    }

    public Section getRoot() {
        return root;
    }

    @Override
    public Iterator<Section> iterator() {
        return new LibraryIterator();
    }

    /**
     * Iterator po drzewie
     */
    class LibraryIterator implements Iterator<Section> {

        private Section current = null;
        private List<Section> currents = null;
        private int level = 0;
        private boolean stopIteration = false, returnIteration = false, nextChildren = false;

        @Override
        public boolean hasNext() {
            if (isEmpty()) {
                return false;
            }
            if (current != null) {
                return !stopIteration;
            } else {
                return true;
            }
        }

        @Override
        public Section next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            while (true) {
                if (current != null) {
                    if (currents.size() > 0 && !returnIteration && !nextChildren) { //przejście przez listę dzieci
                        nextChildren = true;
                        return current;
                    } else if (current.getChildren().size() > 0 && !returnIteration) { //Wejście w kolejne dziecko od lewej
                        nextChildren = false;
                        currents = current.getChildren();
                        current = currents.get(0);
                        level++;
                    } else if (currents.size() > 1 && !current.equals(currents.get(currents.size() - 1))) {//Przejście na kolejnego rodzica
                        returnIteration = false;
                        nextChildren = false;
                        int count = 0;
                        for (Section temp : currents) { //wyszukanie poprzedniej lokalizacji działu na podstawie pozycji rodzica
                            if (current.equals(temp)) {
                                current = currents.get(++count);         //trzeba zmienić żeby brał następną wartość;
                                break;
                            }
                            count++;
                        }
                    } else { //powrót do rodzica
                        if (level > 0) {
                            level--;
                            if (level == 0) {
                                Section stop = new Section("STOP");
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
                    level++;
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