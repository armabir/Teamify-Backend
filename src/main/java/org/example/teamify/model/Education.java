package org.example.teamify.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Education {

    @Id
    private String educationId = java.util.UUID.randomUUID().toString(); // unique identifier

    private String institutionName;
    private String degree;                 // e.g., BSc, MSc, Diploma
    private String fieldOfStudy;           // e.g., Computer Science
    private LocalDate startDate;
    private LocalDate endDate;             // can be null if currently studying
    private String institutionImageUrl;    // optional logo/image
}
