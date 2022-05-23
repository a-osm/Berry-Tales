package com.launchacademy.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping(value = {"/berries", "/berries/{id}", "/berries/new", "/berries/{id}/reviews/new", "/berries/{id}/edit"})
  public String forward() {
    return "forward:/";
  }
}
