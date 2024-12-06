package com.dhruvdugar.venueservice.service;

import com.dhruvdugar.venueservice.entity.Venue;
import com.dhruvdugar.venueservice.entity.VenueAvailability;
import com.dhruvdugar.venueservice.model.VenueAvailabilityModel;
import com.dhruvdugar.venueservice.model.VenueModel;
import com.dhruvdugar.venueservice.repository.VenueAvailabilityRepository;
import com.dhruvdugar.venueservice.repository.VenueRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VenueServiceImpl implements VenueService{


    @Autowired
    private VenueRepository venueRepo;

    @Autowired
    private VenueAvailabilityRepository venueAvailabilityRepo;

    @Override
    public VenueModel createVenue(VenueModel venueModel) {
        Venue venue = venueRepo.save(VenueModelToVenue(venueModel));
        return VenueToVenueModel(venue);
    }

    @Override
    public VenueModel getVenue(Long venueId) {
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
    public String bookVenue(Long venueId, VenueAvailabilityModel venueAvailabilityModel) {
        try{
            Venue venue = venueRepo.findById(venueId).get();
        } catch (Exception e){
            throw new RuntimeException("Venue with venueid "+ venueId + " not found");
        }


        VenueAvailability venueAvailability = venueAvailabilityModelToVenueAvailability(venueAvailabilityModel);

        venueAvailability.setVenueId(venueId);

        venueAvailabilityRepo.save(venueAvailability);
        return "Venue booked successfully";
    }

    @Override
    public List<VenueAvailabilityModel> getBookedSlots(Long venueId) {
        // TODO
        // change this method to allow if date is also provided and then do processing
        List<VenueAvailability> venueAvailabilities = venueAvailabilityRepo.findAllByVenueId(venueId);
        return venueAvailabilities.stream()
                .map(this::venueAvailabilityToVenueAvailabilityModel)
                .toList();
    }


    protected Venue VenueModelToVenue(VenueModel venueModel){
        Venue venue = new Venue();
        venue.setId(venueModel.getId());
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
        venueModel.setId(venue.getId());
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
    protected VenueAvailability venueAvailabilityModelToVenueAvailability(VenueAvailabilityModel venueAvailabilityModel){
        VenueAvailability venueAvailability = new VenueAvailability();
        venueAvailability.setVenueId(venueAvailabilityModel.getVenueId());
        venueAvailability.setId(venueAvailabilityModel.getId());
        venueAvailability.setStartDateTime(venueAvailabilityModel.getStartDateTime());
        venueAvailability.setEndDateTime(venueAvailabilityModel.getEndDateTime());
        venueAvailability.setAvailable(false);
        return venueAvailability;
    }

    protected VenueAvailabilityModel venueAvailabilityToVenueAvailabilityModel(VenueAvailability venueAvailability){
        VenueAvailabilityModel venueAvailabilityModel = new VenueAvailabilityModel();
        venueAvailabilityModel.setVenueId(venueAvailability.getVenueId());
        venueAvailabilityModel.setId(venueAvailability.getId());
        venueAvailabilityModel.setStartDateTime(venueAvailability.getStartDateTime());
        venueAvailabilityModel.setEndDateTime(venueAvailability.getEndDateTime());
        return venueAvailabilityModel;
    }

}
