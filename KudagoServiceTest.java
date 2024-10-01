package fj_lesson_2024_5;

import model.Category;
import model.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.InMemoryRepository;
import service.KudagoService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class KudagoServiceTest {
    private InMemoryRepository<Category> categoryRepository;
    private InMemoryRepository<Location> locationRepository;
    private KudagoService kudagoService;

    @BeforeEach
    public void setUp() {
        categoryRepository = Mockito.mock(InMemoryRepository.class);
        locationRepository = Mockito.mock(InMemoryRepository.class);
        kudagoService = new KudagoService(categoryRepository, locationRepository);
    }

    // Тесты для Category
    @Test
    public void testGetAllCategories() {
        Category category = new Category("1", "Test Category");
        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category));

        assertEquals(1, kudagoService.getAllCategories().size());
        assertEquals("Test Category", kudagoService.getAllCategories().get(0).getName());
    }

    @Test
    public void testCreateCategory() {
        Category category = new Category("1", "Test Category");
        kudagoService.createCategory(category);
        verify(categoryRepository).save(category);
    }

    @Test
    public void testGetCategoryById() {
        Category category = new Category("1", "Test Category");
        when(categoryRepository.findById("1")).thenReturn(category);

        assertEquals("Test Category", kudagoService.getCategoryById("1").getName());
    }

    @Test
    public void testGetCategoryByIdNotFound() {
        when(categoryRepository.findById("unknown")).thenReturn(null);
        assertNull(kudagoService.getCategoryById("unknown"));
    }

    @Test
    public void testUpdateCategory() {
        Category category = new Category("1", "Updated Category");
        kudagoService.updateCategory("1", category);
        verify(categoryRepository).update("1", category);
    }

    @Test
    public void testDeleteCategoryNotFound() {
        doThrow(new RuntimeException("Category not found")).when(categoryRepository).delete("unknown");
        assertThrows(RuntimeException.class, () -> kudagoService.deleteCategory("unknown"));
    }

    // Тесты для Location
    @Test
    public void testGetAllLocations() {
        Location location = new Location("1", "Test Location");
        when(locationRepository.findAll()).thenReturn(Arrays.asList(location));

        assertEquals(1, kudagoService.getAllLocations().size());
        assertEquals("Test Location", kudagoService.getAllLocations().get(0).getName());
    }

    @Test
    public void testCreateLocation() {
        Location location = new Location("1", "Test Location");
        kudagoService.createLocation(location);
        verify(locationRepository).save(location);
    }

    @Test
    public void testGetLocationById() {
        Location location = new Location("1", "Test Location");
        when(locationRepository.findById("1")).thenReturn(location);

        assertEquals("Test Location", kudagoService.getLocationById("1").getName());
    }

    @Test
    public void testGetLocationByIdNotFound() {
        when(locationRepository.findById("unknown")).thenReturn(null);
        assertNull(kudagoService.getLocationById("unknown"));
    }

    @Test
    public void testUpdateLocation() {
        Location location = new Location("1", "Updated Location");
        kudagoService.updateLocation("1", location);
        verify(locationRepository).update("1", location);
    }

    @Test
    public void testDeleteLocationNotFound() {
        doThrow(new RuntimeException("Location not found")).when(locationRepository).delete("unknown");
        assertThrows(RuntimeException.class, () -> kudagoService.deleteLocation("unknown"));
    }
}
