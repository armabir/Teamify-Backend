package org.example.teamify.controller;

import org.example.teamify.interfaces.EventServiceInterface;
import org.example.teamify.model.Event;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EventController {

    private final EventServiceInterface eventService;

    public EventController(EventServiceInterface eventService) {
        this.eventService = eventService;
    }

    // ---------- Event Core Endpoints ----------

    @PostMapping("/api/events")
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @GetMapping("/api/events/{id}")
    public Event getEventById(@PathVariable String id) {
        return eventService.getEventById(id);
    }

    @GetMapping("/api/events/by-title/{title}")
    public Event getEventByTitle(@PathVariable String title) {
        return eventService.getEventByTitle(title);
    }

    @GetMapping("/api/events")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/api/events/by-type/{type}")
    public List<Event> getEventsByType(@PathVariable String type) {
        return eventService.getEventsByType(type);
    }

    @PatchMapping("/api/events/{id}")
    public Event updateEvent(@PathVariable String id, @RequestBody Event updatedEvent) {
        return eventService.updateEvent(id, updatedEvent);
    }

    @DeleteMapping("/api/events/{id}")
    public void deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
    }

    // ---------- Event Team Management ----------

    @PostMapping("/api/events/{eventId}/teams/{teamName}")
    public Event addTeamToEvent(@PathVariable String eventId, @PathVariable String teamName) {
        return eventService.addTeamToEvent(eventId, teamName);
    }

    @DeleteMapping("/api/events/{eventId}/teams/{teamName}")
    public Event removeTeamFromEvent(@PathVariable String eventId, @PathVariable String teamName) {
        return eventService.removeTeamFromEvent(eventId, teamName);
    }
}