package opreators;

import java.util.Date;

public class Payments {

    private int id;
    private String f_name;
    private String l_name;
    private double price;
    private Date date;

    Payments(int id, String f_name, String l_name, double price, Date date){
        this.id=id;
        this.f_name=f_name;
        this.l_name=l_name;
        this.price=price;
        this.date=date;
    }

    @Override
    public String toString() {
        return  id +  f_name +  l_name + price + date ;
    }
}
