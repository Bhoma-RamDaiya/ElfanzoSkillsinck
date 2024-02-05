package com.example.Elfonze_SkillSync.Service;

import com.example.Elfonze_SkillSync.Dto.request.JobRequestDto;
import com.example.Elfonze_SkillSync.Dto.request.UpdateJobRequest;
import com.example.Elfonze_SkillSync.Dto.response.JobresponseDto;
import com.example.Elfonze_SkillSync.Model.JobEntity;
import com.example.Elfonze_SkillSync.exception.JobNotFoundException;
import com.example.Elfonze_SkillSync.repository.JobRepository;
import com.example.Elfonze_SkillSync.transfer.JobTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;

    public JobresponseDto addJob(JobRequestDto jobRequestDto) {
        JobEntity jobEntity = JobTransfer.jobRequestDtoToJob(jobRequestDto);
        JobEntity savedJob = jobRepository.save(jobEntity);
        JobresponseDto jobresponseDto = JobTransfer.jobToJobResponseDto(savedJob);

        return jobresponseDto;
    }

    public JobresponseDto updateJob(UpdateJobRequest updateJobRequest) {
       int jobId = updateJobRequest.getJobId();
       Optional<JobEntity> optional = jobRepository.findById(jobId);
       if(optional.isEmpty()) throw new JobNotFoundException("Enter a Valid JobId");
     else {

           JobEntity jobEntity = optional.get();
//           jobEntity = JobTransfer.updateJobRequestDtoToJobEntity(updateJobRequest);
           jobEntity.setSalaryOffered(updateJobRequest.getSalaryOffered());
           jobEntity.setNoOfOpenings(updateJobRequest.getNoOfOpenings());
           jobEntity.setSkillsRequired(updateJobRequest.getSkillsRequired());
           jobEntity.setIsAvailable(updateJobRequest.getIsAvailable());
           jobEntity.setResponsibilities(updateJobRequest.getResponsibilities());
           jobEntity.setExperience(updateJobRequest.getExperience());
           jobEntity.setLocation(updateJobRequest.getLocation());

           JobEntity savedJob = jobRepository.save(jobEntity);
           return JobTransfer.jobToJobResponseDto(savedJob);
       }
    }

    public String deleteJob(int jobId) {
        Optional<JobEntity>optional = jobRepository.findById(jobId);
        if(optional.isEmpty()) throw new JobNotFoundException("Enter A Valid JobId");
        JobEntity job = optional.get();
        jobRepository.delete(job);
        return " JobId:- "+ jobId+"  this job has been deleted";
    }
}
