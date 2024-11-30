package com.example.teruzushi_project.service;

import com.example.teruzushi_project.modelo.Restaurant;
import com.example.teruzushi_project.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(int id) {
        return restaurantRepository.findById(id);
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(int id) {
        restaurantRepository.deleteById(id);
    }

    public Restaurant updateRestaurant(Restaurant restaurant) {
        if (restaurantRepository.findById(restaurant.getId()).isPresent()) {
            Restaurant updatedRestaurant = restaurantRepository.getById(restaurant.getId());
            updatedRestaurant.setName(restaurant.getName());
            updatedRestaurant.setAddress(restaurant.getAddress());
            updatedRestaurant.setCapacity(restaurant.getCapacity());
            return restaurantRepository.save(updatedRestaurant);
        }
        else {
            return null;
        }
    }
}
