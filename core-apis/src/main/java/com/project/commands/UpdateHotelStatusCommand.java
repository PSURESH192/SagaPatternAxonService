package com.project.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateHotelStatusCommand {

    @TargetAggregateIdentifier
    public final String hotelId;

    public final String bookingStatus;

    public UpdateHotelStatusCommand(String hotelId, String bookingStatus) {
        this.hotelId = hotelId;
        this.bookingStatus = bookingStatus;
    }
}
