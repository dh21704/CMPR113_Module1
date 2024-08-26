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
import javax.swing.JPasswordField;


//Continuing from project 3, code the cancel button so it will end the program. Then create a
//second Java Form that will have the username and password. When the user enters the correct
//username and password then redirects it to project #2. Allow only one form to show at a time.
//When the cancel button is pressed have the application redirect to the login form. Hard code
//the username and password


public class Exercise2 extends JFrame {

    // Declaring the object variables
    JLabel lblLastName, lblFirstName, lblAge;
    JTextField txtLastName, txtFirstName, txtAge;
    JButton btnOK, btnCancel;
    
    JLabel usernameLabel, passwordLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    

    // Creating the constructor that will initialize the variable objects
    public Exercise2() {
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
        
        btnCancel.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    JFrame secondFrame = new JFrame("Second Frame");
                    secondFrame.setSize(300, 200);
                    secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
                    panel.setVisible(false);
                    secondFrame.setVisible(true);
                    
                    JTextField textfield = new JTextField(20);
                    
                    JPanel panel2 = new JPanel();
                    panel2.add(usernameLabel = new JLabel("Username"));
                    panel2.add(usernameField = new JTextField(20));
                    
                    panel2.add(passwordLabel = new JLabel("Password"));
                    panel2.add(passwordField = new JPasswordField(20));
                    
                    JButton okButton = new JButton("Go");
                    
                    
                    panel2.add(okButton);
                    
                    
                    secondFrame.add(panel2);
                    
                             
                    okButton.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent event)
                        {
                            String usernameEntered = usernameField.getText();
                            String passwordEntered = passwordField.getText();
                            
                            System.out.println("password: " + passwordEntered);
                            System.out.println("username: " + usernameEntered);
                            
                            if (usernameEntered.equals("Daniel") && passwordEntered.equals("Hernandez"))
                            {
                                System.out.println("over here");
                                
//                                JFrame thirdFrame = new JFrame("Credentials");
//                                thirdFrame.setSize(300, 200);
//                                thirdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                                
                                panel2.setVisible(false);
//                                thirdFrame.setVisible(true);

                                    JOptionPane.showMessageDialog(null, "Login Successfull");
                                System.out.println("jklfdsljf");
                            }
                        }
                    }
                    
                    
                    );
                    
                   

                }}
        
        );

        // Set the frame properties
        setTitle("Character Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
 
    public static void main(String[] args) 
    {
        new Exercise2();
    }
}
