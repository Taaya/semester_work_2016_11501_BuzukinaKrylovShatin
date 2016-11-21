package ru.kpfu.Buzukina.serviceImpl;


import ru.kpfu.Buzukina.dao.FeedbackDAO;
import ru.kpfu.Buzukina.daoImpl.FeedbackDAOImpl;
import ru.kpfu.Buzukina.entities.Feedback;
import ru.kpfu.Buzukina.services.FeedbackService;

/**
 * Created by taa on 16.11.16.
 */
public class FeedbackServiceImpl implements FeedbackService {
    private FeedbackDAO feedbackDAO = new FeedbackDAOImpl();
    @Override
    public void sendFeedback(Feedback feedback) {
        feedbackDAO.sendFeedback(feedback);
    }
}
