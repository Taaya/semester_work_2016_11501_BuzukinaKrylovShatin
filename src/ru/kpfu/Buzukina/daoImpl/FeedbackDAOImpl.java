package ru.kpfu.Buzukina.daoImpl;

import ru.kpfu.Buzukina.dao.FeedbackDAO;
import ru.kpfu.Buzukina.entities.Feedback;
import ru.kpfu.Buzukina.helpers.ConnectionSingleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by taa on 16.11.16.
 */
public class FeedbackDAOImpl implements FeedbackDAO {

    private Connection conn;
    public void sendFeedback(Feedback feedback){
        try {
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            st.executeQuery("insert into feedback (\"name\", \"phone\", \"email\", \"feedback_text\") values('"
            + feedback.getName() + "', '" + feedback.getPhone() + "','" + feedback.getEmail() + "','" + feedback.getFeedback_text() + "');");


        } catch (SQLException e){
           e.printStackTrace();
        }
    }
}
