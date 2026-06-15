package com.orhanararat.courier.tracking.distance.dto.projection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourierInfoProjectionDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 3655744465743462790L;

    private Long id;

    private String firstName;

    private String lastName;

    private String plateNumber;

    private String phoneNumber;
}
