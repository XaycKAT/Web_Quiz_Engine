package engine.controller;

import engine.component.Feedback;
import engine.component.Question;
import engine.component.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class QuizController {

    private QuestionDao questionDao;

    @Autowired
    public QuizController(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @PostMapping(path = "/api/quizzes")
    public Question addQuestion(@RequestBody Question question) {
        questionDao.save(question);
        return question;
    }

    @PostMapping(path = "/api/quizzes/{id}/solve")
    public Feedback addQuestion(@PathVariable int id, @RequestParam("answer") int answer) {
        try {
            Question question = questionDao.get(id).get();
            if (question.getAnswer().equals(answer))
                return Feedback.getSuccessFeedback();
            else
                return Feedback.getFailedFeedback();
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found");
        }
    }

    @GetMapping(path = "/api/quizzes/{id}")
    public Question getQuestion(@PathVariable int id) {
        try {
            return questionDao.get(id).get();
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found");
        }
    }

    @GetMapping(path = "/api/quizzes")
    public List<Question> getAll() {
        return questionDao.getAll();
    }
}
