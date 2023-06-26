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
    @Size(max = 100, message = "Street must be less than or equal to 100 characters")
    @NotBlank(message = "Street is required")
    String street;

    @Size(max = 100, message = "City must be less than or equal to 100 characters")
    @NotBlank(message = "City is required")
    String city;

    @Size(max = 100, message = "Postal code must be less than or equal to 100 characters")
    @NotBlank(message = "Postal code is required")
    String postalCode;

    @Size(max = 100, message = "Country must be less than or equal to 100 characters")
    @NotBlank(message = "Country is required")
    String country;

    @Size(max = 2, message = "Country code must be less than or equal to 2 characters")
    @NotBlank(message = "Country code is required")
    String countryCode;
}