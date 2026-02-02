package org.example.teamify.controller;

import org.example.teamify.model.*;
import org.example.teamify.service.InterestService;
import org.example.teamify.service.SkillService;
import org.example.teamify.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    private final InterestService interestService;
    private final SkillService skillService;

    public UserController(UserService userService, InterestService interestService, SkillService skillService) {
        this.userService = userService;
        this.interestService = interestService;
        this.skillService = skillService;
    }

    // ---------- User Endpoints ----------

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/api/users/{userId}")
    public User getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/api/users/by-username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/api/users/by-email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PatchMapping("/api/users/{userId}")
    public User updateUser(
            @PathVariable String userId,
            @RequestBody User updatedUser) {
        return userService.updateUser(userId, updatedUser);
    }

    // ---------- Project Endpoints ----------

    @PostMapping("/api/users/{userId}/projects")
    public User addProject(@PathVariable String userId, @RequestBody Project project) {
        return userService.addProject(userId, project);
    }

    @PatchMapping("/api/users/{userId}/projects/{projectId}")
    public User updateProject(
            @PathVariable String userId,
            @PathVariable String projectId,
            @RequestBody Project updatedProject) {
        return userService.updateProject(userId, projectId, updatedProject);
    }

    @DeleteMapping("/api/users/{userId}/projects/{projectId}")
    public User deleteProject(@PathVariable String userId, @PathVariable String projectId) {
        return userService.deleteProject(userId, projectId);
    }

    // ---------- Experience Endpoints ----------

    @PostMapping("/api/users/{userId}/experiences")
    public User addExperience(@PathVariable String userId, @RequestBody Experience experience) {
        return userService.addExperience(userId, experience);
    }

    @PatchMapping("/api/users/{userId}/experiences/{experienceId}")
    public User updateExperience(
            @PathVariable String userId,
            @PathVariable String experienceId,
            @RequestBody Experience updatedExperience
    ) {
        return userService.updateExperience(userId, experienceId, updatedExperience);
    }

    @DeleteMapping("/api/users/{userId}/experiences/{experienceId}")
    public User deleteExperience(
            @PathVariable String userId,
            @PathVariable String experienceId) {
        return userService.deleteExperience(userId, experienceId);
    }

    // ---------- Education Endpoints ----------

    @PostMapping("/api/users/{userId}/educations")
    public User addEducation(@PathVariable String userId, @RequestBody Education education) {
        return userService.addEducation(userId, education);
    }

    @PatchMapping("/api/users/{userId}/educations/{educationId}")
    public User updateEducation(
            @PathVariable String userId,
            @PathVariable String educationId,
            @RequestBody Education updatedEducation) {
        return userService.updateEducation(userId, educationId, updatedEducation);
    }

    @DeleteMapping("/api/users/{userId}/educations/{educationId}")
    public User deleteEducation(
            @PathVariable String userId,
            @PathVariable String educationId) {
        return userService.deleteEducation(userId, educationId);
    }

    // ---------- Skills Endpoints ----------

    @GetMapping("/api/skills")
    public List<Skill> getAllSkills(){
        return skillService.getAll();
    }

    @PostMapping("/api/users/{userId}/skills/{skillId}")
    public User addSkill(@PathVariable String userId, @PathVariable String skillId) {
        return userService.addSkill(userId, skillId);
    }

    @DeleteMapping("/api/users/{userId}/skills/{skillId}")
    public User removeSkill(@PathVariable String userId, @PathVariable String skillId) {
        return userService.removeSkill(userId, skillId);
    }

    // ---------- Interests Endpoints ----------

    @GetMapping("/api/interests")
    public List<Interest> getAllInterests(){
        return interestService.getAll();
    }

    @PostMapping("/api/users/{userId}/interests/{interestId}")
    public User addInterest(@PathVariable String userId, @PathVariable String interestId) {
        return userService.addInterest(userId, interestId);
    }

    @DeleteMapping("/api/users/{userId}/interests/{interestId}")
    public User removeInterest(@PathVariable String userId, @PathVariable String interestId) {
        return userService.removeInterest(userId, interestId);
    }
}
