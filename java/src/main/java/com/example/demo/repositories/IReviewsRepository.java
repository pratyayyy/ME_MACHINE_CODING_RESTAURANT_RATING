package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.Reviews;

public interface IReviewsRepository {
    Reviews save(Reviews reviews);
    List<Reviews> findAll();
}
