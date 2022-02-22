package tech.finalproject.project.feedback;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auction")
public class FeedbackResource {


    private final FeedbackService feedbackService;

    public FeedbackResource(FeedbackService feedbackService)
    {
        this.feedbackService = feedbackService;
    }


    @GetMapping("/feedback/all")
    public ResponseEntity<List<Feedback>> getAllFeedbacks()
    {
        List<Feedback> feedback = feedbackService.findallFeedback();
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }


    @PostMapping("/feedback/add")
    public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback)
    {
        Feedback newFeedback = feedbackService.addFeedback(feedback);
        return new ResponseEntity<>(newFeedback, HttpStatus.CREATED);
    }
}
