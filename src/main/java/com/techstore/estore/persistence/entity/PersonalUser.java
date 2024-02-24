package com.techstore.estore.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSONAL_USERS")
public class PersonalUser extends User  {

    private  static final long serialVersionUID = -9856339713415641L;

    private String sex;
    private String occupation;
}
