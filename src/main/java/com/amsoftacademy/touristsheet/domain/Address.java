package com.amsoftacademy.touristsheet.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents an address entity.
 *
 * @author Alex Pumnea
 */
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Street is required")
    @Size(message = "Street must be less than or equal to 100 characters", max = 100)
    @Column(name = "street", nullable = false)
    private String street;

    @NotBlank(message = "City is required")
    @Size(message = "City must be less than or equal to 100 characters", max = 100)
    @Column(name = "city")
    private String city;

    @NotBlank(message = "Postal code is required")
    @Size(message = "Postal code must be less than or equal to 100 characters", max = 100)
    @Column(name = "postal_code")
    private String postalCode;

    @NotBlank(message = "Country is required")
    @Size(message = "Country must be less than or equal to 100 characters", max = 100)
    @Column(name = "country")
    private String country;

    @NotBlank(message = "Country code is required")
    @Size(message = "Country code must be less than or equal to 2 characters", max = 2)
    @Column(name = "country_code")
    private String countryCode;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TouristSheet> touristSheets = new LinkedHashSet<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Address address = (Address) o;
        return getId() != null && Objects.equals(getId(), address.getId());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "street = " + street + ", " +
                "city = " + city + ", " +
                "postalCode = " + postalCode + ", " +
                "country = " + country + ", " +
                "countryCode = " + countryCode + ")";
    }
}