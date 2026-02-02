package org.example.teamify.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Experience {

    @Id
    private String experienceId = UUID.randomUUID().toString(); // unique identifier

    private String companyName;
    private String role;                   // role/title in the company
    private String location;               // city, country (optional)
    private String description;            // short summary of responsibilities
    private LocalDate startDate;
    private LocalDate endDate;             // can be null if currently working
    private String companyImageUrl;
}
