package interfaces;

import sql.SQL_API;

import java.io.Console;
import java.util.Scanner;

public class Login {
    protected String provider_id;
    private static String account_type;
    private static String username;
    private static String password;

    // Manages printing the initial header
    public void display_login_header(){
        System.out.println("------------------Chocolate Anonymous Terminal----------------------");
        System.out.println("\n\n\n");
    }

    // Manages requesting account types
    public int request_account_type(){
        int choice = 0;

        System.out.print("Please select your account type[1-4]: \n");
        System.out.print("1) Manager\n" +
                           "2) Provider\n" +
                           "3) ACME\n" +
                           "4) Admin\n\n" +
                           "> ");

        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();

        return choice;
    }

    // Initializes account_type variable
    public boolean validate_account_type(int account_type){
        // Perform SQL call to compare account_type w/ User_Accounts Account_Type
        // 0 - Provider
        // 1 - Manager
        // 2 - ACME
        // 3 - Admin

        switch(account_type){
            // Manager
            case 1:
                this.account_type = "MANAGER";
                break;

            // Provider
            case 2:
                this.account_type = "PROVIDER";
                break;

            // ACME
            case 3:
                this.account_type = "ACME";
                break;

            case 4:
                this.account_type = "ADMIN";
                break;

            default:
                return false;
        }

        return true;
    }

    // Requests and Initialize username and password
    public boolean request_credentials() {

        System.out.println("Are you a provider? If manager enter 'N', provider enter 'Y':");
        Console console = System.console();
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        if (response.equals("Y") || response.equals("Yes")) {
            if(!getProviderID())
                return false;
            else
                username = this.provider_id;
                System.out.print("Enter your Password now: ");
                password = scanner.next();
                return true;
        }

        else {
            System.out.print("Username: ");
            username = scanner.next();

            System.out.print("Password: ");
            password = scanner.next();

            if (username == "" || password == "") {
                return false;
            }

        }

        return true;
    }
    //get the provider id number from the user to verify whether it is correct or not 
    private boolean getProviderID() {
        System.out.println("Please enter your provider number:");
        Scanner scanner = new Scanner(System.in);
        this.provider_id = new String();
        this.provider_id = scanner.nextLine();
        if(provider_id.length()!=10)
            return true;
        else
            System.out.println("ProviderNumberIncorrect");
            return false;
    }

    // Verifies if user exists within database
    public boolean verify_user(){
        SQL_API API = new SQL_API();

        // Checks if user is in database
        if(API.Validate_User(username, password, account_type) == false)
            return false;

        return true;
    }

}
