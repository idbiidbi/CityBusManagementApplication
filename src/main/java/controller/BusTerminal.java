package controller;

import database.BusRepository;
import database.DriverRepository;
import database.StopRepository;
import entity.Bus;
import entity.Driver;
import entity.Stop;

import java.sql.SQLException;
import java.util.List;

public class BusTerminal {

    BusRepository busRepository = new BusRepository();
    DriverRepository driverRepository = new DriverRepository();
    StopRepository stopRepository = new StopRepository();

    public List<Bus> getBusesList() {
        return busRepository.getAll();
    }

    public String addBus(Bus bus) {

        Bus existingBus = getBusByNumber(bus.getBusNumber());

        if(bus.getBusNumber() == 0 || existingBus!= null) {
           return "ERROR: Invalid bus number";
        }

        if(bus.getFirstStop().isBlank()) {
            return "ERROR: The name of the stop can't be empty";
        }

        if(bus.getLastStop().isBlank()) {
            return "ERROR: The name of the stop can't be empty";
        }

        try{
            busRepository.add(bus);
        }catch (SQLException e){
            e.printStackTrace();
            return "error with creating bus";
        }
        return "Bus number " + bus.getBusNumber() + " created successfully";
    }

    public String updateBus(Bus bus) {

        if(bus.getFirstStop().isBlank()) {
            return "ERROR: The name of the stop can't be empty";
        }

        if(bus.getLastStop().isBlank()) {
            return "ERROR: The name of the stop can't be empty";
        }

        try{
            busRepository.update(bus);
        }catch (SQLException e){
            e.printStackTrace();
            return "error with updating bus";
        }
        return "Bus number " + bus.getBusNumber() + " updated successfully";

    }

    public String deleteBus(int id){
        try{
            busRepository.delete(id);
        }catch (SQLException e){
            e.printStackTrace();
            return "error with deleting bus";
        }
        return "Bus deleting successfully";
    }

    public Bus getBusById(int id) {
        return busRepository.getById(id);
    }

    private Bus getBusByNumber(int busNumber) {
        return busRepository.getByNumber(busNumber);
    }



    public List<Driver> getDriversList() {
        return driverRepository.getAll();
    }

    public String addDriver(Driver driver) {

        if(driver.getName().isBlank()) {
            return "ERROR: The name of the driver can't be empty";
        }

        if(driver.getLastName().isBlank()) {
            return "ERROR: The last name of the driver can't be empty";
        }

        try{
            driverRepository.add(driver);
        }catch (SQLException e){
            e.printStackTrace();
            return "error with creating driver";
        }
        return "Driver " + driver.fullName()+ " created successfully";
    }

    public String updateDriver(Driver driver) {

        if(driver.getName().isBlank()) {
            return "ERROR: The name of the driver can't be empty";
        }

        if(driver.getLastName().isBlank()) {
            return "ERROR: The last name of the driver can't be empty";
        }

        try{
            driverRepository.update(driver);
        }catch (SQLException e){
            e.printStackTrace();
            return "error with updating driver";
        }
        return "Driver " + driver.fullName() + " updated successfully";

    }

    public String deleteDriver(int id){
        try{
            driverRepository.delete(id);
        }catch (SQLException e){
            e.printStackTrace();
            return "error with deleting driver";
        }
        return "Driver deleting successfully";
    }

    public Driver getDriverById(int id) {
        return driverRepository.getById(id);
    }



    public List<Stop> getStopsList() {
        return stopRepository.getAll();
    }

    public String addStop(Stop stop) {

        if(stop.getBusStopName().isBlank()) {
            return "ERROR: The name of the stop can't be empty";
        }

        try{
            stopRepository.add(stop);
        }catch (SQLException e){
            e.printStackTrace();
            return "error with creating stop";
        }
        return "Stop " + stop.getBusStopName() + " created successfully";
    }

    public String updateStop(Stop stop) {

        if(stop.getBusStopName().isBlank()) {
            return "ERROR: The name of the stop can't be empty";
        }

        try{
            stopRepository.update(stop);
        }catch (SQLException e){
            e.printStackTrace();
            return "error with updating stop";
        }
        return "Stop " + stop.getBusStopName() + " updated successfully";

    }

    public String deleteStop(int id){
        try{
            stopRepository.delete(id);
        }catch (SQLException e){
            e.printStackTrace();
            return "error with deleting stop";
        }
        return "Stop deleting successfully";
    }

    public Stop getStopById(int id) {
        return stopRepository.getById(id);
    }
}

