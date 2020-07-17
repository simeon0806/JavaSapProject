package opreators;


        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

        import static java.sql.Types.NULL;

public class JDBC {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public List<Payments> readWhoNeedToPay() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/operator_service","root","admin");

            statement = connect.createStatement();
            resultSet = statement
                    .executeQuery("select c.id,c.f_name,c.l_name,p.price,p.pay_until from paymants as p join clients as c on p.client_id=c.id where p.day_of_paymant IS NULL");
            return readWhoNeedToPayResultSet(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    private List<Payments> readWhoNeedToPayResultSet(ResultSet resultSet) throws SQLException {
        List<Payments> payments = new ArrayList<Payments>();
        while (resultSet.next()) {
            int id = resultSet.getInt("c.id");
            String f_name = resultSet.getString("c.f_name");
            String l_name = resultSet.getString("c.l_name");
            Double price = resultSet.getDouble("p.price");
            Date date = resultSet.getDate("p.pay_until");
            Payments curr = new Payments(id,f_name,l_name,price,date);
            payments.add(curr);
        }

        return payments;
    }

    public Client readDataForClient(int client_id) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/operator_service","root","admin");
            statement = connect.createStatement();
            int id = client_id;
            resultSet = statement
                    .executeQuery("select c.f_name,c.l_name,c.phone_num,c.min,c.sms,c.internet,s.type,s.min,s.sms,s.internet from clients as c join service as s on c.service_id=s.id where c.id = "+id);
            return readDataForClientResultSet(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private Client readDataForClientResultSet(ResultSet resultSet) throws SQLException {
        Client client = null;
        while (resultSet.next()) { //c.f_name,c.l_name,c.phone_num,c.min,c.sms,c.internet,s.type,s.min,s.sms,s.internet
            String f_name = resultSet.getString("c.f_name");
            String l_name = resultSet.getString("c.l_name");
            String phone_num = resultSet.getString("c.phone_num");
            int min = resultSet.getInt("c.min");
            int sms = resultSet.getInt("c.sms");
            int internet = resultSet.getInt("c.internet");
            String type = resultSet.getString("s.type");
            int fullMin = resultSet.getInt("s.min");
            int fullSms = resultSet.getInt("s.sms");
            int fullInternet = resultSet.getInt("s.internet");
            client =new Client(f_name,l_name,phone_num,min,sms,internet,type,fullMin,fullSms,fullInternet);
        }
        return client;
    }

    public String checkAdminClient(String username,String password) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/operator_service", "root", "admin");
            statement = connect.createStatement();
            resultSet = statement
                    .executeQuery("select client_id,admin_id from login where username = '" + username + "' and `password`='" + password + "'");

            Integer client_id =NULL;
            Integer admin_id = NULL;

            if (resultSet.next()) {
             client_id = resultSet.getInt("client_id");
             admin_id = resultSet.getInt("admin_id");
            }

            if(client_id!=NULL)
                return "client "+client_id;
            else if (admin_id!=NULL)
                return "admin "+admin_id;
            else
                return "not found";

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public int changeServiceType(String f_name, String l_name, int id,int sercice_id) throws Exception {
        boolean result=true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/operator_service","root","admin");

            statement = connect.createStatement();
            int resultUpd = statement
                    .executeUpdate("update clients set service_id = "+sercice_id+" where f_name = '"+f_name+"' and l_name= '"+l_name+"' and id="+id);

            return resultUpd;

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }


    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}