package com.example.Elfonze_SkillSync.Service;

import com.example.Elfonze_SkillSync.Dto.request.candidateRequest;
import com.example.Elfonze_SkillSync.Dto.response.CandidateResponse;
import com.example.Elfonze_SkillSync.Model.Candidate;
import com.example.Elfonze_SkillSync.exception.CandidateNotFoundException;
import com.example.Elfonze_SkillSync.exception.PasswordIsNotCorrect;
import com.example.Elfonze_SkillSync.repository.CandidateRepository;
import com.example.Elfonze_SkillSync.transfer.CandidateTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    @Autowired
    CandidateRepository candidateRepository;
    public CandidateResponse addCandidate(candidateRequest requestDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Candidate candidate = CandidateTransfer.candidaterequestTocandidate(requestDto);
         String encryptPwd = encoder.encode(candidate.getPassword());
//         candidate.setPassword(encryptPwd);
        Candidate savedcandidate = candidateRepository.save(candidate);

        CandidateResponse candidateResponse = CandidateTransfer.candidateToCandidateResponseDto(savedcandidate) ;
        return candidateResponse;
    }

    public Candidate getCandidate(int candidateId) {
        Optional<Candidate> optional = candidateRepository.findById(candidateId);
//        Candidate candidate = optional.get();
        if (optional.isEmpty()) {
            throw new CandidateNotFoundException("Invalid Candidate Id");
            //
        } else {
            return optional.get();
        }
    }

    public String updateCandidate(candidateRequest requestDto) {
        return "";
    }

    public String deleteCandidate(int candidateId) {
        Optional<Candidate> optional = candidateRepository.findById(candidateId);
        if (optional.isEmpty()) throw new CandidateNotFoundException("Please enter a Valid Candidate id");
        Candidate candidate = optional.get();
        candidateRepository.delete(candidate);
        return "Your account has been deleted candidateId : "+ candidateId;
    }

    public String resetPassword(String userName, String oldPassword, String newPassword) {
        Candidate candidate = candidateRepository.findByUserName(userName);
        if(candidate==null) throw new CandidateNotFoundException("Your user name is Incorrect");
        String password = candidate.getPassword();
        if(password.equals(oldPassword)){
            candidate.setPassword(newPassword);

        }
        else{
            throw new PasswordIsNotCorrect("Please Enter Your correct Password");
        }

        candidateRepository.save(candidate);
        return "Congratulations Your Password has been reset";
    }
}
