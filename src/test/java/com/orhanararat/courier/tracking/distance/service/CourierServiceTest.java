package com.orhanararat.courier.tracking.distance.service;

import com.orhanararat.courier.tracking.distance.constant.DomainConstant;
import com.orhanararat.courier.tracking.distance.dto.projection.CourierInfoProjectionDto;
import com.orhanararat.courier.tracking.distance.exception.CourierNotFoundException;
import com.orhanararat.courier.tracking.distance.repository.CourierRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourierServiceTest {

    @Mock
    private CourierRepository courierRepository;

    @Mock
    private MessageSourceService messageSourceService;

    @InjectMocks
    private CourierService courierService;

    // ─── getCourierInfoByPhoneNumber ─────────────────────────────────────────

    @Test
    void getCourierInfoByPhoneNumber_courierExists_returnsProjection() {
        CourierInfoProjectionDto projection = CourierInfoProjectionDto.builder()
                .id(1L)
                .phoneNumber("05551234567")
                .build();

        when(courierRepository.getCourierInfoByPhoneNumber("05551234567"))
                .thenReturn(Optional.of(projection));

        CourierInfoProjectionDto result = courierService.getCourierInfoByPhoneNumber("05551234567");

        assertThat(result).isEqualTo(projection);
        assertThat(result.getId()).isEqualTo(1L);
        verifyNoInteractions(messageSourceService);
    }

    @Test
    void getCourierInfoByPhoneNumber_courierNotFound_throwsCourierNotFoundException() {
        when(courierRepository.getCourierInfoByPhoneNumber("05559999999"))
                .thenReturn(Optional.empty());
        when(messageSourceService.getMessage(DomainConstant.COURIER_NOT_FOUND, "05559999999"))
                .thenReturn("Courier not found: 05559999999");

        assertThatThrownBy(() -> courierService.getCourierInfoByPhoneNumber("05559999999"))
                .isInstanceOf(CourierNotFoundException.class)
                .hasMessageContaining("05559999999");
    }

    @Test
    void getCourierInfoByPhoneNumber_courierNotFound_usesMessageSource() {
        when(courierRepository.getCourierInfoByPhoneNumber("05559999999"))
                .thenReturn(Optional.empty());
        when(messageSourceService.getMessage(DomainConstant.COURIER_NOT_FOUND, "05559999999"))
                .thenReturn("Courier not found: 05559999999");

        assertThatThrownBy(() -> courierService.getCourierInfoByPhoneNumber("05559999999"))
                .isInstanceOf(CourierNotFoundException.class);

        verify(messageSourceService).getMessage(DomainConstant.COURIER_NOT_FOUND, "05559999999");
    }
}