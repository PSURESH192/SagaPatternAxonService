package com.project.hotelmanagement.hotelservice;

import com.project.commands.CreateHotelCommand;
import com.project.commands.UpdateHotelStatusCommand;
import com.project.events.HotelCreatedEvent;
import com.project.events.HotelStatusUpdatedEvent;
import com.project.hotelmanagement.hotelservice.aggregates.HotelAggregate;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class HotelServiceApplicationTests {

	private FixtureConfiguration<HotelAggregate> fixture;

	@BeforeEach
	public void setUp() {
		fixture = new AggregateTestFixture<>(HotelAggregate.class);
	}

	@Test
	void testCreateHotelCommandEventHandler(){
		String hotelId = UUID.randomUUID().toString();
		fixture.givenNoPriorActivity()
				.when(new CreateHotelCommand(hotelId,"RESORT", 1000L,"INR","CREATED"))
				.expectEvents(new HotelCreatedEvent(hotelId,"RESORT", 1000L,"INR","CREATED"));
	}

	@Test
	void testUpdateHotelStatusCommandEventHandler(){
		String hotelId = UUID.randomUUID().toString();
		fixture.given(new HotelCreatedEvent(hotelId,"RESORT", 1000L,"INR","CREATED"))
				.when(new UpdateHotelStatusCommand(hotelId,"CREATED"))
				.expectEvents(new HotelStatusUpdatedEvent(hotelId,"CREATED"));
	}
}
