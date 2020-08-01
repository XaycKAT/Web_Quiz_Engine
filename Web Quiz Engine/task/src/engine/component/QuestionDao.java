package engine.component;

import engine.interfaces.Dao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class QuestionDao implements Dao<Question> {

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
    public void save(Question question) {
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
