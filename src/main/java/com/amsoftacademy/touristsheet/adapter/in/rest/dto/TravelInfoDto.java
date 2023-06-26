package com.amsoftacademy.touristsheet.adapter.in.rest.dto;

import lombok.Value;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link com.amsoftacademy.touristsheet.domain.TravelInfo}
 */
@Value
public class TravelInfoDto implements Serializable {

    @NotNull(message = "Travel start date is required")
    @FutureOrPresent(message = "Travel start date must be in the future or present")
    LocalDate travelStartDate;

    @NotNull(message = "Travel end date is required")
    @FutureOrPresent(message = "Travel end date must be in the future or present")
    LocalDate travelEndDate;

    @Size(message = "Flight details must be less than or equal to 100 characters", max = 100)
    @NotBlank(message = "Flight details is required")
    String flightDetails;

    @Size(message = "Itinerary must contain between 1 and 15 items", min = 1, max = 15)
    @NotEmpty(message = "Itinerary must not be empty")
    List<String> itinerary;
}