package com.project.events;

public class HotelStatusUpdatedEvent {

    public final String hotelId;

    public final String bookingStatus;

    public HotelStatusUpdatedEvent(String hotelId, String bookingStatus) {
        this.hotelId = hotelId;
        this.bookingStatus = bookingStatus;
    }
}
