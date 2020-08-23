package engine.service;

import engine.component.Response;
import engine.model.Answer;
import engine.model.Question;

import java.util.List;

public interface QuizService {

    Question getQuestionById(long id);

    Question saveQuestion(Question question);

    Question updateQuestion(long id, Question question);

    Response solveQuiz(long id, Answer answer);

    void deleteQuestion(long id);

    List<Question> getAllQuestions();

}