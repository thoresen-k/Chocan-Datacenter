package interfaces;/*
    This class will manage provider's personal information
    and offer the following provider interface functionalities
    1) Validate a member's Membership interfaces.Status
    2) Create a bill for a completed service
    3) View a list of all possible services that the clinic can offer
 */

import service_records.Service_Directory;
import service_records.Service_Provided;
import sql.SQL_API;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Provider
{
    // Data Members
    private String provider_ID;
    private String name;
    private String address;
    private String apt_number;
    private String state;
    private int zip;
    private String city;
    private Service_Provided service;
    private Service_Directory directory;

    //hide a SQL_API object
    SQL_API sql_api;


    // Constructor
    public Provider() {
        this.provider_ID = new String();
        this.name = new String();
        this.address = new String();
        this.apt_number = new String();
        this.state = new String();
        this.zip = 0;
        this.city = new String();
        this.service = new Service_Provided();
        this.sql_api = new SQL_API();

    }

    // Initialize Provider
    public int initProvider(String provider_ID, String name, String address, String apt_number, String state, int zip, String city,Service_Provided service) {
        this.provider_ID = provider_ID;
        this.name = name;
        this.address = address;
        this.apt_number = apt_number;
        this.state = state;
        this.zip = zip;
        this.city = city;
        return 1;
    }

    public Provider(String id, String name, String address, String apt, String state, int zip, String city, Service_Provided service) {
        this.provider_ID = id;
        this.name = name;
        this.address = address;
        this.apt_number = apt;
        this.state = state;
        this.zip = zip;
        this.city = city;
    }

    //Returns a string stating the status of member
    //Initial step for provider billing/interface!
    public String validateMember(int member_id){return this.sql_api.ValidateMember(member_id);}


    public boolean verifyMember(int member_id){
        return this.sql_api.VerifyMember(member_id);
    }


    private boolean user_input()
    {
        boolean correct = false;
        Scanner input = new Scanner(System.in);
        String response = input.nextLine();
        if(response.equals("y"))
        {
            correct = true;
        }
        return correct;
    }


    protected boolean response() {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to add another visitation with a member?: (Y, Yes)");
        String response = input.nextLine();
        if (response.toUpperCase().equals("Y") || response.toUpperCase().equals("YES"))
            return true;
        return false;

    }

    public int billVisitation(int member_id,String provider_id){
        String member_status = validateMember(member_id);
        System.out.println(member_status);
        if(member_status.equals("VALIDATED")){
            String dateOfService = readDateOfService();
            System.out.println(dateOfService);
            //Ask the user if they would like to lookup the service code directory:
            getServiceDirectory();
            //Ask the provider to verify the service code.
            int service_code = checkServiceCode();
            //Ask the user to write any comments about the visit:
            String comments = commentReport();
            //Write report to record/database:
            writeReportToDB(dateOfService, provider_id, member_id, service_code, comments);
        }

        return 0;
    }

    public String readDateOfService(){
        Scanner a_scan = new Scanner(System.in);
        System.out.println("Enter date of visit: \n");
        System.out.println("Month(XX):");
        String month = a_scan.nextLine();
        System.out.println("Day(XX):");
        String day = a_scan.nextLine();
        System.out.println("Year(XXXX):");
        String year = a_scan.nextLine();
        String dateOfService = month + "-" + day + "-" + year;

        return dateOfService;
    }

    public void getServiceDirectory(){
        Scanner a_scan = new Scanner(System.in);
        System.out.println("\nEnter 'S' for service directory or 'N' to enter the service code NOW:");
        String response = a_scan.nextLine();
        if(response.toUpperCase().equals("S"))
            this.sql_api.DisplayServiceDirectory();
    }

    public int checkServiceCode(){
        Scanner a_scan = new Scanner(System.in);
        System.out.println("\nEnter the 6 digit service code(XXXXXX):");
        int service_code = a_scan.nextInt();
        service_code = this.sql_api.checkServiceCode(service_code);
        return service_code;
    }

    public String commentReport(){
        Scanner a_scan = new Scanner(System.in);
        System.out.println("\nEnter any comments you have about the visit(100 characters max):");
        String comments = a_scan.nextLine();
        return comments;
    }

    public void writeReportToDB(String dateOfService, String provider_ID, int member_id, int service_code, String comments){
        //Hash transaction ID using member name, and time of report
        //This transaction ID is just for testing. PlEASE MAKE HASH FUNCTION!!
        //int transaction_id = 4454451;
        //Get the recorded system time:
        String recorded_time = getTime();

        //#1. Get the name if the member via member_id.
        String member_name = this.sql_api.getMemberName(member_id);

        //#2. Get the provider name using the provider id
        String provider_name = this.sql_api.getProviderName(provider_ID);

        //#3. Get the name of the service code using the service id:
        String service_name = this.sql_api.getServiceName(service_code);

        int transaction_id = recorded_time.hashCode();

        Service_Provided a_visit = new Service_Provided();

        a_visit.initService_Provided(transaction_id,dateOfService,recorded_time,
                provider_name,provider_ID,service_code,service_name,member_name,member_id,comments);

        this.sql_api.AddServiceProvided(a_visit);

    }

    public String getTime(){
        Date date = new Date();
        LocalDate localDate = LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        LocalDateTime time = LocalDateTime.now(ZoneId.systemDefault());
        int year  = localDate.getYear();
        int month = localDate.getMonthValue();
        int day   = localDate.getDayOfMonth();


        int hr = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        String recorded_time = month + "-" + day + "-" + year + " " + hr + ":" + minute + ":" + second ;


        return recorded_time;
    }

    public String getProviderID()
    {
        return this.provider_ID;
    }

    public String getName()
    {
        return this.name;
    }

    public String getStreet()
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

    public String getCity() { return this.city;
    }
}