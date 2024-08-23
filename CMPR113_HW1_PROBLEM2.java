
package com.mycompany.cmpr113_hw1;

import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;


//PROJECT #2
//Convert project #1 into a Java Frame, with a label, text field, and a button object.
//SUM and AVERAGE and display the results into a JOPtionPane class and transfer
//the results to a text file.

public class CMPR113_HW1 extends JFrame{

    private JTextField multipleNumbersField;
    
    public CMPR113_HW1()
    {
        
        
        setTitle("Input Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(600, getLocation().y + 300); //set x coordinate to 0 and y coordinate to 0
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,2));
        
        JLabel messageLabel = new JLabel("Input Numbers separated by spaces: ");
        multipleNumbersField = new JTextField(5);
        
        //adding our objects to the panel
        panel.add(messageLabel);
        panel.add(multipleNumbersField);
        
        JButton button = new JButton("Submit");
        
        button.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                int n, sum = 0;
                String s = JOptionPane.showInputDialog("Enter your numbers separated by space: ");
                
                
                StringTokenizer str = new StringTokenizer(s, " ");
                
                while(str.hasMoreTokens()){
                    String temp = str.nextToken();
                    //convert string to an integer
                    n = Integer.parseInt(temp);
                    
                    System.out.println(n);
                    
                    sum = sum + n;
                    
                }
                
                //you can add further logic or proecessing here
                //clear the fields after submission
                JOptionPane.showMessageDialog(panel, "Sum: " + sum);
                
            }
        });
        
        panel.add(button);
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CMPR113_HW1 inputForm = new CMPR113_HW1();
                inputForm.setVisible(true); //display the form
            }
        });
    }
        
  }
