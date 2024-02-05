package com.example.Elfonze_SkillSync.Controller;

import com.example.Elfonze_SkillSync.Dto.request.JobRequestDto;
import com.example.Elfonze_SkillSync.Dto.request.UpdateJobRequest;
import com.example.Elfonze_SkillSync.Dto.response.JobresponseDto;
import com.example.Elfonze_SkillSync.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    JobService jobService;
    @PostMapping("/add_job")

    public ResponseEntity addJob(@RequestBody JobRequestDto jobRequestDto){
        try{
            JobresponseDto jobresponseDto = jobService.addJob(jobRequestDto);
            return new ResponseEntity<>(jobresponseDto , HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("update_job")
    public ResponseEntity updateJob(@RequestBody UpdateJobRequest updateJobRequest){
        try{
            JobresponseDto jobresponseDto = jobService.updateJob(updateJobRequest);
            return new ResponseEntity<>(jobresponseDto , HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete_job")
    public ResponseEntity deleteJob(@RequestParam("jobId") int jobId ){
        try{
            String message = jobService.deleteJob(jobId);
            return new ResponseEntity<>(message , HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
