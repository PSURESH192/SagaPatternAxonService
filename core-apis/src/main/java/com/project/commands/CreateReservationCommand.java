package com.project.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateReservationCommand {

    @TargetAggregateIdentifier
    public final String reservationId;

    public final String hotelId;
    public final String paymentId;


    public CreateReservationCommand(String reservationId, String hotelId, String paymentId) {
        this.reservationId = reservationId;
        this.hotelId = hotelId;
        this.paymentId = paymentId;
    }
}
