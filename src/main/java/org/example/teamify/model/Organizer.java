package org.example.teamify.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "organizers")
public class Organizer {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
    private String email;
    private String password;

    private String type;
    private String description;
    private String logoUrl;
    private String websiteUrl;
    private LocalDate createdAt;

    private List<Event> eventList;
}
