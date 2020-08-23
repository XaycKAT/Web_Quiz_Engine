package engine.controller;

import engine.model.Answer;
import engine.component.Response;
import engine.model.Question;
import engine.service.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/quizzes")
public class QuizController {

    private final QuizServiceImpl quizService;

    @Autowired
    public QuizController(QuizServiceImpl quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public Question addQuestion(@Valid @RequestBody Question question) {
        return quizService.saveQuestion(question);
    }

    @PostMapping(path = "/{id}/solve")
    public Response solveQuiz(@PathVariable long id, @RequestBody Answer answer) {
        return quizService.solveQuiz(id, answer);
    }

    @GetMapping(path = "/{id}")
    public Question getQuestion(@PathVariable long id) {
        return quizService.getQuestionById(id);
    }

    @GetMapping
    public List<Question> getAll() {
        return quizService.getAllQuestions();
    }
}