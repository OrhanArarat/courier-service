package com.orhanararat.courier.tracking.distance.repository;

import com.orhanararat.courier.tracking.distance.dto.projection.CourierInfoProjectionDto;
import com.orhanararat.courier.tracking.distance.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {

    @Query(value = """
            select new com.orhanararat.courier.tracking.distance.dto.projection.CourierInfoProjectionDto(c.id, c.firstName,
                        c.lastName, c.plateNumber, c.phoneNumber)
            from Courier c
            where c.phoneNumber = :phoneNumber
            and c.deleted = false
            """)
    Optional<CourierInfoProjectionDto> getCourierInfoByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
