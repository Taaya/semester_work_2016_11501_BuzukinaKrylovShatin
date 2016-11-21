package ru.kpfu.Buzukina.daoImpl;

import ru.kpfu.Buzukina.dao.ClassesDAO;
import ru.kpfu.Buzukina.entities.Course;
import ru.kpfu.Buzukina.helpers.ConnectionSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by taa on 15.11.16.
 */
public class ClassesDAOImp implements ClassesDAO {

    private Connection conn;

    @Override
    public String getNextClass(Course course) {
        try{
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select class_date from classes join groups on classes.group_id = groups.id" +
                    " join courses on courses.id = groups.course_id where class_date > current_timestamp and courses.id =" + course.getId() +
                    "order by class_date limit 1");
            rs.next();
            return rs.getString("class_date");

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }
}
