package com.dhruvdugar.eventservice.service;


import com.dhruvdugar.eventservice.entity.Event;
import com.dhruvdugar.eventservice.external.client.VenueService;
import com.dhruvdugar.eventservice.model.EventModel;
import com.dhruvdugar.eventservice.repository.EventRepository;
import com.dhruvdugar.venueservice.model.VenueAvailabilityModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepo;
    @Autowired
    private VenueService venueService;




    @Override
    public EventModel createEvent(EventModel eventModel){
        Event event = eventRepo.save(EventModelToEvent(eventModel));
        VenueAvailabilityModel venueAvailabilityModel = new VenueAvailabilityModel();
        venueAvailabilityModel.setVenueId(eventModel.getVenueId());
        venueAvailabilityModel.setStartDateTime(eventModel.getStartDateTime());
        venueAvailabilityModel.setEndDateTime(eventModel.getEndDateTime());
        venueService.bookVenue(eventModel.getVenueId(), venueAvailabilityModel);
        return EventToEventModel(event);
    }

    @Override
    public EventModel getEvent(Long eventId) {
        Event event = eventRepo.findById(eventId).get();
        return EventToEventModel(event);
    }

    @Override
    public List<EventModel> getAllEvents() {
        List<Event> eventList = eventRepo.findAll();
        return eventList.stream().map(this::EventToEventModel).toList();
    }

    @Override
    public EventModel updateEvent(Long eventId, EventModel eventModel) {
        Event event = eventRepo.findById(eventId).get();

        if(Objects.nonNull(eventModel.getName()) && !("").equalsIgnoreCase(eventModel.getName())){
            event.setName(eventModel.getName());
        }

        if(Objects.nonNull(eventModel.getDescription()) && !("").equalsIgnoreCase(eventModel.getDescription())){
            event.setDescription(eventModel.getDescription());
        }

        if(Objects.nonNull(eventModel.getVenueId())){
            event.setVenueId(eventModel.getVenueId());
        }

        if(Objects.nonNull(eventModel.getOrganizerId())){
            event.setOrganizerId(eventModel.getOrganizerId());
        }

        eventRepo.save(event);
        return EventToEventModel(event);

    }

    @Override
    public String deleteEvent(Long eventId) {
        Event event = eventRepo.findById(eventId).get();
        eventRepo.deleteById(eventId);
        return "Event with id "+eventId+" deleted successfully";
    }

    protected Event EventModelToEvent(EventModel eventModel){
        Event event = new Event();
        event.setId(eventModel.getId());
        event.setName(eventModel.getName());
        event.setDescription(eventModel.getDescription());
        event.setVenueId(eventModel.getVenueId());
        event.setOrganizerId(eventModel.getOrganizerId());
        return event;
    }

    protected EventModel EventToEventModel(Event event){
        EventModel eventModel = new EventModel();
        eventModel.setId(event.getId());
        eventModel.setName(event.getName());
        eventModel.setDescription(event.getDescription());
        eventModel.setVenueId(event.getVenueId());
        eventModel.setOrganizerId(event.getOrganizerId());
        return eventModel;
    }

}
