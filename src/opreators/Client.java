package opreators;

public class Client {

    private String f_name;
    private String l_name;
    private String phone_num;
    private int min;
    private int sms;
    private int internet;
    private String type;
    private int fullMin;
    private int fullSms;
    private int fullInternet;

    Client(String f_name,String l_name,String phone_num,int min,int sms,int internet,String type,int fullMin,int fullSms,int fullInternet)
    {
        this.f_name=f_name;
        this.l_name=l_name;
        this.phone_num=phone_num;
        this.min=min;
        this.sms=sms;
        this.internet=internet;
        this.type=type;
        this.fullMin=fullMin;
        this.fullSms=fullSms;
        this.fullInternet=fullInternet;
    }

    public int getFullInternet() {
        return fullInternet;
    }

    public int getFullMin() {
        return fullMin;
    }

    public int getFullSms() {
        return fullSms;
    }

    public int getInternet() {
        return internet;
    }

    public int getMin() {
        return min;
    }

    public int getSms() {
        return sms;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public String getType() {
        return type;
    }

}
