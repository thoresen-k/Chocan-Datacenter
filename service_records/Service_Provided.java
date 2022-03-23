package service_records;

public class Service_Provided
{
    private int transaction_id;
    private String date_of_service;
    private String provider_id;
    private int service_id;
    private int member_id;
    private String comments;
    private String recorded_time;
    private String provider_name;
    private String service_name;
    private String member_name;

    public Service_Provided(int transaction_id, String date_of_service, String provider_id, int service_id, int member_id, String comments, String recorded_time, String provider_name, String service_name, String member_name) {
        this.transaction_id = transaction_id;
        this.date_of_service = date_of_service;
        this.provider_id = provider_id;
        this.service_id = service_id;
        this.member_id = member_id;
        this.comments = comments;
        this.recorded_time = recorded_time;
        this.provider_name = provider_name;
        this.service_name = service_name;
        this.member_name = member_name;
    }

    public Service_Provided() {
        this.transaction_id = 0;
        this.date_of_service = new String();
        this.provider_id = new String();
        this.service_id = 0;
        this.member_id = 0;
        this.comments = new String();
        this.recorded_time = new String();
        this.provider_name = new String();
        this.service_name = new String();
        this.member_name = new String();
    }

    public int initService_Provided(int transaction_id, String date_of_service, String recorded_time,
                                    String provider_name, String provider_id, int service_id, String service_name,
                                    String member_name, int member_id, String comments) {
        this.transaction_id = transaction_id;
        this.date_of_service = date_of_service;
        this.recorded_time = recorded_time;
        this.provider_name = provider_name;
        this.provider_id = provider_id;
        this.service_id = service_id;
        this.service_name = service_name;
        this.member_name = member_name;
        this.member_id = member_id;
        this.comments = comments;
        return 1;
    }


    public String getProvider_ID() {
        return this.provider_id;
    }

    public String getDate_Of_Service(){ return this.date_of_service; }

    public String getRecordedTime() { return this.recorded_time; }

    public String getProviderName() { return this.provider_name; }

    public int getServiceCode() { return this.service_id; }

    public String getServiceName() { return this.service_name; }

    public String getMemberName() {return this.member_name; }

    public int getMember_ID() {
        return this.member_id;
    }

    public int getService_ID(){
        return this.service_id;
    }

    public String getComments() { return this.comments; }

    public int getTransaction_ID() { return this.transaction_id; }
}
