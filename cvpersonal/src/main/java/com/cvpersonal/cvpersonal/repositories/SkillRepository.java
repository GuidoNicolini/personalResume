package com.cvpersonal.cvpersonal.repositories;

import com.cvpersonal.cvpersonal.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, String> {
}
