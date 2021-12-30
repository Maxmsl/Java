package interfaceGraphique;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;


public class GUI extends JFrame {
    private JLabel labelArtiste, labelTitre, labelResultat;
    private PlaceholderTextField nomArtiste, prenomArtiste, pseudoArtiste;
    private JPanel panel;
    private JButton button;
    private JComboBox<String> mainComboBox, subComboBox;
    private Hashtable<String, String[]> subItems;

    public GUI(){
        initGUI();
    }

    private void initGUI() {
        setTitle("Ceci est un titre");
        setSize(700, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        nomArtiste = new PlaceholderTextField("");
        nomArtiste.setPlaceholder("Nom de l'artiste");
        nomArtiste.setFont( new Font("Comic sans ms",Font.BOLD,22));
        nomArtiste.setBounds(15, 100, 250, 40);

        prenomArtiste = new PlaceholderTextField("");
        prenomArtiste.setPlaceholder("Prénom de l'artiste");
        prenomArtiste.setFont( new Font("Comic sans ms",Font.BOLD,22));
        prenomArtiste.setBounds(15, 150, 250, 40);

        pseudoArtiste = new PlaceholderTextField("");
        pseudoArtiste.setPlaceholder("Pseudo de l'artiste");
        pseudoArtiste.setFont( new Font("Comic sans ms",Font.BOLD,22));
        pseudoArtiste.setBounds(15, 200, 250, 40);


        panel = new JPanel();
        panel.setLayout(null);

        panel.add(nomArtiste);
        panel.add(prenomArtiste);
        panel.add(pseudoArtiste);

        this.add(panel);

        String[] optionsToChoose = {"Artiste", "Titre", "Label", "Podcast", "Beatmaker", "Playlist"};
        mainComboBox= new JComboBox<>(optionsToChoose);
        mainComboBox.addActionListener((ActionListener) this);
        mainComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        mainComboBox.setBounds(15, 40, 140, 20);

        subComboBox = new JComboBox<String>();
        subComboBox.setPrototypeDisplayValue("XXXXXXXXXX");

        subItems = new Hashtable<String, String[]>();
        String[] subItems1 = { "Select Color", "Red", "Blue", "Green" };
        subItems.put(optionsToChoose[1], subItems1);
        String[] subItems2 = { "Select Shape", "Circle", "Square", "Triangle" };
        subItems.put(optionsToChoose[2], subItems2);
        String[] subItems3 = { "Select Fruit", "Apple", "Orange", "Banana" };
        subItems.put(optionsToChoose[3], subItems3);


        JButton jButton = new JButton("Rechercher");
        jButton.setBounds(500,140,110,25);

        JLabel jLabel = new JLabel();
        jLabel.setBounds(90, 100, 400, 100);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCategory = "You selected " + mainComboBox.getItemAt(mainComboBox.getSelectedIndex());
                jLabel.setText(selectedCategory);

                String item = (String)mainComboBox.getSelectedItem();
                Object o = subItems.get( item );

                if (o == null)
                {
                    subComboBox.setModel( new DefaultComboBoxModel() );
                }
                else
                {
                    subComboBox.setModel( new DefaultComboBoxModel( (String[])o ) );
                }
            }
        });
        panel.add(jButton);
        panel.add(mainComboBox);
        panel.add(subComboBox);
        panel.add(jLabel);
        panel.setLayout(null);
        panel.setSize(350, 250);
        panel.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUI window = new GUI();
            window.setVisible(true);
        });
        
    }
}