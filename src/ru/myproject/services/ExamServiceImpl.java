package ru.myproject.services;

import ru.myproject.dao.ExamDAO;
import ru.myproject.dao.ExamDAOImpl;
import ru.myproject.entities.Exam;

import java.util.List;

/**
 * Created by taa on 05.11.16.
 */
public class ExamServiceImpl implements ExamService {

    private ExamDAO examDAO = new ExamDAOImpl();

    public List<Exam> getAllExams() {
        return examDAO.getExams();

    }

    @Override
    public List<Exam> getNExams(int limit, int offset) {
        return  examDAO.getNExams(limit, offset);
    }

    @Override
    public Exam getExam(long id) {
        return examDAO.getExam(id);
    }
}
