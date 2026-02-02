package org.example.teamify.service;

import org.example.teamify.interfaces.EventServiceInterface;
import org.example.teamify.model.Event;
import org.example.teamify.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService implements EventServiceInterface {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // ---------- Core CRUD ----------

    @Override
    public Event createEvent(Event event) {
        if (eventRepository.existsByTitle(event.getTitle())) {
            throw new RuntimeException("Event title already exists: " + event.getTitle());
        }

        event.setCreatedAt(LocalDate.now());

        if (event.getTeamNames() == null) {
            event.setTeamNames(new ArrayList<>());
        }

        return eventRepository.save(event);
    }

    @Override
    public Event getEventById(String id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public Event getEventByTitle(String title) {
        return eventRepository.findByTitle(title).orElse(null);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getEventsByType(String type) {
        return eventRepository.findByEventType(type);
    }

    @Override
    public Event updateEvent(String id, Event updatedEvent) {
        Optional<Event> optionalEvent = eventRepository.findById(id);

        if (optionalEvent.isPresent()) {
            Event existing = optionalEvent.get();

            if (updatedEvent.getTitle() != null && !updatedEvent.getTitle().isEmpty()) {
                existing.setTitle(updatedEvent.getTitle());
            }
            if (updatedEvent.getShortDescription() != null) {
                existing.setShortDescription(updatedEvent.getShortDescription());
            }
            if (updatedEvent.getFullDescription() != null) {
                existing.setFullDescription(updatedEvent.getFullDescription());
            }
            if (updatedEvent.getEventType() != null) {
                existing.setEventType(updatedEvent.getEventType());
            }
            if (updatedEvent.getLocation() != null) {
                existing.setLocation(updatedEvent.getLocation());
            }
            if (updatedEvent.getCoverUrl() != null) {
                existing.setCoverUrl(updatedEvent.getCoverUrl());
            }
            // Boolean fields need care (checking if it was actually sent),
            // but for simplicity we assume typical setter usage:
            existing.setPaid(updatedEvent.isPaid());

            return eventRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteEvent(String id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
        }
    }

    // ---------- Team Logic ----------

    @Override
    public Event addTeamToEvent(String eventId, String teamName) {
        Event event = getEventById(eventId);
        if (event != null) {
            if (event.getTeamNames() == null) {
                event.setTeamNames(new ArrayList<>());
            }
            if (!event.getTeamNames().contains(teamName)) {
                event.getTeamNames().add(teamName);
                return eventRepository.save(event);
            }
        }
        return event;
    }

    @Override
    public Event removeTeamFromEvent(String eventId, String teamName) {
        Event event = getEventById(eventId);
        if (event != null && event.getTeamNames() != null) {
            event.getTeamNames().remove(teamName);
            return eventRepository.save(event);
        }
        return event;
    }
}