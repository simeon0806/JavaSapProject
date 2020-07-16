package opreators;

import javax.swing.*;
import java.awt.*;

public class GUIClient extends JFrame{

    private JLabel service ;
    private JLabel serviceName ;
    private JLabel remaining ;
    private JLabel lMin ;
    private JTextField min;
    private JLabel lSms ;
    private JTextField sms;
    private JLabel lInternet ;
    private JTextField internet;
    private JLabel infoDate;
    private JLabel date;


    GUIClient()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        service = new JLabel("Service: ");
        serviceName = new JLabel();
        remaining = new JLabel("Remaining");
        lMin = new JLabel("Min:");
        min = new JTextField(10);
        lSms = new JLabel("SMS:");
        sms = new JTextField(10);
        lInternet = new JLabel("Internet:");
        internet = new JTextField(10);
        infoDate = new JLabel("Payment by");
        date = new JLabel();

        min.setEnabled(false);
        sms.setEnabled(false);
        internet.setEnabled(false);

        setTitle("Client");
        setSize(800,400);

        add(service);
        add(serviceName);
        add(remaining);
        add(lMin);
        add(min);
        add(lSms);
        add(sms);
        add(lInternet);
        add(internet);
        add(infoDate);
        add(date);

        action();

        setVisible(true);
    }

    public void action() {
        // logic
    }
}
