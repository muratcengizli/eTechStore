package com.techstore.estore.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.techstore.estore.enums.ERole;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "USERS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode
public class User extends BaseModel implements Serializable, UserDetails {

    private  static final long serialVersionUID = -9856336413415641L;

    private String name;
    private String surname;
    private String emailAddress;
    private String mobilePhone;
    private String password;
    private ERole role;
    private Boolean locked = false;
    private Timestamp lockedAt;
    private Boolean enabled = false;
    private Boolean reactivated = false;

    public User() {}

    public User(Long id, String uuid, Timestamp createTime, Timestamp updateTime, Timestamp deleteTime, Boolean isDeleted, String deletedReason, int version, String name, String surname, String emailAddress, String mobilePhone, String password, ERole role, Boolean locked, Timestamp lockedAt, Boolean enabled, Boolean reactivated) {
        super(id, uuid, createTime, updateTime, deleteTime, isDeleted, deletedReason, version);
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.mobilePhone = mobilePhone;
        this.password = password;
        this.role = role;
        this.locked = locked;
        this.lockedAt = lockedAt;
        this.enabled = enabled;
        this.reactivated = reactivated;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(simpleGrantedAuthority);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {return emailAddress;}

    @Override
    public boolean isAccountNonExpired() {return true;}

    @Override
    public boolean isAccountNonLocked() {return true;}

    @Override
    public boolean isCredentialsNonExpired() {return true;}

    @Override
    public boolean isEnabled() {return enabled;}

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

    public void setPassword(String password) {
        this.password = password;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Timestamp getLockedAt() {
        return lockedAt;
    }

    public void setLockedAt(Timestamp lockedAt) {
        this.lockedAt = lockedAt;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getReactivated() {
        return reactivated;
    }

    public void setReactivated(Boolean reactivated) {
        this.reactivated = reactivated;
    }
}
