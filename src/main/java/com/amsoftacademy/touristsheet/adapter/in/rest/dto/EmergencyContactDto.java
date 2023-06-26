package com.amsoftacademy.touristsheet.adapter.in.rest.dto;

import com.amsoftacademy.touristsheet.domain.Relationship;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * DTO for {@link com.amsoftacademy.touristsheet.domain.EmergencyContact}
 */
@Value
public class EmergencyContactDto implements Serializable {
    @Size(max = 100, message = "First name must be less than or equal to 100 characters")
    @NotBlank(message = "First name is required")
    String firstName;

    @Size(max = 100, message = "Last name must be less than or equal to 100 characters")
    @NotBlank(message = "Last name is required")
    String lastName;

    Relationship relationship;

    @Size(max = 20, message = "Phone must be less than or equal to 20 characters")
    @NotBlank(message = "Phone is required")
    String phone;
}