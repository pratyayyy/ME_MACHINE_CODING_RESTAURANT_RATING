package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Reviews;
import com.example.demo.repositories.IReviewsRepository;

public class ReviewsService {
    private final IReviewsRepository reviewsRepository;

    public ReviewsService(IReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }
        private List<Reviews> reviewsList = new ArrayList<>();

        public String addRating(Double rating, Long userId, Long restaurantId) {
            Reviews reviews = new Reviews(Long.valueOf(reviewsList.size() + 1), rating, userId, restaurantId);

            for (int i = 0; i < reviewsList.size(); i++) {
                if (reviewsList.get(i).getUserId() == userId && reviewsList.get(i).getRestaurantId() == restaurantId) {
                    reviewsList.set(i, reviews);
                    Reviews r = reviewsRepository.save(reviews);
                    return "Review [id=" + reviews.getId() + "] added successfully for Restaurant [id=" + restaurantId + "] by User [id=" + userId + "]!";  
                }
        }
        reviewsList.add(reviews);
        Reviews r = reviewsRepository.save(reviews);
        return "Review [id=" + r.getId() + "] added successfully for Restaurant [id=" + restaurantId + "] by User [id=" + userId + "]!";
        }

        public List<Reviews> getReviews(Long restaurantId, String order) {

            List<Reviews> filteredReviews = new ArrayList<>();
              
            for (Reviews review : reviewsList) {
                if (review.getRestaurantId() == restaurantId) {
                    filteredReviews.add(review);
                }
            }
            if (order.equals("RATING_ASC")) {
                filteredReviews.sort((r1, r2) -> r1.getRating().intValue() - r2.getRating().intValue());
            } 
            else {
                filteredReviews.sort((r1, r2) -> r2.getRating().intValue() - r1.getRating().intValue());
            }
            return filteredReviews;
        }

        public List<Reviews> getReviewsFilterOrder(Long restaurantId, int low, int high, String reviewOrderType){

            List<Reviews> filteredReviews = new ArrayList<>();

            for (Reviews review : reviewsList) {
                if (review.getRestaurantId().equals(restaurantId)
                        && review.getRating() >= low
                        && review.getRating() <= high) {
                    filteredReviews.add(review);
                }
            }

            if (reviewOrderType.equals("RATING_ASC")) {
                filteredReviews.sort((r1, r2) -> r1.getRating().compareTo(r2.getRating()));
            }
             else if (reviewOrderType.equals("RATING_DESC")) {
                filteredReviews.sort((r1, r2) -> r2.getRating().compareTo(r1.getRating()));
            }
            return filteredReviews;
        }
}
