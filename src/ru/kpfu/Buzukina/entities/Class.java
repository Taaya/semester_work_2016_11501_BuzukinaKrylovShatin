package ru.kpfu.Buzukina.entities;

/**
 * Created by taa on 15.11.16.
 */
public class Class {
    private int id;
    private int groupId;
    private String classDate;

    public Class(int id, int groupId, String classDate) {
        this.id = id;
        this.groupId = groupId;
        this.classDate = classDate;
    }

    public int getId() {
        return id;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getClassDate() {
        return classDate;
    }
}
