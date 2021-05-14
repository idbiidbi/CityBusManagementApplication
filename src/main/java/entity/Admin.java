package entity;

public class Admin {

    private String name;
    private String password;

    public Admin(){
    }

    public String getName() {
        name = "ADMIN";
        return name;
    }

    public String getPassword() {
        password = "123456";
        return password;
    }
}
