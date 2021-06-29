package com.project.reservationmanagement.reservationservice.aggregates;

import com.project.commands.CreateReservationCommand;
import com.project.events.HotelReservedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class ReservationAggregate {

    @AggregateIdentifier
    private String reservationId;

    private String hotelId;
    private String paymentId;

    @CommandHandler
    public ReservationAggregate(CreateReservationCommand createReservationCommand){
        AggregateLifecycle.apply(new HotelReservedEvent(createReservationCommand.reservationId,
                createReservationCommand.hotelId, createReservationCommand.paymentId));
    }

    @EventSourcingHandler
    protected void on(HotelReservedEvent hotelReservedEvent){
        this.reservationId = hotelReservedEvent.reservationId;
        this.hotelId = hotelReservedEvent.hotelId;
        this.paymentId = hotelReservedEvent.paymentId;
    }
}
