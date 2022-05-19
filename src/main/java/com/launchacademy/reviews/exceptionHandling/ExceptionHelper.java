package com.launchacademy.reviews.exceptionHandling;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ExceptionHelper {
    @ExceptionHandler(value = { BerryNotFoundException.class })
    public ResponseEntity<String> handleBerryNotFoundException(BerryNotFoundException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { ReviewNotCreatedException.class })
    public ResponseEntity<Map<String, List>> handleReviewNotCreatedException(ReviewNotCreatedException ex) {
        System.out.println("Could not create review");
        List<String> errorList = new ArrayList<>();
        errorList.add(ex.getMessage());
        Map<String, List> responseBody = new HashMap<>();
        responseBody.put("errors", errorList);
        return new ResponseEntity<Map<String, List>>(responseBody, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}