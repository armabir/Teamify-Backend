package org.example.teamify.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Document(collection = "teams")
public class Team {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
    private String createdBy;
    private String goal;
    private String description;
    private LocalDate createAt;
    private String coverImageUrl;

    private List<String> memberUsernames;
    private List<String> announcements;
}
