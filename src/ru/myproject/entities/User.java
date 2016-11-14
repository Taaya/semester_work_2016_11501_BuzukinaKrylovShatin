package ru.myproject.entities;

/**
 * Created by taa on 05.11.16.
 */
public class User {

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }



    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return userrole;
    }

    public String getPhone() {
        return phone;
    }

    private long id;
    public String username;
    public String password;
    public  String email;
    public String userrole;
    public String phone;

    public User(long id, String username, String password, String email, String userrole, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userrole = userrole;
        this.phone = phone;
    }





}
