package com.techstore.estore.service;

import com.techstore.estore.dto.request.RegisterRequestModel;
import com.techstore.estore.dto.response.RegisterResponseModel;
import com.techstore.estore.persistence.repository.PersonalUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonalUserManagerImpl implements PersonalUserManager{

    private PersonalUserRepository repository;


    @Override
    public ResponseEntity<RegisterResponseModel> save(RegisterRequestModel model) {
        return null;
    }
}
