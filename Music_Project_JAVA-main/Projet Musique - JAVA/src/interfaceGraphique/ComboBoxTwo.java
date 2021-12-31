package interfaceGraphique;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionListener;



public class ComboBoxTwo extends JPanel implements ActionListener
{
    private JComboBox<String> mainComboBox;
    private JComboBox<String> subComboBox;
    private Hashtable<String, String[]> subItems = new Hashtable<String, String[]>();
    private PlaceholderTextField nomArtiste, prenomArtiste, pseudoArtiste;


    public ComboBoxTwo()
    {
        String[] items = { "Artiste", "Playlist" };
        mainComboBox = new JComboBox<String>( items );
        mainComboBox.addActionListener( this );

        //  prevent action events from being fired when the up/down arrow keys are used
        mainComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        add( mainComboBox );

        //  Create sub combo box with multiple models

        subComboBox = new JComboBox<String>();
        subComboBox.setPrototypeDisplayValue("XXXXXXXXXX"); // JDK1.4
        add( subComboBox );

        String[] subItems0 = { "Nom","Prénom","Pseudo" };
        subItems.put(items[0], subItems0);

        String[] subItems1 = { "Genre","Pop","Rap","Variété Française" };
        subItems.put(items[1], subItems1);
    }

    public void actionPerformed(ActionEvent e)
    {
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

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new ComboBoxTwo() );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}
