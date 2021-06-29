package com.project.hotelmanagement.hotelservice.controller;

import com.project.hotelmanagement.hotelservice.model.HotelCreateDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.concurrent.CompletableFuture;

@RestController
@Api(value = "Hotel Command Controller")
public interface HotelCommandController {

    @ApiOperation(value = "Create Hotel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CompletableFuture<String>> createHotel(@NotNull @RequestBody HotelCreateDTO hotelCreateDTO);
}
