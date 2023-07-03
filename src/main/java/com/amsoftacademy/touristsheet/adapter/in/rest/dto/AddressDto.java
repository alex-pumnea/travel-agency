package com.amsoftacademy.touristsheet.adapter.in.rest.dto;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * DTO for {@link com.amsoftacademy.touristsheet.domain.Address}
 */
@Value
public class AddressDto implements Serializable {

    @Size(message = "Street must be less than or equal to 100 characters", max = 100)
    @NotBlank(message = "Street is required")
    String street;

    @Size(message = "City must be less than or equal to 100 characters", max = 100)
    @NotBlank(message = "City is required")
    String city;

    @Size(message = "Postal code must be less than or equal to 100 characters", max = 100)
    @NotBlank(message = "Postal code is required")
    String postalCode;

    @Size(message = "Country must be less than or equal to 100 characters", max = 100)
    @NotBlank(message = "Country is required")
    String country;

    @Size(message = "Country code must be less than or equal to 2 characters", max = 2)
    @NotBlank(message = "Country code is required")
    String countryCode;
}