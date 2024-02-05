package com.example.Elfonze_SkillSync.transfer;

import com.example.Elfonze_SkillSync.Dto.request.candidateRequest;
import com.example.Elfonze_SkillSync.Dto.response.CandidateResponse;
import com.example.Elfonze_SkillSync.Model.Candidate;

public class CandidateTransfer {
    public static Candidate candidaterequestTocandidate(candidateRequest requestDto) {
        return Candidate.builder()
                .userName(requestDto.getUserName())
                .firstName(requestDto.getFristName())
                .lastName(requestDto.getLastName())
                .highestQualificationHeld(requestDto.getHighestQualificationHeld())
                .phoneNo(requestDto.getPhoneNo())
                .emailId(requestDto.getEmailId())
                .mobileNo(requestDto.getMobileNo())
                .experienceInYears(requestDto.getExperienceInYears())
                .relevantExperience(requestDto.getRelevantExperience())
                .gender(requestDto.getGender())
                .currentJobTitle(requestDto.getCurrentJobTitle())
                .currentWorkLocation(requestDto.getCurrentWorkLocation())
                .city(requestDto.getCity())
                .skillSet(requestDto.getSkillSet())
                .zipCode(requestDto.getZipCode())
                .isResumeUploded(requestDto.getIsResumeUploaded())
                .password(requestDto.getPassword())
                .build();

    }

    public static CandidateResponse candidateToCandidateResponseDto(Candidate savedcandidate) {
        return CandidateResponse.builder().id(savedcandidate.getCandidateId())
                .fristName(savedcandidate.getFirstName())
                .lastName(savedcandidate.getLastName())
                .phoneNo(savedcandidate.getPhoneNo())
                .mobileNo(savedcandidate.getMobileNo())
                .currentJobTitle(savedcandidate.getCurrentJobTitle())
                .currentWorkLocation(savedcandidate.getCurrentWorkLocation())
                .city(savedcandidate.getCity())
                .emailId(savedcandidate.getEmailId())
                .skillSet(savedcandidate.getSkillSet())
                .relevantExperience(savedcandidate.getRelevantExperience())
                .highestQualificationHeld(savedcandidate.getHighestQualificationHeld())
                .isResumeUploaded(savedcandidate.getIsResumeUploded())
                .userName(savedcandidate.getUserName())
                .zipCode(savedcandidate.getZipCode())
                .gender(savedcandidate.getGender())
                .experienceInYears(savedcandidate.getExperienceInYears())
                .build();
    }
}
