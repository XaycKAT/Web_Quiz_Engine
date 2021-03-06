package engine.interfaces;

import java.util.List;
import java.util.Optional;

@Deprecated
public interface DAO<T, R> {

    Optional<T> get(int id);

    List<T> getAll();

    void add(T t);

    void update(T t, String[] params);

    void delete(T t);
}
