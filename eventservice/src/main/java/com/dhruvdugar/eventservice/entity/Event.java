package com.dhruvdugar.eventservice.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.TrueFalseConverter;
import org.hibernate.validator.constraints.Length;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name="events")
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="event_name")
    @Length(min=3, max=30)
    private String name;

    @Column(name="event_description")
    private String description;

    @Column(name="start_date_time")
    private Instant startDateTime;

    @Column(name="end_date_time")
    private Instant endDateTime;

    @Column(name="event_venue")
    private Long venueId;

    @Column(name="event_organizer")
    private Long organizerId;

    @Enumerated
    private EventStatus eventStatus;

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @ManyToMany
    @JoinTable(
            name="event_category",
            joinColumns = @JoinColumn(name="event_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")
    )
    private Set<Category> categories;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public Event() {
    }

    public Event(Long id, String name, String description, Instant startDateTime, Instant endDateTime, Long venueId, Long organizerId, EventStatus eventStatus, Set<Category> categories, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.venueId = venueId;
        this.organizerId = organizerId;
        this.eventStatus = eventStatus;
        this.categories = categories;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
