package service_records;

public class Service_Directory extends Service_Provided
{
    private int service_id;
    private String service_name;
    private float fee;

    public Service_Directory() {
        this.service_id = super.getService_ID();
        this.service_name = super.getServiceName();
        this.fee = 0;
    }

    public Service_Directory(int id, String name, int price) {
        this.service_id = id;
        this.service_name = name;
        this.fee = price;
    }

    public void initService_Directory(int service_id, String service_name, float fee) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.fee = fee;
    }

    public int getServiceID() {
        return this.service_id;
    }

    public String getServiceName() {
        return this.service_name;
    }

    public float getServiceFee(){
        return this.fee;
    }
}