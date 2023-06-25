package com.amsoftacademy.touristsheet.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a Customer entity.
 *
 * @author Alex Pumnea
 */
@Getter
@Setter
@Entity
@Table(name = "emergency_contacts")
public class EmergencyContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name must be less than or equal to 100 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 100, message = "Last name must be less than or equal to 100 characters")
    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "relationship")
    private Relationship relationship;

    @NotBlank(message = "Phone is required")
    @Size(max = 20, message = "Phone must be less than or equal to 20 characters")
    @Column(name = "phone")
    private String phone;

    @PastOrPresent
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate createdAt;

    @PastOrPresent
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "emergencyContact", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TouristSheet> touristSheets = new LinkedHashSet<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        EmergencyContact that = (EmergencyContact) o;
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
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "relationship = " + relationship + ", " +
                "phone = " + phone + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ")";
    }
}