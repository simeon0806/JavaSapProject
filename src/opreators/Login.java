package opreators;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    private JLabel username;
    private JTextField tfUsername;
    private JLabel password;
    private JTextField tfPassword;
    private JButton login;
    Login()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        username = new JLabel("username");
        tfUsername = new JTextField(10);
        password = new JLabel("password");
        tfPassword = new JTextField(10);
        login = new JButton("Login");

        setTitle("Login");
        setSize(800,400);

        add(username);
        add(tfUsername);
        add(password);
        add(tfPassword);
        add(login);

        login.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = tfUsername.getText();
        String pass = tfPassword.getText();

        // logic
    }
}
