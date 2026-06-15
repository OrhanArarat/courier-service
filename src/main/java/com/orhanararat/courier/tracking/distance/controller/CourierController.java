package com.orhanararat.courier.tracking.distance.controller;

import com.orhanararat.courier.tracking.distance.dto.projection.CourierInfoProjectionDto;
import com.orhanararat.courier.tracking.distance.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/courier")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<CourierInfoProjectionDto> getCourierInfoByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return ResponseEntity.ok(courierService.getCourierInfoByPhoneNumber(phoneNumber));
    }
}
