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
    @Size(message = "First name must be less than or equal to 100 characters", max = 100)
    @NotBlank(message = "First name is required")
    String firstName;
    @Size(message = "Last name must be less than or equal to 100 characters", max = 100)
    @NotBlank(message = "Last name is required")
    String lastName;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    String email;
    @Size(message = "Phone must be less than or equal to 20 characters", max = 20)
    @NotBlank(message = "Phone is required")
    String phone;
    @Size(message = "Nationality must be less than or equal to 100 characters", max = 100)
    @NotBlank(message = "Nationality is required")
    String nationality;
}