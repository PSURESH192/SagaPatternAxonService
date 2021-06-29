package com.project.hotelmanagement.hotelservice.service.impl;

import com.project.commands.CreateHotelCommand;
import com.project.hotelmanagement.hotelservice.aggregates.BookingStatus;
import com.project.hotelmanagement.hotelservice.model.HotelCreateDTO;
import com.project.hotelmanagement.hotelservice.service.HotelCommandService;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class HotelCommandServiceImpl implements HotelCommandService {

    @Autowired
    CommandGateway commandGateway;

    @Override
    public CompletableFuture<String> createHotel(HotelCreateDTO hotelCreateDTO) {
        return commandGateway.send(new CreateHotelCommand(UUID.randomUUID().toString().replace("-", ""),
                hotelCreateDTO.getHotelType(),hotelCreateDTO.getPrice(),hotelCreateDTO.getCurrency(),String.valueOf(BookingStatus.CREATED)));
    }
}
