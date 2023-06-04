package com.cvpersonal.cvpersonal.services.interfaces;

import com.cvpersonal.cvpersonal.dtos.request.SocialMediaDto;
import com.cvpersonal.cvpersonal.models.SocialMedia;

import java.util.List;

public interface SocialMediaService {
    SocialMedia createSocialMedia(SocialMediaDto socialMediaDto);
    SocialMedia getSocialMediaById(String id);
    List<SocialMedia> getAllSocialMedia();
    SocialMedia updateSocialMedia(SocialMediaDto socialMediaDto, String id);

    SocialMedia deleteSocialMedia(String id);
}
