package com.project.reservationmanagement.reservationservice;;

import com.project.commands.CreateReservationCommand;
import com.project.events.HotelReservedEvent;
import com.project.events.InvoiceCreatedEvent;
import com.project.reservationmanagement.reservationservice.aggregates.ReservationAggregate;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@SpringBootTest
public class ReservationServiceApplicationTests {

	private FixtureConfiguration<ReservationAggregate> fixture;

	@BeforeEach
	public void setUp() {
		fixture = new AggregateTestFixture<>(ReservationAggregate.class);
	}

	@Test
	void testCreateReservationCommandEventHandler(){
		String hotelId = UUID.randomUUID().toString();
		String paymentId = UUID.randomUUID().toString();
		String reservationId = UUID.randomUUID().toString();
		fixture.givenNoPriorActivity()
				.when(new CreateReservationCommand(reservationId,hotelId,paymentId))
				.expectEvents(new HotelReservedEvent(reservationId,hotelId,paymentId));
	}

}
