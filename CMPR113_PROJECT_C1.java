
package com.mycompany.classexercise1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


//exercise 1
public class c1 extends JFrame { //by using the extend statement we are inheriting the JFrame class

    private JTextField idField;
    private JTextField lastNameField;
    private JTextField firstNameField;

    public c1() {
        setTitle("Input Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the frame once stopped
        setLocation(600, getLocation().y + 300); //set x coordinate to 0 and y coordinate to 0
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2)); //5 represents the rows from top to bottom
        // the 2 represents the columns

        JLabel idLabel = new JLabel("ID: ");
        idField = new JTextField(5);
        JLabel lastNameLabel = new JLabel("Lastname: ");
        lastNameField = new JTextField(5);
        JLabel firstNameLabel = new JLabel("Firstname: ");
        firstNameField = new JTextField(5);

        //adding our objects to the panel
        panel.add(idLabel);
        panel.add(idField);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(firstNameLabel);
        panel.add(firstNameField);

        JButton submitButton = new JButton("Submit");

        //jere is our action Listener that will listen to an Action Event
        submitButton.addActionListener(new ActionListener() {

            //here is what the action takes place
            public void actionPerformed(ActionEvent e) {
                //declare variables to our objects, teh .get text will display the text entered
                String id = idField.getText();
                String lastName = lastNameField.getText();
                String firstName = firstNameField.getText();

                // do something with input values
                System.out.println("ID: " + id);
                System.out.println("LastName: " + lastName);
                System.out.println("FirstName: " + firstName);

                //you can add further logic or proecessing here
                //clear the fields after submission
                idField.setText("");
                lastNameField.setText("");
                firstNameField.setText("");
            }
        });

        panel.add(submitButton); //adding the button object to the panel
        add(panel); //adding the panel to the frame

    }

    //run the c1 class
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                c1 inputForm = new c1();
                inputForm.setVisible(true); //display the form
            }
        });
    }

}
