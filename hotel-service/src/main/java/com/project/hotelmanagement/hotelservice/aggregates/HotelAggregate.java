package com.project.hotelmanagement.hotelservice.aggregates;

import com.project.commands.CreateHotelCommand;
import com.project.commands.UpdateHotelStatusCommand;
import com.project.events.HotelCreatedEvent;
import com.project.events.HotelStatusUpdatedEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Data
@NoArgsConstructor
public class HotelAggregate {

    @AggregateIdentifier
    private String hotelId;
    private HotelType hotelType;
    private long price;
    private String currency;
    private BookingStatus bookingStatus;


    @CommandHandler
    public HotelAggregate(CreateHotelCommand createHotelCommand){
        AggregateLifecycle.apply(new HotelCreatedEvent(createHotelCommand.hotelId, createHotelCommand.hotelType,
                createHotelCommand.price, createHotelCommand.currency, createHotelCommand.bookingStatus));
    }

    @EventSourcingHandler
    protected void on(HotelCreatedEvent hotelCreatedEvent){
        this.hotelId = hotelCreatedEvent.hotelId;
        this.hotelType = HotelType.valueOf(hotelCreatedEvent.hotelType);
        this.price = hotelCreatedEvent.price;
        this.currency = hotelCreatedEvent.currency;
        this.bookingStatus = BookingStatus.valueOf(hotelCreatedEvent.bookingStatus);
    }

    @CommandHandler
    protected void handle(UpdateHotelStatusCommand updateHotelStatusCommand){
        AggregateLifecycle.apply(new HotelStatusUpdatedEvent(updateHotelStatusCommand.hotelId, updateHotelStatusCommand.bookingStatus));
    }

    @EventSourcingHandler
    protected void on(HotelStatusUpdatedEvent hotelStatusUpdatedEvent){
        this.hotelId = hotelStatusUpdatedEvent.hotelId;
        this.bookingStatus = BookingStatus.valueOf(hotelStatusUpdatedEvent.bookingStatus);
    }
}
