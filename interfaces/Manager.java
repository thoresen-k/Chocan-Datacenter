package interfaces;
import sql.SQL_API;
import service_records.Member;
import service_records.Service_Provided;

import java.util.*;
import java.io.*;

//timer libraries
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/*
    The manager class will manage administrative access to the database.
    The functionalities offered to managers are
    1) Deleting existing member accounts
    2) Adding new member accounts
    3) Requesting weekly reports to be generate
    4) Run reports ??????? <-- TODO need to get this clarified
 */

public class Manager
{
    //hide a sql_api.SQL_API object
    private final SQL_API sql_api;

    public Manager(){
        this.sql_api = new SQL_API();
    }

    //functions to implement
    public void delete_member(int member_id){
        this.sql_api.RemoveMember(member_id);
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
            System.out.println("New street: " + street);

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

            //update member record
            this.sql_api.updateMember(member_id,id,first_name,last_name,street,apt,state,city,zip,status);
            //this.sql_api.DisplayAllMembers();

            //update provided_services record
            String member = first_name+" "+last_name;
            this.sql_api.updateServiceProvided(member_id,id,member);
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

    public String member_report(String member_id)
    {
        //get the current date
        String date = getDate();
        //System.out.println("Date of report: " + date);

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
            System.out.println(member_name);

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
            //sort the services provided by date of service by attaching the provider name & service name to the correct date
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

    public void view_report(String member_id, String date)
    {
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
}