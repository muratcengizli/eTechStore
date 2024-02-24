package com.techstore.estore.dto.response;

import com.techstore.estore.enums.ERole;
import com.techstore.estore.persistence.entity.AdminUser;
import com.techstore.estore.persistence.entity.PersonalUser;
import com.techstore.estore.persistence.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RegisterResponseModel {

    private AdminUser adminUser;
    private PersonalUser personalUser;
    private User user;
    private ERole role;
/*
    public RegisterResponseModel(AdminUser adminUser)    {
        this.adminUser = adminUser;
        this.role = ERole.ADMIN_USER;
    }

    public RegisterResponseModel(PersonalUser personalUser)    {
        this.personalUser = personalUser;
        this.role = ERole.PERSONAL_USER;
    }

    public  RegisterResponseModel(User user)    {this.user = user;}

 */
}
