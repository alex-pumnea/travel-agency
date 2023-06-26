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
    @Size(message = "First name must be less than or equal to 100 characters", max = 100)
    @NotBlank(message = "First name is required")
    String firstName;
    @Size(message = "Last name must be less than or equal to 100 characters", max = 100)
    @NotBlank(message = "Last name is required")
    String lastName;
    Relationship relationship;
    @Size(message = "Phone must be less than or equal to 20 characters", max = 20)
    @NotBlank(message = "Phone is required")
    String phone;
}