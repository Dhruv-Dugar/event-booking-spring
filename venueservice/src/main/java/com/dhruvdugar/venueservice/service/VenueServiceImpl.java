package com.dhruvdugar.venueservice.service;

import com.dhruvdugar.venueservice.entity.Venue;
import com.dhruvdugar.venueservice.model.VenueAvailability;
import com.dhruvdugar.venueservice.model.VenueModel;
import com.dhruvdugar.venueservice.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VenueServiceImpl implements VenueService{


    @Autowired
    private VenueRepository venueRepo;

    @Override
    public VenueModel createVenue(VenueModel venueModel) {
//        return null;
        Venue venue = venueRepo.save(VenueModelToVenue(venueModel));
        return VenueToVenueModel(venue);
    }

    @Override
    public VenueModel getVenue(Long venueId) {
//        return null;
        Venue venue = venueRepo.findById(venueId).get();
        return VenueToVenueModel(venue);
    }

    @Override
    public List<VenueModel> getAllVenues() {
//        return List.of();
        List<Venue> venueList = venueRepo.findAll();
        return venueList.stream().map(this::VenueToVenueModel).toList();
    }


    @Override
    public VenueModel updateVenue(Long venueId, VenueModel venueModel) {
        Venue venue = venueRepo.findById(venueId).get();

        if(venueModel.getVenueName() != null && !venueModel.getVenueName().isEmpty()){
            venue.setName(venueModel.getVenueName());
        }

        if(venueModel.getAddress() != null && !venueModel.getAddress().isEmpty()){
            venue.setAddress(venueModel.getAddress());
        }

        if(venueModel.getCity() != null && !venueModel.getCity().isEmpty()){
            venue.setCity(venueModel.getCity());
        }

        if(venueModel.getState() != null && !venueModel.getState().isEmpty()){
            venue.setState(venueModel.getState());
        }

        if(venueModel.getZip() != null && !venueModel.getZip().isEmpty()){
            venue.setZip(venueModel.getZip());
        }

        if(venueModel.getCapacity() != 0){
            venue.setCapacity(venueModel.getCapacity());
        }

        if(venueModel.getAmenities() != null && !venueModel.getAmenities().isEmpty()){
            venue.setAmenities(venueModel.getAmenities());
        }

        if(venueModel.getDescription() != null && !venueModel.getDescription().isEmpty()){
            venue.setDescription(venueModel.getDescription());
        }

        if(venueModel.getImageURL() != null && !venueModel.getImageURL().isEmpty()){
            venue.setImageURL(venueModel.getImageURL());
        }

        venueRepo.save(venue);
        return VenueToVenueModel(venue);
    }

    @Override
    public String deleteVenue(Long venueId) {
        Venue venue = venueRepo.findById(venueId).get();
        venueRepo.deleteById(venueId);
        return "Venue with venueid "+ venueId + " deleted successfully";
    }

    @Override
    public String bookVenue(Long venueId, VenueAvailability venueAvailabilityModel) {
        return "";
    }


    protected Venue VenueModelToVenue(VenueModel venueModel){
        Venue venue = new Venue();
        venue.setVenueId(venueModel.getVenueId());
        venue.setName(venueModel.getVenueName());
        venue.setAddress(venueModel.getAddress());
        venue.setCity(venueModel.getCity());
        venue.setState(venueModel.getState());
        venue.setZip(venueModel.getZip());
        venue.setCapacity(venueModel.getCapacity());
        venue.setAmenities(venueModel.getAmenities());
        venue.setDescription(venueModel.getDescription());
        venue.setImageURL(venueModel.getImageURL());
        return venue;
    }

    protected VenueModel VenueToVenueModel(Venue venue){
        VenueModel venueModel = new VenueModel();
        venueModel.setVenueId(venue.getVenueId());
        venueModel.setVenueName(venue.getName());
        venueModel.setAddress(venue.getAddress());
        venueModel.setCity(venue.getCity());
        venueModel.setState(venue.getState());
        venueModel.setZip(venue.getZip());
        venueModel.setCapacity(venue.getCapacity());
        venueModel.setAmenities(venue.getAmenities());
        venueModel.setDescription(venue.getDescription());
        venueModel.setImageURL(venue.getImageURL());
        return venueModel;
    }

    protected VenueAvailability venueAvailabilityModelToVenueAvailability(VenueAvailability venueAvailability){

    }

}
