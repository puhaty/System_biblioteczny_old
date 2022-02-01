
/*TODO:

zapis catalogu do pliku
przenesienie fukcji do odpowiednich bloków
setDefaultCloseOperation - zeby nie zamykało się wszystko tylko wybrane okno
zrobic zeby bylo ladnie (rozmiary przycisków, centering itp)
 */





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

    public EditFrame editFrame;
    public SearchFrame searchFrame;


    public Window() throws FileNotFoundException {
        super("System Biblioteczny");
    }

    static ActionListener ac;

    public void LaunchFrame(){
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(1);
            }
        });

        Panel MainPanel = new Panel(new GridLayout(5,1));


        //tylko tekst "System Biblioteczny"
        Panel witaj = new Panel(new GridLayout(1,1));
        Label systembiblioteczny;
        witaj.add(systembiblioteczny = new Label("System Biblioteczny"));



        Button edycja;

        MainPanel.add(edycja = new Button("Edycja"));
        edycja.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    editFrame = new EditFrame();
                    editFrame.LaunchEditFrame();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });


        Button wyszukaj;

        MainPanel.add(wyszukaj = new Button("Wyszukaj"));
        wyszukaj.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    searchFrame = new SearchFrame();
                    searchFrame.LaunchSearchFrame();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
        });

        Panel niewiempoco = new Panel(new GridLayout(1,1));


        Panel opcjeNaKoniec = new Panel(new GridLayout(1,2));
        opcjeNaKoniec.setPreferredSize(new Dimension(100,20));

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
                System.exit(1);

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

        MainPanel.setPreferredSize(new Dimension(300,300));
        setBounds((Toolkit.getDefaultToolkit().getScreenSize().width >> 1) - (getSize().width >> 1),
                (Toolkit.getDefaultToolkit().getScreenSize().height >> 1) - (getSize().height >> 1), getSize().width, getSize().height);

        setBounds(500, 500, 700, 500);
        EventQueue.invokeLater(() -> setVisible(true));
        setFont(new Font("Courier", Font.BOLD,10));

    }

    public static void main(String[] args) throws FileNotFoundException{
        Window gui = new Window();
        gui.LaunchFrame();

    }


}
