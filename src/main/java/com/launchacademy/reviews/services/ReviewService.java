package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.models.ReviewForm;
import java.util.Optional;

public interface ReviewService {

  Optional<Review> findById(Long id);
  Iterable<Review> findAll();
  void save(Review review);
  Review createReview(ReviewForm reviewForm);
}
