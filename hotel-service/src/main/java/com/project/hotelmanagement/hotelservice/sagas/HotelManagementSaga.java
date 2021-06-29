package com.project.hotelmanagement.hotelservice.sagas;

import com.project.commands.CreateInvoiceCommand;
import com.project.commands.CreateReservationCommand;
import com.project.commands.UpdateHotelStatusCommand;
import com.project.events.HotelCreatedEvent;
import com.project.events.HotelReservedEvent;
import com.project.events.HotelStatusUpdatedEvent;
import com.project.events.InvoiceCreatedEvent;
import com.project.hotelmanagement.hotelservice.aggregates.BookingStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import javax.inject.Inject;
import java.util.UUID;

@Saga
public class HotelManagementSaga {

    static final Logger logger  = LogManager.getLogger(HotelManagementSaga.class.getName());

    @Inject
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "hotelId")
    public void handle(HotelCreatedEvent hotelCreatedEvent){
        String paymentId = UUID.randomUUID().toString().replace("-", "");
        logger.info("Saga Invoked");

        SagaLifecycle.associateWith("paymentId", paymentId);

        logger.info("hotelId : {}",hotelCreatedEvent.hotelId);

        commandGateway.send(new CreateInvoiceCommand(paymentId,hotelCreatedEvent.hotelId));
    }

    @SagaEventHandler(associationProperty = "paymentId")
    public void handle(InvoiceCreatedEvent invoiceCreatedEvent){
        String reservationId = UUID.randomUUID().toString().replace("-", "");
        logger.info("Saga Continued");

        SagaLifecycle.associateWith("reservationId", reservationId);

        logger.info("paymentId : {}",invoiceCreatedEvent.paymentId);

        commandGateway.send(new CreateReservationCommand(reservationId,invoiceCreatedEvent.hotelId,invoiceCreatedEvent.paymentId));
    }

    @SagaEventHandler(associationProperty = "hotelId")
    public void handle(HotelReservedEvent hotelReservedEvent){
        commandGateway.send(new UpdateHotelStatusCommand(hotelReservedEvent.hotelId, String.valueOf(BookingStatus.BOOKED)));
    }

    @SagaEventHandler(associationProperty = "hotelId")
    public void handle(HotelStatusUpdatedEvent hotelStatusUpdatedEvent){
        SagaLifecycle.end();
    }

}
