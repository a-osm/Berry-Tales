package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.exceptionHandling.ReviewNotCreatedException;
import com.launchacademy.reviews.models.Berry;
import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.models.ReviewForm;
import com.launchacademy.reviews.services.BerryService;
import com.launchacademy.reviews.services.ReviewService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/berries/{id}/reviews")
public class ReviewsApiV1Controller {

  private ReviewService reviewService;
  private BerryService berryService;

  public ReviewsApiV1Controller(ReviewService reviewService, BerryService berryService) {
    this.reviewService = reviewService;
    this.berryService = berryService;
  }

  @PostMapping
  public ResponseEntity<Map<String, Review>> create(@PathVariable Integer id, @RequestBody ReviewForm reviewForm){
   try{
//     reviewForm.setBerryId(id);
//     Review review = new Review();
//     review.setName(reviewForm.getName());
//     review.setRating(reviewForm.getRating());
//     review.setComment(reviewForm.getComment());
//     Optional<Berry> berry = berryService.findById(Long.valueOf(id));

     Review newReview = reviewService.createReview(reviewForm);
     Map<String, Review> dataMap = new HashMap<>();
     dataMap.put("review", newReview);
     return new ResponseEntity<Map<String, Review>>(dataMap, HttpStatus.CREATED);

   } catch(IllegalArgumentException ex){
     throw new ReviewNotCreatedException();
    }
  }
}
