package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.repositories.BerriesRepository;
import com.launchacademy.reviews.repositories.ReviewsRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewDatabaseService implements ReviewService {

  private ReviewsRepository reviewsRepository;
  private BerriesRepository berriesRepository;

  @Autowired
  public ReviewDatabaseService(ReviewsRepository reviewsRepository, BerriesRepository berriesRepository) {
    this.reviewsRepository = reviewsRepository;
    this.berriesRepository = berriesRepository;
  }

  public Optional<Review> findById(Long id) {
    return reviewsRepository.findById(id);
  }

  public Iterable<Review> findAll(){ return reviewsRepository.findAll(); }

  public void save(Review review) { reviewsRepository.save(review); }
}
