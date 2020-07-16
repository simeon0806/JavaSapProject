//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;
class gui {
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);


        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel username = new JLabel("Username",JLabel.LEFT);
        JTextField tfUsername = new JTextField(10); // accepts upto 10 characters
        JLabel password = new JLabel("Password",JLabel.LEFT);
        JPasswordField pfPassword = new JPasswordField(10);
        JButton login = new JButton("Login");
        panel.add(username); // Components Added using Flow Layout
        panel.add(tfUsername);
        panel.add(password);
        panel.add(pfPassword);
        panel.add(login);


        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}