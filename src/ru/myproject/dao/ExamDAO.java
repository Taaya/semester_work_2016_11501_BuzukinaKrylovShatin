package ru.myproject.dao;

import ru.myproject.entities.Exam;

import java.util.List;

/**
 * Created by taa on 05.11.16.
 */
public interface ExamDAO {

    List<Exam> getExams();

    List<Exam> getNExams(int limit, int offset);

    Exam getExam(long id);
}
