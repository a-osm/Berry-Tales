package com.launchacademy.reviews.exceptionHandling;

public class BerryNotFoundException extends RuntimeException {

  public BerryNotFoundException() {
    super("No berry found with the provided ID");
  }
}
