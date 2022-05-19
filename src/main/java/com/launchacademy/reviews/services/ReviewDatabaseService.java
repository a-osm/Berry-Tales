package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Berry;
import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.models.ReviewForm;
import com.launchacademy.reviews.repositories.BerriesRepository;
import com.launchacademy.reviews.repositories.ReviewsRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewDatabaseService implements ReviewService {

  private ReviewsRepository reviewsRepository;
  private BerriesRepository berriesRepository;
  private BerryService berryService;

  @Autowired
  public ReviewDatabaseService(ReviewsRepository reviewsRepository, BerriesRepository berriesRepository, BerryService berryService) {
    this.reviewsRepository = reviewsRepository;
    this.berriesRepository = berriesRepository;
    this.berryService = berryService;
  }

  public Optional<Review> findById(Long id) {
    return reviewsRepository.findById(id);
  }

  public Iterable<Review> findAll(){ return reviewsRepository.findAll(); }

  public void save(Review review) { reviewsRepository.save(review); }

  @Override
  public Review createReview(ReviewForm reviewForm) {
    Review review = new Review();
    review.setName(reviewForm.getName());
    review.setRating(reviewForm.getRating());
    review.setComment(reviewForm.getComment());
    Optional<Berry> berry = berryService.findById(Long.valueOf(reviewForm.getBerryId()));
    if(berry.isPresent()) {
      review.setBerry(berry.get());
    }
    return reviewsRepository.save(review);
  }
}
