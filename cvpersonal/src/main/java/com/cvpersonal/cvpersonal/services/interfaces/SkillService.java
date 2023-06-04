package com.cvpersonal.cvpersonal.services.interfaces;

import com.cvpersonal.cvpersonal.dtos.request.SkillDto;
import com.cvpersonal.cvpersonal.models.Skill;

import java.util.List;

public interface SkillService {
    Skill createSkill(SkillDto skillDto);
    Skill getSkillById(String id);
    List<Skill> getAllSkill();
    Skill updateSkill(SkillDto skillDto, String id);

    Skill deleteSkill(String id);
}
