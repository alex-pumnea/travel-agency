package com.amsoftacademy.touristsheet.adapter.in.rest.dto;

import lombok.Value;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link com.amsoftacademy.touristsheet.domain.TouristSheet}
 */
@Value
public class TouristSheetResponse implements Serializable {

    Long id;

    @NotNull(message = "Travel start date is required")
    @FutureOrPresent(message = "Travel start date must be in the future or present")
    LocalDate travelStartDate;

    @NotNull(message = "Travel end date is required")
    @Future(message = "Travel end date must be in the future")
    LocalDate travelEndDate;

    @Size(message = "Flight details must be less than or equal to 100 characters", max = 100)
    @NotBlank(message = "Flight details is required")
    String flightDetails;

    @Size(message = "Tour plan must contain between 1 and 15 items", min = 1, max = 15)
    @NotEmpty(message = "Tour plan must not be empty")
    List<String> tourPlan;

    @NotNull(message = "Customer is required")
    CustomerResponse customer;

    Instant createdAt;

    Instant updatedAt;
}