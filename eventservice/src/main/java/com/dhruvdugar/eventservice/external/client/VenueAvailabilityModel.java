package com.dhruvdugar.eventservice.external.client;

import java.time.Instant;

public class VenueAvailabilityModel {
    private Long Id;
    private Long venueId;
    private Instant startDateTime;
    private Instant endDateTime;

    public VenueAvailabilityModel() {
    }

    public VenueAvailabilityModel(Long id, Long venueId, Instant startDateTime, Instant endDateTime) {
        Id = id;
        this.venueId = venueId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public Instant getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Instant startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Instant getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Instant endDateTime) {
        this.endDateTime = endDateTime;
    }
}
