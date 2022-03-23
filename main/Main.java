package main;

import interfaces.*;
import service_records.*;
import sql.*;

public class Main {

    public static void main(String[] args) {
        // Declaring Service Object
        //Service serviceobj = new Service();

        // Declaring service_records.Member Object
        Member memberobj = new Member();

        //Declaring interfaces.Provider Object
        Provider providerobj = new Provider();

        // Declaring sql_api.SQL_API object
        SQL_API API = new SQL_API();

        //serviceobj.initService(123, 123, "bug", 123);

        //API.AddService(serviceobj);
        //API.DisplayAllProviders();
        //String str = "123456789";
        //API.DisplayMember(3);
        //int x = 3;
        //String temp = API.ValidateMember(12345);
        //System.out.println(temp);
        //API.DisplayAllServiceProvided(str);

        Manager manager = new Manager();
        //manager.update_member(6);
        //API.DisplayAllProviders();
        //manager.delete_member(3);
        //API.DisplayAllMembers();
        //manager.update_member("666666666");
        //API.DisplayAllMembers();
        //API.DisplayAServiceProvided("777777777");
        String date = manager.member_report("777777777");
        manager.view_report("777777777",date);
    }
}