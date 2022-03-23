package service_records;

public class Service_Provided
{
    private int transaction_id;
    private String date_of_service;
    private int provider_id;
    private int service_id;
    private String member_id;
    private String comments;
    private String recorded_time;
    private String provider_name;
    private String service_name;
    private String member_name;


    public Service_Provided()
    {
        this.transaction_id = 0;
        this.date_of_service = new String();
        this.provider_id = 0;
        this.service_id = 0;
        this.member_id = new String();
        this.comments = new String();
        this.recorded_time = new String();
        this.provider_name = new String();
        this.service_name = new String();
        this.member_name = new String();
    }

    public int initService_Provided(int transaction_id, String date_of_service, String recorded_time,
                                    String provider_name, int provider_id, int service_id, String service_name,
                                    String member_name, String member_id, String comments)
    {
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

    public int getTransaction_ID() {
        return this.transaction_id;
    }

    public int getProvider_ID() {
        return this.provider_id;
    }

    public int getService_ID() {
        return this.service_id;
    }

    public String getMember_ID() {
        return this.member_id;
    }

    public String getComments() {
        return this.comments;
    }

    public String getDate_Of_Service(){ return this.date_of_service; }

    public String getRecordedTime() {
        return this.recorded_time;
    }

    public String getProviderName() {
        return this.provider_name;
    }

    public int getServiceCode() {
        return this.service_id;
    }

    public String getServiceName() {
        return this.service_name;
    }

    public String getMemberName() {
        return this.member_name;
    }
}
