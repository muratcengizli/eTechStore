package com.techstore.estore.service;

import com.techstore.estore.dto.request.LoginRequestModel;
import com.techstore.estore.dto.request.RegisterRequestModel;
import com.techstore.estore.dto.response.BaseResponse;
import com.techstore.estore.dto.response.RegisterResponseModel;
import com.techstore.estore.enums.ERole;
import com.techstore.estore.persistence.entity.ConfirmationToken;
import com.techstore.estore.persistence.entity.PersonalUser;
import com.techstore.estore.persistence.entity.User;
import com.techstore.estore.persistence.repository.PersonalUserRepository;
import com.techstore.estore.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonalUserManagerImpl implements PersonalUserManager {

    @Autowired
    private PersonalUserRepository repository;
    @Autowired
    private ConfirmationTokenManager confirmationTokenManager;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private final JwtUtils jwtUtils;

    public PersonalUserManagerImpl(PersonalUserRepository repository, ConfirmationTokenManager confirmationTokenManager, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.repository = repository;
        this.confirmationTokenManager = confirmationTokenManager;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public BaseResponse<RegisterResponseModel> save(RegisterRequestModel model) {

        if(Objects.equals(Boolean.TRUE, repository.existsByEmailAddress(model.getEmailAddress())))
            return new BaseResponse<>("Email is already taken in use!", HttpStatus.BAD_REQUEST.value());

        PersonalUser user = new PersonalUser();
        user.setId(1L);
        user.setUuid(UUID.randomUUID().toString());
        user.setName(model.getName());
        user.setSurname(model.getSurname());
        user.setOccupation(null);
        user.setSex(null);
        user.setEmailAddress(model.getEmailAddress());
        user.setPassword(model.getPassword());
        user.setMobilePhone(model.getMobilePhone());
        user.setRole(ERole.PERSONAL_USER);
        //repository.save(user);

        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        confirmationTokenManager.saveConfirmationToken(confirmationToken);

        BaseResponse<RegisterResponseModel> response = new BaseResponse<>();
        response.setData(new RegisterResponseModel(user));
        response.setMessage(HttpStatus.CREATED.toString());
        response.setStatus(HttpStatus.CREATED.value());



        return response;
    }

    @Override
    public BaseResponse<RegisterResponseModel> update(RegisterRequestModel model) {
        return null;
    }

    @Override
    public BaseResponse<RegisterResponseModel> delete(String emailAdress) {
        return null;
    }

    @Override
    public BaseResponse<List<Object>> login(LoginRequestModel model) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(model.getEmailAddress(), model.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        var user = (User) authentication.getPrincipal();

        List<Object> response = new ArrayList<>();

        var personalUser = (PersonalUser) user;
        response.add(personalUser);

        var listJwt = new HashMap<String, String>();
        listJwt.put("accessToken", jwt);
        listJwt.put("tokenType", "Bearer");
        response.add(listJwt);

        return new BaseResponse<List<Object>>(response, "Login success!", HttpStatus.OK.value());
    }

}
