package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Berry;
import java.util.List;

public interface BerryService {

  List<Berry> findAll();
  void save(Berry berry);
}
