package com.example.demo.entities;

public class Reviews {

    private Long id;
    private Long userId;
    private Long restaurantId;
    private Double rating;
    private String dishes;
    private String description;

    public Reviews(Long id, Long userId, Long restaurantId, Double rating, String dishes, String description) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.rating = rating;
        this.dishes = dishes;
        this.description = description;
    }

    public Reviews(Long id, Double rating, Long userId, Long restaurantId){
        this.id = id;
        this.rating = rating;
        this.userId = userId;
        this.restaurantId = restaurantId;
    }

    public Reviews(Long id, Double rating){
        this.id = id;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reviews other = (Reviews) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public String toString() {
        return "Review [id=" + id + "]";
    }
}
