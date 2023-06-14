package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.SkillDto;
import com.cvpersonal.cvpersonal.models.Skill;
import com.cvpersonal.cvpersonal.models.Skill;
import com.cvpersonal.cvpersonal.repositories.ProfileRepository;
import com.cvpersonal.cvpersonal.repositories.SkillRepository;
import com.cvpersonal.cvpersonal.services.interfaces.SkillService;
import com.cvpersonal.cvpersonal.utils.Verifier;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final ModelMapper modelMapper;
    @Autowired
    private SkillRepository repository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private Verifier verifier;
    @Override
    @Transactional
    public Skill createSkill(SkillDto skillDto) {
        try {
            if (profileRepository.existsById(skillDto.getIdProfile())) {
                Skill skill = modelMapper.map(skillDto, Skill.class);
                return repository.save(skill);
            }else{
                throw new IllegalArgumentException("Profile does not exist");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Skill", e);
        }
    }

    @Override
    @Transactional
    public Skill getSkillById(String id) {
        verifier.IdVerification(id);

        Optional<Skill> answer = repository.findById(id);
        return answer.orElseThrow(() -> new EntityNotFoundException("Skill not found for ID: " + id));
    }

    @Override
    @Transactional
    public List<Skill> getAllSkill() {
        return repository.findAll();
    }

    @Override
    @Transactional
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
    @Transactional
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
