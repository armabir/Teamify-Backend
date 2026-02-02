package org.example.teamify.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    private String id = java.util.UUID.randomUUID().toString();
    private String title;

    private String shortDescription;
    private String fullDescription;
    private String eventType;
    private String location;
    private String coverUrl;
    private LocalDate createdAt;

    private List<String> teamNames;
}