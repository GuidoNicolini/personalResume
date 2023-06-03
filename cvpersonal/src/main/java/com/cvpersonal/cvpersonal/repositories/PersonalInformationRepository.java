package com.cvpersonal.cvpersonal.repositories;

import com.cvpersonal.cvpersonal.models.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, String> {
}
