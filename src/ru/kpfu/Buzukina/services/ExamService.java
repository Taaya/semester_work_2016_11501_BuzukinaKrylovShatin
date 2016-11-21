package ru.kpfu.Buzukina.services;

import ru.kpfu.Buzukina.entities.Exam;

import java.util.List;

/**
 * Created by taa on 05.11.16.
 */
public interface ExamService {

    public List<Exam> getAllExams();

    public List<Exam> getNExams(int limit, int offset);

    public Exam getExam(long id);
}
