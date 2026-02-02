package org.example.teamify.repository;

import org.example.teamify.model.Organizer;
import java.util.List;

public interface OrganizationServiceInterface {
    Organizer createOrganizer(Organizer organizer);
    Organizer getOrganizerById(String id);
    Organizer getOrganizerByEmail(String email);
    List<Organizer> getAllOrganizers();
    Organizer updateOrganizer(String id, Organizer updatedOrganizer);
    Organizer addEventToOrganizer(String organizerId, String eventId);
    void deleteOrganizer(String id);
}