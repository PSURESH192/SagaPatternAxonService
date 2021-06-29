package com.project.hotelmanagement.hotelservice.service;

import com.project.hotelmanagement.hotelservice.model.HotelCreateDTO;
import com.project.hotelmanagement.hotelservice.service.impl.HotelCommandServiceImpl;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelCommandServiceTest {

    @InjectMocks
    HotelCommandServiceImpl hotelCommandService;

    @Mock
    CommandGateway commandGateway;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateHotel(){
        HotelCreateDTO hotelCreateDTO = new HotelCreateDTO();
        hotelCreateDTO.setHotelType("RESORT");
        hotelCreateDTO.setCurrency("INR");
        hotelCreateDTO.setPrice(25000L);
        Mockito.when(commandGateway.send(Mockito.any())).thenReturn(CompletableFuture.anyOf());
        CompletableFuture<String> account = hotelCommandService.createHotel(hotelCreateDTO);
        Assert.assertNotNull(account);
    }
}
