package com.cvpersonal.cvpersonal.repositories;

import com.cvpersonal.cvpersonal.models.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInformationRepository extends JpaRepository<ContactInformation, String> {
}
