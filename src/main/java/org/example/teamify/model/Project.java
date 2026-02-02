package org.example.teamify.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    private String projectId = UUID.randomUUID().toString();  // unique identifier

    @Indexed(unique = true)
    private String title;                 // unique per user (enforced in service)
    private String description;
    private String projectUrl;            // optional: GitHub, demo link
    private String role;                  // role of the user
    private LocalDate startDate;
    private LocalDate endDate;            // can be null if ongoing

    private String coverImageUrl;
    private List<String> imageUrls;       // multiple project pictures
    private List<String> techStacks;
}
