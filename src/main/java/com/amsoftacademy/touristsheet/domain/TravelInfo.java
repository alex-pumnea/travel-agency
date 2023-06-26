package com.amsoftacademy.touristsheet.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Represents a TravelInfo entity.
 *
 * @author Alex Pumnea
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "travel_infos")
public class TravelInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "Travel start date is required")
    @FutureOrPresent(message = "Travel start date must be in the future or present")
    @Column(name = "travel_start_date")
    private LocalDate travelStartDate;

    @NotNull(message = "Travel end date is required")
    @FutureOrPresent(message = "Travel end date must be in the future or present")
    @Column(name = "travel_end_date")
    private LocalDate travelEndDate;

    @NotBlank(message = "Flight details is required")
    @Size(max = 100, message = "Flight details must be less than or equal to 100 characters")
    @Column(name = "flight_details")
    private String flightDetails;

    @NotEmpty(message = "Itinerary must not be empty")
    @Size(min = 1, max = 15, message = "Itinerary must contain between 1 and 15 items")
    @ElementCollection
    @CollectionTable(name = "itinerary", joinColumns = @JoinColumn(name = "travel_info_id"))
    @Column(name = "item")
    private List<String> itinerary;
}