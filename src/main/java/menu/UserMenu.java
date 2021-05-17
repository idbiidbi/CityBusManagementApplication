package menu;
import controller.BusTerminal;
import java.util.Scanner;

public class UserMenu {
    Scanner input = new Scanner(System.in);
    BusTerminal busTerminal = new BusTerminal();

    public void showUserMenu() {

        String userInput;
        do {
            System.out.println("\n1. Show All Buses"
                    + "\n2. Show All Stops"
                    + "\n3. ......"
                    + "\n4. ......"
                    + "\nEnter E to Exit");

            System.out.println();
            System.out.print("Enter your choice: ");

            userInput = input.nextLine().toUpperCase();

            switch (userInput) {
                case "1":
                    viewAllBuses();
                    break;
                case "2":
                    //viewAllStops();
                    break;
                case "3":
                    //removeBus();
                    break;
                case "E":
                    System.out.println("See you later, come again!");
                default:
                    break;
            }
        } while (!userInput.equalsIgnoreCase("E"));

    }

    void viewAllBuses() {
        System.out.println("\nBUS LIST");

        for (var bus: busTerminal.getBusesList()) {
            System.out.println(bus);
        }
    }
}
