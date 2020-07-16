package opreators;

import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        // Invoke the constructor to setup the GUI, by allocating an instance
        //App app = new App();

       // new Login();
       // new Client();
       // new Admin();
        JDBC s = new JDBC();
        List<Payments> test = s.readWhoNeedToPay();
        for (Payments r:test) {
            System.out.println(r.toString());
        }

        // or simply "new AWTCounter();" for an anonymous instance
    }

}
