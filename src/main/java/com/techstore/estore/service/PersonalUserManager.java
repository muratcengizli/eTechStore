package com.techstore.estore.service;

import com.techstore.estore.dto.request.RegisterRequestModel;
import com.techstore.estore.dto.response.RegisterResponseModel;
import org.springframework.http.ResponseEntity;

public interface PersonalUserManager {

    ResponseEntity<RegisterResponseModel> save(RegisterRequestModel model);
}
