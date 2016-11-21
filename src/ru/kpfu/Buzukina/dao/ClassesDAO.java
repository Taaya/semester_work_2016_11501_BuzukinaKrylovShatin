package ru.kpfu.Buzukina.dao;

import ru.kpfu.Buzukina.entities.Course;

/**
 * Created by taa on 15.11.16.
 */
public interface ClassesDAO {

    String getNextClass(Course course);
}
