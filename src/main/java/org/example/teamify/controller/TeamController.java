package org.example.teamify.controller;

import org.example.teamify.model.Team;
import org.example.teamify.service.TeamService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // ---------- Team Core Endpoints ----------

    @PostMapping("/api/teams")
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @GetMapping("/api/teams/{teamId}")
    public Team getTeamById(@PathVariable String teamId) {
        return teamService.getTeamById(teamId);
    }

    @GetMapping("/api/teams/by-name/{name}")
    public Team getTeamByName(@PathVariable String name) {
        return teamService.getTeamByName(name);
    }

    @GetMapping("/api/teams/by-member/{username}")
    public List<Team> getTeamsByMember(@PathVariable String username) {
        return teamService.getTeamsByMember(username);
    }

    @GetMapping("/api/teams")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PatchMapping("/api/teams/{teamId}")
    public Team updateTeam(
            @PathVariable String teamId,
            @RequestBody Team updatedTeam) {
        return teamService.updateTeam(teamId, updatedTeam);
    }

    // ---------- Team Membership Endpoints ----------

    @PostMapping("/api/teams/{teamId}/members/{username}")
    public Team addMember(@PathVariable String teamId, @PathVariable String username) {
        return teamService.addMember(teamId, username);
    }

    @DeleteMapping("/api/teams/{teamId}/members/{username}")
    public Team removeMember(@PathVariable String teamId, @PathVariable String username) {
        return teamService.removeMember(teamId, username);
    }

    // ---------- Announcements ----------

    @PostMapping("/api/teams/{teamId}/announcements")
    public Team addAnnouncement(@PathVariable String teamId, @RequestBody String announcement) {
        return teamService.addAnnouncement(teamId, announcement);
    }
}