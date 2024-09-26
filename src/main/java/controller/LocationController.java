package controller;

import model.Location;
import service.KudagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {
    private final KudagoService kudagoService;

    public LocationController(KudagoService kudagoService) {
        this.kudagoService = kudagoService;
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return kudagoService.getAllLocations();
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable String id) {
        return kudagoService.getLocationById(id);
    }

    @PostMapping
    public void createLocation(@RequestBody Location location) {
        kudagoService.createLocation(location);
    }

    @PutMapping("/{id}")
    public void updateLocation(@PathVariable String id, @RequestBody Location location) {
        kudagoService.updateLocation(id, location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable String id) {
        kudagoService.deleteLocation(id);
    }
}
