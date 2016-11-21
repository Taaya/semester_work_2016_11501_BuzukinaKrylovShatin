package ru.kpfu.Buzukina.entities;

/**
 * Created by taa on 17.11.16.
 */
public class ClassRequest {
    private int id;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    private String name;
    private String email;
    private String phone;

    public ClassRequest(String phone, String name, String email) {
        this.phone = phone;
        this.name = name;
        this.email = email;
    }
}
