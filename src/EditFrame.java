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





public class EditFrame extends JFrame {

    public EditFrame() throws FileNotFoundException {
        super("System Biblioteczny");
    }

    static ActionListener ac;

    public void LaunchEditFrame() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(1);
            }
        });


        Panel panelEdycji = new Panel(new GridLayout(5, 2));
        panelEdycji.setPreferredSize(new Dimension(50, 200));




        TextField dodajK;
        TextField dodajD;

        TextField edytujIstnK;
        TextField edytujIstnD;

        TextField przenoszonyD;
        TextField gdziejestprzenoszonyD;


        panelEdycji.add(dodajD = new TextField("",20));
        panelEdycji.add(dodajK = new TextField("",20));
        panelEdycji.add(edytujIstnD = new TextField("",20));
        panelEdycji.add(edytujIstnK = new TextField("",20));
        panelEdycji.add(przenoszonyD = new TextField("Przenoszony dział",20));
        panelEdycji.add(gdziejestprzenoszonyD = new TextField("Gdzie chcesz przenieść",20));

        dodajD.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        Button dodajDzial;
        Button dodajKsiazke;
        Button edytuIstniejacaKsiazke;
        Button edytujIstniejacyDzial;
        Button przeniesDzial;

        panelEdycji.add(dodajDzial = new Button("Dodaj Dział"));

        dodajDzial.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajD.getText();
                //TU MUSI 'ROBIĆ SIE' FUNKCJA CO DODAJE NOWY DZIAL
                if (dodajD.getText() == null){
                    //zrobic okienko "wprowadz dane" (takie same we wszystkich przypadkach)
                }

            }
        });

        panelEdycji.add(dodajKsiazke = new Button("Dodaj Książkę"));
        dodajKsiazke.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dodajK.getText();
                if (dodajK.getText() == null){

                }


            }
        });

        panelEdycji.add(edytujIstniejacyDzial = new Button("Edytuj istniejący dział"));
        edytujIstniejacyDzial.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        panelEdycji.add(edytuIstniejacaKsiazke = new Button("Edytuj istniejącą książkę"));
        edytuIstniejacaKsiazke.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        panelEdycji.add(przeniesDzial = new Button("Przenieś dział"));
        przeniesDzial.addActionListener(ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        add(panelEdycji);
        pack();

        setBackground(Color.LIGHT_GRAY);
        panelEdycji.setPreferredSize(new Dimension(200,200));
        setBounds((Toolkit.getDefaultToolkit().getScreenSize().width >> 1) - (getSize().width >> 1),
                (Toolkit.getDefaultToolkit().getScreenSize().height >> 1) - (getSize().height >> 1), getSize().width, getSize().height);
        setBounds(500, 500, 700, 500);

        EventQueue.invokeLater(() -> setVisible(true));
        setFont(new Font("Courier", Font.BOLD,10));
    }


}










