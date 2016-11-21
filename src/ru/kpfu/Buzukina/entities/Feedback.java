package ru.kpfu.Buzukina.entities;

/**
 * Created by taa on 16.11.16.
 */
public class Feedback {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String feedback_text;

    public Feedback(int id, String name, String phone, String email, String feedback_text) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.feedback_text = feedback_text;
    }

    public Feedback(String name, String phone, String email, String feedback_text) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.feedback_text = feedback_text;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getFeedback_text() {
        return feedback_text;
    }
}
