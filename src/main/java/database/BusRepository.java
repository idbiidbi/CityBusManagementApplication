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
        String query = "INSERT INTO buses (id, busNumber, firstStop, lastStop) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, bus.getId());
        preparedStatement.setInt(2, bus.getBusNumber());
        preparedStatement.setString(3, bus.getFirstStop());
        preparedStatement.setString(4, bus.getLastStop());

        preparedStatement.execute();

        preparedStatement.close();
    }

    public List<Bus> getAll() {
        List<Bus> busList = new ArrayList<>();
        Connection connection = dbHandler.getConnection();
        String query = "SELECT * from buses";

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                busList.add(Bus.create(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return busList;
    }

    public Bus getByNumber(int busNumber) {
        Connection connection = dbHandler.getConnection();
        String query = "SELECT * from buses WHERE (busNumber = ?)";

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setInt(1, busNumber);
            ResultSet resultSet = prepareStatement.executeQuery();

            boolean res = resultSet.next();

            if(!res) {
                return null;
            }

            return Bus.create(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Bus getById(int id) {
        Connection connection = dbHandler.getConnection();
        String query = "SELECT * from buses WHERE (id = ?)";

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            resultSet.next();
            return Bus.create(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(Bus bus) throws SQLException {

        Connection connection = dbHandler.getConnection();
        String query = "UPDATE buses SET firstStop = ?, lastStop = ?  WHERE (id = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, bus.getFirstStop());
        preparedStatement.setString(2, bus.getLastStop());
        preparedStatement.setInt(3, bus.getId());

        preparedStatement.execute();

        preparedStatement.close();
    }

    public void delete(int id) throws SQLException {

        Connection connection = dbHandler.getConnection();
        String query = "DELETE FROM buses WHERE (id = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        preparedStatement.execute();

        preparedStatement.close();
    }
}
