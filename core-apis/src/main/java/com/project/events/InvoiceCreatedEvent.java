package com.project.events;

public class InvoiceCreatedEvent {

    public final String paymentId;

    public final String hotelId;

    public InvoiceCreatedEvent(String paymentId, String hotelId) {
        this.paymentId = paymentId;
        this.hotelId = hotelId;
    }
}
