package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.exceptionHandling.ReviewNotCreatedException;
import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.models.ReviewForm;
import com.launchacademy.reviews.services.ReviewService;
import java.util.HashMap;
import java.util.Map;
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

//  private ReviewService reviewService;
//
//  public ReviewsApiV1Controller(ReviewService reviewService) {
//    this.reviewService = reviewService;
//  }
//
//  @PostMapping
//  public ResponseEntity<Map<String, Review>> create(@PathVariable Integer id, @RequestBody ReviewForm reviewForm){
//   try{
//     reviewForm.setId(id);
//     Review review = reviewService.createReview(reviewForm);
//
//   } catch{
//    }
//  }


//  @PostMapping("/{id}/reviews")
//  public ResponseEntity<Map<String, Review>> addNewReview(@RequestBody Review review) {
//    try {
//      Map<String, Review> dataMap = new HashMap<>();
//      reviewService.save(review);
//      dataMap.put("review", review);
//      return new ResponseEntity<>(dataMap, HttpStatus.CREATED);
//    } catch (Exception exception) {
//      throw new ReviewNotCreatedException();
//    }
//  }
}
