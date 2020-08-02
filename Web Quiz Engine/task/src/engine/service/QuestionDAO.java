package engine.service;

import engine.component.Answer;
import engine.component.Question;
import engine.interfaces.DAO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionDAO implements DAO<Question, Answer> {

    private final List<Question> questions = new ArrayList<>();

    @Override
    public Optional<Question> get(int id) {
        return Optional.ofNullable(questions.get(id - 1));
    }

    @Override
    public List<Question> getAll() {
        return questions;
    }

    @Override
    public void add(Question question) {
        question.setId(questions.size() + 1);
        questions.add(question);
    }

    @Override
    public void update(Question question, String[] params) {

    }

    @Override
    public void delete(Question question) {
        questions.remove(question);
    }
}
