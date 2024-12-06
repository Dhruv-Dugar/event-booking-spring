package com.dhruvdugar.eventservice.external.client;

import com.dhruvdugar.eventservice.model.APIResponse;
import com.dhruvdugar.venueservice.model.VenueAvailabilityModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "VENUE-SERVICE/api/venues")
public interface VenueService {
    @PostMapping("/{venueId}/bookVenue")
    public ResponseEntity<APIResponse> bookVenue(@PathVariable("venueId") Long venueId, @RequestBody VenueAvailabilityModel venueAvailabilityModel);
}
