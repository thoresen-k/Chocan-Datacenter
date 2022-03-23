package interfaces;/*

    This class will manage provider's personal information
    and offer the following provider interface functionalities
    1) Validate a member's Membership interfaces.Status
    2) Create a bill for a completed service
    3) View a list of all possible services that the clinic can offer

 */

import service_records.Service_Provided;

public class Provider
{
    // Data Members
    private String provider_ID;
    private String name;
    private String address;
    private String apt_number;
    private String state;
    private int zip;
    private Service_Provided service;

    // Constructor
    public Provider()
    {
        this.provider_ID = new String();
        this.name = new String();
        this.address = new String();
        this.apt_number = new String();
        this.state = new String();
        this.zip = 0;
        this.service = new Service_Provided();
    }

    // Initialize interfaces.Provider
    public int initProvider(String provider_ID, String name, String address, String apt_number, String state, int zip, Service_Provided service)
    {
        this.provider_ID = provider_ID;
        this.name = name;
        this.address = address;
        this.apt_number = apt_number;
        this.state = state;
        this.zip = zip;
        //this.service.initService_Provided(service.getService_name(),service.getTransaction_ID(), service.getProvider_ID(),service.getService_ID(),service.getMember_ID(),service.getComments(),service.getPaid_status());
        return 1;
    }

    public String getProviderID()
    {
        return this.provider_ID;
    }

    public String getName()
    {
        return this.name;
    }

    public String getAddress()
    {
        return this.address;
    }

    public String getAptNumber()
    {
        return this.apt_number;
    }

    public String getState()
    {
        return this.state;
    }

    public int getZip()
    {
        return this.zip;
    }

}