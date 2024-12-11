package com.dhruvdugar.venueservice.controller;


import com.dhruvdugar.venueservice.model.APIResponse;
import com.dhruvdugar.venueservice.model.VenueAvailabilityModel;
import com.dhruvdugar.venueservice.model.VenueModel;
import com.dhruvdugar.venueservice.service.VenueService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;


//    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<APIResponse> createVenue(@RequestBody VenueModel venueModel){
        VenueModel venueModel1 = venueService.createVenue(venueModel);
        return ResponseEntity.ok(new APIResponse(true, "Venue created successfully", venueModel1));
    }

//    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer') || hasAuthority('SCOPE_internal')")
    @GetMapping("/{venueId}")
    public ResponseEntity<APIResponse> getVenue(@PathVariable("venueId") Long venueId){
        VenueModel venueModel1 = venueService.getVenue(venueId);
        return ResponseEntity.ok(new APIResponse(true, "Venue fetched successfully", venueModel1));
    }

//    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer') || hasAuthority('SCOPE_internal')")
    @GetMapping
    public ResponseEntity<APIResponse> getAllVenues(){
        return ResponseEntity.ok(new APIResponse(true, "All Venues fetched successfully", venueService.getAllVenues()));
    }

//    @PreAuthorize("hasAuthority('Admin')")
    @PutMapping("/{venueId}")
    public ResponseEntity<APIResponse> updateVenue(@PathVariable("venueId") Long venueId, @RequestBody VenueModel venueModel){
        VenueModel updatedVenue = venueService.updateVenue(venueId, venueModel);
        return ResponseEntity.ok(new APIResponse(true, "Venue updated successfully", updatedVenue));
    }

//    @PreAuthorize("hasAuthority('Admin')")
    @DeleteMapping("/{venueId}")
    public ResponseEntity<APIResponse> deleteVenue(@PathVariable("venueId") Long venueId){
        String result = venueService.deleteVenue(venueId);
        return ResponseEntity.ok(new APIResponse(true, "Venue deleted successfully", null));
    }

//    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer') || hasAuthority('SCOPE_internal')")
    @PostMapping("/{venueId}/bookVenue")
    public ResponseEntity<APIResponse> bookVenue(@PathVariable("venueId") Long venueId, @RequestBody VenueAvailabilityModel venueAvailabilityModel){
        String bookingStatus = venueService.bookVenue(venueId, venueAvailabilityModel);
        return ResponseEntity.ok(new APIResponse(true, "Venue booked successfully", bookingStatus));
    }

//    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<APIResponse> getBookedSlots(@PathVariable("venueId") Long venueId, @RequestParam(required = false) String date){
        List<VenueAvailabilityModel> availabilityModels = venueService.getBookedSlots(venueId, date);

        return ResponseEntity.ok(new APIResponse(true, "Booked slots fetched successfully", availabilityModels));
    }

}
