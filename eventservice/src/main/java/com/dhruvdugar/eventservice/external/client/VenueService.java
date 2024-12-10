package com.dhruvdugar.eventservice.external.client;

import com.dhruvdugar.eventservice.model.APIResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "VENUE-SERVICE/api/venues")
@CircuitBreaker(
        name="external", fallbackMethod = "fallback"
)
public interface VenueService {
    @PostMapping("/{venueId}/bookVenue")
    public ResponseEntity<APIResponse> bookVenue(@PathVariable("venueId") Long venueId, @RequestBody VenueAvailabilityModel venueAvailabilityModel);
}
