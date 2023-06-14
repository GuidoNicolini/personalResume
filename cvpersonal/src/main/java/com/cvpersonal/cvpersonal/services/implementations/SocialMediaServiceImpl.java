package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.SocialMediaDto;
import com.cvpersonal.cvpersonal.models.SocialMedia;
import com.cvpersonal.cvpersonal.repositories.PersonalInformationRepository;
import com.cvpersonal.cvpersonal.repositories.SocialMediaRepository;
import com.cvpersonal.cvpersonal.services.interfaces.SocialMediaService;
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
public class SocialMediaServiceImpl implements SocialMediaService {
    private final ModelMapper modelMapper;
    @Autowired
    private SocialMediaRepository repository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    @Autowired
    private Verifier verifier;
    @Override
    @Transactional
    public SocialMedia createSocialMedia(SocialMediaDto socialMediaDto) {

        if(personalInformationRepository.existsById(socialMediaDto.getIdPersonalInformation())) {
            try {
                SocialMedia socialMedia = modelMapper.map(socialMediaDto, SocialMedia.class);
                return repository.save(socialMedia);
            } catch (Exception e) {
                throw new RuntimeException("Failed to create social media", e);
            }
        }else{
            throw new IllegalArgumentException("Profile does not exist");
        }
    }

    @Override
    @Transactional
    public SocialMedia getSocialMediaById(String id) {
        verifier.IdVerification(id);

        Optional<SocialMedia> answer = repository.findById(id);
        return answer.orElseThrow(() -> new EntityNotFoundException("Social media not found for ID: " + id));
    }

    @Override
    @Transactional
    public List<SocialMedia> getAllSocialMedia() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public SocialMedia updateSocialMedia(SocialMediaDto socialMediaDto, String id) {
        verifier.IdVerification(id);

        SocialMedia answer = getSocialMedia(id);

        modelMapper.map(socialMediaDto,answer);

        try {
            return repository.save(answer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update social media", e);
        }
    }

    @Override
    @Transactional
    public SocialMedia deleteSocialMedia(String id) {
        verifier.IdVerification(id);

        SocialMedia answer = getSocialMedia(id);
        try {
            repository.deleteById(id);
            return answer;
        }catch(Exception e){
            throw new RuntimeException("Failed to delete social media", e);
        }
    }

    private SocialMedia getSocialMedia(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Social media not found for ID: " + id));
    }
}
