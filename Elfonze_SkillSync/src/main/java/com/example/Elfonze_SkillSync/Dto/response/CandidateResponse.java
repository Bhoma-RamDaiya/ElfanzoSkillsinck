package com.example.Elfonze_SkillSync.Dto.response;

import com.example.Elfonze_SkillSync.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CandidateResponse {
    int id;
    String userName;
    String fristName;
    String lastName;
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
