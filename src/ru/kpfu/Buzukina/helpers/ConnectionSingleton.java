package ru.kpfu.Buzukina.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by taa on 23.10.16.
 */
public class ConnectionSingleton {
    private static ConnectionSingleton ourInstance = new ConnectionSingleton();

    public static ConnectionSingleton getInstance() {
        return ourInstance;
    }

    private ConnectionSingleton() {
    }
    private static Connection conn = null;

    private static String URL = "jdbc:postgresql://localhost:5432/Semester_work_1_education";
    private static String USERNAME = "postgres";
    private  static String PASSWORD = "postgres";
    private static String DRIVER = "org.postgresql.Driver";
    public  static Connection getConnection() throws SQLException {
        if (conn == null) {
            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return conn;
    }

}