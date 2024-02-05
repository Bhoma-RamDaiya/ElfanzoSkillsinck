package com.example.Elfonze_SkillSync.Dto.response;

import com.example.Elfonze_SkillSync.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RecruitResponseDto {
    int recruiterId;
    String userName;

     String fristName;
      String lastName;
     String phoneNo;


     String emailId;
     String mobileNo;
     int age;
    //    private int  relevantExperience;

     String panNo;

     String adharNo;
     String position;
     int  experienceInYears;
     String responsibilities;

    Gender gender;
     String companyName;
     String url;
     String city;
     String zipCode;
}
