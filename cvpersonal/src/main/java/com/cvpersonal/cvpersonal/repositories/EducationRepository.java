package com.cvpersonal.cvpersonal.repositories;

import com.cvpersonal.cvpersonal.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, String> {
}
