package com.launchacademy.reviews.exceptionHandling;

public class BerryNotDeletedException extends RuntimeException {

  public BerryNotDeletedException() {
    super("Could not delete Berry");
  }
}
