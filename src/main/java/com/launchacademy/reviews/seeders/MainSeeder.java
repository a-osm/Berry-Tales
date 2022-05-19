package com.launchacademy.reviews.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {

  private ReviewSeeder reviewSeeder;
  private final BerrySeeder berrySeeder;

  @Autowired
  public MainSeeder(ReviewSeeder reviewSeeder, BerrySeeder berrySeeder) {
    this.reviewSeeder = reviewSeeder;
    this.berrySeeder = berrySeeder;
  }

  @Override
  public void run(String... args) throws Exception {
    berrySeeder.seed();
    reviewSeeder.seed();
  }
}
