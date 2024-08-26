
import java.io.BufferedReader;
import java.io.*;
import java.awt.*;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Exercise3 extends JFrame{
    
    private JTextField usernameField;
    private JTextField addressField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField zipField;
    
    public Exercise3()
    {
        setTitle("Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8,3));
        
        JLabel usernameLabel = new JLabel("Username");
        usernameField = new JTextField();
        
        
        JLabel addressLabel = new JLabel("Address");
        addressField = new JTextField();
        
        JLabel cityLabel = new JLabel("City");
        cityField = new JTextField();
        
        JLabel stateLabel = new JLabel("State");
        stateField = new JTextField();
        
        JLabel zipLabel = new JLabel("Zip");
        zipField = new JTextField();
        
        JButton transferButton = new JButton("Transfer");
        JButton readButton = new JButton("Read");
        
        transferButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                       String usernameString = usernameField.getText();
                       String addressString = addressField.getText();
                       String cityString = cityField.getText();
                       String stateString = stateField.getText();
                       String zipString = zipField.getText();
                       
                       File file = new File("/Users/danielhernandez/Desktop/Information.txt");
                       
                       try(BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
                       {
                           writer.write(usernameString);
                           writer.write("\n");
                           writer.write(addressString);
                           writer.write("\n");
                           writer.write(cityString);
                           writer.write("\n");
                           writer.write(stateString);
                           writer.write("\n");
                           writer.write(zipString);
                           writer.write("\n");

                           System.out.println("done writing");
                       }
                       catch(IOException exx)
                       {
                           exx.printStackTrace();
                       }
                
                }}
        
        
                );
        
        readButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                    String line;
                    
                    try
                    {
                      BufferedReader br = new BufferedReader(new FileReader(new File("/Users/danielhernandez/Desktop/Information.txt")));
                      System.out.println("");
                      System.out.println("");
                      System.out.println("");

                      while ((line = br.readLine()) != null)
                      {
                          System.out.println(line);
                      }
                        
                    }
                    catch(Exception exc)
                    {
                       System.out.println(exc.toString());

                    }
                
        }}
        );
        
        
        add(usernameLabel);
        add(usernameField);
        add(addressLabel);
        add(addressField);
        add(cityLabel);
        add(cityField);
        add(stateLabel);
        add(stateField);
        add(zipLabel);
        add(zipField);
        //add(new JButton());
        add(transferButton);
        
        add(readButton);
               
    }
    
    public static void main(String[] args){
        
        Exercise3 c = new Exercise3();
        c.setVisible(true);
        
        
        
        double sum = 0;
        String line; //read each line
        int counter = 0; //increment by 1
        
        
        

        try{
            BufferedReader br = new BufferedReader(new FileReader(new File
            ("/Users/danielhernandez/Desktop/SalesData.txt")));
            
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

