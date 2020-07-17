package opreators;

import javax.swing.*;
import java.awt.*;

public class GUIClient extends JFrame{

    private JLabel nameAndPhone ;
    private JLabel service ;
    private JLabel serviceName ;
    private JLabel remaining ;
    private JLabel lMin ;
    private JTextField min;
    private JLabel lSms ;
    private JTextField sms;
    private JLabel lInternet ;
    private JTextField internet;
    private JButton back;

    GUIClient(int client_id) throws Exception {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        nameAndPhone = new JLabel();
        service = new JLabel("Service: ");
        serviceName = new JLabel();
        remaining = new JLabel("Remaining");
        lMin = new JLabel("Min:");
        min = new JTextField(10);
        lSms = new JLabel("SMS:");
        sms = new JTextField(10);
        lInternet = new JLabel("Internet:");
        internet = new JTextField(10);
        back = new JButton("Logout");

        min.setEnabled(false);
        sms.setEnabled(false);
        internet.setEnabled(false);

        setTitle("Client");
        setSize(800,400);

        add(nameAndPhone);
        add(service);
        add(serviceName);
        add(remaining);
        add(lMin);
        add(min);
        add(lSms);
        add(sms);
        add(lInternet);
        add(internet);
        add(back);

        action(client_id);

        back.addActionListener(e->{
            new Login();
            setVisible(false);
        });

        setVisible(true);
    }

    public void action(int client_id) throws Exception {
        JDBC bd = new JDBC();
        Client clientData = bd.readDataForClient(client_id);

        nameAndPhone.setText(clientData.getF_name()+ "  " + clientData.getL_name() + "  " + clientData.getPhone_num());
        serviceName.setText(clientData.getType());
        min.setText(clientData.getMin() + " / " + clientData.getFullMin());
        sms.setText(clientData.getSms() + " / " + clientData.getFullSms());
        internet.setText(clientData.getInternet() + " / " + clientData.getFullInternet());
    }
}
