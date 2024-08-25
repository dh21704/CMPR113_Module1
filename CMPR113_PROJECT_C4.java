
package com.mycompany.classexercise1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class c4 extends JFrame{
    private JTextField firstNameField;
    private JTextField lastNameField;
    
    public c4(){
        setTitle("customer info");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,2));
        
        JLabel firstNameLabel = new JLabel("First Name");
        firstNameField = new JTextField();
        
        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameField = new JTextField();
        
        JButton SubmitButton = new JButton("submit");
        SubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
            }
        });
         
        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
    }
    
    private boolean containsNumber(String text){
        return text.matches(".*\\d*");
    }
    
    public static void main(String[] args) {
    c4 frame = new c4();  // Create an instance of c4
    frame.setVisible(true);  // Make the frame visible
}

}
