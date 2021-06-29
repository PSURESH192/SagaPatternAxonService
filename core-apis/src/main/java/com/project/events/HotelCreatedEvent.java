package com.project.events;

public class HotelCreatedEvent {
    public final String hotelId;
    public final String hotelType;
    public final long price;
    public final String currency;
    public final String bookingStatus;

    public HotelCreatedEvent(String hotelId, String hotelType, long price, String currency, String bookingStatus) {
        this.hotelId = hotelId;
        this.hotelType = hotelType;
        this.price = price;
        this.currency = currency;
        this.bookingStatus = bookingStatus;
    }
}
