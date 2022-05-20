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
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
  public ResponseEntity create(@RequestBody @Valid ReviewForm reviewForm,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      Map<String, String> errorList = new HashMap<>();
      for (FieldError fieldError : bindingResult.getFieldErrors()) {
        errorList.put(fieldError.getField(), fieldError.getDefaultMessage());
      }
      Map<String, Map> errors = new HashMap<>();
      errors.put("errors", errorList);
      return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);
    } else {
      try {
        Review newReview = reviewService.createReview(reviewForm);
        Map<String, Review> dataMap = new HashMap<>();
        dataMap.put("review", newReview);
        return new ResponseEntity<Map<String, Review>>(dataMap, HttpStatus.CREATED);

      } catch (IllegalArgumentException ex) {
        throw new ReviewNotCreatedException();
      }
    }
  }
}
