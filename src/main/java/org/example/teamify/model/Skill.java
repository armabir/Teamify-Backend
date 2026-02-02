package org.example.teamify.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "skills")
public class Skill {

    @Id
    private String id;          // MongoDB _id

    @Indexed(unique = true)
    private String name;        // e.g., Java, React, Spring Boot
}
