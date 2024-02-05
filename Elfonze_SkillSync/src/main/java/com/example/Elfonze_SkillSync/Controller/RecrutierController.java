package com.example.Elfonze_SkillSync.Controller;

import com.example.Elfonze_SkillSync.Dto.request.RecruitRequestDto;
import com.example.Elfonze_SkillSync.Dto.request.UpdateRecruitRequest;
import com.example.Elfonze_SkillSync.Dto.request.UpdateRecruiterRequest;
import com.example.Elfonze_SkillSync.Dto.response.RecruitResponseDto;
import com.example.Elfonze_SkillSync.Model.Recrutier;
import com.example.Elfonze_SkillSync.Service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recruiter")
public class RecrutierController {
    @Autowired
    RecruiterService recruiterService;

    @PostMapping("/add_recruiter")
    public ResponseEntity addRecruiter(@RequestBody RecruitRequestDto recruitrequestDto){
        try{
            RecruitResponseDto recruitResponseDto = recruiterService.addRecruiter(recruitrequestDto);
            return new ResponseEntity<>(recruitResponseDto , HttpStatus.CREATED);

        } catch (Exception E){
            return new ResponseEntity<>(E.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get_Recruiter")
    public ResponseEntity getRecruiter(@RequestParam("recruiterId") int recruiterId){
        try{
            Recrutier recrutier = recruiterService.getRecruiter(recruiterId);
            return new ResponseEntity<>(recrutier , HttpStatus.ACCEPTED);

        } catch (Exception E){
            return new ResponseEntity<>(E.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update_Recruiter")
    public ResponseEntity updateRecruiter(@RequestBody UpdateRecruiterRequest recruitUpdate){
        try{
            RecruitResponseDto recruitResponseDto = recruiterService.updateRecruiter(recruitUpdate);
            return new ResponseEntity<>(recruitResponseDto , HttpStatus.ACCEPTED);

        } catch (Exception E){
            return new ResponseEntity<>(E.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete_Recruiter")
    public ResponseEntity deleteRecruiter(@RequestParam("recruiterId") int recruiterId){
        try{
            String response = recruiterService.deleteRecruiter(recruiterId);
            return new ResponseEntity<>("null" , HttpStatus.CREATED);

        } catch (Exception E){
            return new ResponseEntity<>(E.getMessage() , HttpStatus.ACCEPTED);
        }
    }
    @PutMapping("/reset_password")
    public  ResponseEntity resetPassword(@RequestParam("user_name") String userName , @RequestParam("old_password") String oldPassword , @RequestParam("new_password") String newPassword){
        try {
            String message = recruiterService.resetPassword(userName , oldPassword, newPassword);
            return  new ResponseEntity<>(message , HttpStatus.ACCEPTED);
        } catch (Exception E){
            return new ResponseEntity<>(E.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

}
