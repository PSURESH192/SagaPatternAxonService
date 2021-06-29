package com.project.hotelmanagement.hotelservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class HotelCreateDTO {

    public final String hotelType;
    public final long price;
    public final String currency;
}
