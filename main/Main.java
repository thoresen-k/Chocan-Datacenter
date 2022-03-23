package main;/*
    TEST
*/

import com.google.api.services.sqladmin.model.User;
import encryption.Hash_Function;
import interfaces.*;
import service_records.*;
import sql.*;

import javax.crypto.Cipher;
import javax.swing.*;

import java.util.Scanner;

import static javafx.application.Platform.exit;

public class Main {
    // Data Members
    public static User_Interfaces UI = new User_Interfaces();
    static Scanner scanner = new Scanner(System.in);
    public static char choice = '\0';
    public static int account_type = 0;

    public static void main(String[] args) {

        // [PROGRAM START]
        // Initiate Login Interface
        account_type = UI.LaunchLoginInterface();
        while(choice != 'y' && choice != 'Y'){

            // Launch Provider Interface
            if(account_type == 1)
                UI.LaunchManagerInterface();

            // Launch Manager Interface
            else if(account_type == 2)
                UI.LaunchProviderInterface();

            // Launch Acme Interface
            else if(account_type == 3)
                UI.LaunchAcmeInterface();

            // Launch Admin Interface
            else if(account_type == 4)
                UI.LaunchAdminInterface();

            System.out.print("Quit? [Y/N]\n" +
                             "> ");
            choice = scanner.next().charAt(0);
        }

        // [PROGRAM END]
        System.out.print("Shutting down program...\n");
        exit();
    }
}