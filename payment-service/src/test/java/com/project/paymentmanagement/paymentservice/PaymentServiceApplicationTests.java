package com.project.paymentmanagement.paymentservice;

import com.project.commands.CreateInvoiceCommand;
import com.project.events.InvoiceCreatedEvent;
import com.project.paymentmanagement.paymentservice.aggregates.PaymentAggregate;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.UUID;

@SpringBootTest
public class PaymentServiceApplicationTests {

	private FixtureConfiguration<PaymentAggregate> fixture;

	@BeforeEach
	public void setUp() {
		fixture = new AggregateTestFixture<>(PaymentAggregate.class);
	}

	@Test
	void testCreateInvoiceCommandEventHandler(){
		String hotelId = UUID.randomUUID().toString();
		String paymentId = UUID.randomUUID().toString();
		fixture.givenNoPriorActivity()
				.when(new CreateInvoiceCommand(paymentId,hotelId))
				.expectEvents(new InvoiceCreatedEvent(paymentId,hotelId));
	}

}
