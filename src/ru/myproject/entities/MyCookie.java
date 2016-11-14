package ru.myproject.entities;

/**
 * Created by taa on 13.11.16.
 */
public class MyCookie {
    public MyCookie(String cookie, String cookieToken, long user_id) {
        this.cookie = cookie;
        this.cookieToken = cookieToken;
        this.user_id = user_id;
    }

    public long getId() {
        return id;
    }

    public String getCookie() {
        return cookie;
    }

    public String getCookieToken() {
        return cookieToken;
    }

    private  long id;
    private String cookie;
    private  String cookieToken;
    private long user_id;

    public long getUser() {
        return user_id;
    }

    public MyCookie(long id, String cookie, String cookieToken, long user_id) {
        this.id = id;
        this.cookie = cookie;
        this.cookieToken = cookieToken;
        this.user_id = user_id;
    }
}
