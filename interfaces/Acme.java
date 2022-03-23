package interfaces;

import sql.SQL_API;

import java.util.Scanner;

public class Acme {
    public static Status statusobj = new Status();

    //hide a sql_api.SQL_API object
    private final SQL_API sql_api;

    public Acme(){
        this.sql_api = new SQL_API();
    }
    //this function is responsible for changing the member's status if requested by the user
    
    protected boolean update_status(String member_id) {
        Scanner input = new Scanner(System.in);
        String temp = this.sql_api.getStatus(member_id);
        if (!temp.equals("1") && !temp.equals("-1")) {
            System.out.print("Would you like to update the member status " + temp + "? (y/n): ");
            if (user_input()) {
                System.out.print("Please enter a new status: ");
                temp = input.nextLine();
                statusobj.setStatus(member_id,temp);
                return true;
            }
        }
        return false;
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
        System.out.println("Would you like to update the status of a member?: (Y, Yes)");
        String response = input.nextLine();
        if (response.toUpperCase().equals("Y") || response.toUpperCase().equals("YES"))
            return true;
        return false;
    }
}