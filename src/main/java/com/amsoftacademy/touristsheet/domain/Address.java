package com.amsoftacademy.touristsheet.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Represents an address entity.
 *
 * @author Alex Pumnea
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Street is required")
    @Size(max = 100, message = "Street must be less than or equal to 100 characters")
    @Column(name = "street", nullable = false)
    private String street;

    @NotBlank(message = "City is required")
    @Size(max = 100, message = "City must be less than or equal to 100 characters")
    @Column(name = "city")
    private String city;

    @NotBlank(message = "Postal code is required")
    @Size(max = 100, message = "Postal code must be less than or equal to 100 characters")
    @Column(name = "postal_code")
    private String postalCode;

    @NotBlank(message = "Country is required")
    @Size(max = 100, message = "Country must be less than or equal to 100 characters")
    @Column(name = "country")
    private String country;

    @NotBlank(message = "Country code is required")
    @Size(max = 2, message = "Country code must be less than or equal to 2 characters")
    @Column(name = "country_code")
    private String countryCode;

}