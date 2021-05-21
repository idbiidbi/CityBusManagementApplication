import entity.Admin;
import menu.AdminMenu;
import menu.UserMenu;
import ui.MainForm;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    Scanner input = new Scanner(System.in);
    static AdminMenu adminMenu = new AdminMenu();
    Admin admin = new Admin();
    UserMenu userMenu = new UserMenu();

//    MainForm mainForm;

    public static void main(String[] args) {
        Main main = new Main();

//          main.mainForm = new MainForm();
//          main.mainForm.showForm();

        main.signIn();
    }

    public void signIn() {
        String userInput;

        do {
            System.out.println("\nWELCOME TO THE BUS TERMINAL APPLICATION!!!");
            System.out.println("\nPlease choose: \n" +
                    "1. Sign in as admin" + "\n" +
                    "2. Sign in as user" + "\n" +
                    "Enter E to Exit" + "\n");

            System.out.print("Enter your choice: ");

            userInput = input.nextLine().toUpperCase();

            switch (userInput) {
                case "1":
                    boolean result = signInAsAdmin();
                    if (!result) {
                        return;
                    }
                    break;
                case "2":
                    boolean result1 = signInAsUser();
                    if (!result1) {
                        return;
                    }
                    break;
                case "E":
                    System.out.println("See you later, come again!");
                    return;
                default:
                    break;
            }
        } while (!userInput.equalsIgnoreCase("E"));
    }

    Boolean signInAsAdmin() {

        do {
            System.out.print("Please enter your name: ");
            String adminEnter = input.nextLine().toUpperCase();

            while (!adminEnter.isBlank() && adminEnter.equals(admin.getName())) {
                System.out.print("Please enter your password: ");
                String adminPassword = input.nextLine();

                while (!adminPassword.isBlank() && adminPassword.equals(admin.getPassword())) {
                    System.out.println("\nWelcome " + adminEnter + "!!!");
                    var result = adminMenu.showBusAdminMenu();

                    return result;
                }
                System.out.println("Incorrect password, please try again.");
                continue;
            }
            System.out.println("Incorrect name, please try again.");
            continue;
        } while (true);
    }

    Boolean signInAsUser() {
        boolean result = userMenu.showUserMenu();
        if (!result) {
            return false;
        }

        return true;
    }
}

