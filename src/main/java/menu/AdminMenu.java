package menu;

import controller.BusTerminal;
import entity.Bus;
import entity.Driver;
import entity.Stop;


import java.util.Scanner;

public class AdminMenu {

    Scanner input = new Scanner(System.in);
    BusTerminal busTerminal = new BusTerminal();
    UserMenu userMenu =new UserMenu();


    public Boolean showBusAdminMenu() {

        String userInput;
        do {
            System.out.println("\n1. Add Bus \t\t\t\t5. Add Driver \t\t\t\t10. Add Bus Stop"
                    + "\n2. Update Bus  \t\t\t6. Update Driver \t\t\t11. Update Bus Stop"
                    + "\n3. Remove Bus \t\t\t7. Remove Driver \t\t\t12. Remove Bus Stop"
                    + "\n4. View All Buses \t\t8. View All Drivers \t\t13. View All Bus Stops"
                    + "\n\t\t\t\t\t\t9. View Driver in Bus\n"
                    + "\nEnter E to Exit\t\t\tEnter B to Back Main Menu\t Enter U to User Menu");

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
                    addDriver();
                    break;
                case "6":
                    updateDriver();
                    break;
                case "7":
                    removeDriver();
                    break;
                case "8":
                    viewAllDrivers();
                    break;
                case "9":
                    //viewDriverInBus();
                    viewAllDriversInBus();
                    break;
                case "10":
                    addBusStop();
                    break;
                case "11":
                    updateBusStop();
                    break;
                case "12":
                    removeBusStop();
                    break;
                case "13":
                    viewAllBusStops();
                    break;
                case "B":
                    backMainMenu();
                    break;
                case "U":
                    goToUserMenu();
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

    void backMainMenu(){

    }
    void goToUserMenu(){
        userMenu.showUserMenu();
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

        System.out.print("Update bus number "+ bus.getBusNumber() +" first stop: ");
        bus.setFirstStop(input.nextLine());

        System.out.print("Update bus number "+ bus.getBusNumber() +" last stop: ");
        bus.setLastStop(input.nextLine());

        System.out.println(busTerminal.updateBus(bus));

    }

    void removeBus(){
        this.viewAllBuses();

        System.out.println("\nDELETE BUS");
        System.out.print("Enter bus id: ");
        int id = Integer.parseInt(input.nextLine());

        //Bus bus = busTerminal.getBusById(id);
        System.out.println(busTerminal.deleteBus(id));

    }

    void viewAllBuses() {
        System.out.println("\nBUS LIST");

        for (var bus: busTerminal.getBusesList()) {
            System.out.println(bus);
        }
    }


    void addDriver(){

        Driver newDriver = new Driver();

        System.out.println("\nCREATE A NEW DRIVER");

        System.out.print("Enter driver name: ");
        newDriver.setName(input.nextLine());

        System.out.print("Enter driver last name: ");
        newDriver.setLastName(input.nextLine());

        System.out.println(busTerminal.addDriver(newDriver));
    }

    void updateDriver(){
        this.viewAllDrivers();

        System.out.println("\nUPDATE DRIVER");

        System.out.print("Enter driver id: ");
        int id = Integer.parseInt(input.nextLine());

        Driver driver = busTerminal.getDriverById(id);

        System.out.print("Update driver name: ");
        driver.setName(input.nextLine());

        System.out.print("Update driver last name: ");
        driver.setLastName(input.nextLine());

        System.out.println(busTerminal.updateDriver(driver));

    }

    void removeDriver(){
        this.viewAllDrivers();

        System.out.println("\nDELETE DRIVER");
        System.out.print("Enter driver id: ");
        int id = Integer.parseInt(input.nextLine());

        //Driver driver = busTerminal.getDriverById(id);
        System.out.println(busTerminal.deleteDriver(id));

    }

    void viewAllDrivers() {
        System.out.println("\nDRIVER LIST");

        for (var driver: busTerminal.getDriversList()) {
            System.out.println(driver);
        }
    }


    void viewAllDriversInBus(){

        System.out.print("Enter bus number: ");
        int busNumber = Integer.parseInt(input.nextLine());

        Bus bus = busTerminal.getBusByNumber(busNumber);

        System.out.println("\nBus number " + busNumber + " cen be driven by the following drivers: ");
        int counter = 1;
        for (Driver driver: busTerminal.getAllDriversInBus(bus.getBusNumber())) {
            System.out.println(counter + " driver: " + driver.getInfo());
            counter++;
        }
    }



    void addBusStop(){

        Stop newStop = new Stop();

        System.out.println("\nCREATE A NEW STOP");

        System.out.print("Enter stop name: ");
        newStop.setBusStopName(input.nextLine());

        System.out.println(busTerminal.addStop(newStop));
    }

    void updateBusStop(){
        this.viewAllBusStops();

        System.out.println("\nUPDATE STOP");

        System.out.print("Enter stop id: ");
        int id = Integer.parseInt(input.nextLine());

        Stop stop = busTerminal.getStopById(id);

        System.out.print("Update stop new name: ");
        stop.setBusStopName(input.nextLine());

        System.out.println(busTerminal.updateStop(stop));
    }

    void removeBusStop(){
        this.viewAllBusStops();

        System.out.println("\nDELETE STOP");
        System.out.print("Enter stop id: ");
        int id = Integer.parseInt(input.nextLine());

        //Stop stop = busTerminal.getStopById(id);
        System.out.println(busTerminal.deleteStop(id));

    }

    void viewAllBusStops() {
        System.out.println("\nSTOPS LIST");

        for (var stop: busTerminal.getStopsList()) {
            System.out.println(stop.getInfo());
        }
    }
}
