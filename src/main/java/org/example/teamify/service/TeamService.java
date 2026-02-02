package org.example.teamify.service;

import org.example.teamify.interfaces.TeamServiceInterface;
import org.example.teamify.model.Team;
import org.example.teamify.repository.TeamRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService implements TeamServiceInterface {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    // ---------- Basic CRUD ----------

    @Override
    public Team createTeam(Team team) {

        if (teamRepository.existsByName(team.getName())) {
            throw new RuntimeException("Team name already exists: " + team.getName());
        }

        team.setCreateAt(LocalDate.now());

        if (team.getMemberUsernames() == null) {
            team.setMemberUsernames(new ArrayList<>());
        }
        if (team.getCreatedBy() != null && !team.getMemberUsernames().contains(team.getCreatedBy())) {
            team.getMemberUsernames().add(team.getCreatedBy());
        }

        return teamRepository.save(team);
    }

    @Override
    public Team getTeamById(String id) {
        return teamRepository.findById(id).orElse(null);
    }

    @Override
    public Team getTeamByName(String name) {
        return teamRepository.findByName(name).orElse(null);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team updateTeam(String id, Team updatedTeam) {

        Optional<Team> optionalTeam = teamRepository.findById(id);

        if (optionalTeam.isPresent()) {
            Team existingTeam = optionalTeam.get();

            if (updatedTeam.getGoal() != null) {
                existingTeam.setGoal(updatedTeam.getGoal());
            }
            if (updatedTeam.getDescription() != null) {
                existingTeam.setDescription(updatedTeam.getDescription());
            }
            if (updatedTeam.getCoverImageUrl() != null) {
                existingTeam.setCoverImageUrl(updatedTeam.getCoverImageUrl());
            }
            if (updatedTeam.getName() != null && !updatedTeam.getName().isEmpty()) {
                existingTeam.setName(updatedTeam.getName());
            }
            if (updatedTeam.getCreatedBy() != null) {
                existingTeam.setCreatedBy(updatedTeam.getCreatedBy());
            }
            return teamRepository.save(existingTeam);
        }

        return null;
    }

    @Override
    public Team addAnnouncement(String teamId, String announcement) {
        Team team = getTeamById(teamId);

        if (team != null) {
            // Initialize list if it doesn't exist yet
            if (team.getAnnouncements() == null) {
                team.setAnnouncements(new ArrayList<>());
            }

            // Add the new announcement
            team.getAnnouncements().add(announcement);

            return teamRepository.save(team);
        }

        return null;
    }

    // ---------- Membership Logic ----------

    @Override
    public List<Team> getTeamsByMember(String username) {
        return teamRepository.findByMemberUsernamesContaining(username);
    }

    @Override
    public Team addMember(String teamId, String username) {
        Team team = getTeamById(teamId);
        if (team != null) {
            if (team.getMemberUsernames() == null) {
                team.setMemberUsernames(new ArrayList<>());
            }
            // Prevent duplicates
            if (!team.getMemberUsernames().contains(username)) {
                team.getMemberUsernames().add(username);
                return teamRepository.save(team);
            }
        }
        return team;
    }

    @Override
    public Team removeMember(String teamId, String username) {
        Team team = getTeamById(teamId);
        if (team != null && team.getMemberUsernames() != null) {
            team.getMemberUsernames().remove(username);
            return teamRepository.save(team);
        }
        return team;
    }
}