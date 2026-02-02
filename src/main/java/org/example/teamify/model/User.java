package org.example.teamify.model;

import lombok.*;
import org.example.teamify.enums.Gender;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    private String userName;

    @Indexed(unique = true)
    private String email;
    private String password;

    private String firstName;
    private String lastName;
    private String bio;
    private String about;
    private String location;
    private LocalDate dateOfBirth;
    private Gender gender;
    private LocalDate createdAt;

    private String profilePictureUrl;
    private String CoverPictureUrl;

    // Relationships / Lists
    private List<Project> projectList;
    private List<Experience> experienceList;
    private List<Education> educationList;

    // Basic only link for now. later add icons & shortner
    private List<String> socialMediaLinkList;
    private List<String> lookingForList;

    @DBRef
    private List<Skill> skills;
    @DBRef
    private List<Interest> interests;

}
