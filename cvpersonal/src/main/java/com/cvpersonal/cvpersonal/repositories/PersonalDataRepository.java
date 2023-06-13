package com.cvpersonal.cvpersonal.repositories;

import com.cvpersonal.cvpersonal.models.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalData, String> {
}
