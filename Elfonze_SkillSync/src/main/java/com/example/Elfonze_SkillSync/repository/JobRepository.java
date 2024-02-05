package com.example.Elfonze_SkillSync.repository;

import com.example.Elfonze_SkillSync.Model.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobEntity , Integer> {
}
