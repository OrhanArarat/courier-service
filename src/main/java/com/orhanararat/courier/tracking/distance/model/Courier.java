package com.orhanararat.courier.tracking.distance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "courier", uniqueConstraints = {@UniqueConstraint(columnNames = "phone_number", name = "ix_unique_phone_number")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Courier extends BaseEntity<Long> implements Serializable {

    @Serial
    private static final long serialVersionUID = -5168350955149273542L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "plate_number", nullable = false)
    private String plateNumber;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
}
