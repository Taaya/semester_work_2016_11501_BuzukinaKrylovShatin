package ru.myproject.dao;

import ru.myproject.entities.User;
import ru.myproject.helpers.ConnectionSingleton;
import ru.myproject.helpers.MD5;

import java.sql.*;


/**
 * Created by taa on 06.11.16.
 */
public class UserDAOImpl implements UserDAO{

    private Connection conn;

    @Override
    public String getPassword(String username) {

        try {
            conn = ConnectionSingleton.getConnection();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select password from users where username='" + username + "'");
            rs.next();
            return rs.getString("password");

        } catch (SQLException e) {
            return null;
        }

    }

    @Override
    public boolean registrateUser(String username, String password, String email, String phone) {
        try {
            MD5 md5 = new MD5();
            String hashed_password = md5.getHash(password);
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            int rs = statement.executeUpdate("insert into users(\"username\",\"password\", \"email\",\"phone\", \"user_role\") values('" +
                    username + "', '" + hashed_password + "', '" + email + "', '" + phone + "', 'student');");
            return rs == 1;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public User getUser(String username) {
        try{
            Connection connection = ConnectionSingleton.getConnection();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users where username='" + username + "'");
            if (rs.next()){
                User user = new User(
                        (long)rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        "student",
                        rs.getString("phone")
                );
                return user;
            } else
                return null;

        } catch(SQLException e){
            return null;
        }
    }


}
