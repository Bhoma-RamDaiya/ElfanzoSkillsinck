package com.example.Elfonze_SkillSync.Dto.request;

import com.example.Elfonze_SkillSync.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RecruitRequestDto {
    String userName;
    String password;

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
     int  experienceInYears = 0;
     String responsibilities;

    Gender gender;
     String companyName;
     String url;
     String City;
     String zipCode;
}
