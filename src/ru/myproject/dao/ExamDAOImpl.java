package ru.myproject.dao;

import ru.myproject.entities.Course;
import ru.myproject.entities.Exam;
import ru.myproject.helpers.ConnectionSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by taa on 05.11.16.
 */
public class ExamDAOImpl implements ExamDAO {

    private Connection conn;
    @Override
    public List<Exam> getExams() {

        try {
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from exams");
            List<Exam> exams = new ArrayList<>();
            while (rs.next()){
                Exam exam =
                        new Exam(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("language_code"),
                                rs.getString("description")

                        );
                exams.add(exam);
            }
            return exams;

        } catch (SQLException e) {
            return null;
        }

    }

    @Override
    public List<Exam> getNExams(int limit, int offset) {
        try {
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from exams limit " + limit + "offset " + offset);
            List<Exam> exams = new ArrayList<>();
            while (rs.next()){
                Exam exam =
                        new Exam(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("language_code"),
                                rs.getString("description")

                        );
                exams.add(exam);
            }
            return exams;

        }catch (SQLException e){
            return null;
        }
    }
    public Exam getExam(long id) {
        try{
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from exams where id='" + id + "'");
            rs.next();

            Exam exam = new Exam(
                    (long)rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("language_code"),
                    rs.getString("description")

            );

            return exam;


        } catch (SQLException e) {
            return  null;
        }

    }

}
