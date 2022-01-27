package com.nav.springkeycloak.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/*This class is not needed once KeycloakSecurityConfig is created and users/roles are created in keycloak.*/
@Table (name="users")
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;

    //below "user" is the variable name defined in Roles.java
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Roles> roles;

}
