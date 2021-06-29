package com.project.hotelmanagement.hotelservice.controller;

import com.project.hotelmanagement.hotelservice.model.HotelCreateDTO;
import com.project.hotelmanagement.hotelservice.service.HotelCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@RequestMapping(value = "/api/hotels")
public class HotelCommandControllerImpl implements HotelCommandController{

    @Autowired
    HotelCommandService hotelCommandService;

    @Override
    @PostMapping
    public ResponseEntity<CompletableFuture<String>> createHotel(@NotNull @RequestBody HotelCreateDTO hotelCreateDTO){
        return new ResponseEntity<>(hotelCommandService.createHotel(hotelCreateDTO), HttpStatus.CREATED);
    }
}
