package menu;

import controller.BusTerminal;
import entity.Bus;
import entity.Stop;

import java.util.Scanner;

public class UserMenu {
    Scanner input = new Scanner(System.in);
    BusTerminal busTerminal = new BusTerminal();


    public void showUserMenu() {
        System.out.println("\nWELCOME TO THE USER MENU!");

        String userInput;
        do {
            System.out.println("\n1. Show All Buses"
                    + "\n2. Show All Bus Stops"
                    + "\n3. Show All Buses at a Specific Bus Stop"
                    + "\n4. Show All Stops for a Specific Bus"
                    + "\nEnter E to Exit");

            System.out.println();
            System.out.print("Enter your choice: ");

            userInput = input.nextLine().toUpperCase();

            switch (userInput) {
                case "1":
                    viewAllBuses();
                    break;
                case "2":
                    viewAllBusStops();
                    break;
                case "3":
                    viewAllBusesAtSpecificBusStop();
                    break;
                case "4":
                    viewAllStopsForSpecificBus();
                    break;
                case "E":
                    System.out.println("See you later, come again!");

                default:
                    break;
            }
        } while (!userInput.equalsIgnoreCase("E"));

    }

    void viewAllBuses() {
        System.out.println("\nLIST OF BUSES");

        for (var bus: busTerminal.getBusesList()) {
            System.out.println(bus.getInfo());
        }
    }

    void viewAllBusStops() {
        System.out.println("\nLIST OF BUS STOPS");

        for (var stop: busTerminal.getStopsList()) {
            System.out.println(stop.getInfo());
        }
    }

    void viewAllBusesAtSpecificBusStop() {
        System.out.println("Which bus stop do you want to check for bus availability?");
        viewAllBusStops();
        System.out.print("Enter bus stop number: ");
        int id = Integer.parseInt(input.nextLine());

        Stop stop = busTerminal.getStopById(id);

        System.out.println("\nThe following buses stop at the bus stop " + stop.getBusStopName() + ":");

        for (Bus bus: busTerminal.getAllBusesForStop(stop.getId())) {
            System.out.println(bus.getInfo());
        }
    }

    void viewAllStopsForSpecificBus() {
        viewAllBuses();

        System.out.print("Enter bus number: ");
        int busNumber = Integer.parseInt(input.nextLine());

        Bus bus = busTerminal.getBusByNumber(busNumber);

        System.out.println("\nBus number " + busNumber + " stops at the following bus stops: " +
                "\nFirst stop: " + bus.getFirstStop());

        int counter = 2;
        for (Stop stop: busTerminal.getAllStopsForBus(bus.getBusNumber())) {
            System.out.println(counter + " bus stop: " + stop.getBusStopName());
            counter++;
        }

        System.out.println("Last stop: " + bus.getLastStop());

    }

//    do {
//        System.out.print("Please enter your name: ");
//        String adminEnter = input.nextLine().toUpperCase();
//
//        while (!adminEnter.isBlank() && adminEnter.equals(admin.getName())) {
//            System.out.print("Please enter your password: ");
//            String adminPassword = input.nextLine();
//
//            while (!adminPassword.isBlank() && adminPassword.equals(admin.getPassword())) {
//                System.out.println("\nWelcome " + adminEnter + "!!!");
//                var result = adminMenu.showBusAdminMenu();
//
//                if (!result) {
//                    return false;
//                }
//            }
//            System.out.println("Incorrect password, please try again.");
//            continue;
//        }
//        System.out.println("Incorrect name, please try again.");
//        continue;
//    } while (true);
}
