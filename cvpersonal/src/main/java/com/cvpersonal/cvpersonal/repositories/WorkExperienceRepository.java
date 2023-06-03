package com.cvpersonal.cvpersonal.repositories;

import com.cvpersonal.cvpersonal.models.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, String> {
}
