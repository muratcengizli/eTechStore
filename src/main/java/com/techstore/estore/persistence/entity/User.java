package com.techstore.estore.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.techstore.estore.enums.ERole;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
