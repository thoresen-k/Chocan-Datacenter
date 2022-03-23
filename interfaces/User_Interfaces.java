package interfaces;

import service_records.Member;
import service_records.Service_Provided;
import sql.SQL_API;

import java.io.Console;
import java.util.Scanner;
import java.util.UUID;
import static javafx.application.Platform.exit;

public class User_Interfaces {
    // Data Members
    public static Member memberobj = new Member();
    public static Provider providerobj = new Provider();
    public static Manager managerobj = new Manager();
    public static Acme acmeobj = new Acme();
    public static SQL_API API = new SQL_API();
    public static Login login_obj = new Login();
    public static int account_type = -1;
    public static Scanner scanner = new Scanner(System.in);

    // Launches Login Interface
    public int LaunchLoginInterface(){
        // Displays login header
        login_obj.display_login_header();

        // Request type of account
        account_type = login_obj.request_account_type();

        // Error checks and will continue to request user to enter in account type until valid.
        while(!login_obj.validate_account_type(account_type)){
            System.out.println("\nUnidentified input value. Please try again.");
            account_type = login_obj.request_account_type();
        }

        // Prompt for username/password
        login_obj.request_credentials();
        if(login_obj.verify_user())
            System.out.println("Login Success!");
        else{
            // Exit from program if user is not authorized
            System.out.println("Unable to verify account.");
            exit();
        }

        return account_type;
    }

        // Launches Manager Interface
        public void LaunchManagerInterface(){
            char choice = 0;
            System.out.println("What would you like to do:\n" +
                    "1) Work on member information \n" +
                    "2) Work on provider information \n" +
                    "3) Generate reports for the week \n" +
                    "4) Generate individual reports \n" +
                    "5) Quit interface \n"
            );
            choice = scanner.next().charAt(0);
            System.out.println("");
            while (choice != 5){
                switch (choice) {
                    case '1':
                        ManagerWorkMember();
                        break;
                    case '2':
                        ManageUpdateProvider();
                        break;
                    case '3':
                        ManageGenerateEFTReport();
                        break;
                    case '4':
                        scanner.nextLine();
                        String value = scanner.nextLine();
                        ManageGenerateReport();
                    case '5':
                        return;
                    default:
                        System.out.println("What would you like to do:\n");
                        choice = scanner.next().charAt(0);
                }
            }
            //Prompt manager to update Provider.
            managerobj.update_provider();
        }

        private void ManagerWorkMember(){
            char choice = 0;
            System.out.println("");
            while(choice != 4 ){
                System.out.println("Available functionality:\n" +
                        "1) Add member \n" +
                        "2) Update member \n" +
                        "3) Delete member \n" +
                        "4) Quit \n"
                );
                choice = scanner.next().charAt(0);
                switch (choice){
                    case '1':
                        ManagerAddMember();
                        System.out.println("What would you like to do:\n");
                        choice = scanner.next().charAt(0);
                        break;
                    case '2':
                        ManagerUpdateMember();
                        System.out.println("What would you like to do:\n");
                        choice = scanner.next().charAt(0);
                        break;
                    case '3':
                        ManagerDeleteMember();
                        System.out.println("What would you like to do:\n");
                        choice = scanner.next().charAt(0);
                        break;
                    case '4':
                        return;
                }
            }
        }

        private void ManagerAddMember(){
            scanner.nextLine();
            String uniqueID = UUID.randomUUID().toString();
            String id = uniqueID.substring(0,8);
            System.out.println("Enter member first name: ");
            String first_name = scanner.nextLine();
            System.out.println("Enter member last name: ");
            String last_name = scanner.nextLine();
            System.out.println("Enter member address: ");
            String address = scanner.nextLine();
            System.out.println("Enter member apt number: ");
            String apt = scanner.nextLine();
            System.out.println("Enter member city: ");
            String city = scanner.nextLine();
            System.out.println("Enter member state: ");
            String state = scanner.nextLine();
            System.out.println("Enter member zip: ");
            String zip_string = scanner.nextLine();
            int zip = Integer.parseInt(zip_string);
            System.out.println("Enter member status: ");
            String name = first_name + " " + last_name;
            Status status = new Status(name ,"Validated");
            Member new_member = new Member(id, last_name, first_name, address, apt, city, state, zip, status);
            managerobj.add_member(new_member);
        }

        private void ManagerUpdateMember(){
            scanner.nextLine();
            System.out.println("Please provide id of member: ");
            String id = scanner.nextLine();
            managerobj.update_member(id);
        }

        private void ManagerDeleteMember(){
            System.out.println("Please provide id of member:\n");
            String id = scanner.nextLine();
            managerobj.delete_member(id);
        }

        private void ManageUpdateProvider(){
            scanner.nextLine();
            System.out.println("Please enter provider id:");
            String id = scanner.nextLine();
            char choice = 0;
            System.out.println("What would you like to do:\n" +
                    "1) ADD provider info \n" +
                    "2) Update provider info \n" +
                    "3) Delete provider \n" +
                    "4) Generate report \n"
            );
            choice = scanner.next().charAt(0);
            System.out.println("");
            while (choice != 3){
                switch (choice) {
                    case '1':
                        ManagerAddProvider();
                        System.out.println("What would you like to do:\n");
                        choice = scanner.next().charAt(0);
                        break;
                    case '2':
                        managerobj.update_provider();
                        System.out.println("What would you like to do:\n");
                        choice = scanner.next().charAt(0);
                        break;
                    case '3':
                        managerobj.delete_provider(id);
                        System.out.println("What would you like to do:\n");
                        choice = scanner.next().charAt(0);
                        break;
                    case '4':
                        break;
                    case '5':

                    default:
                        System.out.println("What would you like to do:\n");
                        choice = scanner.next().charAt(0);
                }
            }
        }

        private void ManagerAddProvider(){
            scanner.nextLine();
            String uniqueID = UUID.randomUUID().toString();
            String id = uniqueID.substring(0,8);
            System.out.println("Enter provider first name: ");
            String first_name = scanner.nextLine();
            System.out.println("Enter provider last name: ");
            String last_name = scanner.nextLine();
            System.out.println("Enter provider address: ");
            String address = scanner.nextLine();
            System.out.println("Enter provider apt number: ");
            String apt = scanner.nextLine();
            System.out.println("Enter provider city: ");
            String city = scanner.nextLine();
            System.out.println("Enter provider state: ");
            String state = scanner.nextLine();
            System.out.println("Enter provider zip: ");
            String zip_string = scanner.nextLine();
            int zip = Integer.parseInt(zip_string);
            System.out.println("Enter provider status: ");
            String name = first_name + " " + last_name;
            Service_Provided service = new Service_Provided();
            Provider new_provider = new Provider(id, name, address, apt, state, zip, city, service );
            managerobj.add_provider(new_provider);
        }



    private void ManageGenerateReport(){
        char choice = 0;
        System.out.println("");
        while(choice != 4 ){
            System.out.println("Available functionality:\n" +
                    "1) Generate Member Report \n" +
                    "2) Generate Provider Report \n" +
                    "3) Quit \n"
            );
            choice = scanner.next().charAt(0);
            switch (choice){
                case '1':
                    ManagerMemberReport();
                    System.out.println("What would you like to do:\n");
                    choice = scanner.next().charAt(0);
                    break;
                case '2':
                    ManagerProviderReport();
                    System.out.println("What would you like to do:\n");
                    choice = scanner.next().charAt(0);
                    break;
                case '3':
                    return;
            }
        }
    }

    private void ManagerMemberReport() {
        managerobj.member_report();
    }


    private void ManagerProviderReport(){

    }

    private void ManageGenerateEFTReport(){

    }


    // Launches Provider Interface
    public void LaunchProviderInterface(){
        boolean flag = true;

        while(providerobj.response() && flag == true) {
            System.out.println("Enter the member number you would like to add a visitation for:");
            Scanner a_scan = new Scanner(System.in);
            String member_id = a_scan.nextLine();
            int temp = Integer.parseInt(member_id);
            providerobj.billVisitation(temp, login_obj.provider_id);
        }
        flag = false;
    }

    // Launches Acme Interface
    public void LaunchAcmeInterface(){
        boolean flag = true;

        while(acmeobj.response() && flag == true) {
            String member_id;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the member id to update status: \n");
            member_id = scanner.next();
            acmeobj.update_status(member_id);
            }
            flag = false;
    }

    // Launches Admin Interface
    public void LaunchAdminInterface(){

    }

}
