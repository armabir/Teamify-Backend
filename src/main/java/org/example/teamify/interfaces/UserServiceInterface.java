package org.example.teamify.interfaces;

import org.example.teamify.model.Education;
import org.example.teamify.model.Experience;
import org.example.teamify.model.Project;
import org.example.teamify.model.User;

import java.util.List;

public interface UserServiceInterface {

    // ---------- User ----------
    User createUser(User user);

    User getUserById(String userId);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    List<User> getAll();

    User updateUser(String userId, User updatedUser);

    // ---------- Projects ----------
    User addProject(String userId, Project project);

    User updateProject(String userId, String projectId, Project updatedProject);

    User deleteProject(String userId, String projectId);

    // ---------- Experience ----------
    User addExperience(String userId, Experience experience);

    User updateExperience(String userId, String experienceId, Experience updatedExperience);

    User deleteExperience(String userId, String experienceId);

    // ---------- Education ----------
    User addEducation(String userId, Education education);

    User updateEducation(String userId, String educationId, Education updatedEducation);

    User deleteEducation(String userId, String educationId);

    // ---------- Skills ----------
    User addSkill(String userId, String skillId);

    User removeSkill(String userId, String skillId);

    // ---------- Interests ----------
    User addInterest(String userId, String interestId);

    User removeInterest(String userId, String interestId);
}
