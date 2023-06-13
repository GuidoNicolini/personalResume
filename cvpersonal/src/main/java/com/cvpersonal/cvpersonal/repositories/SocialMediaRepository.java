package com.cvpersonal.cvpersonal.repositories;

import com.cvpersonal.cvpersonal.models.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMedia, String> {
}
