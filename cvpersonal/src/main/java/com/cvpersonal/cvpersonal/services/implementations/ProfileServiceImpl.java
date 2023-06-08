package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.ProfileDto;
import com.cvpersonal.cvpersonal.models.Profile;
import com.cvpersonal.cvpersonal.repositories.ProfileRepository;
import com.cvpersonal.cvpersonal.services.interfaces.ProfileService;
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
public class ProfileServiceImpl implements ProfileService {
    private final ModelMapper modelMapper;
    @Autowired
    private ProfileRepository repository;

    @Autowired
    private Verifier verifier;
    @Override
    public Profile createProfile(ProfileDto profileDto) {
        Profile profile = modelMapper.map(profileDto,Profile.class);

        try {
            return repository.save(profile);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create profile", e);
        }
    }

    @Override
    public Profile getProfileById(String id) {
        verifier.IdVerification(id);

        Optional<Profile> answer = repository.findById(id);
        return answer.orElseThrow(() -> new EntityNotFoundException("Profile not found for ID: " + id));
    }

    @Override
    public List<Profile> getAllProfile() {
        return repository.findAll();
    }

    @Override
    public Profile updateProfile(ProfileDto profileDto, String id) {
        verifier.IdVerification(id);

        Profile answer = getProfile(id);

        modelMapper.map(profileDto,answer);

        try {
            return repository.save(answer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update profile", e);
        }
    }

    @Override
    public Profile deleteProfile(String id) {
        verifier.IdVerification(id);

        Profile answer = getProfile(id);
        try {
            repository.deleteById(id);
            return answer;
        }catch(Exception e){
            throw new RuntimeException("Failed to delete profile", e);
        }
    }

    private Profile getProfile(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Profile not found for ID: " + id));
    }
}
