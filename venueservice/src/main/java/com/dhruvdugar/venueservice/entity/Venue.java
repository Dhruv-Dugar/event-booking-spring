package com.dhruvdugar.venueservice.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "venues")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venueId;

    @Column(name = "venue_name")
    private String name;

    @Column(name="venue_address")
    private String address;

    @Column(name="venue_city")
    private String city;

    @Column(name="venue_state")
    private String state;

    @Column(name="venue_zip")
    private String zip;

    @Column(name="venue_capacity")
    private int capacity;

    @Column(name="amenities")
    private String amenities;

    @Column(name="description")
    private String description;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @Column(name="venue_picture")
    private String imageURL;

    public Venue() {
    }

    public Venue(Long venueId, String name, String address, String city, String state, String zip, int capacity, String amenities, String description, Instant createdAt, Instant updatedAt, String imageURL) {
        this.venueId = venueId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.capacity = capacity;
        this.amenities = amenities;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.imageURL = Venue.this.imageURL;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = Venue.this.imageURL;
    }
}
