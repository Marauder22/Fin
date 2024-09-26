package service;


import model.Category;
import model.Location;
import repository.InMemoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KudagoService {
    private final InMemoryRepository<Category> categoryRepository;
    private final InMemoryRepository<Location> locationRepository;

    public KudagoService(InMemoryRepository<Category> categoryRepository,
                         InMemoryRepository<Location> locationRepository) {
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;
    }

    // Методы для работы с категориями
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(String id) {
        return categoryRepository.findById(id);
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(String id, Category category) {
        categoryRepository.update(id, category);
    }

    public void deleteCategory(String id) {
        categoryRepository.delete(id);
    }

    // Методы для работы с городами
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(String id) {
        return locationRepository.findById(id);
    }

    public void createLocation(Location location) {
        locationRepository.save(location);
    }

    public void updateLocation(String id, Location location) {
        locationRepository.update(id, location);
    }

    public void deleteLocation(String id) {
        locationRepository.delete(id);
    }
}
