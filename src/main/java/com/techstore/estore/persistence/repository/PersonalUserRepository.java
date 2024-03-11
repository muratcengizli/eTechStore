package com.techstore.estore.persistence.repository;

import com.techstore.estore.persistence.entity.PersonalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalUserRepository extends JpaRepository<PersonalUser, String> {

    Boolean existsByEmailAddress(String emailAddress);
}
