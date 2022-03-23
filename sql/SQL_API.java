package sql;

import interfaces.Provider;
import service_records.Member;
import service_records.Service_Directory;
import service_records.Service_Provided;

import javax.crypto.Cipher;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class SQL_API {
    // -------------------<LOGIN CREDENTIALS>-----------------------
    public static String url = "jdbc:mysql://34.66.94.176:3306/chocan";
    public static String user;
    public static String pass;
    // ---------------------<SERVICE DIRECTORY TABLE>-------------------------
    // Add a service
    public int AddService(Service_Directory to_add) {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            String sql = "INSERT INTO service_directory(service_code, service_name, fee) VALUES('"
                    + to_add.getServiceCode() + "', '"
                    + to_add.getServiceName() + "', '"
                    + to_add.getServiceFee() + "')";

            myStmt.executeUpdate(sql);
            return 1;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }

    public String getServiceName(int service_code){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from service_directory");
            while(myRs.next()) {
                if (service_code == myRs.getInt("service_code")) {
                    String service_name = myRs.getString("service_name");
                    return service_name;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return "System Error";
        }

        return "Invalid Service Code Entered.";
    }

    public int checkServiceCode(int service_code){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from service_directory");
            System.out.println("ID \t\tName \t\t\t\tFee ");
            System.out.println("---\t\t-----\t\t\t\t-----");

            while(myRs.next()) {
                if (service_code == myRs.getInt("service_code")) {
                    System.out.println(myRs.getString("service_name") + "\n");
                }
            }
            return service_code;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }

    // Displays all services
    public int DisplayServiceDirectory() {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from service_directory");
            System.out.println("ID \t\tName \t\t\t\tFee ");
            System.out.println("---\t\t-----\t\t\t\t-----");

            while(myRs.next()) {
                System.out.println(myRs.getInt("service_code") + "\t\t"
                        + myRs.getString("service_name") + "\t\t"
                        + myRs.getFloat("fee") + "\n");
            }

            return 1;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }

    // Deletes a service with matching Service_ID
    public int RemoveService(int service_ID) {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            PreparedStatement myStmt = myConn.prepareStatement("DELETE FROM service_directory WHERE service_id = ?");
            myStmt.setInt(1, service_ID);
            myStmt.executeUpdate();
            return 1;
        } catch (Exception var4) {
            var4.printStackTrace();
            return 0;
        }
    }



    // ---------------------<MEMBERS TABLE>--------------------------
    // Add a member
    public int AddMembers(Member to_add) {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            String sql = "INSERT INTO members(member_id, first_name, last_name, street, apt, state, city, zip, membership_state) VALUES('"
                            + to_add.getMemberID() + "', '"
                            + to_add.getFirstName() + "', '"
                            + to_add.getLastName() + "', '"
                            + to_add.getAddress() + "', '"
                            + to_add.getAptNumber() + "', '"
                            + to_add.getState() + "', '"
                            + to_add.getCity() + "', '"
                            + to_add.getZip() + "', '"
                            + to_add.getMembershipStatus() + "')";
            myStmt.executeUpdate(sql);
            return 1;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }

    // Get member ID
    public String getMemberID(String member_id){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            while(myRs.next()) {
                if (member_id.equals(myRs.getString("member_id"))) {
                    String temp = myRs.getString("member_id");
                    return temp;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return "-1";
        }
        return "1";
    }

    //Get member apt
    public String getApt(String member_id){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            while(myRs.next()) {
                if (member_id.equals(myRs.getString("member_id"))) {
                    String temp = myRs.getString("apt");
                    return temp;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return "-1";
        }
        return "1";
    }

    //Get member first name
    public String getFName(String member_id){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            while(myRs.next()) {
                if (member_id.equals(myRs.getString("member_id"))) {
                    String temp = myRs.getString("first_name");
                    return temp;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return "-1";
        }
        return "1";
    }

    //Get member last name
    public String getLName(String member_id){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            while(myRs.next()) {
                if (member_id.equals(myRs.getString("member_id"))) {
                    String temp = myRs.getString("last_name");
                    return temp;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return "-1";
        }
        return "1";
    }

    //Get member city
    public String getCity(String member_id){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            while(myRs.next()) {
                if (member_id.equals(myRs.getString("member_id"))) {
                    String temp = myRs.getString("city");
                    return temp;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return "-1";
        }
        return "1";
    }

    //Get member state
    public String getState(String member_id){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            while(myRs.next()) {
                if (member_id.equals(myRs.getString("member_id"))) {
                    String temp = myRs.getString("state");
                    return temp;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return "-1";
        }
        return "1";
    }

    //Get member street
    public String getStreet(String member_id){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            while(myRs.next()) {
                if (member_id.equals(myRs.getString("member_id"))) {
                    String temp = myRs.getString("street");
                    return temp;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return "-1";
        }
        return "1";
    }

    //Get member zip
    public int getZip(String member_id){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            while(myRs.next()) {
                if (member_id.equals(myRs.getString("member_id"))) {
                    int temp = myRs.getInt("zip");
                    return temp;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return -1;
        }
        return 1;
    }

    //Get member status
    public String getStatus(String member_id){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            while(myRs.next()) {
                if (member_id.equals(myRs.getString("member_id"))) {
                    String temp = myRs.getString("membership_state");
                    return temp;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return "-1";
        }
        return "1";
    }

    // Update a member based on the member ID
    public int updateMember(String original_id, String new_id, String fName, String lName, String street, String apt, String state, String city, int zip, String status) {
        try {
            //connect to SQL database
            Connection myConn = DriverManager.getConnection(url, user, pass);

            //create our java preparedstatement using a sql update query
            PreparedStatement ps = myConn.prepareStatement("UPDATE members SET member_id = ?, first_name = ?, last_name = ?, street = ?, apt = ?, state = ?, city = ?, zip = ?, membership_state = ? WHERE member_id = ?");

            // set the preparedstatement parameters
            ps.setString(1,new_id);
            ps.setString(2,fName);
            ps.setString(3,lName);
            ps.setString(4,street);
            ps.setString(5,apt);
            ps.setString(6,state);
            ps.setString(7,city);
            ps.setInt(8,zip);
            ps.setString(9,status);
            ps.setString(10,original_id);

            //call executeUpdate to execute our sql update statement
            ps.executeUpdate();
            ps.close();
            return 1;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }

    // Displays all members
    public int DisplayAllMembers() {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            System.out.println("---------\t\t-----------------\t\t----------\t\t---------\t\t-------\t\t---\t\t----\t\t-----\t\t---");

            while(myRs.next()) {
                System.out.println("service_records.Member ID: " + myRs.getString("member_id") + "\t\t"
                        + "interfaces.Membership Status: " + myRs.getString("membership_state") + "\t\t"
                        + "service_records.Member Name: " + myRs.getString("first_name") + " "
                        + myRs.getString("last_name") + "\t\t"
                        + "service_records.Member Address: " + myRs.getString("street") + " "
                        + myRs.getString("apt") + " "
                        + myRs.getString("city") + " "
                        + myRs.getString("state") + " "
                        + myRs.getInt("zip") + "\n");
            }

            return 1;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }

    // Validate a member
    public String ValidateMember(String Member_ID){
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            while(myRs.next()) {
                if (Member_ID.equals(myRs.getString("member_id"))) {
                    System.out.println(myRs.getString("member_id"));
                    String temp = myRs.getString("membership_state") + "\t\t\n";
                    return temp;
                }
            }

        } catch (Exception var5){
            var5.printStackTrace();
            return "System Error";
        }
        return "Invalid Number";
    }

    // Displays a member with matching member_ID
    public int DisplayMember(String Member_ID) {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            System.out.println("---------\t\t-----------------\t\t----------\t\t---------\t\t-------\t\t---\t\t----\t\t-----\t\t---");

            while(myRs.next()) {
                if (Member_ID.equals(myRs.getString("member_id"))) {
                    System.out.println("service_records.Member ID: " + myRs.getString("member_id") + "\t\t"
                            + "interfaces.Membership Status: " + myRs.getString("membership_state") + "\t\t"
                            + "service_records.Member Name: " + myRs.getString("first_name") + " "
                            + myRs.getString("last_name") + "\t\t"
                            + "service_records.Member Address: " + myRs.getString("street") + " "
                            + myRs.getString("apt") + " "
                            + myRs.getString("city") + " "
                            + myRs.getString("state") + " "
                            + myRs.getInt("zip") + "\n");
                }
            }

            return 1;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }

    // Deletes a member with matching member_ID
    public int RemoveMember(int member_ID) {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            PreparedStatement myStmt = myConn.prepareStatement("DELETE FROM members WHERE member_id = ?");
            myStmt.setInt(1, member_ID);
            myStmt.executeUpdate();
            return 1;
        } catch (Exception var4) {
            var4.printStackTrace();
            return 0;
        }
    }

    public String getMemberName(int Member_ID){
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            while(myRs.next()) {
                if (Member_ID == myRs.getInt("member_id")) {
                    String temp = myRs.getString("first_name");
                    String temp2 = myRs.getString("last_name");
                    String fullName = temp + temp2;

                    return fullName;
                }
            }

        } catch (Exception var5){
            var5.printStackTrace();
            return "System Error";
        }
        return "Invalid Number";
    }

    public String ValidateMember(int Member_ID){
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            while(myRs.next()) {
                if (Member_ID == myRs.getInt("member_id")) {
                    System.out.println(myRs.getString("member_id"));
                    String temp = myRs.getString("membership_state");
                    return temp;
                }
            }

        } catch (Exception var5){
            var5.printStackTrace();
            return "System Error";
        }
        return "Invalid Number";
    }

    public boolean VerifyMember(int Member_ID){
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            while(myRs.next()) {
                if (Member_ID == myRs.getInt("member_id")) {
                    System.out.println(myRs.getString("member_id"));
                    return true;
                }
            }

        } catch (Exception var5){
            var5.printStackTrace();
            return false;
        }
        return false;
    }

    // Displays a member with matching member_ID
    public int DisplayMember(int Member_ID) {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from members");
            System.out.println("Member ID\t\tMembership Status\t\tFirst Name\t\tLast Name\t\tAddress\t\tApt\t\tCity\t\tState\t\tZIP");
            System.out.println("---------\t\t-----------------\t\t----------\t\t---------\t\t-------\t\t---\t\t----\t\t-----\t\t---");

            while(myRs.next()) {
                if (Member_ID == myRs.getInt("member_id")) {
                    System.out.println(myRs.getString("member_id") + "\t\t"
                            + myRs.getString("membership_state") + "\t\t"
                            + myRs.getString("first_name") + "\t\t"
                            + myRs.getString("last_name") + "\t\t"
                            + myRs.getString("street") + "\t\t"
                            + myRs.getString("apt") + "\t\t"
                            + myRs.getString("city") + "\t\t"
                            + myRs.getString("state") + "\t\t"
                            + myRs.getInt("zip") + "\t\t\n");
                }
            }

            return 1;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }


    // --------------------<PROVIDERS TABLE>-------------------------
    public String getProviderID(String provider_id){
       try{
           Connection myConn = DriverManager.getConnection(url, user, pass);
           Statement myStmt = myConn.createStatement();
           ResultSet myRs = myStmt.executeQuery("select * from provider");
           while(myRs.next()) {
               if (provider_id.equals(myRs.getString("provider_id"))) {
                   String temp = myRs.getString("provider_id");
                   return temp;
               }
           }
       } catch (Exception var5) {
           var5.printStackTrace();
           return "-1";
       }
       return "1";

   }

   public String getProviderStreet(String provider_id){
       try{
           Connection myConn = DriverManager.getConnection(url, user, pass);
           Statement myStmt = myConn.createStatement();
           ResultSet myRs = myStmt.executeQuery("select * from provider");
           while(myRs.next()) {
               if (provider_id.equals(myRs.getString("provider_id"))) {
                   String temp = myRs.getString("street");
                   return temp;
               }
           }
       } catch (Exception var5) {
           var5.printStackTrace();
           return "-1";
       }
       return "1";

   }

    public String getProviderApt(String provider_id){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from provider");
            while(myRs.next()) {
                if (provider_id.equals(myRs.getString("provider_id"))) {
                    String temp = myRs.getString("apt");
                    return temp;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return "-1";
        }
        return "1";

    }

    public String getProviderState(String provider_id){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from provider");
            while(myRs.next()) {
                if (provider_id.equals(myRs.getString("provider_id"))) {
                    String temp = myRs.getString("state");
                    return temp;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return "-1";
        }
        return "1";

    }


    public int getProviderZip(String provider_id){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from provider");
            while(myRs.next()) {
                if (provider_id.equals(myRs.getString("provider_id"))) {
                    int temp = myRs.getInt("zip");
                    return temp;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return -1;
        }
        return 1;
    }

    public String getProviderCity(String provider_id){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from provider");
            while(myRs.next()) {
                if (provider_id.equals(myRs.getString("provider_id"))) {
                    String temp = myRs.getString("city");
                    return temp;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return "-1";
        }
        return "1";
    }

    
    
    //Return Provider Name via ID for reporting purposes
    public String getProviderName(String Provider_ID){
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from provider");
            while(myRs.next()) {
                if (Provider_ID.equals(myRs.getString("provider_id"))) {
                    String pname = myRs.getString("provider_name");
                    return pname;
                }
            }

        } catch (Exception var5){
            var5.printStackTrace();
            return "System Error";
        }
        return "Invalid Provider Number";
    }


    //Display a provider with matching Provider_ID
    public int DisplayAProvider(String Provider_ID) {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from provider");
            System.out.println("Provider ID\t\tProvider Name\t\tAddress\t\tApt\t\tState\t\tZIP");
            System.out.println("-----------\t\t-------------\t\t-------\t\t---\t\t-----\t\t---");

            while(myRs.next()) {
                if (Provider_ID.compareTo(myRs.getString("provider_id")) == 0) {
                    System.out.println(myRs.getString("provider_id") + "\t\t"
                            + myRs.getString("provider_name") + "\t\t"
                            + myRs.getString("street") + "\t\t"
                            + myRs.getString("apt") + "\t\t"
                            + myRs.getString("state") + "\t\t"
                            + myRs.getInt("zip") + "\n");
                }
            }
            return 1;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }

    //Display all providers
    public int DisplayAllProviders() {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from provider");
            System.out.println("Provider ID\t\tProvider Name\t\tAddress\t\tApt\t\tState\t\tZIP");
            System.out.println("-----------\t\t-------------\t\t-------\t\t---\t\t-----\t\t---");

            while(myRs.next()) {
                System.out.println(myRs.getString("provider_id") + "\t\t"
                        + myRs.getString("provider_name") + "\t\t"
                        + myRs.getString("street") + "\t\t"
                        + myRs.getString("apt") + "\t\t"
                        + myRs.getString("state") + "\t\t"
                        + myRs.getInt("zip") + "\n");
            }

            return 1;
        } catch (Exception var4) {
            var4.printStackTrace();
            return 0;
        }
    }

    // Delete a provider with matching Provider_ID
    public int RemoveProvider(String Provider_ID) {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            PreparedStatement myStmt = myConn.prepareStatement("DELETE FROM provider WHERE provider_id = ?");
            myStmt.setString(1, Provider_ID);
            myStmt.executeUpdate();
            return 1;
        } catch (Exception var4) {
            var4.printStackTrace();
            return 0;
        }
    }

     public int AddProvider(Provider to_add){
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            String sql = "INSERT INTO provider(provider_id, provider_name, street, apt, state, zip, city) VALUES('"
                    + to_add.getProviderID() + "', '"
                    + to_add.getName() + "', '"
                    + to_add.getStreet() + "', '"
                    + to_add.getAptNumber() + "', '"
                    + to_add.getState() + "', '"
                    + to_add.getCity() + "', '"
                    + to_add.getZip() + "')";
            myStmt.executeUpdate(sql);
            return 1;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }
    
     public int updateProvider(String provider_id, String new_id, String provider_name, String street, String apt, String state, int zip, String city) {
        try {
            //connect to SQL database
            Connection myConn = DriverManager.getConnection(url, user, pass);

            //create our java prepared statement using a sql update query
            PreparedStatement pr = myConn.prepareStatement("UPDATE provider SET provider_id = ?, provider_name = ?, street = ?, apt = ?, state = ?, zip = ?, city = ? WHERE provider_id = ?");

            // set the prepared statement parameters
            pr.setString(1,new_id);
            pr.setString(2,provider_name);
            pr.setString(3,street);
            pr.setString(4,apt);
            pr.setString(5,state);
            pr.setInt(6,zip);
            pr.setString(7,city);
            pr.setString(8,provider_id);

            //call executeUpdate to execute our sql update statement
            pr.executeUpdate();
            pr.close();
            return 1;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }
    


    // ------------------<PROVIDED_SERVICES TABLE>---------------------
    public int AddServiceProvided(Service_Provided to_add) {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            String sql = "INSERT INTO provided_services(provider_id, date_of_service, recorded_time, provider_name ,service_code, service_name, member_name, member_id,comments,transaction_id) VALUES('"
                    + to_add.getProvider_ID() + "', '"
                    + to_add.getDate_Of_Service() + "', '"
                    + to_add.getRecordedTime() + "', '"
                    + to_add.getProviderName() + "', '"
                    + to_add.getServiceCode() + "', '"
                    + to_add.getServiceName() + "', '"
                    + to_add.getMemberName() + "', '"
                    + to_add.getMember_ID() + "', '"
                    + to_add.getComments() + "', '"
                    + to_add.getTransaction_ID() + "')";
            myStmt.executeUpdate(sql);
            return 1;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }
    
    //Get member name
    public String getMemberName(String member_id){
        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from provided_services");
            while(myRs.next()) {
                if (member_id.equals(myRs.getString("member_id"))) {
                    String temp = myRs.getString("member_name");
                    return temp;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return "-1";
        }
        return "1";
    }    
    
    //get the date of service based on the member id and name
    public int getServiceInfo(String member_id, String member_name, java.util.Date[] dateofservice, String[] providername, String[] servicename, String[] sorted_date)
    {
        int items = 0;
        try
        {
            //connect to SQL database
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from provided_services");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");

            int i = 0;
            while(myRs.next())
            {
                if(member_name.equals(myRs.getString("member_name")) && member_id.equals(myRs.getString("member_id")))
                {
                    String dos = myRs.getString("date_of_service");
                    //System.out.println(dos);
                    String pname = myRs.getString("provider_name");
                    String sname = myRs.getString("service_name");

                    dateofservice[i] = simpleDateFormat.parse(dos);
                    providername[i] = pname;
                    servicename[i] = sname;

                    //store the string to copy over in service_name for later comparison
                    servicename[i] = dateofservice[i] + ";" + providername[i] + ";" + servicename[i];
                    System.out.println("Index: " + i + " " + servicename[i]);
                    ++i;
                    ++items;
                }
            }
            for(i = items; i<20; ++i)
            {
                dateofservice[i] = simpleDateFormat.parse("00-00-0000");
                sorted_date[i] = new String();
            }
            Arrays.sort(dateofservice);
        }
        catch (Exception var5)
        {
            var5.printStackTrace();
        }

        return items;
    }

    // Update a service provided based on the member id
    public int updateServiceProvided(String original_id, String new_id, String member_name) {
        try {
            //connect to SQL database
            Connection myConn = DriverManager.getConnection(url, user, pass);

            //create our java preparedstatement using a sql update query
            PreparedStatement ps = myConn.prepareStatement("UPDATE provided_services SET member_name = ?, member_id = ? WHERE member_id = ?");

            // set the preparedstatement parameters
            ps.setString(1,member_name);
            ps.setString(2,new_id);
            ps.setString(3,original_id);

            //call executeUpdate to execute our sql update statement
            ps.executeUpdate();
            ps.close();
            return 1;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }

    // Display a service_provided with matching Member_ID
    public int DisplayAServiceProvided(String Member_ID) {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from provided_services");
            System.out.println("--------------\t\t-----------\t\t----------\t\t---------\t\t---------------\t\t--------");

            while(myRs.next()) {
                if (Member_ID.equals(myRs.getString("member_id"))) {
                    System.out.println(myRs.getInt("provider_id") + "\t\t"
                            + "Date of Service:" + myRs.getString( "date_of_service") + "\t\t"
                            + "Recorded Time:" + myRs.getInt("recorded_time") + "\t\t"
                            + "interfaces.Provider Name:"+ myRs.getString( "provider_name") + "\t\t"
                            + "Service Code:" + myRs.getInt("service_code") + "\t\t"
                            + "Service Name:" + myRs.getString("service_name")+ "\t\t"
                            + "service_records.Member Name:" + myRs.getString("member_name")+ "\t\t"
                            + "service_records.Member ID:" +myRs.getInt("member_id") + "\t\t"
                            + "Comments:" + myRs.getString("comments") + "\n");
                }
            }

            return 1;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }

    // Displays all service_provided by matching Provider_ID
    public int DisplayAllServiceProvided(String Provider_ID) {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from provided_services");
            System.out.println("--------------\t\t-----------\t\t----------\t\t---------\t\t---------------\t\t--------");

            while(myRs.next()) {
                if (Provider_ID.compareTo(myRs.getString("provider_id")) == 0) {
                    System.out.println("interfaces.Provider ID: " + myRs.getInt("provider_id") + "\t\t"
                            + "Date of Service:" + myRs.getString( "date_of_service") + "\t\t"
                            + "Recorded Time:" + myRs.getInt("recorded_time") + "\t\t"
                            + "interfaces.Provider Name:"+ myRs.getString( "provider_name") + "\t\t"
                            + "Service Code:" + myRs.getInt("service_code") + "\t\t"
                            + "Service Name:" + myRs.getString("service_name")+ "\t\t"
                            + "service_records.Member Name:" + myRs.getString("member_name")+ "\t\t"
                            + "service_records.Member ID:" +myRs.getInt("member_id") + "\t\t"
                            + "Comments:" + myRs.getString("comments") + "\n");
                }
            }

            return 1;
        } catch (Exception var5) {
            var5.printStackTrace();
            return 0;
        }
    }

    // Delete a service with matching Transaction_ID
    public int RemoveServiceProvided(int Transaction_ID) {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            PreparedStatement myStmt = myConn.prepareStatement("DELETE FROM provided_services WHERE id = ?");
            myStmt.setInt(1, Transaction_ID);
            myStmt.executeUpdate();
            return 1;
        } catch (Exception var4) {
            var4.printStackTrace();
            return 0;
        }
    }





    // -------------------<USER_ACCOUNTS TABLE>------------------------
    // Register a User Account
    public boolean Register_User(String username, int encrypted_password, String account_type, String email){
        // To get the hash code for a password, declare a String and store the password within it.
        // Then call .hashCode()

        if(username == null || account_type == null || email == null)
            return false;

        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStmt = myConn.createStatement();
            String sql = "INSERT INTO User_Accounts(Account_ID, Account_Type, Username, Hash_Password, Email) VALUES('"
                    + "0','"
                    + account_type + "', '"
                    + username + "', '"
                    + encrypted_password + "', '"
                    + email
                    + "')";
            myStmt.executeUpdate(sql);
            return true;
        } catch (Exception var4) {
            var4.printStackTrace();
            return false;
        }

    }

    // Validate Login Credentials
    public boolean Validate_User(String username, String password, String account_type) {
        int encrypted_password = password.hashCode();

        try {
            Connection myConn = DriverManager.getConnection(url, username, password);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from User_Accounts");

        while (myRs.next()) {
            if (encrypted_password == myRs.getInt("Hash_Password")
                    && username.compareTo(myRs.getString("Username")) == 0
                    && account_type.compareTo(myRs.getString("Account_Type")) == 0) {
                set_user_session(username, password);
                return true;
            }
        }
            return false;
        }catch (Exception var5) {
            var5.printStackTrace();
            return false;
        }
    }

    private void set_user_session(String username, String password){
        this.user = username;
        this.pass = password;
    }
}
