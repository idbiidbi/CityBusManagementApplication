package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Bus {

    private int id;
    private int busNumber;
    private String firstStop;
    private String lastStop;

    public Bus(int id, int busNumber, String firstStop, String lastStop) {
        this.id = id;
        this.busNumber = busNumber;
        this.firstStop = firstStop;
        this.lastStop = lastStop;
    }

    public Bus() {

    }

    public int getId() {
        return id;
    }

    public int getBusNumber() {
        return busNumber;
    }

    public int setBusNumber(int busNumber) {
        this.busNumber = busNumber;
        return busNumber;
    }

    public String getFirstStop() {
        return firstStop;
    }

    public void setFirstStop(String firstStop) {
        this.firstStop = firstStop;
    }

    public String getLastStop() {
        return lastStop;
    }

    public void setLastStop(String lastStop) {
        this.lastStop = lastStop;
    }

    public String Route(){
        String route = getFirstStop() + " - " + getLastStop();

        return route;
    }

    public static Bus create(ResultSet row) {
        try {
            return new Bus(row.getInt("id"),
                    row.getInt("busNumber"),
                    row.getString("firstStop"),
                    row.getString("lastStop"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return id + ". Bus Number: " + busNumber + ", Route: " + Route();
    }
}
