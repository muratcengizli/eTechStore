package com.techstore.estore.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.techstore.estore.enums.ERole;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "USERS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode
public class User extends BaseModel {

    private  static final long serialVersionUID = -9856336413415641L;

    private String name;
    private String surname;
    private String emailAddress;
    private String mobilePhone;
    private String password;
    private ERole role;

    public User() {}

    public User(Long id, String uuid, Timestamp createTime, Timestamp updateTime, Timestamp deleteTime, Boolean isDeleted, String deletedReason, int version, String name, String surname, String emailAddress, String mobilePhone, String password, ERole role) {
        super(id, uuid, createTime, updateTime, deleteTime, isDeleted, deletedReason, version);
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.mobilePhone = mobilePhone;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}
