package interfaces;
import sql.SQL_API;
import service_records.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Manager
{
    //hide a sql_api.SQL_API object
    private final SQL_API sql_api;

    public Manager(){
        this.sql_api = new SQL_API();
    }

    //functions to implement
    public void delete_member(String member_id){
         int temp = Integer.parseInt(member_id);
         this.sql_api.RemoveMember(temp);
    }

    public void add_member(Member to_add){
        this.sql_api.AddMembers(to_add);
    }

    public void update_member(String member_id){
        System.out.println("Locating the member to update...");
        this.sql_api.DisplayMember(member_id);
        System.out.print("Is this the correct member? (y/n): ");
        if(user_input())
        {
            String id = update_ID(member_id);
            System.out.println("New member ID: " + id);

            String first_name = update_fname(member_id);
            System.out.println("New first name: " + first_name);

            String last_name = update_lname(member_id);
            System.out.println("New last name: " + last_name);

            String street = update_street(member_id);
            System.out.println("New state: " + street);

            String apt = update_APT(member_id);
            System.out.println("New apartment number: " + apt);

            String city = update_city(member_id);
            System.out.println("New city: " + city);

            String state = update_state(member_id);
            System.out.println("New state: " + state);

            int zip = update_zip(member_id);
            System.out.println("New zip: " + zip);

            String status = update_status(member_id);
            System.out.println("New status: " + status);

            this.sql_api.updateMember(member_id,id,first_name,last_name,street,apt,state,city,zip,status);
        }
    }


    // helper functions for update_member
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

    private String update_status(String member_id)
    {
        Scanner input = new Scanner(System.in);
        String temp = this.sql_api.getStatus(member_id);
        if(!temp.equals("1") && !temp.equals("-1"))
        {
            System.out.print("Would you like to update the member status " + temp + "? (y/n): ");
            if(user_input())
            {
                System.out.print("Please enter a new status: ");
                temp = input.nextLine();
            }
        }
        return temp;
    }

    private int update_zip(String member_id)
    {
        Scanner input = new Scanner(System.in);
        int temp = this.sql_api.getZip(member_id);
        if(temp!=1 && temp!=-1)
        {
            System.out.print("Would you like to update the zip " + temp + "? (y/n): ");
            if(user_input())
            {
                System.out.print("Please enter a new zip: ");
                temp = input.nextInt();
            }
        }
        return temp;
    }

    private String update_state(String member_id)
    {
        Scanner input = new Scanner(System.in);
        String temp = this.sql_api.getState(member_id);
        if(!temp.equals("1") && !temp.equals("-1"))
        {
            System.out.print("Would you like to update the state " + temp + "? (y/n): ");
            if(user_input())
            {
                System.out.print("Please enter a new state: ");
                temp = input.nextLine();
            }
        }
        return temp;
    }

    private String update_city(String member_id)
    {
        Scanner input = new Scanner(System.in);
        String temp = this.sql_api.getCity(member_id);
        if(!temp.equals("1") && !temp.equals("-1"))
        {
            System.out.print("Would you like to update the city " + temp + "? (y/n): ");
            if(user_input())
            {
                System.out.print("Please enter a new city: ");
                temp = input.nextLine();
            }
        }
        return temp;
    }

    private String update_APT(String member_id)
    {
        Scanner input = new Scanner(System.in);
        String apt = this.sql_api.getApt(member_id);
        if(!apt.equals("1") && !apt.equals("-1"))
        {
            System.out.print("Would you like to update the apartment number " + apt + "? (y/n): ");
            if(user_input())
            {
                System.out.print("Please enter a new apartment number: ");
                apt = input.nextLine();
            }
        }
        return apt;
    }

    private String update_street(String member_id)
    {
        Scanner input = new Scanner(System.in);
        String temp = this.sql_api.getStreet(member_id);
        if(!temp.equals("1") && !temp.equals("-1"))
        {
            System.out.print("Would you like to update the street " + temp + "? (y/n): ");
            if(user_input())
            {
                System.out.print("Please enter a new street: ");
                temp = input.nextLine();
            }
        }
        return temp;
    }

    private String update_lname(String member_id)
    {
        Scanner input = new Scanner(System.in);
        String temp = this.sql_api.getLName(member_id);
        if(!temp.equals("1") && !temp.equals("-1"))
        {
            System.out.print("Would you like to update the last name " + temp + "? (y/n): ");
            if(user_input())
            {
                System.out.print("Please enter a new last name: ");
                temp = input.nextLine();
            }
        }
        return temp;
    }

    private String update_fname(String member_id)
    {
        Scanner input = new Scanner(System.in);
        String temp = this.sql_api.getFName(member_id);
        if(!temp.equals("1") && !temp.equals("-1"))
        {
            System.out.print("Would you like to update the first name " + temp + "? (y/n): ");
            if(user_input())
            {
                System.out.print("Please enter a new first name: ");
                temp = input.nextLine();
            }
        }
        return temp;
    }

    private String update_ID(String member_id)
    {
        Scanner input = new Scanner(System.in);
        String temp = this.sql_api.getMemberID(member_id);

        if(!temp.equals("1") && !temp.equals("-1"))
        {
            System.out.print("Would you like to update the member ID " + temp + "? (y/n): ");
            if(user_input())
            {
                System.out.print("Please enter a new 9 digit ID: ");
                temp = input.nextLine();
                if(String.valueOf(temp).length()<9)
                {
                    Random random = new Random();
                    for(int i = String.valueOf(temp).length(); i<9; ++i)
                    {
                        int k = random.nextInt(9);
                        temp = Integer.toString(Integer.parseInt(String.valueOf(temp) + k));
                    }
                }
            }
        }

        return temp;
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




    public String member_report()
    {
        //get the current date
        String date = getTime();
        System.out.println("What is the member_ID for this member's weekly services?:");
        Scanner a_scan = new Scanner(System.in);
        String member_id = a_scan.nextLine();

        //create the name of the file
        String file_name = this.sql_api.getFName(member_id) + this.sql_api.getLName(member_id) + date + ".txt";
        File member_file = new File(file_name);

        //insert a line at a time into the file
        String temp_string;
        java.util.Date[] dateofservice = new Date[20];
        String[] providername = new String[20];
        String[] servicename = new String[20];
        String[] sorted_date = new String[20];
        int items;

        //use these to insert each date of service, provider name, and service name
        String dos;
        String pname;
        String sname;

        //write to the file
        try
        {
            if(member_file.createNewFile())
            {
                System.out.println("File created: " + member_file.getName());
            }
            //declare a FileWriter object
            FileWriter fileWriter = new FileWriter(file_name);

            //get and insert the first and last name of the member
            temp_string = this.sql_api.getFName(member_id) + " " + this.sql_api.getLName(member_id)+"\n";
            System.out.print("Inserting into File: " + temp_string+"\n");
            fileWriter.write(temp_string);

            //save the member name for future reference
            String member_name = this.sql_api.getMemberName(member_id);
            
            //insert the member id passed in into the file
            System.out.print("Inserting into File: " + member_id+"\n");
            fileWriter.write(member_id+"\n");

            //get and insert the address of the member
            temp_string = this.sql_api.getStreet(member_id)+"\n";
            System.out.print("Inserting into File: " + temp_string+"\n");
            fileWriter.write(temp_string);

            //get and insert the city of the member
            temp_string = this.sql_api.getCity(member_id)+"\n";
            System.out.print("Inserting into File: " + temp_string+"\n");
            fileWriter.write(temp_string);

            //get and insert the state of the member
            temp_string = this.sql_api.getState(member_id)+"\n";
            System.out.print("Inserting into File: " + temp_string+"\n");
            fileWriter.write(temp_string);

            //get and insert the zip of the member
            temp_string = this.sql_api.getZip(member_id)+"\n";
            System.out.print("Inserting into File: " + temp_string+"\n");
            fileWriter.write(temp_string);

            //read in provided service info into arrays
            items = this.sql_api.getServiceInfo(member_id,member_name,dateofservice,providername,servicename,sorted_date);
            System.out.println(items);
            //sort the services provided by date of service by matching the sorted dates with the date in the service_name array
            for(int i = (20-items); i<20; ++i)
            {
                //System.out.println(dateofservice[i]);

                //initialize the string to the ith index of the servicename
                String string = servicename[i-(20-items)];
                System.out.println(string);
                String checkdate = servicename[i-(20-items)].substring(0,28);
                System.out.println(checkdate);
                for(int j = (20-items); j<20; ++j)
                {
                    if(String.valueOf(dateofservice[j]).equals(checkdate))
                    {
                        System.out.println("j:" + (j-(20-items)) + " i: " +(i-(20-items)));
                        sorted_date[j-(20-items)] = string + "\n";
                    }
                }
                System.out.println();
            }
            
            //go through the sorted services and write them to the file
            for(int i = 0; i<items; ++i)
            {
                System.out.println("Inserting into file: " + sorted_date[i]);
                fileWriter.write(sorted_date[i]);
            }

            fileWriter.close();
        }
        catch (IOException file)
        {
            System.out.println("Cannot create/write to file");
        }
        return date;
    }

    //function to get the current date
    public String getDate()
    {
        Date date = new Date();
        LocalDate localDate = LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        String recorded_time = month + "-" + day + "-" + year;

        return recorded_time;
    }

    public void view_report()
    {
        System.out.println("What is the member_id for this report?:");
        Scanner a_scan = new Scanner(System.in);
        String member_id = a_scan.nextLine();


        System.out.println("What is the date for this report?(MM-DD-YYYY):");
        String date = a_scan.nextLine();

        String file_name = this.sql_api.getFName(member_id) + this.sql_api.getLName(member_id) + date + ".txt";
        System.out.println("Contents of: " + file_name);
        try
        {
            File member_file = new File(file_name);
            Scanner myReader = new Scanner(member_file);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (IOException error)
        {
            System.out.println("Unable to read file: "+ file_name);
        }
    }

    //Add/Update/Delete Providers////////////////////////////////////////////////////////////:
    private String updateProviderID(String provider_id) {
        Scanner input = new Scanner(System.in);
        String temp = this.sql_api.getProviderID(provider_id);

        if (!temp.equals("1") && !temp.equals("-1")) {
            System.out.print("Would you like to update the provider ID " + temp + "? (y/n): ");
            if (user_input()) {
                System.out.print("Please enter a new 9 digit ID: ");
                temp = input.nextLine();
                if (String.valueOf(temp).length() < 9) {
                    Random random = new Random();
                    for (int i = String.valueOf(temp).length(); i < 9; ++i) {
                        int k = random.nextInt(9);
                        temp = Integer.toString(Integer.parseInt(String.valueOf(temp) + k));
                    }
                }
            }
        }

        return temp;
    }


    private String updateProviderName(String provider_id) {
        {
            Scanner input = new Scanner(System.in);
            String temp = this.sql_api.getProviderName(provider_id);
            if (!temp.equals("1") && !temp.equals("-1")) {
                System.out.print("Would you like to update the full name " + temp + "? (y/n): ");
                if (user_input()) {
                    System.out.print("Please enter the full name for the provider: ");
                    temp = input.nextLine();
                }
            }
            return temp;
        }
    }


    private String updateProviderStreet(String provider_id) {
        Scanner input = new Scanner(System.in);
        String temp = this.sql_api.getProviderStreet(provider_id);
        if (!temp.equals("1") && !temp.equals("-1")) {
            System.out.print("Would you like to update the street: " + temp + "? (y/n): ");
            if (user_input()) {
                System.out.print("Please enter a new street location: ");
                temp = input.nextLine();
            }
        }
        return temp;
    }


    private String updateProviderApt(String provider_id) {
        Scanner input = new Scanner(System.in);
        String temp = this.sql_api.getProviderApt(provider_id);
        if (!temp.equals("1") && !temp.equals("-1")) {
            System.out.print("Would you like to update the Apt #: " + temp + "? (y/n): ");
            if (user_input()) {
                System.out.print("Please enter a new Apt#: ");
                temp = input.nextLine();
            }
        }
        return temp;
    }

    private String updateProviderState(String provider_id) {
        Scanner input = new Scanner(System.in);
        String temp = this.sql_api.getProviderState(provider_id);
        if (!temp.equals("1") && !temp.equals("-1")) {
            System.out.print("Would you like to update the state location #: " + temp + "? (y/n): ");
            if (user_input()) {
                System.out.print("Please enter a new state location: ");
                temp = input.nextLine();
            }
        }
        return temp;
    }


    private int updateProviderZip(String provider_id) {
        Scanner input = new Scanner(System.in);
        int temp = this.sql_api.getProviderZip(provider_id);
        if (!(temp == 1) && !(temp == -1)) {
            System.out.print("Would you like to update the zip-code #: " + temp + "? (y/n): ");
            if (user_input()) {
                System.out.print("Please enter a new zip-code: ");
                temp = input.nextInt();
            }
        }
        return temp;
    }

    private String updateProviderCity(String provider_id) {
        Scanner input = new Scanner(System.in);
        String temp = this.sql_api.getProviderCity(provider_id);
        if (!temp.equals("1") && !temp.equals("-1")) {
            System.out.print("Would you like to update the city location #: " + temp + "? (y/n): ");
            if (user_input()) {
                System.out.print("Please enter a new city: ");
                temp = input.nextLine();
            }
        }
        return temp;
    }


    public void delete_provider(String provider_id) {
        this.sql_api.RemoveProvider(provider_id);
    }

    public void add_provider(Provider to_add) {
        this.sql_api.AddProvider(to_add);
    }

    public void update_provider() {

        System.out.println("What is the id# of the provider you are updating?:");
        Scanner a_scan = new Scanner(System.in);
        String provider_id = a_scan.nextLine();

        System.out.println("Locating the provider to update...");
        this.sql_api.DisplayAProvider(provider_id);
        System.out.print("Is this the correct member? (y/n): ");
        if (user_input()) {
            String id = updateProviderID(provider_id);
            System.out.println("New member ID: " + id);

            String full_name = updateProviderName(provider_id);
            System.out.println("New provider name: " + full_name);

            String street = updateProviderStreet(provider_id);
            System.out.println("New street address: " + street);

            String apt = updateProviderApt(provider_id);
            System.out.println("New apartment number: " + apt);

            String state = updateProviderState(provider_id);
            System.out.println("New state location: " + state);

            int zip = updateProviderZip(provider_id);
            System.out.println("New zip location: " + zip);

            String city = updateProviderCity(provider_id);
            System.out.println("New city location: " + city);


            this.sql_api.updateProvider(provider_id, id, full_name, street, apt, state, zip, city);
        }

    }
}

