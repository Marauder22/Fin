package controller;

import model.Category;
import service.KudagoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/places/categories")
public class CategoryController {
    private final KudagoService kudagoService;

    public CategoryController(KudagoService kudagoService) {
        this.kudagoService = kudagoService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return kudagoService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable String id) {
        return kudagoService.getCategoryById(id);
    }

    @PostMapping
    public void createCategory(@RequestBody Category category) {
        kudagoService.createCategory(category);
    }

    @PutMapping("/{id}")
    public void updateCategory(@PathVariable String id, @RequestBody Category category) {
        kudagoService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable String id) {
        kudagoService.deleteCategory(id);
    }
}
