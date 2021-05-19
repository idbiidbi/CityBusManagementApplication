package database;

import entity.Bus;
import entity.Driver;
import entity.Stop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverRepository {
    private DBHandler dbHandler = new DBHandler();

    public void add(Driver driver) throws SQLException {

        Connection connection = dbHandler.getConnection();
        String query = "INSERT INTO drivers (id, name, lastName) VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, driver.getId());
        preparedStatement.setString(2, driver.getName());
        preparedStatement.setString(3, driver.getLastName());

        preparedStatement.execute();

        preparedStatement.close();
    }

    public List<Driver> getAll() {
        List<Driver> driversList = new ArrayList<>();
        Connection connection = dbHandler.getConnection();
        String query = "SELECT * from drivers";

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                driversList.add(Driver.create(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driversList;
    }

    public Driver getById(int id) {
        Connection connection = dbHandler.getConnection();
        String query = "SELECT * from drivers WHERE (id = ?)";

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            resultSet.next();
            return Driver.create(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(Driver driver) throws SQLException {

        Connection connection = dbHandler.getConnection();
        String query = "UPDATE drivers SET name = ?, lastName = ?  WHERE (id = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, driver.getName());
        preparedStatement.setString(2, driver.getLastName());
        preparedStatement.setInt(3, driver.getId());

        preparedStatement.execute();

        preparedStatement.close();
    }

    public void delete(int id) throws SQLException {

        Connection connection = dbHandler.getConnection();
        String query = "DELETE FROM drivers WHERE (id = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        preparedStatement.execute();

        preparedStatement.close();
    }

    public List<Driver> getDriversForBus(int busNumber) {
        List<Driver> driversList = new ArrayList<>();
        Connection connection = dbHandler.getConnection();
        String query = "{call sp_drivers_for_bus(?)}";

        try {
            CallableStatement call = connection.prepareCall(query);
            call.setInt("busNumber",busNumber);

            ResultSet resultSet = call.executeQuery();

            while (resultSet.next()) {
                driversList.add(Driver.create(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driversList;
    }
}
