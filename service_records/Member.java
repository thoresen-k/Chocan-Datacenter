package service_records;

import interfaces.Status;

public class Member {
    private String member_ID = new String();
    private String last_name = new String();
    private String first_name = new String();
    private String address = new String();
    private String apt_number = new String();
    private String city = new String();
    private String state = new String();
    private int zip = 0;
    private Status status;

    public Member(String id, String last_name, String first_name, String address, String apt, String city, String state, int zip, Status status){
        this.member_ID = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.address = address;
        this.apt_number = apt;
        this.city = city;
        this.state = state;
        this.zip = zip;

        if(status == null)
        {
            this.status = new Status();
            String name = this.first_name +" "+this.last_name;
            this.status.initStatus(name,"VALIDATED");
        }

        this.status = new Status(status.getName(), status.getMembership_status());

    }

    //copy constructor
    public Member(Member to_add)
    {
        this.member_ID = to_add.member_ID;
        this.last_name = to_add.last_name;
        this.first_name = to_add.first_name;
        this.address = to_add.address;
        this.apt_number = to_add.apt_number;
        this.city = to_add.city;
        this.state = to_add.state;
        this.zip = to_add.zip;

        if(to_add.status == null)
        {
            this.status = new Status();
            String name = this.first_name +" "+this.last_name;
            this.status.initStatus(name,"VALIDATED");
        }

    }

    public Member() {

    }

    public int initMember(String member_ID, String last_name, String first_name, String address,
                          String apt_number, String city, String state, int zip, String membership_status)
    {
        this.member_ID = member_ID;
        this.last_name = last_name;
        this.first_name = first_name;
        this.address = address;
        this.apt_number = apt_number;
        this.city = city;
        this.state = state;
        this.zip = zip;

        if(this.status==null)
            this.status = new Status();
        String name = first_name +" "+last_name;
        this.status.initStatus(name,membership_status);

        return 1;
    }

    public String getMemberID() {
        return this.member_ID ;
    }

    public String getLastName() {
        return this.last_name;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getAptNumber() { return this.apt_number; }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public int getZip() {
        return this.zip;
    }

    public String getMembershipStatus() {
        return this.status.getMembership_status();
    }
}