package com.dhruvdugar.venueservice.model;

public class VenueModel {
    private Long venueId;
    private String venueName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private int capacity;
    private String amenities;
    private String description;
    private String imageURL;

    public VenueModel() {
    }

    public VenueModel(Long venueId, String venueName, String address, String city, String state, String zip, int capacity, String amenities, String description, String imageURL) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.capacity = capacity;
        this.amenities = amenities;
        this.description = description;
        this.imageURL = imageURL;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
