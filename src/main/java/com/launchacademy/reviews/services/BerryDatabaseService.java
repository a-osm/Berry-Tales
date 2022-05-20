package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Berry;
import com.launchacademy.reviews.repositories.BerriesRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BerryDatabaseService implements BerryService {

  private final BerriesRepository berriesRepository;

  @Autowired
  public BerryDatabaseService(BerriesRepository berriesRepository) {
    this.berriesRepository = berriesRepository;
  }

  @Override
  public List<Berry> findAll(){ return (List<Berry>)berriesRepository.findAll(); }

  @Override
  public void save(Berry berry) { berriesRepository.save(berry); }

  @Override
  public Optional<Berry> findById(Long id) {
    return berriesRepository.findById(id);
  }

  @Override
  public Optional<Berry> findByName(String menuName) {
    return Optional.ofNullable(berriesRepository.findByName(menuName));
  }
}
