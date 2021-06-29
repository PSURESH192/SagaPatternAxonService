package com.project.hotelmanagement.hotelservice.service;

import com.project.hotelmanagement.hotelservice.model.HotelCreateDTO;

import java.util.concurrent.CompletableFuture;

public interface HotelCommandService {

    CompletableFuture<String> createHotel(HotelCreateDTO hotelCreateDTO);
}
