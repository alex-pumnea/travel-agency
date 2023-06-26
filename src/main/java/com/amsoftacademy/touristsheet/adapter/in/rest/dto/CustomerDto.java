package com.amsoftacademy.touristsheet.adapter.in.rest.dto;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * DTO for {@link com.amsoftacademy.touristsheet.domain.Customer}
 */
@Value
public class CustomerDto implements Serializable {
    @Size(max = 100, message = "First name must be less than or equal to 100 characters")
    @NotBlank(message = "First name is required")
    String firstName;

    @Size(max = 100, message = "Last name must be less than or equal to 100 characters")
    @NotBlank(message = "Last name is required")
    String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    String email;

    @Size(max = 20, message = "Phone must be less than or equal to 20 characters")
    @NotBlank(message = "Phone is required")
    String phone;

    @Size(max = 100, message = "Nationality must be less than or equal to 100 characters")
    @NotBlank(message = "Nationality is required")
    String nationality;
}