package com.amsoftacademy.touristsheet.adapter.in.rest.dto;

import com.amsoftacademy.touristsheet.domain.Relationship;
import lombok.Value;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * DTO for {@link com.amsoftacademy.touristsheet.domain.EmergencyContact}
 */
@Value
public class EmergencyContactDto implements Serializable {

    @Size(message = "First name must be less than or equal to 100 characters", max = 100)
    @NotBlank(message = "First name is required")
    String firstName;

    @Size(message = "Last name must be less than or equal to 100 characters", max = 100)
    @NotBlank(message = "Last name is required")
    String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    String email;

    @Digits(integer = 11, fraction = 0, message = "Phone number should be maximum 11 digits")
    @NotBlank(message = "Phone is required")
    String phone;

    Relationship relationship;
}