package engine.service;

import engine.component.Response;
import engine.model.Answer;
import engine.model.Question;
import engine.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuizServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question getQuestionById(long id) {
        return questionRepository.findById(id).get();
    }

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Response solveQuiz(long id, Answer answer) {
        List<Integer> rightAnswer = new ArrayList<>(getQuestionById(id).getAnswer());
        return rightAnswer.equals(answer.getAnswer()) ? Response.getSuccessFeedback() :
                Response.getFailedFeedback();
    }

    @Override
    public Question updateQuestion(long id, Question question) {
        return null;
    }

    @Override
    public void deleteQuestion(long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}

