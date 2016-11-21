package ru.kpfu.Buzukina.daoImpl;

import ru.kpfu.Buzukina.entities.Course;
import ru.kpfu.Buzukina.entities.Group;
import ru.kpfu.Buzukina.helpers.ConnectionSingleton;
import ru.kpfu.Buzukina.dao.GroupDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by taa on 14.11.16.
 */
public class GroupDAOImpl implements GroupDAO {

    private  Connection conn;
    @Override
    public List<Group> getAllGroupsFromCourse(Course course) {
        try{
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from groups where course_id=" + course.getId());
            List<Group> groups = new ArrayList<>();
            while (rs.next()){
                Group group =
                        new Group(
                                rs.getInt("id"),
                                rs.getInt("course_id"),
                                rs.getInt("teacher"),
                                rs.getString("name")
                        );
                groups.add(group);
            }
            return groups;


        } catch (SQLException e){
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public String getTeacherName(Group group) {
        try {
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select username from users join groups on groups.teacher = users.id where groups.id=" + group.getId());
            rs.next();
            return rs.getString("username");
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Group getGroupFromId(int id) {
        try {
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from groups where id =" + id);
            rs.next();
            Group group = new Group(
                    rs.getInt("id"),
                    rs.getInt("course_id"),
                    rs.getInt("teacher"),
                    rs.getString("name")
            );
            return group;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> getTime(Group group) {
        try{
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select class_date from classes where group_id =" + group.getId());
            List<String> times = new ArrayList<>();
            while(rs.next()){
                String datetime = rs.getString("class_date");
                String date = datetime.substring(5,10);
                String time = datetime.substring(11,16);
                String month = GroupDAOImpl.getMonth(date);
                date =  date.substring(3) + " " + month;
                String dateAndtime = date + " " + time;
                times.add(dateAndtime);
            }


            return times;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getFirstClass(Group group) {
        try{
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select class_date from classes where id =" + group.getId() + " order by class_date limit 1");
            rs.next();
            return rs.getString("class_date").substring(0,16);


        }catch (SQLException e){
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public int placesLeft(Group group) {
        try{
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select count(user_id) count from group_enrollments where group_id=" + group.getId());
            rs.next();
            return 20 - rs.getInt("count");
        } catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }
    static String getMonth(String date){
        String month = "";
        String part = date.substring(0,2);
        switch (part){
            case "01":
                month = "Jan";
                break;
            case "02":
                month = "Feb";
                break;
            case "03":
                month = "Mar";
                break;
            case "04":
                month = "Apr";
                break;
            case "05":
                month = "May";
                break;
            case "06":
                month = "June";
                break;
            case "07":
                month = "July";
                break;
            case "08":
                month = "Aug";
                break;
            case "09":
                month = "Sept";
                break;
            case "10":
                month = "Oct";
                break;
            case "11":
                month = "Nov";
                break;
            case "12":
                month = "Dec";
                break;
        }

        return month;
    }


}
