package com.example.Elfonze_SkillSync.Dto.response;

import com.example.Elfonze_SkillSync.Enum.Skills;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class JobresponseDto {
    int jobId;
    String salaryOffered;

    String location;
    int noOfOpenings;
    List<Skills> skillsRequired ;


    String jobDescription;
    String responsibilities;
    int noticePeriodInDays;

    int experience;
    String companyWeb;
    boolean isAvailable;
    String company;
}
