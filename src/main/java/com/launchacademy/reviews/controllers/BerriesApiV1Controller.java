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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/berries")
public class BerriesApiV1Controller {

    private final BerryService berryService;

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
    public ResponseEntity<Map<String, Berry>> addNewBerry(@RequestBody Berry berry) {
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