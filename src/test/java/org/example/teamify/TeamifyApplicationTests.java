package org.example.teamify;

import org.example.teamify.enums.Gender;
import org.example.teamify.model.*;
import org.example.teamify.repository.InterestRepository;
import org.example.teamify.repository.SkillRepository;
import org.example.teamify.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class TeamifyApplicationTests {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private SkillRepository skillRepository;
//
//    @Autowired
//    private InterestRepository interestRepository;
//
//    @Test
//    void insertUserTest() {
//
//        User user = new User();
//        user.setUserName("test_user");
//        user.setEmail("test.user@gmail.com");
//        user.setPassword("hashed_password_here");
//
//        user.setFirstName("Test");
//        user.setLastName("User");
//        user.setBio("Spring Boot Test User");
//        user.setAbout("Inserted using Spring Boot test case");
//
//        user.setGender(Gender.MALE);
//        user.setDateOfBirth(LocalDate.of(2002, 6, 15));
//        user.setCreatedAt(LocalDate.now());
//
//        user.setProfilePictureUrl("https://example.com/profile.jpg");
//        user.setCoverPictureUrl("https://example.com/cover.jpg");
//
//        user.setSocialMediaLinkList(List.of(
//                "https://github.com/testuser",
//                "https://linkedin.com/in/testuser"
//        ));
//
//        user.setLookingForList(List.of("Backend Developer", "Team"));
//
//        // optional lists (safe to keep empty)
//        user.setProjectList(new ArrayList<>());
//        user.setExperienceList(new ArrayList<>());
//        user.setEducationList(new ArrayList<>());
//        user.setSkills(new ArrayList<>());
//        user.setInterests(new ArrayList<>());
//
//        User savedUser = userRepository.save(user);
//
//        System.out.println("Saved User ID: " + savedUser.getId());
//    }
//
//    @Test
//    void insert(){
//        User user = userRepository.findByUserName("test_user").orElse(null);
//
//        Project project = new Project();
//        project.setTitle("Test_Project");
//        project.setCoverImageUrl("https://example.com/cover.jpg");
//        project.setDescription("Inserted using Spring Boot test case, Inserted using Spring Boot test case");
//        project.setStartDate(LocalDate.of(2023, 5, 9));
//        project.setEndDate(null);
//        project.setImageUrls(List.of("image1", "Image2"));
//        project.setRole("Team Lead");
//        project.setTechStacks(List.of("Java", "Spring", "HTML"));
//
//        Project project2 = new Project();
//        project2.setTitle("New_Project");
//        project2.setCoverImageUrl("https://example.com/cover.jpg");
//        project2.setDescription("Inserted using Spring Boot test case, asdasdasdasdasd Inserted using Spring Boot test case");
//        project2.setStartDate(LocalDate.of(2024, 7, 9));
//        project2.setEndDate(LocalDate.of(2025, 6, 12));
//        project2.setImageUrls(List.of("image1", "Image2"));
//        project2.setRole("Coder");
//        project2.setTechStacks(List.of("Python", "pyqt", "css"));
//
//
//        user.setProjectList(List.of(project, project2));
//
//        user.setSkills(List.of(skillRepository.findByName("Java").get(), skillRepository.findByName("HTML").get()));
//        user.setInterests(List.of(interestRepository.findByName("Business").get(), interestRepository.findByName("AI").get()));
//
//        userRepository.save(user);
//
//        System.out.println(user);
//    }
//
//    @Test
//    void newSkill(){
//        Skill skill = new Skill();
//        skill.setName("Java");
//        skillRepository.save(skill);
//
//        Skill skill1 = new Skill();
//        skill1.setName("HTML");
//        skillRepository.save(skill1);
//
//        Skill skill2 = new Skill();
//        skill2.setName("CSS");
//        skillRepository.save(skill2);
//
//        Skill skill3 = new Skill();
//        skill3.setName("Spring Boot");
//        skillRepository.save(skill3);
//
//        Interest interest = new Interest();
//        interest.setName("Coding");
//        interestRepository.save(interest);
//
//        Interest interest1 = new Interest();
//        interest1.setName("Business");
//        interestRepository.save(interest1);
//
//        Interest interest2 = new Interest();
//        interest2.setName("UI Design");
//        interestRepository.save(interest2);
//
//        Interest interest3 = new Interest();
//        interest3.setName("AI");
//        interestRepository.save(interest3);
//    }
//
//    @Test
//    void insertExperience(){
//        User user = userRepository.findByUserName("test_user").orElse(null);
//
//        Experience experience = new Experience();
//        experience.setCompanyName("OPCED");
//        experience.setRole("CEO");
//        experience.setLocation("Dhaka, Bangladesh");
//        experience.setLocation("Leading a team of 5 developers in building microservices-based applications. Responsible for architecture decisions, code reviews, and mentoring junior developers. Implemented CI/CD pipelines reducing deployment time by 60%.");
//        experience.setCompanyImageUrl("https://logo.clearbit.com/google.com");
//        experience.setStartDate(LocalDate.of(2023, 2, 2));
//
//        Experience experience2 = new Experience();
//        experience2.setCompanyName("Shop Easy");
//        experience2.setRole("Sales");
//        experience2.setLocation("Kushtia, Bangladesh");
//        experience2.setLocation("Leading a team of 5 developers in building microservices-based applications. Responsible for architecture decisions, code reviews, and mentoring junior developers. Implemented CI/CD pipelines reducing deployment time by 60%.");
//        experience2.setCompanyImageUrl("https://logo.clearbit.com/microsoft.com");
//        experience2.setStartDate(LocalDate.of(2023, 2, 2));
//
//        user.setExperienceList(List.of(experience, experience2));
//        userRepository.save(user);
//
//    }
//
//    @Test
//    void insertEducation(){
//        User user = userRepository.findByUserName("test_user").orElse(null);
//
//        Education education = new Education();
//        education.setInstitutionName("Educare");
//        education.setDegree("SSC");
//        education.setFieldOfStudy("SCIENCE");
//        education.setInstitutionImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQa2p7oy8yjctfpVjX4j8hcPN1F8uvm_r424A&s");
//        education.setStartDate(LocalDate.of(2023, 2, 2));
//        education.setEndDate(LocalDate.of(2025, 2, 2));
//
//        Education education2 = new Education();
//        education2.setInstitutionName("SEU");
//        education2.setDegree("BSC");
//        education2.setFieldOfStudy("CSE");
//        education2.setInstitutionImageUrl("https://upload.wikimedia.org/wikipedia/en/f/f2/Southeast_University_%28Bangladesh%29_%28logo%29.png");
//        education2.setStartDate(LocalDate.of(2023, 2, 2));
//        education2.setEndDate(LocalDate.of(2025, 2, 2));
//
//
//        user.setEducationList(List.of(education, education2));
//        userRepository.save(user);
//    }

}
