package com.cvpersonal.cvpersonal.services.implementations;

import com.cvpersonal.cvpersonal.dtos.request.SocialMediaDto;
import com.cvpersonal.cvpersonal.models.SocialMedia;
import com.cvpersonal.cvpersonal.repositories.ToolRepository;
import com.cvpersonal.cvpersonal.services.interfaces.SocialMediaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SocialMediaServiceImpl implements SocialMediaService {
    private final ModelMapper modelMapper;
    @Autowired
    private ToolRepository repository;
    @Override
    public SocialMedia createSocialMedia(SocialMediaDto socialMediaDto) {
        return null;
    }

    @Override
    public SocialMedia getSocialMediaById(String id) {
        return null;
    }

    @Override
    public List<SocialMedia> getAllSocialMedia() {
        return null;
    }

    @Override
    public SocialMedia updateSocialMedia(SocialMediaDto socialMediaDto, String id) {
        return null;
    }

    @Override
    public SocialMedia deleteSocialMedia(String id) {
        return null;
    }
}
