package ru.myproject.entities;

import ru.myproject.dao.GroupDAO;
import ru.myproject.dao.GroupDAOImpl;

import java.util.List;

/**
 * Created by taa on 14.11.16.
 */
public class Group {
    public int id;
    int course_id;
    int teacher_id;
    String name;

    GroupDAO groupDAO = new GroupDAOImpl();
    public String getTeacherName(){
        return groupDAO.getTeacherName(this);
    }
    public List<String> getTime(){
        return groupDAO.getTime(this);
    }
    public String getFirstClass(){
        return groupDAO.getFirstClass(this);
    }
    public int getPlacesLeft(){
        return groupDAO.placesLeft(this);
    }


    public Group(int id, int course_id, int teacher_id, String name) {
        this.id = id;
        this.course_id = course_id;
        this.teacher_id = teacher_id;
        this.name = name;
    }

    public Group(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public String getName() {
        return name;
    }
}
