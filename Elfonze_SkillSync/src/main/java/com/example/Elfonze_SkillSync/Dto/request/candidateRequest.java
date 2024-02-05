package com.example.Elfonze_SkillSync.Dto.request;


import com.example.Elfonze_SkillSync.Enum.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;


@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class candidateRequest {
     String userName;
     String password;
     String fristName;
     String lastName;

    @Enumerated(value = EnumType.STRING)
    Gender gender;
   String phoneNo;
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
    Boolean isResumeUploaded;

}
