package com.project.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateInvoiceCommand {

    @TargetAggregateIdentifier
    public final String paymentId;

    public final String hotelId;

    public CreateInvoiceCommand(String paymentId, String hotelId) {
        this.paymentId = paymentId;
        this.hotelId = hotelId;
    }
}
