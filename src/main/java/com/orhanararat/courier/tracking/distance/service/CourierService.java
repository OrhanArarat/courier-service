package com.orhanararat.courier.tracking.distance.service;

import com.orhanararat.courier.tracking.distance.constant.DomainConstant;
import com.orhanararat.courier.tracking.distance.dto.projection.CourierInfoProjectionDto;
import com.orhanararat.courier.tracking.distance.exception.CourierNotFoundException;
import com.orhanararat.courier.tracking.distance.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourierService {

    private final CourierRepository courierRepository;

    private final MessageSourceService messageSourceService;

    public CourierInfoProjectionDto getCourierInfoByPhoneNumber(String phoneNumber) {
        return courierRepository.getCourierInfoByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new CourierNotFoundException(messageSourceService.getMessage(DomainConstant.COURIER_NOT_FOUND, phoneNumber)));
    }
}
