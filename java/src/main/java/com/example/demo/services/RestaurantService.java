package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;
import com.example.demo.repositories.IRestaurantRepository;
import com.example.demo.repositories.IReviewsRepository;

public class RestaurantService {

    private final IRestaurantRepository restaurantRepository;
    private final IReviewsRepository reviewsRepository;
    
    public RestaurantService(IRestaurantRepository restaurantRepository, IReviewsRepository reviewsRepository) {
        this.restaurantRepository = restaurantRepository;
        this.reviewsRepository = reviewsRepository;
    }

    private List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant registerRestaurant(String name){
        Restaurant restaurant = new Restaurant(Long.valueOf(restaurants.size() + 1), name);
        restaurants.add(restaurant);
        Restaurant r = restaurantRepository.save(restaurant);
        return r;
    }

    public void describeRestaurant(Long restaurantId){
        Restaurant restaurant = null;
        for (Restaurant res : restaurants) {
            if (res.getId() == restaurantId) {
                restaurant = res;
                break;
            }
        }
        if (restaurant == null) {
            System.out.println("Restaurant with id " + restaurantId + " not found.");
            return;
        }
    
        List<Double> ratings = reviewsRepository.findAll().stream().filter(review -> review.getRestaurantId().equals(restaurantId)).map(review -> review.getRating()).collect(Collectors.toList());
        if (ratings.size() == 0) {
            System.out.println("Restaurant [id=" + restaurant.getId() + ", name=" + restaurant.getName() + ", rating=No ratings yet]");
        } else {
            double avgRating = ratings.stream().mapToDouble(val -> val).average().orElse(0.0);
            System.out.println("Restaurant [id=" + restaurant.getId() + ", name=" + restaurant.getName() + ", rating=" + avgRating + "]");
        }
    }

    public List<Restaurant> listRestaurants(){
        return restaurants;
    }

}
