package database;

import entity.Stop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StopRepository {
    private DBHandler dbHandler = new DBHandler();

    public void add(Stop stop) throws SQLException {

        Connection connection = dbHandler.getConnection();
        String query = "INSERT INTO stops (id, busStopName) VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, stop.getId());
        preparedStatement.setString(2, stop.getBusStopName());

        preparedStatement.execute();

        preparedStatement.close();
    }

    public List<Stop> getAll() {
        List<Stop> stopsList = new ArrayList<>();
        Connection connection = dbHandler.getConnection();
        String query = "SELECT * from stops";

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                stopsList.add(Stop.create(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stopsList;
    }

    public Stop getById(int id) {
        Connection connection = dbHandler.getConnection();
        String query = "SELECT * from stops WHERE (id = ?)";

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            resultSet.next();
            return Stop.create(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(Stop stop) throws SQLException {

        Connection connection = dbHandler.getConnection();
        String query = "UPDATE stops SET busStopName = ? WHERE (id = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, stop.getBusStopName());
        preparedStatement.setInt(2, stop.getId());

        preparedStatement.execute();

        preparedStatement.close();
    }

    public void delete(int id) throws SQLException {

        Connection connection = dbHandler.getConnection();
        String query = "DELETE FROM stops WHERE (id = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        preparedStatement.execute();

        preparedStatement.close();
    }
}
