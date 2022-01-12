package interfaceGraphique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Hashtable;

public class GUIv2 extends JFrame {
    private JLabel labelInformations,labelPlaylist, labelResultat;
    private PlaceholderTextField parametre1,parametre2,parametre3,parametre4; //On utilise des Placeholder pour que
                                                                              //l'utilisateur donne les informations
                                                                              //nécessaire à la recherche
    private JComboBox<String> mainComboBox,subComboBox; //On utilise des ComboBox (liste déroulante) pour choisir
                                                        //quel type d'information l'utilisateur recherche
    private Hashtable<String, String[]> subItems = new Hashtable<String, String[]>();//Liste pour la ComboBox
    private JButton button;
    private JPanel panel;

    public GUIv2(){
        initGUIv2();
    }
    private void initGUIv2(){
        //Dans un premier temps on définit les paramètres de notre fenêtre
        setTitle("Ceci est un titre");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        JLabel jLabel = new JLabel();
        panel.setLayout(null);
        panel.add(jLabel);
        panel.setLayout(null);
        panel.setVisible(true);

        //On introduit in label pour demander à l'utilisateur de rentrer des informations en fonction que ce qu'il cherche
        labelInformations = new JLabel("Veuillez remplir les informations suivantes:");
        labelInformations.setBounds(430, 10, 350, 30);
        labelInformations.setFont( new Font("Comic sans ms",Font.BOLD,16));
        panel.add(labelInformations);

        //Pour le cas Playlist on utilise la 2e ComboBox
        labelPlaylist = new JLabel("<html>Après avoir sélectioner Playlist<br/>veuillez  choisir le genre ici:</html>");
        labelPlaylist.setBounds(15,50,200,35);
        labelPlaylist.setFont( new Font("Comic sans ms",Font.BOLD,13));
        panel.add(labelPlaylist);

        //On utilise une liste déroulante pour définir quels informations souhaite avoir
        String[] items = { "Artiste", "Playlist", "Album", "Podcast", "Beatmaker","Label","Utilisateur"};
        mainComboBox = new JComboBox<String>( items );
        mainComboBox.setFont( new Font("Comic sans ms",Font.BOLD,20));
        mainComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        mainComboBox.setBounds(15,10,200,35);
        panel.add(mainComboBox);

        //La 2e liste déroulante n'est utilisé que dans le cas où l'utilisateur choisie Playlist
        subComboBox = new JComboBox<String>();
        subComboBox.setPrototypeDisplayValue("XXXXXXXXXX");
        subComboBox.setFont( new Font("Comic sans ms",Font.BOLD,20));
        subComboBox.setBounds(15,90,200,35);

        panel.add(subComboBox);

        // Liste utilisé pour le cas Playlist
        String[] subItems1 = { "Genre","Pop","Rap","Variété Française" };
        subItems.put(items[1], subItems1);

        //Ici on définit les PlaceHolder dans lesquels l'utilisateur doit rentrer les paramètres
        parametre1 = new PlaceholderTextField("");
        parametre1.setBounds(430, 50, 350, 30);
        parametre1.setFont( new Font("Comic sans ms",Font.BOLD,16));
        parametre2 = new PlaceholderTextField("");
        parametre2.setBounds(430, 100, 350, 30);
        parametre2.setFont( new Font("Comic sans ms",Font.BOLD,16));
        parametre3 = new PlaceholderTextField();
        parametre3.setBounds(430, 150, 350, 30);
        parametre3.setFont( new Font("Comic sans ms",Font.BOLD,16));
        parametre4 = new PlaceholderTextField();
        parametre4.setBounds(430, 200, 350, 30);
        parametre4.setFont( new Font("Comic sans ms",Font.BOLD,16));
        panel.add(parametre1);
        panel.add(parametre2);
        panel.add(parametre3);
        panel.add(parametre4);

        labelResultat = new JLabel();
        labelResultat.setBounds(170,250,150,40);
        labelResultat.setForeground(Color.black);
        panel.add(labelResultat);

        button = new JButton("Rechercher");
        button.setBounds(15,250,150,40);
        button.setFont( new Font("Comic sans ms",Font.BOLD,20));
        button.addActionListener(new ActionListener() {
            @Override
            //Ici on utilise un ActionListener lié au boutton Recherche pour afficher les résultats
            public void actionPerformed(ActionEvent e) {
                labelResultat.setText("Résultat(s) :");
            }
        });
        panel.add(button);

        mainComboBox.addActionListener(new ActionListener() {
            @Override
            //Cette partie sert à relier les 2 ComboBoxs notamment pour le cas Playlist
            public void actionPerformed(ActionEvent e) {
                String item = (String)mainComboBox.getSelectedItem();
                if (e.getSource() == mainComboBox){
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
                //On utilise des boucles if pour définir quel informations doit rentrer l'utilisateur dans les Placeholder
                if (item == items[0] | item == items[4]){
                    parametre1.setPlaceholder("Nom");
                    parametre2.setPlaceholder("Prénom(s)");
                    parametre3.setPlaceholder("Pseudo");
                }
                if (item == items[1]){
                    parametre1.setPlaceholder("Genre");
                }
                if (item == items[2]){
                    parametre1.setPlaceholder("Nom");
                    parametre2.setPlaceholder("Artiste");
                    parametre3.setPlaceholder("Date de sortie");
                }
                if (item == items[3]){
                    parametre1.setPlaceholder("Nom");
                    parametre2.setPlaceholder("Durée");
                    parametre3.setPlaceholder("Host(s)");
                    parametre4.setPlaceholder("Particitpants");
                }
                if (item == items[5]){
                    parametre1.setPlaceholder("Nom");
                    parametre2.setPlaceholder("Fondateur");
                }
            }
        });
        this.add(panel);
    }
    //Cette partie sert seulement à l'affichage
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIv2 window = new GUIv2();
            window.setVisible(true);
        });
    }
}