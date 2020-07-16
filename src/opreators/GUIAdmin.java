package opreators;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAdmin extends JFrame {

    private JLabel info1;
    private JList<String> clientsToPay;
    private JLabel info2;
    private JLabel lF_name;
    private JTextField f_name;
    private JLabel lL_name;
    private JTextField l_name;
    private JLabel lClient_num;
    private JTextField client_num;
    private JLabel lType;
    private JComboBox<String> box;
    private String[] types;
    private JButton change;

    GUIAdmin()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        info1 = new JLabel("Change service");
        clientsToPay = new JList<String>();
        info2 = new JLabel("Change service");
        lF_name = new JLabel("First name");
        f_name = new JTextField(10);
        lL_name = new JLabel("Last name");
        l_name = new JTextField(10);
        lClient_num = new JLabel("Client number");
        client_num = new JTextField(10);
        lType = new JLabel("Type");
        types = new String[]{"S","M","L"};
        box = new JComboBox<>(types);
        change = new JButton("Change");

        setTitle("Client");
        setSize(800,400);

        add(info1);
        add(clientsToPay);
        add(info2);
        add(lF_name);
        add(f_name);
        add(lL_name);
        add(l_name);
        add(lClient_num);
        add(client_num);
        add(lType);
        add(box);
        add(change);


        clientsToPay.addListSelectionListener(e -> {
            //logic
        });


        change.addActionListener(e -> {
            //logic
        });

        setVisible(true);
    }
}
