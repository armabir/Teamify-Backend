package org.example.teamify.controller;

import org.example.teamify.model.Organizer;
import org.example.teamify.service.OrganizationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    // ---------- Organization Core Endpoints ----------

    @PostMapping("/api/organizers")
    public Organizer createOrganizer(@RequestBody Organizer organizer) {
        return organizationService.createOrganizer(organizer);
    }

//    @GetMapping("/api/organizers/{id}")
//    public Organizer getOrganizerById(@PathVariable String id) {
//        return organizationService.getOrganizerById(id);
//    }

    @GetMapping("/api/organizers/{name}")
    public Organizer getOrganizerByName(@PathVariable String name) {
        return organizationService.getOrganizerByName(name);
    }

    @GetMapping("/api/organizers/by-email")
    public Organizer getOrganizerByEmail(@RequestParam String email) {
        return organizationService.getOrganizerByEmail(email);
    }

    @GetMapping("/api/organizers")
    public List<Organizer> getAllOrganizers() {
        return organizationService.getAllOrganizers();
    }

    @PatchMapping("/api/organizers/{id}")
    public Organizer updateOrganizer(
            @PathVariable String id,
            @RequestBody Organizer updatedOrganizer) {
        return organizationService.updateOrganizer(id, updatedOrganizer);
    }

    @DeleteMapping("/api/organizers/{id}")
    public void deleteOrganizer(@PathVariable String id) {
        organizationService.deleteOrganizer(id);
    }

    // ---------- Event Management Endpoints ----------

    @PostMapping("/api/organizers/{organizerId}/events/{eventId}")
    public Organizer addEventToOrganizer(@PathVariable String organizerId, @PathVariable String eventId) {
        return organizationService.addEventToOrganizer(organizerId, eventId);
    }
}