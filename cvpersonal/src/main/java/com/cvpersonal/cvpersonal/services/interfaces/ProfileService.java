package com.cvpersonal.cvpersonal.services.interfaces;

import com.cvpersonal.cvpersonal.dtos.request.ProfileDto;
import com.cvpersonal.cvpersonal.models.Profile;

import java.util.List;

public interface ProfileService {
    Profile createProfile(ProfileDto profileDto);
    Profile getProfileById(String id);
    List<Profile> getAllProfile();
    Profile updateProfile(ProfileDto profileDto, String id);

    Profile deleteProfile(String id);
}
