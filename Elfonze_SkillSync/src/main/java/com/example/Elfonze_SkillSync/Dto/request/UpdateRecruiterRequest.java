package com.example.Elfonze_SkillSync.Dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UpdateRecruiterRequest {
    int recruiterId;
    String mobileNo;
    String emailId;
    String position ;
    int  experienceInYears;
    String responsibilities;
    String City;

}
