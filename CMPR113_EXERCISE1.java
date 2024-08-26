
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//contuining from project 2, add a second clear button object
//that will clear out the three text fields when pressed,
//and when teh submit button is pressed, display the output
//on one JOptionPane
public class Exercise1 extends JFrame{
    private JTextField usernameField;
    private JPasswordField passwordField;
    
    public Exercise1(){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,3));
        
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
                    Exercise1 mainFrame = new Exercise1();
                    mainFrame.setVisible(true);
                    
                }
             
            }
            
            
            
    });
        
       JButton clearbutton = new JButton("Clear");
       clearbutton.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               usernameField.setText("");
               passwordField.setText("");
           }
       });
        
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); //placeholder for layout purposes
        add(loginButton);
        add(new JLabel());
        add(clearbutton); //adding clearbutton
}
    
private boolean containsNumber(String text){
    return text.matches(".*\\d.*");
}

public static void main(String[] args){
    new Exercise1().setVisible(true);
}
}
