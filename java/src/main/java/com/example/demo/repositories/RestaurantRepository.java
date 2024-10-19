package com.example.demo.repositories;

import java.util.HashMap;
import java.util.Map;
import com.example.demo.entities.Restaurant;

public class RestaurantRepository implements IRestaurantRepository {

    private final Map<Long, Restaurant> restaurantMap;
    private Long counter = 1L;

    public RestaurantRepository(){
        restaurantMap = new HashMap<Long, Restaurant>();    
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        if (restaurant.getId() == null) {
            Restaurant r = new Restaurant(counter, restaurant.getName());
            restaurantMap.put(r.getId(), r);
            counter++;
            return r;
        }
        restaurantMap.put(restaurant.getId(), restaurant);
        return restaurant;
    }


}
