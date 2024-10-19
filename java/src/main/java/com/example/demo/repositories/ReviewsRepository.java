package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.example.demo.entities.Reviews;

public class ReviewsRepository implements IReviewsRepository {
  private final Map<Long,Reviews> reviewsMap;
  private Long counter = 1L;

  public ReviewsRepository(){
    reviewsMap = new HashMap<Long, Reviews>();
  }

  @Override
  public Reviews save(Reviews reviews) {
      if (reviews.getId() == null) {
          Reviews myReviews = new Reviews(counter, reviews.getRating());
          reviewsMap.put(myReviews.getId(), myReviews);
          counter++;
          return myReviews;
      }
      reviewsMap.put(reviews.getId(), reviews);
      return reviews;
  }

  @Override
  public List<Reviews> findAll() {
      return reviewsMap.values().stream().collect(Collectors.toList());
  }
}
