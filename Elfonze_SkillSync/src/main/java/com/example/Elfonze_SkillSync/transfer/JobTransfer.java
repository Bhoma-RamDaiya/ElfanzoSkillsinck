package com.example.Elfonze_SkillSync.transfer;

import com.example.Elfonze_SkillSync.Dto.request.JobRequestDto;
import com.example.Elfonze_SkillSync.Dto.request.UpdateJobRequest;
import com.example.Elfonze_SkillSync.Dto.response.JobresponseDto;
import com.example.Elfonze_SkillSync.Model.JobEntity;

public class JobTransfer {
    public static JobEntity jobRequestDtoToJob(JobRequestDto jobRequestDto) {
        return JobEntity.builder().jobDescription(jobRequestDto.getJobDescription())
                .location(jobRequestDto.getLocation())
                .noOfOpenings(jobRequestDto.getNoOfOpenings())
                .skillsRequired(jobRequestDto.getSkillsRequired())
                .experience(jobRequestDto.getExperience())
                .noticePeriodInDays(jobRequestDto.getNoticePeriodInDays())
                .isAvailable(jobRequestDto.getIsAvailable())
                .salaryOffered(jobRequestDto.getSalaryOffered())
                .responsibilities(jobRequestDto.getResponsibilities())
                .companyWeb(jobRequestDto.getCompanyWeb())
                .company(jobRequestDto.getCompany())
                .build();
    }

    public static JobresponseDto jobToJobResponseDto(JobEntity savedJob) {
        return JobresponseDto.builder().jobId(savedJob.getJobId())
                .jobDescription(savedJob.getJobDescription())
                .responsibilities(savedJob.getResponsibilities())
                .companyWeb(savedJob.getCompanyWeb())
                .experience(savedJob.getExperience())
                .isAvailable(savedJob.getIsAvailable())
                .location(savedJob.getLocation())
                .noOfOpenings(savedJob.getNoOfOpenings())
                .noticePeriodInDays(savedJob.getNoticePeriodInDays())
                .salaryOffered(savedJob.getSalaryOffered())
                .skillsRequired(savedJob.getSkillsRequired())
                .company(savedJob.getCompany())
                .build();
    }

    public static JobEntity updateJobRequestDtoToJobEntity(UpdateJobRequest updateJobRequest) {
        return JobEntity.builder().location(updateJobRequest.getLocation())
                .noOfOpenings(updateJobRequest.getNoOfOpenings())
                .skillsRequired(updateJobRequest.getSkillsRequired())
                .experience(updateJobRequest.getExperience())
               .isAvailable(updateJobRequest.getIsAvailable())
                .salaryOffered(updateJobRequest.getSalaryOffered())
                .responsibilities(updateJobRequest.getResponsibilities())

                .build();
    }
}
