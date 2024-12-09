package com.dhruvdugar.eventservice.controller;


import com.dhruvdugar.eventservice.model.APIResponse;
import com.dhruvdugar.eventservice.model.EventModel;
import com.dhruvdugar.eventservice.model.EventResponse;
import com.dhruvdugar.eventservice.service.EventService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {


    @Autowired
    private EventService eventService;


    @PostMapping
    public ResponseEntity<APIResponse> createEvent(@RequestBody EventModel eventModel) {
        EventModel eventModel1 = eventService.createEvent(eventModel);
        return new ResponseEntity<APIResponse>(new APIResponse(true, "Event created successfully", eventModel1), HttpStatus.CREATED);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<APIResponse> getEvents(@PathVariable("eventId") Long eventId){
        EventModel eventModel1 = eventService.getEvent(eventId);
        return new ResponseEntity<APIResponse>(new APIResponse(true, "Event fetched successfully", eventModel1), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<APIResponse> getAllEvents(){
        List<EventModel> events = eventService.getAllEvents();
        return new ResponseEntity<APIResponse>(new APIResponse(true, "All Events fetched successfully", events), HttpStatus.OK);
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<APIResponse> updateEvent(@PathVariable("eventId") Long eventId, @RequestBody EventModel eventModel){
        EventModel updatedEvent = eventService.updateEvent(eventId, eventModel);
        return new ResponseEntity<APIResponse>(new APIResponse(true, "Event updated successfully", updatedEvent), HttpStatus.OK);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<APIResponse> deleteEvent(@PathVariable("eventId") Long eventId){
        String result = eventService.deleteEvent(eventId);
        return new ResponseEntity<APIResponse>(new APIResponse(true, "Event deleted successfully", null), HttpStatus.OK);
    }

    @GetMapping("/{eventId}/details")
    public ResponseEntity<APIResponse> getEventDetails(@PathVariable("eventId") Long eventId){
        EventResponse eventModel1 = eventService.getEventDetails(eventId);
        return new ResponseEntity<>(new APIResponse(true, "Event Fetched Succesfully", eventModel1), HttpStatus.OK);
    }

}
