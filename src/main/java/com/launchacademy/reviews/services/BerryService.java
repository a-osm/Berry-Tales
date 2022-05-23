package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Berry;
import java.util.List;
import java.util.Optional;

public interface BerryService {

  List<Berry> findAll();
  void save(Berry berry);
  Optional<Berry> findById(Long id);
  Optional<Berry> findByName(String berryName);

  Optional<Berry> deleteById(Long id);
}
