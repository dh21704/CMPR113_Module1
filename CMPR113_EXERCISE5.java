import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Exercise5 extends JFrame{
       public static void main(String[] args){
           JFrame frame = new Exercise5();
           frame.setTitle("Character Test");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.pack();
           frame.setVisible(true);
       }
       
       private final JLabel lblEnterName;
       private final JTextField txtEnterName;
       private final JButton btnOK;
       
       Exercise5()
       {
           JPanel panel = new JPanel();
           
           panel.add(lblEnterName = new JLabel("Enter a Name"));
           panel.add(txtEnterName = new JTextField(7));
           panel.add(btnOK = new JButton("OK"));
           add(panel);
           
           btnOK.addActionListener(new ActionListener()
           {
               public void actionPerformed(ActionEvent e)
               {
                   String lookup;
                   
                   String[]people = { "Cutshaw", "Will", "Davis", "George",
            "Davis", "Jenny", "Russert", "Phil",
            "Rusell", "Cindy", "Setzer", "Charles",
            "Smathers", "Holly", "Smith", "Chris",
            "Smith", "Brad", "William", "Jean"
        
        };
                   
                   lookup = txtEnterName.getText();
                   
                   for(String person: people)
                   {
                       if(person.startsWith(lookup))
                           JOptionPane.showMessageDialog(null, person);
                   }
                   
               }
           });
           
       }

}
