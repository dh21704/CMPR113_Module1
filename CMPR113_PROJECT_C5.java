
package com.mycompany.classexercise1;

import java.io.BufferedReader;
import java.io.*;

public class c5 {
    public static void main(String[] args){
        double sum = 0;
        String line; //read eaach line
        int counter = 0; //increment by 1
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File
            ("C:\\Users\\techi\\Downloads\\SalesData.txt")));
            
            while ((line = br.readLine()) != null) //while the text is not empty read each line
            {
                System.out.println("$" + line);
                sum+= Double.parseDouble(line); //sum each number
                counter++;
            }
            
            System.out.println("the total sales $" + sum);
            System.out.println("the average sales $" + (sum/counter));
                    
            
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        
    }
}
