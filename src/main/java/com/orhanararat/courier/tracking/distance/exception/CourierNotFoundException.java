package com.orhanararat.courier.tracking.distance.exception;

import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

@Slf4j
public class CourierNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 8398964274366937103L;

    public CourierNotFoundException(String message) {
        super(message);
    }
}
