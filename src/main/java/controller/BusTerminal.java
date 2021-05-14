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

    public String addBus(Bus bus) {
        try{
            busRepository.add(bus);
        }catch (SQLException e){
            e.printStackTrace();
            return "error with creating bus";
        }
        return "Bus number " + bus.getBusNumber() + " created successfully";
    }

    public List<Bus> getBusList() {
       return busRepository.getAllBuses();
    }
}
