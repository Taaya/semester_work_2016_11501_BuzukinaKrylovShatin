package ru.kpfu.Buzukina.entities;

import ru.kpfu.Buzukina.dao.GroupDAO;
import ru.kpfu.Buzukina.daoImpl.GroupDAOImpl;

import java.util.List;

/**
 * Created by taa on 14.11.16.
 */
public class Group {
    private int id;
    private int courseId;
    private int teacherId;
    private String name;

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


    public Group(int id, int courseId, int teacherId, String name) {
        this.id = id;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.name = name;
    }

    public Group(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }
}
