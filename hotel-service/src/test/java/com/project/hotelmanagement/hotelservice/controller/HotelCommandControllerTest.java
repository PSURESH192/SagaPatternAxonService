package com.project.hotelmanagement.hotelservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.hotelmanagement.hotelservice.model.HotelCreateDTO;
import com.project.hotelmanagement.hotelservice.service.impl.HotelCommandServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class HotelCommandControllerTest {

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    HotelCommandServiceImpl hotelCommandService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    public void testCreateHotel() throws Exception {
        HotelCreateDTO hotelCreateDTO = new HotelCreateDTO();
        hotelCreateDTO.setHotelType("RESORT");
        hotelCreateDTO.setCurrency("INR");
        hotelCreateDTO.setPrice(25000L);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/hotels")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mapToJson(hotelCreateDTO))).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(201, status);
    }
}
