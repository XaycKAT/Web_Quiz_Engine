package engine.controller;

import engine.component.Answer;
import engine.component.Response;
import engine.component.Question;
import engine.service.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/quizzes")
public class QuizController {

    private final QuestionDAO questionDao;

    @Autowired
    public QuizController(QuestionDAO questionDao) {
        this.questionDao = questionDao;
    }

    @PostMapping
    public Question addQuestion(@Valid  @RequestBody Question question) {
        questionDao.add(question);
        return question;
    }

    @PostMapping(path = "/{id}/solve")
    public Response solveQuiz(@PathVariable int id, @RequestBody Answer answer) {
        return getQuestion(id).getAnswer().equals(answer.getAnswer()) ? Response.getSuccessFeedback() :
                Response.getFailedFeedback();
    }

    @GetMapping(path = "/{id}")
    public Question getQuestion(@PathVariable int id) {
        try {
            return questionDao.get(id).get();
        } catch (NoSuchElementException | IndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found");
        }
    }

    @GetMapping
    public List<Question> getAll() {
        return questionDao.getAll();
    }
}
