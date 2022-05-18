package com.launchacademy.reviews.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {

  private final BerrySeeder berrySeeder;

  @Autowired
  public MainSeeder(BerrySeeder berrySeeder) {
    this.berrySeeder = berrySeeder;
  }

  @Override
  public void run(String... args) throws Exception {
    berrySeeder.seed();
  }
}
