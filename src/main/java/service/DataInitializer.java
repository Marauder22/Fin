package service;

import model.Category;
import model.Location;
import repository.InMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;


@Component
public class DataInitializer {
    private final InMemoryRepository<Category> categoryRepository;
    private final InMemoryRepository<Location> locationRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public DataInitializer(InMemoryRepository<Category> categoryRepository,
                           InMemoryRepository<Location> locationRepository,
                           RestTemplate restTemplate) {
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void init() {

        List<Category> categories = fetchCategoriesFromKudago();
        for (Category category : categories) {
            categoryRepository.save(category);
        }


        List<Location> locations = fetchLocationsFromKudago();
        for (Location location : locations) {
            locationRepository.save(location);
        }

        System.out.println("Данные успешно инициализированы из API kudago.com");
    }

    private List<Category> fetchCategoriesFromKudago() {
        String url = "https://kudago.com/public-api/v1.4/place-categories";
        Category[] categories = restTemplate.getForObject(url, Category[].class);
        return Arrays.asList(categories);
    }

    private List<Location> fetchLocationsFromKudago() {
        String url = "https://kudago.com/public-api/v1.4/locations";
        Location[] locations = restTemplate.getForObject(url, Location[].class);
        return Arrays.asList(locations);
}
