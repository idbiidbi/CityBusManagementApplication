package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Stop {

    private int id;
    private String busStopName;

    public Stop(int id, String busStopName) {
        this.id = id;
        this.busStopName = busStopName;
    }

    public Stop() {
    }

    public int getId() {
        return id;
    }

    public String getBusStopName() {
        return busStopName;
    }

    public void setBusStopName(String busStopName) {
        this.busStopName = busStopName;
    }

    public static Stop create(ResultSet row) {
        try {
            return new Stop(row.getInt("id"),
                    row.getString("busStopName"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Bus Stop " + id + ": " + busStopName;
    }

    public String getInfo(){
        return "Bus Stop " + id + ": " + busStopName;
    }
}


