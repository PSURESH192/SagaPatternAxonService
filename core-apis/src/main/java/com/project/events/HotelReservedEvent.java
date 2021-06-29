package com.project.events;

public class HotelReservedEvent {

    public final String reservationId;
    public final String hotelId;
    public final String paymentId;

    public HotelReservedEvent(String reservationId, String hotelId, String paymentId) {
        this.reservationId = reservationId;
        this.hotelId = hotelId;
        this.paymentId = paymentId;
    }
}
