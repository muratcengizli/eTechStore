package com.techstore.estore.controller;

import com.techstore.estore.dto.request.LoginRequestModel;
import com.techstore.estore.dto.request.RegisterRequestModel;
import com.techstore.estore.dto.response.BaseResponse;
import com.techstore.estore.dto.response.RegisterResponseModel;
import com.techstore.estore.service.PersonalUserManager;
import com.techstore.estore.service.UserManager;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/e-store")
public class PersonalUserAuthController {

    @Autowired
    private PersonalUserManager personalUserManager;

    @PostMapping("/auth/create")
    public BaseResponse<RegisterResponseModel> create(@Valid @RequestBody RegisterRequestModel requestModel, BindingResult result) throws Exception {
        if(result != null && result.hasErrors() && result.getFieldError() != null)  {
            try {
                throw new Exception(result.getFieldError().getDefaultMessage());
            }catch (Exception e) {
                throw new Exception("Binding result error");
            }
        }
        return personalUserManager.save(requestModel);
    }

    @PostMapping("/auth/update")
    public BaseResponse<RegisterResponseModel> update(@Valid @RequestBody RegisterRequestModel requestModel)   {
        return personalUserManager.update(requestModel);
    }

    @PostMapping("/auth/delete")
    public BaseResponse<RegisterResponseModel> delete(@Valid @RequestParam (name = "emailAddress") String emailAdress)   {
        return personalUserManager.delete(emailAdress);
    }

    @PostMapping("/auth/login")
    public BaseResponse<List<Object>> create(@Valid @RequestBody LoginRequestModel requestModel, BindingResult result) throws Exception {
        if(result != null && result.hasErrors() && result.getFieldError() != null)  {
            try {
                throw new Exception(result.getFieldError().getDefaultMessage());
            }catch (Exception e) {
                throw new Exception("Binding result error");
            }
        }
        return personalUserManager.login(requestModel);
    }

}
