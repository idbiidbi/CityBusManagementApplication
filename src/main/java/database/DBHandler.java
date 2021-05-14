package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {


    String connectionUrl = "jdbc:mysql://localhost:3306/terminal?serverTimezone=UTC";
    String user = "terminal";
    String password = "terminal123";

    private Connection connection;

    public DBHandler(){  //constructor

        try {
            connection = DriverManager.getConnection(connectionUrl, user, password);
        }catch (Exception e){
            System.out.println("Database is unable to connect to data storage system");
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
}