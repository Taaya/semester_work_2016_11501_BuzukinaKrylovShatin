package ru.kpfu.Buzukina.dao;

import ru.kpfu.Buzukina.entities.Exam;
import ru.kpfu.Buzukina.entities.User;

import java.util.List;

/**
 * Created by taa on 05.11.16.
 */
public interface ExamDAO {

    List<Exam> getExams();

    List<Exam> getNExams(int limit, int offset);

    Exam getExam(long id);

    String getExamDate(Exam exam);


}
