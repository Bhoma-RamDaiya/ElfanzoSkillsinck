package com.example.Elfonze_SkillSync.repository;

import com.example.Elfonze_SkillSync.Model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    public Candidate findByUserName(String userName);
}
