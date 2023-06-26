package com.amsoftacademy.touristsheet.adapter.in.rest.dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * DTO for {@link com.amsoftacademy.touristsheet.domain.TouristSheet}
 */
@Value
@Builder
public class TouristSheetRequest implements Serializable {
    @NotNull
    CustomerDto customer;
    @NotNull
    AddressDto address;
    @NotNull
    TravelInfoDto travelInfo;
    @NotNull
    EmergencyContactDto emergencyContact;
}