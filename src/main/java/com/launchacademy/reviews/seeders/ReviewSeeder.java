package com.launchacademy.reviews.seeders;

import com.launchacademy.reviews.models.Berry;
import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.services.BerryService;
import com.launchacademy.reviews.services.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewSeeder {
  private ReviewService reviewService;
  private BerryService berryService;

  @Autowired
  public ReviewSeeder(
      ReviewService reviewService, BerryService berryService) {
    this.reviewService = reviewService;
    this.berryService = berryService;
  }

  public void seed() {
    if (((List<Review>)reviewService.findAll()).size() == 0) {
      Berry goldenRaspberry = berryService.findByName("Golden Raspberries").get();
      Berry blueberry = berryService.findByName("Blueberries").get();
      Berry strawberry = berryService.findByName("Strawberries").get();

      Review review1 = new Review();
      review1.setName("Kenny Smith");
      review1.setRating(1);
      review1.setComment("I'm miserable so I give these a 1");
      review1.setBerry(goldenRaspberry);
      reviewService.save(review1);

      Review review2 = new Review();
      review2.setName("Charles Barkley");
      review2.setRating(5);
      review2.setComment("One of the best berries ever");
      review2.setBerry(blueberry);
      reviewService.save(review2);

      Review review3 = new Review();
      review3.setName("Ernie Johnson");
      review3.setRating(4);
      review3.setComment("One of the most versatile berries. My go to!");
      review3.setBerry(strawberry);
      reviewService.save(review3);
    }
  }
}
