package com.example.Elfonze_SkillSync.repository;

import com.example.Elfonze_SkillSync.Model.Recrutier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends JpaRepository<Recrutier , Integer> {
    public Recrutier findByUserName(String userName);
}
