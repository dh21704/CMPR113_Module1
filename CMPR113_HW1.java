
package com.mycompany.cmpr113_hw1;

import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


//Convert project #1 into a Java Frame, with a label, text field, and a button object.
//SUM and AVERAGE and display the results into a JOPtionPane class and transfer
//the results to a text file.

public class CMPR113_HW1 extends JFrame{


    public static void main(String[] args) {
 
        int n, sum = 0;
        String s = JOptionPane.showInputDialog("Enter your numbers separated by space: ");
        
        
        try
        {
            
            StringTokenizer st = new StringTokenizer(s, " ");
            
            while (st.hasMoreTokens()){
                String temp = st.nextToken();
                //convert the string length into an integer
                n = Integer.parseInt(temp);
                
                System.out.println(n);
                
                //calculate the numbers
                sum = sum + n;
                
                
            }
            
            JOptionPane.showMessageDialog(null, "Sum of integers is: " + sum);
            
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Only spaces between numbers, example 7, 9, 10, 2, 18, 6");
        }

    }
}

