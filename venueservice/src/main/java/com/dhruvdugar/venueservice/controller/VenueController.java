package com.dhruvdugar.venueservice.controller;


import com.dhruvdugar.venueservice.model.APIResponse;
import com.dhruvdugar.venueservice.model.VenueAvailability;
import com.dhruvdugar.venueservice.model.VenueModel;
import com.dhruvdugar.venueservice.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @PostMapping
    public ResponseEntity<APIResponse> createVenue(@RequestBody VenueModel venueModel){
        VenueModel venueModel1 = venueService.createVenue(venueModel);
        return ResponseEntity.ok(new APIResponse(true, "Venue created successfully", venueModel1));
    }

    @GetMapping("/{venueId}")
    public ResponseEntity<APIResponse> getVenue(@PathVariable("venueId") Long venueId){
        VenueModel venueModel1 = venueService.getVenue(venueId);
        return ResponseEntity.ok(new APIResponse(true, "Venue fetched successfully", venueModel1));
    }

    @GetMapping
    public ResponseEntity<APIResponse> getAllVenues(){
        return ResponseEntity.ok(new APIResponse(true, "All Venues fetched successfully", venueService.getAllVenues()));
    }

    @PutMapping("/{venueId}")
    public ResponseEntity<APIResponse> updateVenue(@PathVariable("venueId") Long venueId, @RequestBody VenueModel venueModel){
        VenueModel updatedVenue = venueService.updateVenue(venueId, venueModel);
        return ResponseEntity.ok(new APIResponse(true, "Venue updated successfully", updatedVenue));
    }

    @DeleteMapping("/{venueId}")
    public ResponseEntity<APIResponse> deleteVenue(@PathVariable("venueId") Long venueId){
        String result = venueService.deleteVenue(venueId);
        return ResponseEntity.ok(new APIResponse(true, "Venue deleted successfully", null));
    }


    @PostMapping("/{venueId}/bookvenue")
    public ResponseEntity<APIResponse> bookVenue(@PathVariable("venueId") Long venueId, @RequestBody VenueAvailability venueAvailabilityModel){
//        VenueModel updatedVenue = venueService.bookVenue(venueId, venueModel);
//        return ResponseEntity.ok(new APIResponse(true, "Venue booked successfully", updatedVenue));
        String bookingStatus = venueService.bookVenue(venueId, venueAvailabilityModel);
        return ResponseEntity.ok(new APIResponse(true, "Venue booked successfully", bookingStatus));
    }
}
