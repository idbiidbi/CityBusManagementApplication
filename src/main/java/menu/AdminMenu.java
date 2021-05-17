package menu;
import controller.BusTerminal;
import database.BusRepository;
import entity.Bus;

import java.util.Scanner;

public class AdminMenu {

    Scanner input = new Scanner(System.in);
    BusTerminal busTerminal = new BusTerminal();

    public Boolean showBusAdminMenu() {

        String userInput;
        do {
            System.out.println("\n1. Add Bus \t\t\t\t5. Add Driver \t\t\t\t9. Add Bus Stop"
                    + "\n2. Update Bus  \t\t\t6. Update Driver \t\t\t10. Update Bus Stop"
                    + "\n3. Remove Bus \t\t\t7. Remove Driver \t\t\t11. Remove Bus Stop"
                    + "\n4. View All Buses \t\t8. View All Drivers \t\t12. View All Bus Stops"
                    + "\nEnter E to Exit");

            System.out.println();
            System.out.print("Enter your choice: ");

            userInput = input.nextLine().toUpperCase();

            switch (userInput) {
                case "1":
                    addBus();
                    break;
                case "2":
                    updateBus();
                    break;
                case "3":
                    removeBus();
                    break;
                case "4":
                    viewAllBuses();
                    break;
                case "5":
                    // addDriver();
                    break;
                case "6":
                    //updateDriver();
                    break;
                case "7":
                    // removeDriver();
                    break;
                case "8":
                    // viewAllDrivers();
                    break;
                case "9":
                    // addBusStop();
                    break;
                case "10":
                    //updateBusStop();
                    break;
                case "11":
                    // removeBusStop();
                    break;
                case "12":
                    //viewAllBusStops();
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

    void addBus(){

        Bus newBus = new Bus();

        System.out.println("\nCREATE A NEW BUS");

        System.out.print("Enter bus number: ");
        newBus.setBusNumber(Integer.parseInt(input.nextLine()));

        System.out.print("Enter bus first stop: ");
        newBus.setFirstStop(input.nextLine());

        System.out.print("Enter bus last stop: ");
        newBus.setLastStop(input.nextLine());

        System.out.println(busTerminal.addBus(newBus));
    }

    void updateBus(){
        this.viewAllBuses();

        System.out.println("\nUPDATE BUS");

        System.out.print("Enter bus id: ");
        int id = Integer.parseInt(input.nextLine());

        Bus bus = busTerminal.getBusById(id);

        System.out.print("Update new bus first stop: ");
        bus.setFirstStop(input.nextLine());

        System.out.print("Update new bus last stop: ");
        bus.setLastStop(input.nextLine());

        System.out.println(busTerminal.updateBus(bus));

    }

    void removeBus(){

        System.out.println("DELETE BUS");
        System.out.print("Enter bus id: ");
        int id = Integer.parseInt(input.nextLine());

        Bus bus = busTerminal.getBusById(id);
        System.out.println(busTerminal.deleteBus(id));

    }

    void viewAllBuses() {
        System.out.println("\nBUS LIST");

        for (var bus: busTerminal.getBusList()) {
            System.out.println(bus);
        }
    }
}
