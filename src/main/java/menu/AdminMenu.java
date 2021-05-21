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
                    return true;
                case "U":
                    boolean result = goToUserMenu();
                    if(!result) {
                        return false;
                    }
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

    boolean goToUserMenu(){
        return  userMenu.showUserMenu();
    }

    void addBus(){

        Bus newBus = new Bus();

        System.out.println("\nCREATE A NEW BUS");

        int number = MenuInputValidator.checkIfNumberEntered("Enter bus number: ");

        newBus.setBusNumber(number);

        System.out.print("Enter bus route first name: ");
        newBus.setFirstStop(input.nextLine());

        System.out.print("Enter bus route last name: ");
        newBus.setLastStop(input.nextLine());

        System.out.println(busTerminal.addBus(newBus));
    }

    void updateBus(){
        this.viewAllBuses();

        System.out.println("\nUPDATE BUS");

        int id;
        Bus bus;

        while(true) {
            id = MenuInputValidator.checkIfNumberEntered("Enter valid bus ID: ");

            bus = busTerminal.getBusById(id);

            if(bus == null) {
                System.out.println("Invalid bus ID");
                continue;
            }

            break;
        }

        System.out.print("Update bus number "+ bus.getBusNumber() +" route first name: ");
        bus.setFirstStop(input.nextLine());

        System.out.print("Update bus number "+ bus.getBusNumber() +" route last name: ");
        bus.setLastStop(input.nextLine());

        System.out.println(busTerminal.updateBus(bus));

    }

    void removeBus(){
        this.viewAllBuses();

        System.out.println("\nDELETE BUS");

        int id;
        Bus bus;

        while(true) {
            id = MenuInputValidator.checkIfNumberEntered("Enter valid bus ID: ");

            bus = busTerminal.getBusById(id);

            if(bus == null) {
                System.out.println("Invalid bus ID");
                continue;
            }

            break;
        }

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

        int id;
        Driver driver;

        while(true) {
            id = MenuInputValidator.checkIfNumberEntered("Enter valid driver id: ");

            driver = busTerminal.getDriverById(id);

            if(driver == null) {
                System.out.println("Invalid driver ID");
                continue;
            }

            break;
        }

        System.out.print("Update driver name: ");
        driver.setName(input.nextLine());

        System.out.print("Update driver last name: ");
        driver.setLastName(input.nextLine());

        System.out.println(busTerminal.updateDriver(driver));

    }

    void removeDriver(){
        this.viewAllDrivers();

        System.out.println("\nDELETE DRIVER");

        int id;
        Driver driver;

        while(true) {
            id = MenuInputValidator.checkIfNumberEntered("Enter valid driver ID: ");

            driver = busTerminal.getDriverById(id);

            if(driver == null) {
                System.out.println("Invalid driver ID");
                continue;
            }

            break;
        }

        System.out.println(busTerminal.deleteDriver(id));

    }

    void viewAllDrivers() {
        System.out.println("\nDRIVER LIST");

        for (var driver: busTerminal.getDriversList()) {
            System.out.println(driver);
        }
    }

    void viewAllDriversInBus(){
        this.viewAllBuses();

        int busNumber;
        Bus bus;

        while(true) {
            busNumber = MenuInputValidator.checkIfNumberEntered("Enter valid bus number: ");

            bus = busTerminal.getBusByNumber(busNumber);

            if(bus == null) {
                System.out.println("Invalid bus number");
                continue;
            }

            break;
        }

        System.out.println("\nBus number " + busNumber + " cen be driven by the following drivers: ");
        int counter = 1;
        for (Driver driver: busTerminal.getAllDriversInBus(bus.getBusNumber())) {
            System.out.println(counter + " driver: " + driver.getInfo());
            counter++;
        }
    }


    void addBusStop(){

        Stop newStop = new Stop();

        System.out.println("\nCREATE A NEW BUS STOP");

        System.out.print("Enter stop name: ");
        newStop.setBusStopName(input.nextLine());

        System.out.println(busTerminal.addStop(newStop));
    }

    void updateBusStop(){
        this.viewAllBusStops();

        System.out.println("\nUPDATE BUS STOP");

        int id;
        Stop stop;

        while(true) {
            id = MenuInputValidator.checkIfNumberEntered("Enter valid bus stop ID: ");

            stop = busTerminal.getStopById(id);

            if(stop == null) {
                System.out.println("Invalid bus stop ID");
                continue;
            }

            break;
        }

        System.out.print("Update bus stop name: ");
        stop.setBusStopName(input.nextLine());

        System.out.println(busTerminal.updateStop(stop));
    }

    void removeBusStop(){
        this.viewAllBusStops();

        System.out.println("\nDELETE BUS STOP");

        int id;
        Stop stop;

        while(true) {
            id = MenuInputValidator.checkIfNumberEntered("Enter valid bus stop ID: ");

            stop = busTerminal.getStopById(id);

            if(stop == null) {
                System.out.println("Invalid bus stop ID");
                continue;
            }
            break;
        }

        System.out.println(busTerminal.deleteStop(id));

    }

    void viewAllBusStops() {
        System.out.println("\nBUS STOPS LIST");

        for (var stop: busTerminal.getStopsList()) {
            System.out.println(stop.getInfo());
        }
    }
}
