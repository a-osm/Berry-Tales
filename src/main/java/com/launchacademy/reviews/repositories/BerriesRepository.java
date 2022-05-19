package com.launchacademy.reviews.repositories;

import com.launchacademy.reviews.models.Berry;
import org.springframework.data.repository.CrudRepository;

public interface BerriesRepository extends CrudRepository<Berry, Long> {

  Berry findByName(String name);
}
