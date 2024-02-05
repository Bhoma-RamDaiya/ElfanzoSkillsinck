package com.example.Elfonze_SkillSync.Model;

import com.example.Elfonze_SkillSync.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int candidateId;

    @Column(unique = true)
    private String userName;

    private String password;

    private String firstName;

    private  String lastName;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private String phoneNo;

    @Column(unique = true)
    String emailId;

    String mobileNo;

    int  experienceInYears;

    int  relevantExperience;

     String highestQualificationHeld;

     ArrayList<String> skillSet ;

     String currentJobTitle ;

     String currentWorkLocation;

     String city;

     String zipCode;

     Boolean isResumeUploded;

//    @Lob
//    private byte[] resume;

// candidate can apply many jobs
 @OneToMany(mappedBy = "candidate" , cascade = CascadeType.ALL)
 List<JobEntity> jobEntityList ;
}
