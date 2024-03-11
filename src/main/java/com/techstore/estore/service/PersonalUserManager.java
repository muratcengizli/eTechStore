package com.techstore.estore.service;

import com.techstore.estore.dto.request.RegisterRequestModel;
import com.techstore.estore.dto.response.BaseResponse;
import com.techstore.estore.dto.response.RegisterResponseModel;
import org.springframework.http.ResponseEntity;

public interface PersonalUserManager {

    BaseResponse<RegisterResponseModel> save(RegisterRequestModel model);
    BaseResponse<RegisterResponseModel> update(RegisterRequestModel model);
    BaseResponse<RegisterResponseModel> delete(String emailAdress);
}
