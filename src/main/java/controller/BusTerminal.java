package controller;

import database.BusRepository;
import database.DriverRepository;
import database.StopRepository;
import entity.Bus;

import java.sql.SQLException;
import java.util.List;

public class BusTerminal {

    BusRepository busRepository = new BusRepository();
    DriverRepository driverRepository = new DriverRepository();
    StopRepository stopRepository = new StopRepository();

    public List<Bus> getBusList() {
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
}

