package com.example.Elfonze_SkillSync.Dto.request;

import com.example.Elfonze_SkillSync.Enum.Skills;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UpdateJobRequest {
    int jobId;
    String salaryOffered;
    int noOfOpenings;
    List<Skills> skillsRequired;
    Boolean isAvailable;
    String responsibilities;
    int experience;
    String location;
}
