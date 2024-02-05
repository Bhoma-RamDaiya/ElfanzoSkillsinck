package com.example.Elfonze_SkillSync.Service;

import com.example.Elfonze_SkillSync.Dto.request.RecruitRequestDto;
import com.example.Elfonze_SkillSync.Dto.request.UpdateRecruitRequest;
import com.example.Elfonze_SkillSync.Dto.request.UpdateRecruiterRequest;
import com.example.Elfonze_SkillSync.Dto.response.RecruitResponseDto;
import com.example.Elfonze_SkillSync.Model.Candidate;
import com.example.Elfonze_SkillSync.Model.Recrutier;
import com.example.Elfonze_SkillSync.exception.CandidateNotFoundException;
import com.example.Elfonze_SkillSync.exception.PasswordIsNotCorrect;
import com.example.Elfonze_SkillSync.exception.RecruiterNotFoundExceprion;
import com.example.Elfonze_SkillSync.repository.RecruiterRepository;
import com.example.Elfonze_SkillSync.transfer.RecruiterTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class RecruiterService {
    @Autowired
    RecruiterRepository recruiterRepository;
    public RecruitResponseDto addRecruiter(RecruitRequestDto recruitrequestDto) {
        Recrutier recrutier = RecruiterTransfer.recruitRequestDtoToRecruter(recruitrequestDto);
        Recrutier savedRecruiter = recruiterRepository.save(recrutier);
        RecruitResponseDto recruitResponseDto = RecruiterTransfer.recruiterToRecruitResponseDto(savedRecruiter);
        return recruitResponseDto;
    }

    public Recrutier getRecruiter(int recruiterId) {
        Optional<Recrutier> optional = recruiterRepository.findById(recruiterId);
        if(optional.isEmpty()) throw new RecruiterNotFoundExceprion("Please Enter a valid RecruiterId");
        Recrutier recrutier = optional.get();

        return  recrutier;
    }

    public RecruitResponseDto updateRecruiter(UpdateRecruiterRequest updateRecruitRequest) {
        int recruiterId = updateRecruitRequest.getRecruiterId();
        Optional<Recrutier> optional = recruiterRepository.findById(recruiterId);
        if(optional.isEmpty()) throw new RecruiterNotFoundExceprion("Please Enter a valid RecruiterId");
        Recrutier recrutier = optional.get();
        recrutier = RecruiterTransfer.updaterequestDtoToRecruiter(updateRecruitRequest);
        Recrutier savedRecruiter = recruiterRepository.save(recrutier);

        return  RecruiterTransfer.recruiterToRecruitResponseDto(savedRecruiter);
    }

    public String deleteRecruiter(int recruiterId) {
        Optional<Recrutier> optional = recruiterRepository.findById(recruiterId);
        if(optional.isEmpty()) throw new RecruiterNotFoundExceprion("Please Enter a valid RecruiterId");
        Recrutier recrutier = optional.get();
        recruiterRepository.delete(recrutier);
        return  " Recruiter has been deleted  RecruiterId is : "+recruiterId;
    }

    public String resetPassword(String userName, String oldPassword, String newPassword) {

            Recrutier recrutier = recruiterRepository.findByUserName(userName);
            if(recrutier==null) throw new RecruiterNotFoundExceprion("Your user name is Incorrect");
            String password = recrutier.getPassword();
            if(password.equals(oldPassword)){
                recrutier.setPassword(newPassword);

            }
            else{
                throw new PasswordIsNotCorrect("Please Enter Your correct Password");
            }

        recruiterRepository.save(recrutier);
        return "Congratulations Your Password has been reset";
    }
}
