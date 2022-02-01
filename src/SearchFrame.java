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




public class SearchFrame extends JFrame {


    public SearchFrame() throws FileNotFoundException {
        super("System Biblioteczny");
    }

    static ActionListener ac;

    public void LaunchSearchFrame() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(1);
            }
        });

        Panel panelWyszukiwania = new Panel (new GridLayout(3,1));
        panelWyszukiwania.setPreferredSize(new Dimension(50,200));

        Label Wyszukiwanie;

        Label wyszukajKsiazke;
        Label wyszukajDzial;
        TextField wyszukanyDzial;
        TextField wyszukanaKsiazka;
        Button powrot;


        panelWyszukiwania.add(wyszukajDzial = new Label("Wyszukaj Dział"));
        panelWyszukiwania.add(wyszukanyDzial = new TextField("",20));
        panelWyszukiwania.add(wyszukajKsiazke = new Label("Wyszukaj książkę"));
        panelWyszukiwania.add(wyszukanaKsiazka = new TextField("",20));

        wyszukanyDzial.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TU MUSI 'ROBIĆ SIE' FUNKCJA CO FILTRUJE PO WYSZUKIWANIU

            }
        });
        wyszukanaKsiazka.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TU MUSI 'ROBIĆ SIE' FUNKCJA CO FILTRUJE PO WYSZUKIWANIU
            }
        });

        panelWyszukiwania.add(powrot = new Button("Powrót"));
        powrot.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        add(panelWyszukiwania);
        pack();

        setBackground(Color.LIGHT_GRAY);
        panelWyszukiwania.setPreferredSize(new Dimension(200,200));
        setBounds((Toolkit.getDefaultToolkit().getScreenSize().width >> 1) - (getSize().width >> 1),
                (Toolkit.getDefaultToolkit().getScreenSize().height >> 1) - (getSize().height >> 1), getSize().width, getSize().height);
        setBounds(500, 500, 700, 500);

        EventQueue.invokeLater(() -> setVisible(true));
        setFont(new Font("Courier", Font.BOLD,10));


    }
}
