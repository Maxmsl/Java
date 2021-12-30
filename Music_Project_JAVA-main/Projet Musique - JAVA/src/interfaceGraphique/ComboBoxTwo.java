package interfaceGraphique;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionListener;



public class ComboBoxTwo extends JPanel {
    public static void main(String[] args) {

    }

    JComboBox<String> mainComboBox;
         JComboBox<String> subComboBox;
         Hashtable<String, String[]> subItems = new Hashtable<String, String[]>();

        public ComboBoxTwo()
        {
            String[] items = { "Select Item", "Color", "Shape", "Fruit" };
            mainComboBox = new JComboBox<String>( items );
            mainComboBox.addActionListener((ActionListener) this);

            //  prevent action events from being fired when the up/down arrow keys are used
            mainComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
            add( mainComboBox );

            //  Create sub combo box with multiple models

            subComboBox = new JComboBox<String>();
            subComboBox.setPrototypeDisplayValue("XXXXXXXXXX"); // JDK1.4
            add( subComboBox );

            String[] subItems1 = { "Select Color", "Red", "Blue", "Green" };
            subItems.put(items[1], subItems1);

            String[] subItems2 = { "Select Shape", "Circle", "Square", "Triangle" };
            subItems.put(items[2], subItems2);

            String[] subItems3 = { "Select Fruit", "Apple", "Orange", "Banana" };
            subItems.put(items[3], subItems3);
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

        private void createAndShowUI()
        {
            JFrame frame = new JFrame("SSCCE");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add( new ComboBoxTwo() );
            frame.setLocationByPlatform( true );
            frame.pack();
            frame.setVisible( true );
        }

    }
