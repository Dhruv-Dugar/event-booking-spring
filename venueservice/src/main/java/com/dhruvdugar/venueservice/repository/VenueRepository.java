package com.dhruvdugar.venueservice.repository;

import com.dhruvdugar.venueservice.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
