package opreators;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAdmin extends JFrame implements ActionListener{

    private JLabel info1;
    private JTextArea clientsToPay;
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
    private JButton back;

    GUIAdmin()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        info1 = new JLabel("Clients who need to pay");
        clientsToPay = new JTextArea();
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
        back = new JButton("Logout");

        setTitle("Client");
        setSize(1200,400);

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
        add(back);


        clientsToPay.enable(false);
        addToJTextArea();


        change.addActionListener(this);

        back.addActionListener(e->{
            new Login();
            setVisible(false);
        });

        setVisible(true);
    }

    void addToJTextArea(){
        JDBC bd = new JDBC();
        try {
            List<Payments> paymentsList = bd.readWhoNeedToPay();
            for (Payments p : paymentsList) {
                clientsToPay.append(p.toString()+"\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        JDBC bd = new JDBC();

        int id = box.getSelectedIndex() + 1;

        try {
            int check = bd.changeServiceType(f_name.getText(),l_name.getText(),Integer.parseInt(client_num.getText()),id);
            final JFrame parent = new JFrame();
            if(check == 0)
            {
                JOptionPane.showMessageDialog(parent ,"There is no user with that first name, last name and id!","Alert",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(parent ,"Successful change","Information",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}