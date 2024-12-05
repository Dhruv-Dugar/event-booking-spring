package com.dhruvdugar.venueservice.service;

import com.dhruvdugar.venueservice.model.VenueModel;

import java.util.List;

public interface VenueService {
    VenueModel createVenue(VenueModel venueModel);
    VenueModel getVenue(Long venueId);
    List<VenueModel> getAllVenues();
    VenueModel updateVenue(Long venueId, VenueModel venueModel);
    String deleteVenue(Long venueId);
}
