package ru.myproject.services;

import ru.myproject.entities.Exam;

import java.util.List;

/**
 * Created by taa on 05.11.16.
 */
public interface ExamService {

    public List<Exam> getAllExams();

    public List<Exam> getNExams(int limit, int offset);

    public Exam getExam(long id);
}
