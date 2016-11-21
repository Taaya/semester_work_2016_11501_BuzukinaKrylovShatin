package ru.kpfu.Buzukina.dao;

import ru.kpfu.Buzukina.entities.Feedback;

/**
 * Created by taa on 16.11.16.
 */
public interface FeedbackDAO {
    void sendFeedback(Feedback feedback);
}
