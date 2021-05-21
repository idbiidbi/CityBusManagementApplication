package menu;

import controller.BusTerminal;
import entity.Bus;
import entity.Stop;

import java.util.Scanner;

public class UserMenu {
    Scanner input = new Scanner(System.in);
    BusTerminal busTerminal = new BusTerminal();


    public boolean showUserMenu() {
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
                    return false;
                default:
                    break;
            }
        } while (!userInput.equalsIgnoreCase("E"));
        return true;
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

        viewAllBusStops();

        int id;
        Stop stop;

        while(true) {
            id = MenuInputValidator.checkIfNumberEntered("Enter bus stop number: ");

            stop = busTerminal.getStopById(id);

            if(stop == null) {
                System.out.println("Invalid bus stop number");
                continue;
            }

            break;
        }

        System.out.println("\nThe following buses stop at the bus stop " + stop.getBusStopName() + ":");

        for (Bus bus: busTerminal.getAllBusesForStop(stop.getId())) {
            System.out.println(bus.getInfo());
        }
    }

    void viewAllStopsForSpecificBus() {
        viewAllBuses();

        int busNumber;
        Bus bus;

        while(true) {
            busNumber = MenuInputValidator.checkIfNumberEntered("Enter bus number: ");

            bus = busTerminal.getBusByNumber(busNumber);

            if(bus == null) {
                System.out.println("Invalid bus number");
                continue;
            }

            break;
        }

        System.out.println("\nBus number " + busNumber + " stops at the following bus stops: " +
                "\nRoute: " + bus.route());

        int counter = 1;
        for (Stop stop: busTerminal.getAllStopsForBus(bus.getBusNumber())) {
            System.out.println(counter + " bus stop: " + stop.getBusStopName());
            counter++;
        }
    }
}
