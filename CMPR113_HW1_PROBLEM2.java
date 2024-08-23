
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
        setTitle("Sum Numbers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,100);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,2));
            
        JLabel numberLabel = new JLabel("Enter your numbers separated by space: ");
        multipleNumbersField = new JTextField();
        
        JButton button = new JButton("Submit");
        
        
        button.addActionListener(new ActionListener()   
        {
            public void actionPerformed(ActionEvent e)
            {
                
                int n, sum = 0;
                
                
                String numbers = multipleNumbersField.getText();
                
                StringTokenizer separators = new StringTokenizer(numbers, " ");
                
                while(separators.hasMoreTokens())
                {
                    String temp = separators.nextToken();
                    
                    //convert the string length into an integer
                    n = Integer.parseInt(temp);
                    
                    System.out.println(n);
                    
                    //calulcate the numbers
                    sum += n;
                    
                }
                
                JOptionPane.showMessageDialog(null, "Sum: " + sum);
                dispose();
            }
        
        }
        );
                
        
        
        add(numberLabel);
        add(multipleNumbersField);
        
        //placeholder for layout purposes
        add(new JLabel());
        add(button);
    }


    public static void main(String[] args) {
        CMPR113_HW1 frame = new CMPR113_HW1();
        frame.setVisible(true);
    }
        
  }
