package org.example.teamify.interfaces;

import org.example.teamify.model.Event;
import java.util.List;

public interface EventServiceInterface {
    Event createEvent(Event event);
    Event getEventById(String id);
    Event getEventByTitle(String title);
    List<Event> getAllEvents();
    List<Event> getEventsByType(String type);

    Event updateEvent(String id, Event updatedEvent);
    void deleteEvent(String id);

    // Team Management inside Event
    Event addTeamToEvent(String eventId, String teamName);
    Event removeTeamFromEvent(String eventId, String teamName);
}