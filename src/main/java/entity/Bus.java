package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Bus {

    private int id;
    private int busNumber;
    private String route;

    public Bus(int id, int busNumber, String route) {
        this.id = id;
        this.busNumber = busNumber;
        this.route = route;
    }

    public Bus() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public static Bus create(ResultSet row) {
        try {
            return new Bus(row.getInt("id"),
                    row.getInt("busNumber"),
                    row.getString("route"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", busNumber=" + busNumber +
                ", route='" + route + '\'' +
                '}';
    }
}
