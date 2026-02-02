package org.example.teamify.service;

import org.example.teamify.model.Organizer;
import org.example.teamify.repository.OrganizationServiceInterface;
import org.example.teamify.repository.OrganizerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService implements OrganizationServiceInterface {

    private final OrganizerRepository organizerRepository;

    public OrganizationService(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }

    // ---------- Basic CRUD ----------

    @Override
    public Organizer createOrganizer(Organizer organizer) {

        if (organizerRepository.existsByName(organizer.getName())) {
            throw new RuntimeException("Organization name already exists: " + organizer.getName());
        }
        if (organizerRepository.existsByEmail(organizer.getEmail())) {
            throw new RuntimeException("Email already registered: " + organizer.getEmail());
        }

        organizer.setCreatedAt(LocalDate.now());

        if (organizer.getEventIds() == null) {
            organizer.setEventIds(new ArrayList<>());
        }

        return organizerRepository.save(organizer);
    }

    @Override
    public Organizer getOrganizerById(String id) {
        return organizerRepository.findById(id).orElse(null);
    }


    public Organizer getOrganizerByName(String name) {
        return organizerRepository.findByName(name).orElse(null);
    }

    @Override
    public Organizer getOrganizerByEmail(String email) {
        return organizerRepository.findByEmail(email).orElse(null);
    }

    @Override
    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    @Override
    public Organizer updateOrganizer(String id, Organizer updatedOrganizer) {

        Optional<Organizer> optionalOrganizer = organizerRepository.findById(id);

        if (optionalOrganizer.isPresent()) {
            Organizer existingOrganizer = optionalOrganizer.get();

            // Partial Updates (Only update if value is provided)
            if (updatedOrganizer.getName() != null && !updatedOrganizer.getName().isEmpty()) {
                existingOrganizer.setName(updatedOrganizer.getName());
            }
            if (updatedOrganizer.getDescription() != null) {
                existingOrganizer.setDescription(updatedOrganizer.getDescription());
            }
            if (updatedOrganizer.getWebsiteUrl() != null) {
                existingOrganizer.setWebsiteUrl(updatedOrganizer.getWebsiteUrl());
            }
            if (updatedOrganizer.getLogoUrl() != null) {
                existingOrganizer.setLogoUrl(updatedOrganizer.getLogoUrl());
            }
            if (updatedOrganizer.getType() != null) {
                existingOrganizer.setType(updatedOrganizer.getType());
            }


            return organizerRepository.save(existingOrganizer);
        }

        return null;
    }

    @Override
    public void deleteOrganizer(String id) {
        if (organizerRepository.existsById(id)) {
            organizerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Organizer not found with ID: " + id);
        }
    }

    // ---------- Event Linking Logic ----------

    @Override
    public Organizer addEventToOrganizer(String organizerId, String eventId) {
        Organizer organizer = getOrganizerById(organizerId);

        if (organizer != null) {
            // Initialize list if it doesn't exist
            if (organizer.getEventIds() == null) {
                organizer.setEventIds(new ArrayList<>());
            }

            // Prevent duplicate event IDs
            if (!organizer.getEventIds().contains(eventId)) {
                organizer.getEventIds().add(eventId);
                return organizerRepository.save(organizer);
            }
        }
        return organizer;
    }
}