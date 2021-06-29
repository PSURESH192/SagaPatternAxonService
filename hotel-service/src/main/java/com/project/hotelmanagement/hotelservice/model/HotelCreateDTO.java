package com.project.hotelmanagement.hotelservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelCreateDTO {

    public String hotelType;
    public long price;
    public String currency;
}
