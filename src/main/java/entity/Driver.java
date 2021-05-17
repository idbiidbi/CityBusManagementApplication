package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Driver {

    private int id;
    private String name;
    private String lastName;

    public Driver(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public Driver() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String fullName(){
        String fullName = getName() + " " + getLastName();
        return fullName;
    }

    @Override
    public String toString() {
        return id + ". Driver: " + fullName();
    }

    public static Driver create(ResultSet row) {
        try {
            return new Driver(row.getInt("id"),
                    row.getString("name"),
                    row.getString("lastName"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
