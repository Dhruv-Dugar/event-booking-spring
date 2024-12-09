package com.dhruvdugar.eventservice.service;

import com.dhruvdugar.eventservice.model.APIResponse;
import com.dhruvdugar.eventservice.model.EventModel;
import com.dhruvdugar.eventservice.model.EventResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventService {

    EventModel createEvent(EventModel eventModel);

    EventModel getEvent(Long eventId);

    List<EventModel> getAllEvents();

    EventModel updateEvent(Long eventId, EventModel eventModel);

    String deleteEvent(Long eventId);


    EventResponse getEventDetails(Long eventId);
}
