package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.SkillDto;
import com.cvpersonal.cvpersonal.models.Skill;
import com.cvpersonal.cvpersonal.repositories.SkillRepository;
import com.cvpersonal.cvpersonal.services.interfaces.SkillService;
import com.cvpersonal.cvpersonal.utils.Verifier;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final ModelMapper modelMapper;
    @Autowired
    private SkillRepository repository;

    @Autowired
    private Verifier verifier;
    @Override
    public Skill createSkill(SkillDto skillDto) {
        Skill skill = modelMapper.map(skillDto,Skill.class);

        try {
            return repository.save(skill);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create skill", e);
        }
    }

    @Override
    public Skill getSkillById(String id) {
        verifier.IdVerification(id);

        Optional<Skill> answer = repository.findById(id);
        return answer.orElseThrow(() -> new EntityNotFoundException("Skill not found for ID: " + id));
    }

    @Override
    public List<Skill> getAllSkill() {
        return repository.findAll();
    }

    @Override
    public Skill updateSkill(SkillDto skillDto, String id) {
        verifier.IdVerification(id);

        Skill answer = getSkill(id);

        modelMapper.map(skillDto,answer);

        try {
            return repository.save(answer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update skill", e);
        }
    }

    @Override
    public Skill deleteSkill(String id) {
        verifier.IdVerification(id);

        Skill answer = getSkill(id);
        try {
            repository.deleteById(id);
            return answer;
        }catch(Exception e){
            throw new RuntimeException("Failed to delete skill", e);
        }
    }

    private Skill getSkill(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Skill not found for ID: " + id));
    }
}
