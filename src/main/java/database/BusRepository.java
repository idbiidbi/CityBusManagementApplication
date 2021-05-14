package database;

import entity.Bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusRepository {
    private DBHandler dbHandler = new DBHandler();

    public void add(Bus bus) throws SQLException {

        Connection connection = dbHandler.getConnection();
        String query = "INSERT INTO bus (id, busNumber, route) VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, bus.getId());
        preparedStatement.setInt(2, bus.getBusNumber());
        preparedStatement.setString(3, bus.getRoute());

        preparedStatement.execute();

        preparedStatement.close();
    }

    public List<Bus> getAllBuses() {
        List<Bus> list = new ArrayList<>();

        Connection connection = dbHandler.getConnection();

        var query = "SELECT * from bus";

        try {
            var stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
               list.add(Bus.create(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
}
