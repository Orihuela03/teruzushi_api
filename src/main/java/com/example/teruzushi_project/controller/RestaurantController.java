package com.example.teruzushi_project.controller;


import com.example.teruzushi_project.modelo.Restaurant;
import com.example.teruzushi_project.service.RestaurantService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teruzushiapi/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int id) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(id);
        return restaurant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable int id, @RequestBody Restaurant updatedRestaurant) {
        updatedRestaurant.setId(id);
        return restaurantService.addRestaurant(updatedRestaurant);
    }

    @DeleteMapping
    public void deleteRestaurant(@PathVariable int id) {
        restaurantService.deleteRestaurant(id);
    }
}
