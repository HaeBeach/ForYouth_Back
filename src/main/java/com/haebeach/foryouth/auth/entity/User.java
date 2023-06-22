package com.haebeach.foryouth.auth.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_auth_user")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id", length = 10)
    private String id;

    @Column(name = "password", length = 15)
    private String password;

    @Column(name = "email", unique = true, length = 50)
    private String email;

    @Column(name = "birth_day", length = 10)
    private String birthDay;

    @Column(name = "gender", length = 1)
    private String gender;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "roles", length = 50)
    private String roles;

}
