package tech.finalproject.project.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.finalproject.project.buyer.BuyerLoginDetails;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private final FeedbackRepo feedbackRepo;

    public FeedbackService(FeedbackRepo feedbackRepo) {
        this.feedbackRepo = feedbackRepo;
    }



    public Feedback addFeedback(Feedback feedback)
    {

        return feedbackRepo.save(feedback);
    }



    public List<Feedback> findallFeedback()
    {

        return feedbackRepo.findAll();
    }
}
