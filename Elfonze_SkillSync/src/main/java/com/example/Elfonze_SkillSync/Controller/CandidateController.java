package com.example.Elfonze_SkillSync.Controller;

import com.example.Elfonze_SkillSync.Dto.request.candidateRequest;
import com.example.Elfonze_SkillSync.Dto.response.CandidateResponse;
import com.example.Elfonze_SkillSync.Model.Candidate;
import com.example.Elfonze_SkillSync.Service.CandidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    CandidateService candidateService;
    @PostMapping("/add_candidate")
    public ResponseEntity addCandidate(@RequestBody candidateRequest requestDto){
       try {
           log.info("We have request : {}",requestDto.toString());
           CandidateResponse candidateResponse= candidateService.addCandidate(requestDto);
           return new ResponseEntity<>(candidateResponse, HttpStatus.CREATED);
       }
 catch (Exception E){
           return new ResponseEntity<>(E.getMessage() , HttpStatus.BAD_REQUEST);
 }
    }
    @GetMapping("get_candidate")
    public ResponseEntity getCandidate(@RequestParam("id") int candidateId){
        try {
            Candidate candidate= candidateService.getCandidate(candidateId);
            return new ResponseEntity<>(candidate, HttpStatus.ACCEPTED);
        }

 catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
 }
    }
    @PutMapping("update_candidate")
    public ResponseEntity<String> updateCandidate(@RequestBody candidateRequest requestDto){
        try {
            String result = candidateService.updateCandidate(requestDto);
            return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }
    @DeleteMapping("Delete_candidate")
    public ResponseEntity deleteCandidate(@RequestParam("id") int candidateId){
        try {
            String sendInfo =  candidateService.deleteCandidate(candidateId);
            return new ResponseEntity<>("account has beenm deleted ", HttpStatus.ACCEPTED);
        }
      catch (Exception E){
            return  new ResponseEntity<>(E.getMessage() , HttpStatus.BAD_REQUEST);
      }

    }
    @PutMapping ("/reset_password")
    public  ResponseEntity resetPassword(@RequestParam("user_name") String userName , @RequestParam("old_password") String oldPassword , @RequestParam("new_password") String newPassword){
        try {
            String message = candidateService.resetPassword(userName , oldPassword, newPassword);
            return  new ResponseEntity<>(message , HttpStatus.ACCEPTED);
        } catch (Exception E){
            return new ResponseEntity<>(E.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

}
