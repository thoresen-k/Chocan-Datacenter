package service_records;

import interfaces.Status;

public class Member {
    private int member_ID = 0;
    private String last_name = new String();
    private String first_name = new String();
    private String address = new String();
    private String apt_number = new String();
    private String city = new String();
    private String state = new String();
    private int zip = 0;
    private Status status;

    public Member() {
    }

    public int initMember(int member_ID, String last_name, String first_name, String address,
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
    public int getMemberID() {
        return this.member_ID;
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

    public String getAptNumber() {
        return this.apt_number;
    }

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
