package com.mycompany.classexercise1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class c3 extends JFrame {

    // Declaring the object variables
    JLabel lblLastName, lblFirstName, lblAge;
    JTextField txtLastName, txtFirstName, txtAge;
    JButton btnOK, btnCancel;

    // Creating the constructor that will initialize the variable objects
    public c3() {
        JPanel panel = new JPanel();
        panel.add(lblLastName = new JLabel("Last Name"));
        panel.add(txtLastName = new JTextField(7));

        panel.add(lblFirstName = new JLabel("First Name"));
        panel.add(txtFirstName = new JTextField(7));

        panel.add(lblAge = new JLabel("Age"));
        panel.add(txtAge = new JTextField(7));

        // The key listener will listen to a key
        txtAge.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!Character.isDigit(input)) {
                    e.consume(); // Deletes the text entered
                    JOptionPane.showMessageDialog(null, "Numbers only");
                }
            }
        });

        panel.add(btnOK = new JButton("Press Here"));
        panel.add(btnCancel = new JButton("Cancel"));

        add(panel); // Adding the panel to the Frame

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lastname = txtLastName.getText();
                String firstname = txtFirstName.getText();
                String age = txtAge.getText();

                char ln, fn; // The char data type will only accept 1 character

                // Check if fields are empty before accessing first character
                if (lastname.isEmpty() || firstname.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both last name and first name.");
                    return;
                }

                ln = lastname.charAt(0);
                fn = firstname.charAt(0);

                if (!Character.isLetter(ln) || !Character.isLetter(fn)) {
                    JOptionPane.showMessageDialog(null, "The first letter must be a character");
                    txtLastName.requestFocus(); // Places the cursor on this field
                    return;
                }

                try {
                    File f = new File("names.txt");
                    FileWriter fw = new FileWriter(f, true); // Boolean value of true, appends the text
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write("Last Name: " + lastname.toUpperCase());
                    bw.newLine();
                    bw.write("First Name: " + firstname.toUpperCase());
                    bw.newLine();
                    bw.write("Age: " + age);
                    bw.newLine();
                    bw.write("----------------------------");
                    bw.newLine();
                    bw.close();

                    JOptionPane.showMessageDialog(null, "Text successfully written to the file.");
                } catch (IOException ex) {
                    System.err.println("Error writing to the file: " + ex.getMessage());
                }
            }
        });

        // Set the frame properties
        setTitle("Character Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
 
    public static void main(String[] args) {
        new c3();
    }
}
