package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.ProfileDto;
import com.cvpersonal.cvpersonal.models.Profile;
import com.cvpersonal.cvpersonal.repositories.ProfileRepository;
import com.cvpersonal.cvpersonal.services.interfaces.ProfileService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ModelMapper modelMapper;
    @Autowired
    private ProfileRepository repository;
    @Override
    public Profile createProfile(ProfileDto profileDto) {
        return null;
    }

    @Override
    public Profile getProfileById(String id) {
        return null;
    }

    @Override
    public List<Profile> getAllProfile() {
        return null;
    }

    @Override
    public Profile updateProfile(ProfileDto profileDto, String id) {
        return null;
    }

    @Override
    public Profile deleteProfile(String id) {
        return null;
    }
}
