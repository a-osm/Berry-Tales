package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.exceptionHandling.BerryNotCreatedException;
import com.launchacademy.reviews.exceptionHandling.BerryNotFoundException;
import com.launchacademy.reviews.models.Berry;
import com.launchacademy.reviews.services.BerryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("api/v1/berries")
public class BerriesApiV1Controller {

  private final BerryService berryService;
  HashMap<String, Berry> tempBerry;

  @Autowired
  public BerriesApiV1Controller(BerryService berryService) {
    this.berryService = berryService;
  }

  @GetMapping
  public ResponseEntity<Map<String, List<Berry>>> allBerries() {
    Map<String, List<Berry>> dataMap = new HashMap<>();
    dataMap.put("berries", berryService.findAll());
    return new ResponseEntity<>(dataMap, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Berry>> getBerry(@PathVariable Long id) {
    Optional<Berry> berry = berryService.findById(id);
    Map<String, Berry> dataMap = new HashMap<>();
    if (berry.isPresent()) {
      dataMap.put("berry", berry.get());
    } else {
      throw new BerryNotFoundException();
    }
    return new ResponseEntity<>(dataMap, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity addNewBerry(@RequestBody @Valid Berry berry,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      Map<String, String> errorList = new HashMap<>();
      for (FieldError fieldError : bindingResult.getFieldErrors()) {
        errorList.put(fieldError.getField(), fieldError.getDefaultMessage());
      }
      Map<String, Map> errors = new HashMap<>();
      errors.put("errors", errorList);
      return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);
    } else {
      try {
        Map<String, Berry> dataMap = new HashMap<>();
        berryService.save(berry);
        dataMap.put("berry", berry);
        return new ResponseEntity<>(dataMap, HttpStatus.CREATED);
      } catch (Exception exception) {
        throw new BerryNotCreatedException();
      }
    }
  }

  @GetMapping("/{id}/edit")
  public ResponseEntity<Map<String, Berry>> editBerry(@PathVariable Long id) {
    Optional<Berry> berry = berryService.findById(id);
    Map<String, Berry> dataMap = new HashMap<>();
    if (berry.isPresent()) {
      dataMap.put("berry", berry.get());
    } else {
      throw new BerryNotFoundException();
    }
    return new ResponseEntity<>(dataMap, HttpStatus.OK);
  }

  @PutMapping("/{id}/edit")
  public ResponseEntity<Map<String, Berry>> updateBerry(@PathVariable("id") long id, @RequestBody Berry updatedBerry) {
      Optional<Berry> berryData = berryService.findById(id);
      Map<String, Berry> dataMap = new HashMap<>();
      if(berryData.isPresent()) {
        Berry berry = berryData.get();
        berry.setDescription(updatedBerry.getDescription());
        berry.setName(updatedBerry.getName());
        berry.setImgUrl(updatedBerry.getImgUrl());
        berryService.save(berry);
        dataMap.put("berry", berry);
        return new ResponseEntity<>(dataMap, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}