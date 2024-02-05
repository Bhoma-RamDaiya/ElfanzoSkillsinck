package com.example.Elfonze_SkillSync.Model;


import com.example.Elfonze_SkillSync.Enum.Skills;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "job")
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int jobId;

     String salaryOffered;

     String location;

     int noOfOpenings;

     List<Skills>skillsRequired ;

     String jobDescription;

     String responsibilities;

     int noticePeriodInDays;

     int experience;

     String companyWeb;

     Boolean isAvailable = true;

     String company;


    @ManyToOne
    @JoinColumn
    Candidate candidate;

    @ManyToOne
    @JoinColumn
    Recrutier recrutier;
}
