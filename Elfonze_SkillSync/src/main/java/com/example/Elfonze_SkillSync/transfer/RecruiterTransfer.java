package com.example.Elfonze_SkillSync.transfer;

import com.example.Elfonze_SkillSync.Dto.request.RecruitRequestDto;
import com.example.Elfonze_SkillSync.Dto.request.UpdateRecruiterRequest;
import com.example.Elfonze_SkillSync.Dto.response.RecruitResponseDto;
import com.example.Elfonze_SkillSync.Model.Recrutier;

public class RecruiterTransfer {
    public static Recrutier recruitRequestDtoToRecruter(RecruitRequestDto recruitrequestDto) {
        return Recrutier.builder().userName(recruitrequestDto.getUserName())
                .age(recruitrequestDto.getAge())
                .firstName(recruitrequestDto.getFristName())
                .lastName(recruitrequestDto.getLastName())
                .emailId(recruitrequestDto.getEmailId())
                .companyName(recruitrequestDto.getCompanyName())
                .phoneNo(recruitrequestDto.getPhoneNo())
                .city(recruitrequestDto.getCity())
                .panNo(recruitrequestDto.getPanNo())
                .adharNo(recruitrequestDto.getAdharNo())
                .companyWeb(recruitrequestDto.getUrl())
                .gender(recruitrequestDto.getGender())
                .mobileNo(recruitrequestDto.getMobileNo())
                .position(recruitrequestDto.getPosition())
                .responsibilities(recruitrequestDto.getResponsibilities())
                .experienceInYears(recruitrequestDto.getExperienceInYears())
                .zipCode(recruitrequestDto.getZipCode())
                .password(recruitrequestDto.getPassword())
                .build();
    }

    public static RecruitResponseDto recruiterToRecruitResponseDto(Recrutier recruiter) {
        return  RecruitResponseDto.builder()
                .recruiterId(recruiter.getRecruiterId())
                .emailId(recruiter.getEmailId())
                .fristName(recruiter.getFirstName())
                .lastName(recruiter.getLastName())
                .gender(recruiter.getGender())
                .adharNo(recruiter.getAdharNo())
                .panNo(recruiter.getPanNo())
                .city(recruiter.getCity())
                .responsibilities(recruiter.getResponsibilities())
                .age(recruiter.getAge())
                .url(recruiter.getCompanyWeb())
                .companyName(recruiter.getCompanyName())
                .experienceInYears(recruiter.getExperienceInYears())
                .mobileNo(recruiter.getMobileNo())
                .position(recruiter.getPosition())
                .phoneNo(recruiter.getPhoneNo())
                .zipCode(recruiter.getZipCode())
                .userName(recruiter.getUserName())
                .companyName(recruiter.getCompanyName())
                .build();
    }

    public static Recrutier updaterequestDtoToRecruiter(UpdateRecruiterRequest update) {
        return Recrutier.builder()

                .emailId(update.getEmailId())
            .city(update.getCity())

                .mobileNo(update.getMobileNo())
                .position(update.getPosition()).responsibilities(update.getResponsibilities())
                .experienceInYears(update.getExperienceInYears())

                .build();
    }
}
