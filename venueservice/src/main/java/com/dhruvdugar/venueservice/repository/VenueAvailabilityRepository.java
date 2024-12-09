package com.dhruvdugar.venueservice.repository;

import com.dhruvdugar.venueservice.entity.VenueAvailability;
import com.dhruvdugar.venueservice.model.VenueAvailabilityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueAvailabilityRepository extends JpaRepository<VenueAvailability, Long> {
    List<VenueAvailability> findAllByVenueId(Long venueId);

    @Query(value = "SELECT id, e.name, e.start_date_time, e.end_date_time"+
            " FROM venue_availability e WHERE e.venue_id = :venueId AND DATE(e.start_date_time AT TIME ZONE 'UTC') = :date", nativeQuery = true)
    List<VenueAvailabilityModel> findAllByVenueIdAndDate(Long venueId, String date);
}
