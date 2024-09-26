package repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


public class InMemoryRepository<T extends Identifiable> implements Repository<T> {
    private final ConcurrentHashMap<String, T> storage = new ConcurrentHashMap<>();

    @Override
    public List<T> findAll() {
        return storage.values().stream().collect(Collectors.toList());
    }

    @Override
    public T findById(String id) {
        return storage.get(id);
    }

    @Override
    public void save(T entity) {
        storage.put(entity.getId(), entity);
    }

    @Override
    public void update(String id, T entity) {
        storage.put(id, entity);
    }

    @Override
    public void delete(String id) {
        storage.remove(id);
    }
}
