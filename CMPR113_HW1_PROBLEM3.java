
package com.mycompany.cmpr113_hw1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Create a password program that will meet the following criteria:
//1. The password should be at least 6 characters long.
//2. The password should contain 1 uppercase and 1 lowercase letter.
//3. The password should have 1 digit.
//Be sure to create a Java frame with 2 labels, username, and password, and 2 text
//fields. Encrypt the password text field. Test all criteria and print screen each one
//below with your code


public class CMPR113_HW1_Project3 extends JFrame{
    private JTextField usernameField;
    private JPasswordField passwordField;
    
    public CMPR113_HW1_Project3()
    {
        setTitle("Username & Password");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,2));
        
        JLabel usernameLabel = new JLabel("Enter a username: ");
        usernameField = new JTextField();
        
        JLabel passwordLabel = new JLabel("Enter a password: ");
        passwordField = new JPasswordField();
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
                boolean check = checkString(password);
                
                if (check)
                {
                    JOptionPane.showMessageDialog(null, "Your password contains a capital, lowercase and digit");
                    
                    dispose();
                    
                    //open the main frame or the frame you want to redirect to
                    CMPR113_HW1_Project3 mainFrame = new CMPR113_HW1_Project3();
                    mainFrame.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Your password DOES NOT contain at least one capital, one lowercase and/or one digit");
                }
            }
            
            
        });
        
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        
        //placeholder for layout purposes
        add(new JLabel());
        add(loginButton);
        
        
    }
    
    public static boolean checkString(String input)
    {
        char ch;
        boolean digitFlag = false;
        boolean upperFlag = false;
        boolean lowerFlag = false;
        
        for (int i = 0; i < input.length(); i++)
        {
            ch = input.charAt(i);
            
            if (Character.isDigit(ch))
            {
                System.out.println("The password has a digit");
                digitFlag = true;
            }
            
            if (Character.isUpperCase(ch))
            {
                System.out.println("The password has an uppercase");
                upperFlag = true;
            }
            
            if (Character.isLowerCase(ch))
            {
                System.out.println("The password has a lowercase");
                lowerFlag = true;
            }
        }
        
        if(digitFlag == true && upperFlag == true && lowerFlag == true)
        {
            return true;
        }
        else
        {
            
            return false;
        }

       
    }
    
    public static void main(String[] args)
    {
        CMPR113_HW1_Project3 frame = new CMPR113_HW1_Project3();
        frame.setVisible(true);
        
        System.out.println("fdjsl world");
        
        
        
    }
}
