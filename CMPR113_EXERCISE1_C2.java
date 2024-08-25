
package com.mycompany.classexercise1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//the project checks for text processing if the username and password are number
//values or empty, else returns a 2nd frame
public class c2 extends JFrame{
    private JTextField usernameField;
    private JPasswordField passwordField;
    
    public c2(){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,2));
        
        JLabel usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField();
        
        JLabel passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField();
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
                if (username.isEmpty() || password.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Username and password cannot be empty!");
                } else if (containsNumber(username) || containsNumber(password)){
                    JOptionPane.showMessageDialog(null, "Username and password cannot contain numbers!");
                } else{
                    //perform login logic here
                    JOptionPane.showMessageDialog(null, "Login Successfull");
                    
                    //redirect to another frame
                    dispose(); //close the login frame
                    
                    //open the main frame or the frame you want to redirect to
                    c2 mainFrame = new c2();
                    mainFrame.setVisible(true);
                    
                }
             
            }
            
            
            
    });
        
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); //placeholder for layout purposes
        add(loginButton);
}
    
private boolean containsNumber(String text){
    return text.matches(".*\\d.*");
}

public static void main(String[] args){
    new c3().setVisible(true);
}
}
