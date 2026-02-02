package org.example.teamify.interfaces;

import org.example.teamify.model.Team;

import java.util.List;

public interface TeamServiceInterface {

    // Basic CRUD
    Team createTeam(Team team);
    Team getTeamById(String id);
    Team getTeamByName(String name);
    List<Team> getAllTeams();
    Team updateTeam(String id, Team updatedTeam);

    Team addAnnouncement(String teamId, String announcement);

    // Specific to Team Logic
    List<Team> getTeamsByMember(String username); // For "My Teams" dashboard
    Team addMember(String teamId, String username);
    Team removeMember(String teamId, String username);
}