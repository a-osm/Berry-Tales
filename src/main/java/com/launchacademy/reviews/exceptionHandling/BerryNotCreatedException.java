package com.launchacademy.reviews.exceptionHandling;

public class BerryNotCreatedException extends RuntimeException {

  public BerryNotCreatedException() {
    super("Could not create Berry");
  }
}
