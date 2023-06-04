package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.SkillDto;
import com.cvpersonal.cvpersonal.models.Skill;
import com.cvpersonal.cvpersonal.repositories.SkillRepository;
import com.cvpersonal.cvpersonal.services.interfaces.SkillService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final ModelMapper modelMapper;
    @Autowired
    private SkillRepository repository;
    @Override
    public Skill createSkill(SkillDto skillDto) {
        return null;
    }

    @Override
    public Skill getSkillById(String id) {
        return null;
    }

    @Override
    public List<Skill> getAllSkill() {
        return null;
    }

    @Override
    public Skill updateSkill(SkillDto skillDto, String id) {
        return null;
    }

    @Override
    public Skill deleteSkill(String id) {
        return null;
    }
}
