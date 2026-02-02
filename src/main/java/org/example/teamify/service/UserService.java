package org.example.teamify.service;

import org.example.teamify.interfaces.UserServiceInterface;
import org.example.teamify.model.*;
import org.example.teamify.repository.InterestRepository;
import org.example.teamify.repository.SkillRepository;
import org.example.teamify.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;
    private final SkillRepository skillRepository;
    private final InterestRepository interestRepository;

    public UserService(UserRepository userRepository, SkillRepository skillRepository, InterestRepository interestRepository) {
        this.userRepository = userRepository;
        this.skillRepository = skillRepository;
        this.interestRepository = interestRepository;
    }

    // ---------- User ----------

    @Override
    public User createUser(User user) {
        user.setCreatedAt(LocalDate.now());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUserName(username).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public User updateUser(String userId, User updatedUser) {

        User user = getUserById(userId); // fetch current user

        if (updatedUser.getFirstName() != null) {
            user.setFirstName(updatedUser.getFirstName());
        }
        if (updatedUser.getLastName() != null) {
            user.setLastName(updatedUser.getLastName());
        }
        if (updatedUser.getBio() != null) {
            user.setBio(updatedUser.getBio());
        }
        if (updatedUser.getAbout() != null) {
            user.setAbout(updatedUser.getAbout());
        }
        if (updatedUser.getLocation() != null) {
            user.setLocation(updatedUser.getLocation());
        }
        if (updatedUser.getDateOfBirth() != null) {
            user.setDateOfBirth(updatedUser.getDateOfBirth());
        }
        if (updatedUser.getGender() != null) {
            user.setGender(updatedUser.getGender());
        }
        if (updatedUser.getProfilePictureUrl() != null) {
            user.setProfilePictureUrl(updatedUser.getProfilePictureUrl());
        }
        if (updatedUser.getCoverPictureUrl() != null) {
            user.setCoverPictureUrl(updatedUser.getCoverPictureUrl());
        }
        if (updatedUser.getSocialMediaLinkList() != null) {
            user.setSocialMediaLinkList(updatedUser.getSocialMediaLinkList());
        }
        if (updatedUser.getLookingForList() != null) {
            user.setLookingForList(updatedUser.getLookingForList());
        }

        // ---------- DO NOT TOUCH ----------
        // projectList, experienceList, educationList, skills, interests remain untouched

        return userRepository.save(user); // save the changes
    }


    // ---------- Projects ----------

    @Override
    public User addProject(String userId, Project project) {
        User user = getUserById(userId);

        boolean exists = user.getProjectList().stream()
                .anyMatch(p -> p.getTitle().equalsIgnoreCase(project.getTitle()));

        if (exists) {
            throw new RuntimeException("Project title already exists");
        }

        user.getProjectList().add(project);
        return userRepository.save(user);
    }

    @Override
    public User updateProject(String userId, String projectId, Project updatedProject) {
        User user = getUserById(userId);

        Project project = user.getProjectList().stream()
                .filter(p -> p.getProjectId().equals(projectId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Project not found"));

        if (updatedProject.getTitle() != null) project.setTitle(updatedProject.getTitle());
        if (updatedProject.getDescription() != null) project.setDescription(updatedProject.getDescription());
        if (updatedProject.getProjectUrl() != null) project.setProjectUrl(updatedProject.getProjectUrl());
        if (updatedProject.getRole() != null) project.setRole(updatedProject.getRole());
        if (updatedProject.getStartDate() != null) project.setStartDate(updatedProject.getStartDate());
        if (updatedProject.getEndDate() != null) project.setEndDate(updatedProject.getEndDate());
        if (updatedProject.getCoverImageUrl() != null) project.setCoverImageUrl(updatedProject.getCoverImageUrl());
        if (updatedProject.getImageUrls() != null) project.setImageUrls(updatedProject.getImageUrls());
        if (updatedProject.getTechStacks() != null) project.setTechStacks(updatedProject.getTechStacks());

        return userRepository.save(user);
    }

    @Override
    public User deleteProject(String userId, String projectId) {
        User user = getUserById(userId);

        user.getProjectList()
                .removeIf(p -> p.getProjectId().equals(projectId));

        return userRepository.save(user);
    }

    // ---------- Experience ----------

    @Override
    public User addExperience(String userId, Experience experience) {
        User user = getUserById(userId);
        user.getExperienceList().add(experience);
        return userRepository.save(user);
    }

    @Override
    public User updateExperience(String userId, String experienceId, Experience updatedExperience) {
        User user = getUserById(userId);

        Experience experience = user.getExperienceList().stream()
                .filter(e -> e.getExperienceId().equals(experienceId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Experience not found"));

        if (updatedExperience.getCompanyName() != null) experience.setCompanyName(updatedExperience.getCompanyName());
        if (updatedExperience.getRole() != null) experience.setRole(updatedExperience.getRole());
        if (updatedExperience.getLocation() != null) experience.setLocation(updatedExperience.getLocation());
        if (updatedExperience.getDescription() != null) experience.setDescription(updatedExperience.getDescription());
        if (updatedExperience.getStartDate() != null) experience.setStartDate(updatedExperience.getStartDate());
        if (updatedExperience.getEndDate() != null) experience.setEndDate(updatedExperience.getEndDate());
        if (updatedExperience.getCompanyImageUrl() != null) experience.setCompanyImageUrl(updatedExperience.getCompanyImageUrl());

        return userRepository.save(user);
    }

    @Override
    public User deleteExperience(String userId, String experienceId) {
        User user = getUserById(userId);
        user.getExperienceList().removeIf(e -> e.getExperienceId().equals(experienceId));
        return userRepository.save(user);
    }

    // ---------- Education ----------

    @Override
    public User addEducation(String userId, Education education) {
        User user = getUserById(userId);
        user.getEducationList().add(education);
        return userRepository.save(user);
    }

    @Override
    public User updateEducation(String userId, String educationId, Education updatedEducation) {
        User user = getUserById(userId);

        Education education = user.getEducationList().stream()
                .filter(e -> e.getEducationId().equals(educationId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Education not found"));

        if (updatedEducation.getInstitutionName() != null) education.setInstitutionName(updatedEducation.getInstitutionName());
        if (updatedEducation.getDegree() != null) education.setDegree(updatedEducation.getDegree());
        if (updatedEducation.getFieldOfStudy() != null) education.setFieldOfStudy(updatedEducation.getFieldOfStudy());
        if (updatedEducation.getStartDate() != null) education.setStartDate(updatedEducation.getStartDate());
        if (updatedEducation.getEndDate() != null) education.setEndDate(updatedEducation.getEndDate());
        if (updatedEducation.getInstitutionImageUrl() != null) education.setInstitutionImageUrl(updatedEducation.getInstitutionImageUrl());

        return userRepository.save(user);
    }

    @Override
    public User deleteEducation(String userId, String educationId) {
        User user = getUserById(userId);
        user.getEducationList().removeIf(e -> e.getEducationId().equals(educationId));
        return userRepository.save(user);
    }

    // ---------- Skills ----------

    @Override
    public User addSkill(String userId, String skillId) {
        User user = getUserById(userId);
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        if (!user.getSkills().contains(skill)) {
            user.getSkills().add(skill);
        }

        return userRepository.save(user);
    }

    @Override
    public User removeSkill(String userId, String skillId) {
        User user = getUserById(userId);
        user.getSkills().removeIf(skill -> skill.getId().equals(skillId));
        return userRepository.save(user);
    }

    // ---------- Interests ----------

    @Override
    public User addInterest(String userId, String interestId) {
        User user = getUserById(userId);
        Interest interest = interestRepository.findById(interestId)
                .orElseThrow(() -> new RuntimeException("Interest not found"));

        if (!user.getInterests().contains(interest)) {
            user.getInterests().add(interest);
        }

        return userRepository.save(user);
    }

    @Override
    public User removeInterest(String userId, String interestId) {
        User user = getUserById(userId);
        user.getInterests().removeIf(i -> i.getId().equals(interestId));
        return userRepository.save(user);
    }
}
