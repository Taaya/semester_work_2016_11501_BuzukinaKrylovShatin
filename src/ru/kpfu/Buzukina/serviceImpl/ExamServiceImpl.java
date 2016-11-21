package ru.kpfu.Buzukina.serviceImpl;

import ru.kpfu.Buzukina.daoImpl.ExamDAOImpl;
import ru.kpfu.Buzukina.entities.Exam;
import ru.kpfu.Buzukina.services.ExamService;
import ru.kpfu.Buzukina.dao.ExamDAO;

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
