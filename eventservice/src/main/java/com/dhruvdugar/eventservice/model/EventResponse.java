package com.dhruvdugar.eventservice.model;

import com.dhruvdugar.eventservice.entity.EventStatus;
import com.dhruvdugar.eventservice.external.client.VenueModel;

import java.time.Instant;
import java.util.Set;


public class EventResponse {
    private Long id;
    private String name;
    private String description;
    private Instant startDateTime;
    private Instant endDateTime;
    private VenueModel venue;
    private Long organizerId;
    private EventStatus eventStatus;
    private Set<CategoryModel> categories;

    public EventResponse() {
    }

    public EventResponse(Long id, String name, String description, Instant startDateTime, Instant endDateTime, VenueModel venue, Long organizerId, EventStatus eventStatus, Set<CategoryModel> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.venue = venue;
        this.organizerId = organizerId;
        this.eventStatus = eventStatus;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public VenueModel getVenue() {
        return venue;
    }

    public void setVenue(VenueModel venue) {
        this.venue = venue;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }

    public Set<CategoryModel> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryModel> categories) {
        this.categories = categories;
    }
}