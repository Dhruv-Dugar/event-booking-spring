package com.dhruvdugar.venueservice.repository;

import com.dhruvdugar.venueservice.entity.VenueAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueAvailabilityRepository extends JpaRepository<VenueAvailability, Long> {
    List<VenueAvailability> findAllByVenueId(Long venueId);
}
