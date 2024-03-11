package com.techstore.estore.persistence.entity;

import com.techstore.estore.enums.ERole;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "PERSONAL_USERS")
public class PersonalUser extends User  {

    private  static final long serialVersionUID = -9856339713415641L;

    private String sex;
    private String occupation;

    public PersonalUser() {}

    public PersonalUser(Long id, String uuid, Timestamp createTime, Timestamp updateTime, Timestamp deleteTime, Boolean isDeleted, String deletedReason, int version, String name, String surname, String emailAddress, String mobilePhone, String password, ERole role, String sex, String occupation) {
        super(id, uuid, createTime, updateTime, deleteTime, isDeleted, deletedReason, version, name, surname, emailAddress, mobilePhone, password, role);
        this.sex = sex;
        this.occupation = occupation;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
