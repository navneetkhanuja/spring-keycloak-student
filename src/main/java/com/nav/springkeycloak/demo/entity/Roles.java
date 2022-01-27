package com.nav.springkeycloak.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
/*This class is not needed once KeycloakSecurityConfig is created and users/roles are created in keycloak.*/
@Table(name="roles")
@Entity
@Getter
@Setter
public class Roles {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="role")
    private String role;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
