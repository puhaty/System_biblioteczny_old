import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Panel;

public class Window extends Frame {

    public Window() throws FileNotFoundException {
        super("dupa");
    }

    static ActionListener ac;

    public void LaunchFrame(){
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(1);
            }
        });

        Panel MainPanel = new Panel(new BorderLayout(50,10));

        Panel witaj = new Panel(new GridLayout(1,1));
        Label systembiblioteczny;
        witaj.add(systembiblioteczny = new Label("System Biblioteczny"));


        Panel edycja = new Panel(new GridLayout(6,1));



        Button dodajDzial;
        Button dodajKsiazke;
        Button edytuIstniejacaKsiazke;
        Button edytujIstniejacyDzial;
        Button przeniesDzial;

        edycja.add(dodajDzial = new Button("Dodaj Dział"));
        dodajDzial.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        edycja.add(dodajKsiazke = new Button("Dodaj Książkę"));
        dodajKsiazke.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        edycja.add(edytujIstniejacyDzial = new Button("Edytuj istniejący dział"));
        edytujIstniejacyDzial.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        edycja.add(edytuIstniejacaKsiazke = new Button("Edytuj istniejącą książkę"));
        edytuIstniejacaKsiazke.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        edycja.add(przeniesDzial = new Button("Przenieś dział"));
        przeniesDzial.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        Panel wyszukaj = new Panel (new GridLayout(3,1));

        Label Wyszukiwanie;

        Label wyszukajKsiazke;
        Label wyszukajDzial;
        TextField wyszukanyDzial;
        TextField wyszukanaKsiazka;


        wyszukaj.add(wyszukajDzial = new Label("Wyszukaj Dział"));
        wyszukaj.add(wyszukanyDzial = new TextField("",20));
        wyszukaj.add(wyszukajKsiazke = new Label("Wyszukaj książkę"));
        wyszukaj.add(wyszukanaKsiazka = new TextField("",20));

        wyszukanyDzial.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        wyszukanaKsiazka.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        Panel niewiempoco = new Panel();


        Panel opcjeNaKoniec = new Panel(new GridLayout(1,2));

        Button zapisz;
        Button wyjdz;

        opcjeNaKoniec.add(zapisz = new Button("Zapisz stan katalogu"));
        zapisz.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        opcjeNaKoniec.add(wyjdz = new Button("Wyjdź"));
        wyjdz.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        MainPanel.add(witaj);
        MainPanel.add(edycja);
        MainPanel.add(wyszukaj);
        MainPanel.add(niewiempoco);
        MainPanel.add(opcjeNaKoniec);

        add(MainPanel);

        setBackground(Color.LIGHT_GRAY);
        pack();

        setBounds(500, 500, 700, 500);
        EventQueue.invokeLater(() -> setVisible(true));

    }

    public static void main(String[] args) throws FileNotFoundException{
        Window gui = new Window();
        gui.LaunchFrame();

    }


}
