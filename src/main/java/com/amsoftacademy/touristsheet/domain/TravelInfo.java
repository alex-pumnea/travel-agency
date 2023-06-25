package com.amsoftacademy.touristsheet.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @OneToMany(mappedBy = "travelInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TouristSheet> touristSheets = new LinkedHashSet<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        TravelInfo that = (TravelInfo) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "travelStartDate = " + travelStartDate + ", " +
                "travelEndDate = " + travelEndDate + ", " +
                "flightDetails = " + flightDetails + ", " +
                "itinerary = " + itinerary + ")";
    }
}