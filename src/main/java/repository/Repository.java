package repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    T findById(String id);
    void save(T entity);
    void update(String id, T entity);
    void delete(String id);
}
